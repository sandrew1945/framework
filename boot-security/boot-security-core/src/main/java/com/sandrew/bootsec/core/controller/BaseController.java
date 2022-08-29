package com.sandrew.bootsec.core.controller;

import com.sandrew.bootsec.core.bean.AclUserBean;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class BaseController
{

    @InitBinder
    protected void ininBinder(WebDataBinder binder)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    /**
     * Function    : 获取登录用户信息
     * LastUpdate  : 2014年5月20日
     *
     * @return
     */
    protected AclUserBean getLoginUser()
    {
//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        AclUserBean loginUser = (AclUserBean) session.getAttribute(Constants.LOGIN_USER);
        AclUserBean loginUser = new AclUserBean();
        loginUser.setUserId(1);
        loginUser.setRoleCode("admin");
        loginUser.setRoleName("系统管理员");
        return loginUser;
    }

    /**
     * Function    : 设置用户登录信息
     * LastUpdate  : 2014年5月20日
     *
     * @param loginUser
     */
    protected void setloginUser(AclUserBean loginUser)
    {
//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        session.setAttribute(Constants.LOGIN_USER, loginUser);
    }

    /**
     * 获取系统的appKey
     *
     * @return
     */
    protected String getAppKey()
    {
//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        return (String) session.getAttribute(Constants.APP_KEY);
        return null;
    }

}