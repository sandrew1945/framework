/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: MyAuthenticationFailureHandler
 * Author:   summer
 * Date:     2022/9/13 10:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config.security;

import com.sandrew.bootsec.core.common.JsonResult;
import com.sandrew.bootsec.core.util.JsonUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAuthenticationFailureHandler
 * @Description
 * @Author summer
 * @Date 2022/9/13 10:41
 **/
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler
{
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException
    {
        JsonResult result = new JsonResult();
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException)
        {
            result.requestFailure("用户名/密码错误");
        }
        else
        {
            result.requestFailure(e.getMessage());
        }
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JsonUtil.javaObject2String(result));
    }
}
