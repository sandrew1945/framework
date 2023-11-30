/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: MyAuthenticationEntryPoint
 * Author:   summer
 * Date:     2022/9/13 10:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAuthenticationEntryPoint
 * @Description
 * @Author summer
 * @Date 2022/9/13 10:30
 **/
@Component
public class OAuthAuthenticationEntryPoint implements AuthenticationEntryPoint
{
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException
    {
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/oauth2/authorization/okta");
    }
}
