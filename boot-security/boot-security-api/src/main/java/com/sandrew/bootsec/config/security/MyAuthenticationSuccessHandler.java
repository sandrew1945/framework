/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: MyAuthenticationSuccessHandler
 * Author:   summer
 * Date:     2022/9/13 14:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config.security;

import cn.nesc.toolkit.common.codec.Base64Util;
import com.sandrew.bootsec.core.common.JsonResult;
import com.sandrew.bootsec.core.util.JsonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAuthenticationSuccessHandler
 * @Description
 * @Author summer
 * @Date 2022/9/13 14:05
 **/
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException
    {
        JsonResult result = new JsonResult();
        result.requestSuccess(Base64Util.encode(httpServletRequest.getSession().getId()));
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JsonUtil.javaObject2String(result));
    }
}
