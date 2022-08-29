/**
 * <pre>
 * FILE : LoginService.java
 * CLASS : LoginService
 *
 * AUTHOR : SuMMeR
 *
 * FUNCTION : TODO
 *
 *
 * ======================================================================
 * CHANGE HISTORY LOG
 * ----------------------------------------------------------------------
 * MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
 * ----------------------------------------------------------------------
 * 		  |2014年5月3日| SuMMeR| Created |
 * DESCRIPTION:
 * </pre>
 * <p>
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 * <p>
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 * <p>
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 * <p>
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 * <p>
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 */
/**
 * $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
 */

package com.sandrew.bootcas.service.login.impl;

import com.sandrew.bootcas.bean.RoleTreeNode;
import com.sandrew.bootcas.core.bean.AclUserBean;
import com.sandrew.bootcas.core.common.Constants;
import com.sandrew.bootcas.core.common.LoginResult;
import com.sandrew.bootcas.core.exception.ServiceException;
import com.sandrew.bootcas.core.shiro.MyUsernamePasswordToken;
import com.sandrew.bootcas.mapper.TmFuncFrontMapper;
import com.sandrew.bootcas.mapper.TmRolePOMapper;
import com.sandrew.bootcas.mapper.login.LoginMapper;
import com.sandrew.bootcas.model.TmFuncFront;
import com.sandrew.bootcas.model.TmFuncFrontExample;
import com.sandrew.bootcas.model.TmRolePO;
import com.sandrew.bootcas.model.TmUserPO;
import com.sandrew.bootcas.service.login.LoginService;
import com.sandrew.bootcas.service.usermanager.UserManagerService;
import com.sandrew.bootcas.service.util.MenuNode;
import com.sandrew.bootcas.service.util.TreeMaker;
import com.sandrew.bootcas.service.util.TreeNode;
import com.sandrew.bootcas.service.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Function    : 
 * @author     : SuMMeR
 * CreateDate  : 2014年5月3日
 * @version    :
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService
{
    @Resource
    private TmRolePOMapper roleMapper;

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private TmFuncFrontMapper tmFuncFrontMapper;

    @Resource
    private UserManagerService userManagerService;


    @Override
    public AclUserBean login(TmUserPO user) throws ServiceException
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            MyUsernamePasswordToken token = new MyUsernamePasswordToken(user.getUserCode(), user.getPassword());

            if (!subject.isAuthenticated())
            {
                subject.login(token);
                TmUserPO databaseUser = userManagerService.getUserByCode(user.getUserCode());
                AclUserBean loginUser = new AclUserBean();
                //                loginUser.setUserCode(user.getUserCode());
                //                loginUser.setUserName(databaseUser.getUserName());
                //                loginUser.setSex(databaseUser.getSex());
                //                loginUser.setUserType(databaseUser.getUserType());
                //                loginUser.setPhone(databaseUser.getPhone());
                //                loginUser.setMobile(databaseUser.getMobile());
                //                loginUser.setEmail(databaseUser.getEmail());
                //                loginUser.setAvatarPath(databaseUser.getAvatar());
                loginUser.setUserId(databaseUser.getUserId());
                loginUser.setToken(subject.getSession().getId().toString());
                subject.getSession().setAttribute(Constants.LOGIN_USER, loginUser);
                return loginUser;
            }
            else
            {
                AclUserBean loginUser = (AclUserBean) subject.getSession().getAttribute(Constants.LOGIN_USER);
                return loginUser;
            }
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ServiceException("登录失败", e);
        }
    }

    @Override
    public AclUserBean userInfo(AclUserBean loginUser) throws ServiceException
    {
        try
        {
            TmUserPO user = userManagerService.findByUserId(loginUser.getUserId());
            loginUser.setUserCode(user.getUserCode());
            loginUser.setUserName(user.getUserName());
            loginUser.setSex(user.getSex());
            loginUser.setUserType(user.getUserType());
            loginUser.setPhone(user.getPhone());
            loginUser.setMobile(user.getMobile());
            loginUser.setEmail(user.getEmail());
            loginUser.setAvatarPath(user.getAvatar());
            List<TmRolePO> roleList = userManagerService.getRelationRolesByUserId(loginUser.getUserId());
            loginUser.setRoleList(roleList);
            return loginUser;
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ServiceException("获取用户信息失败", e);
        }
    }

    @Override
    public List<MenuNode> getMenuByRole(Integer roleId) throws ServiceException
    {
        try
        {
            TmFuncFrontExample example = new TmFuncFrontExample();
            TmFuncFrontExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(roleId);
            List<TmFuncFront> functionList = tmFuncFrontMapper.selectByExample(example);
            List<MenuNode> menuList = new ArrayList<>();
            Map<Integer, MenuNode> cache = new HashMap<>();
            for (TmFuncFront funcFront : functionList)
            {
                MenuNode menu = new MenuNode();
                menu.setPath(funcFront.getPath());
                menu.setName(funcFront.getName());
                menu.setComponent(funcFront.getFile());
                menu.setRedirect(funcFront.getRedirect());
                Map<String, String> meta = new HashMap<>();
                meta.put("title", funcFront.getTitle());
                meta.put("icon", funcFront.getIcon());
                menu.setMeta(meta);
                cache.put(funcFront.getFuncId(), menu);
                if (null != funcFront.getFatherId())
                {
                    // 如果存在父节点，那么将子节点添加到父节点，并且不添加到menuList中
                    MenuNode father = cache.get(funcFront.getFatherId());
                    father.addChildren(menu);
                    continue;
                }
                menuList.add(menu);
            }
            /*
            List<MenuNode> menuList = new ArrayList<>();

            MenuNode b11 = new MenuNode();
            b11.setPath("/menu11");
            b11.setName("Menu-1-1");
            b11.setComponent("b/manager/index");
            b11.setRedirect("");
            Map<String, String> meta = new HashMap<>();
            meta.put("title", "菜单1-2");
            meta.put("icon", "example");
            b11.setMeta(meta);
            b11.setChildren(null);

            MenuNode b12 = new MenuNode();
            b12.setPath("/menu12");
            b12.setName("Menu-1-2");
            b12.setComponent("/b/create/index");
            b12.setRedirect("");
            meta = new HashMap<>();
            meta.put("title", "菜单1-1");
            meta.put("icon", "example");
            b12.setMeta(meta);
            b12.setChildren(null);

            MenuNode b1 = new MenuNode();
            b1.setPath("/Menu1");
            b1.setName("Menu-1");
            b1.setComponent("/b/index");
            b1.setRedirect("");
            meta = new HashMap<>();
            meta.put("title", "菜单1");
            meta.put("icon", "example");
            b1.setMeta(meta);
            b1.addChildren(b11);
            b1.addChildren(b12);
            menuList.add(b1);

            if (roleId != null && roleId.equals(1))
            {
                MenuNode manager = new MenuNode();
                manager.setPath("manager");
                manager.setName("Manager");
                manager.setComponent("/user/index");
                meta = new HashMap<>();
                meta.put("title", "用户管理");
                meta.put("icon", "example");
                manager.setMeta(meta);
                manager.setChildren(null);

                MenuNode user = new MenuNode();
                user.setPath("/user");
                user.setName("User");
                user.setComponent("Layout");
                user.setRedirect("");
                meta = new HashMap<>();
                meta.put("title", "用户管理");
                meta.put("icon", "example");
                user.setMeta(meta);
                user.addChildren(manager);
                menuList.add(user);

                MenuNode roleManager = new MenuNode();
                roleManager.setPath("manager");
                roleManager.setName("Manager");
                roleManager.setComponent("/role/index");
                meta = new HashMap<>();
                meta.put("title", "角色管理");
                meta.put("icon", "example");
                roleManager.setMeta(meta);
                roleManager.setChildren(null);

                MenuNode role = new MenuNode();
                role.setPath("/role");
                role.setName("Role");
                role.setComponent("Layout");
                role.setRedirect("");
                meta = new HashMap<>();
                meta.put("title", "角色管理");
                meta.put("icon", "example");
                role.setMeta(meta);
                role.addChildren(roleManager);
                menuList.add(role);
            }
            */
            return menuList;
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ServiceException("获取系统菜单失败", e);
        }
    }

    /**
     * Function    : 用户角色选择处理器
     * LastUpdate  : 2014年6月4日
     * @param userCode
     * @return
     */
    public LoginResult postRoleHandler(String userCode) throws ServiceException
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            TmUserPO sessionUser = userManagerService.getUserByCode(userCode);
            AclUserBean aclUser = new AclUserBean();
            aclUser.setUserId(sessionUser.getUserId());
            aclUser.setUserCode(sessionUser.getUserCode());
            aclUser.setUserName(sessionUser.getUserName());
            aclUser.setUserType(sessionUser.getUserType());
            aclUser.setAvatarPath(sessionUser.getAvatar());
            session.setAttribute(Constants.LOGIN_USER, aclUser);

            // 如果已经选择完角色，那么直接进入系统首页
            if (UserUtil.hasRole(aclUser))
            {
                return new LoginResult("index", false);
            }
            // 判断用户可以选择的角色，如果只有一个，那么不进行选择，直接跳入系统首页
            List<AclUserBean> list = loginMapper.selectRoleByUserCode(userCode);
            if (null != list && list.size() > 1)
            {
                // 多角色
                return new LoginResult("login/postRoleChoice", false);
            }
            if (null != list && list.size() < 1)
            {
                // 无角色
                return new LoginResult("redirect:error403", true);
            }

            // 角色信息放入SESSION中
            AclUserBean tempAcl = list.get(0);
            aclUser.setRoleId(tempAcl.getRoleId());
            aclUser.setRoleName(tempAcl.getRoleName());
            aclUser.setRoleCode(tempAcl.getRoleCode());
            session.setAttribute(Constants.LOGIN_USER, aclUser);
            return new LoginResult("index", false);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ServiceException("角色选择失败", e);
        }

    }

    /**
     * 	根据用户ID获取角色选择树
     */
    @Override
    public List<RoleTreeNode> choiceRoleTree(Integer userId) throws ServiceException
    {
        try
        {
            return loginMapper.selectRoleForChoice(userId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("角色选择树获取失败", e);
        }
    }

    @Override
    public String generateMenu(Integer roleId) throws ServiceException
    {
        String treeStr = null;
        try
        {
            treeStr = TreeMaker.buildTree(loginMapper.getMenuInfo(roleId));
        }
        catch (Exception e)
        {
            e.printStackTrace();

            throw new ServiceException("获取菜单失败", e);
        }
        return treeStr;
    }


    @Override
    public List<TreeNode> getMenuTreeNode(Integer roleId) throws ServiceException
    {
        List<TreeNode> treeNodes;
        try
        {
            treeNodes = TreeMaker.handleNode(loginMapper.getMenuInfo(roleId));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ServiceException("获取菜单失败", e);
        }
        return treeNodes;
    }

    @Override
    public String showIndex(Integer roleId) throws ServiceException
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            AclUserBean aclUser = (AclUserBean) session.getAttribute(Constants.LOGIN_USER);
            // 通过roleId获取角色信息
            TmRolePO rolePO = roleMapper.selectByPrimaryKey(roleId);
            aclUser.setRoleId(roleId);
            aclUser.setRoleCode(rolePO.getRoleCode());
            aclUser.setRoleName(rolePO.getRoleName());
            session.setAttribute(Constants.LOGIN_USER, aclUser);
            return "index";
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ServiceException("选择岗位、角色失败", e);
        }
    }

    @Override
    public void logout() throws ServiceException
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ServiceException("登出系统失败", e);
        }
    }
}
