/**********************************************************************
* <pre>
* FILE : LoginService.java
* CLASS : LoginService
*
* AUTHOR : SuMMeR
*
* FUNCTION : TODO
*
*
*======================================================================
* CHANGE HISTORY LOG
*----------------------------------------------------------------------
* MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
*----------------------------------------------------------------------
* 		  |2014年5月3日| SuMMeR| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: LoginService.java,v 0.1 2014年5月3日 上午10:58:34 SuMMeR Exp $
*/

package com.sandrew.mvc.service.login.impl;

import com.sandrew.mvc.bean.AclUserBean;
import com.sandrew.mvc.bean.RoleTreeNode;
import com.sandrew.mvc.core.common.Constants;
import com.sandrew.mvc.core.common.LoginResult;
import com.sandrew.mvc.core.exception.ServiceException;
import com.sandrew.mvc.core.shiro.MyUsernamePasswordToken;
import com.sandrew.mvc.mapper.TmRolePOMapper;
import com.sandrew.mvc.mapper.login.LoginMapper;
import com.sandrew.mvc.model.TmRolePO;
import com.sandrew.mvc.model.TmUserPO;
import com.sandrew.mvc.service.login.LoginService;
import com.sandrew.mvc.service.usermanager.UserManagerService;
import com.sandrew.mvc.service.util.TreeMaker;
import com.sandrew.mvc.service.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Function    : 
 * @author     : SuMMeR
 * CreateDate  : 2014年5月3日
 * @version    :
 */
@Service
public class LoginServiceImpl implements LoginService
{
	@Resource
	private TmRolePOMapper tmRolePOMapper;

	@Resource
	private LoginMapper loginMapper;

	@Resource
	private UserManagerService userManagerService;


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
			e.printStackTrace();
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
	public String showIndex(Integer roleId) throws ServiceException
	{
		try
		{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			AclUserBean aclUser = (AclUserBean) session.getAttribute(Constants.LOGIN_USER);
			// 通过roleId获取角色信息
			TmRolePO rolePO = tmRolePOMapper.selectByPrimaryKey(roleId);
			aclUser.setRoleId(roleId);
			aclUser.setRoleCode(rolePO.getRoleCode());
			aclUser.setRoleName(rolePO.getRoleName());
			session.setAttribute(Constants.LOGIN_USER, aclUser);
			return "index";
		}
		catch (Exception e)
		{
			throw new ServiceException("选择岗位、角色失败", e);
		}
	}
	
}
