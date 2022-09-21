package com.sandrew.bootsec.controller;


import com.sandrew.bootsec.core.common.JsonResult;
import com.sandrew.bootsec.core.controller.BaseController;
import com.sandrew.bootsec.core.exception.JsonException;
import com.sandrew.bootsec.core.exception.ServiceException;
import com.sandrew.bootsec.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class LoginController extends BaseController
{

    @Resource
    private LoginService loginService;


    @GetMapping("/")
    public String index(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient, @AuthenticationPrincipal OAuth2User oauth2User)
    {
        model.addAttribute("userName", oauth2User.getName());
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", oauth2User.getAttributes());
        return "index";
    }

    //    @PostMapping(value = "/login")
    //    public JsonResult login(String userCode, String password) throws JsonException
    //    {
    //        JsonResult result = new JsonResult();
    //        try
    //        {
    //            TmUserPO user = new TmUserPO();
    //            user.setUserCode(userCode);
    //            user.setPassword(password);
    //            result = result.requestSuccess(loginService.login(user));
    //        }
    //        catch (Exception e)
    //        {
    //            String errorMsg = null;
    //            if (e instanceof ServiceException)
    //            {
    //                errorMsg = "用户名或密码错误";
    //            }
    //            else
    //            {
    //                errorMsg = "用户登录失败";
    //            }
    //            result.requestFailure(errorMsg);
    //            log.error(e.getMessage(), e);
    //        }
    //        return result;
    //    }

    /**
     * 获取用户信息
     *
     * @return
     * @throws JsonException
     */
    @GetMapping(value = "/userInfo")
    public JsonResult userInfo() throws JsonException
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
     * 获取经办人信息
     *
     * @return
     * @throws JsonException
     */
    @GetMapping(value = "/operatorInfo")
    public JsonResult operatorInfo() throws JsonException
    {
        try
        {
            return loginService.getOperatorInfo(getLoginUser().getUserId());
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new JsonException("获取用户信息失败", e);
        }
    }

    @GetMapping(value = "/getMenuByRole")
    public JsonResult getMenuByRole(Integer roleId) throws JsonException
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
    public @ResponseBody
    JsonResult logout() throws JsonException
    {
        try
        {
            JsonResult result = new JsonResult();
            //            loginService.logout();
            return result.requestSuccess(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new JsonException("登出系统失败", e);
        }

    }

}
