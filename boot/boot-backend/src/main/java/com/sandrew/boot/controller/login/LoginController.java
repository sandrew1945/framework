package com.sandrew.boot.controller.login;


import com.sandrew.boot.core.common.JsonResult;
import com.sandrew.boot.core.controller.BaseController;
import com.sandrew.boot.core.exception.JsonException;
import com.sandrew.boot.core.exception.ServiceException;
import com.sandrew.boot.model.TmUserPO;
import com.sandrew.boot.service.login.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
@Api(tags = "登录相关接口", description = "提供用户登录相关的 API")
public class LoginController extends BaseController
{

    @Resource
    LoginService loginService;



    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public
    @ResponseBody
    JsonResult login(String userCode, String password) throws JsonException
    {
        JsonResult result = new JsonResult();
        try
        {
            TmUserPO user = new TmUserPO();
            user.setUserCode(userCode);
            user.setPassword(password);
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

    @GetMapping(value = "/userInfo")
    @ApiOperation("获取用户信息")
    public
    @ResponseBody
    JsonResult userInfo() throws JsonException
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

    @GetMapping(value = "/getMenuByRole")
    @ApiOperation("获取系统菜单")
    public
    @ResponseBody
    JsonResult getMenuByRole(Integer roleId) throws JsonException
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

    @PostMapping(value = "/logout")
    @ApiOperation("登出系统")
    public
    @ResponseBody
    JsonResult logout() throws JsonException
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

}
