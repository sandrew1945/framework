package com.sandrew.boot.controller.login;


import com.sandrew.boot.bean.RoleTreeNode;
import com.sandrew.boot.core.bean.Principal;
import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.common.LoginResult;
import com.sandrew.boot.core.controller.BaseController;
import com.sandrew.boot.core.exception.ActionException;
import com.sandrew.boot.core.exception.JsonException;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.model.TmUserPO;
import com.sandrew.boot.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class LoginController extends BaseController
{

    @Resource
    LoginService loginService;

    /**
     * 系统默认进入页面
     *
     * @return
     * @throws ActionException
     */
    @RequestMapping("/")
    public String loginPre(Model model) throws ActionException
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            //删除上一次点击的URL
            if(subject != null && subject.getSession() != null){
                subject.getSession().removeAttribute(WebUtils.SAVED_REQUEST_KEY);
            }
            return "login/login";
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new ActionException("访问系统失败", e);
        }

    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     * @throws ActionException
     */
    @RequestMapping(value = "/login")
    public @ResponseBody JsonResult login(TmUserPO user) throws JsonException
    {
        JsonResult result = new JsonResult();
        try
        {
            result = result.requestSuccess(loginService.login(user));
        }
        catch (Exception e)
        {
            String errorMsg = null;
            if (e instanceof ServiceException)
            {
                errorMsg = "用户名或密码错误";
            }
            else
            {
                errorMsg = "用户登录失败";
            }
            log.error(e.getMessage(), e);
            throw new JsonException(errorMsg, e);
        }
        return result;
    }

    /**
     *  获取用户信息
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/userInfo")
    public @ResponseBody JsonResult userInfo() throws JsonException
    {
        try
        {
            JsonResult result = new JsonResult();
            return result.requestSuccess(loginService.userInfo(getLoginUser()));
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new JsonException("获取用户信息失败", e);
        }
    }

    /**
     *  获取系统菜单
     * @param roleId
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/getMenuByRole")
    public @ResponseBody JsonResult getMenuByRole(Integer roleId) throws JsonException
    {
        try
        {
            JsonResult result = new JsonResult();
            return result.requestSuccess(loginService.getMenuByRole(roleId));
        }
        catch (ServiceException e)
        {
            log.error(e.getMessage(), e);
            throw new JsonException("获取系统菜单失败", e);
        }
    }


    @RequestMapping(value = "/showRoleSelect")
    public String showRoleSelect(HttpServletRequest req, Model model) throws ActionException
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            String userCode = ((Principal) subject.getPrincipal()).getName();
            // 验证登录用户
            LoginResult loginResult = loginService.postRoleHandler(userCode);
            // 生成登录记录
            if ("index".equals(loginResult.getReturnView()))
            {
                // 生成菜单
                String menuStr = loginService.generateMenu(getLoginUser().getRoleId());
                model.addAttribute("sessionUser", getLoginUser());
                model.addAttribute("menu", menuStr);
            }
            if (loginResult.getHasError())
            {
                model.addAttribute("noRole", "false");
            }
            return loginResult.getReturnView();
        }
        //catch (ServiceException e)
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("isAuthenticate", "false");
            return "login/login";
        }
    }

    @RequestMapping(value = "/showRoleChoiceTree")
    public String showRoleChoiceTree() throws ActionException
    {
        try
        {
            return "login/postRoleChoiceTree";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.debug(e.getMessage(), e);
            throw new ActionException("角色选择失败", e);
        }
    }

    /**
     * Function    : 根据用户获取可选岗位树
     * LastUpdate  : 2014年5月30日
     *
     * @return
     * @throws ActionException
     */
    @RequestMapping(value = "/getPostRoleForChoice")
    public
    @ResponseBody
    List<RoleTreeNode> getPostRoleForChoice() throws ActionException
    {
        try
        {
            System.out.println("getLoginUser:" + getLoginUser());
            return loginService.choiceRoleTree(getLoginUser().getUserId());
        }
        catch (ServiceException e)
        {
            e.printStackTrace();
            throw new ActionException("根据用户查询岗位失败", e);
        }
    }


    /**
     * 根据用户所选角色，转入到系统主页面，并将角色信息存入SESSION
     *
     * @param roleId
     * @param model
     * @return
     * @throws ActionException
     */
    @RequestMapping(value = "/showIndex")
    public String showIndex(Integer roleId, Model model) throws ActionException
    {
        try
        {
            // 处理选择的角色信息,如果角色信息为空，那么到SESSION中获取
            if (null == roleId)
            {
                roleId = getLoginUser().getRoleId();
            }
            String returnStr = loginService.showIndex(roleId);
            // 生成菜单
            String menuStr = loginService.generateMenu(getLoginUser().getRoleId());
            model.addAttribute("sessionUser", getLoginUser());
            model.addAttribute("menu", menuStr);
            return returnStr;
        }
        catch (ServiceException e)
        {
            e.printStackTrace();
            throw new ActionException("选择岗位、角色失败", e);
        }
    }

    /**
     *  登出系统
     * @return
     * @throws JsonException
     */
    @RequestMapping(value = "/logout")
    public @ResponseBody JsonResult logout() throws JsonException
    {
        try
        {
            JsonResult result = new JsonResult();
            loginService.logout();
            return result.requestSuccess(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException("登出系统失败", e);
        }

    }

    /**
     * 403错误页面
     *
     * @return
     * @throws ActionException
     */
    @RequestMapping(value = "/error403")
    public String showError403() throws ActionException
    {
        try
        {

            return "error/errorpage_403";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ActionException("选择岗位、角色失败", e);
        }
    }

    /**
     * 403错误页面
     *
     * @return
     * @throws ActionException
     */
    @RequestMapping(value = "/error500")
    public String showError500() throws ActionException
    {
        try
        {

            return "error/errorpage_500";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ActionException("选择岗位、角色失败", e);
        }
    }

}
