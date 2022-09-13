/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: MyLogoutSuccessHandler
 * Author:   summer
 * Date:     2022/9/13 14:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config.security;

import com.sandrew.bootsec.core.common.JsonResult;
import com.sandrew.bootsec.core.util.JsonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyLogoutSuccessHandler
 * @Description
 * @Author summer
 * @Date 2022/9/13 14:14
 **/
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler
{
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException
    {
        JsonResult result = new JsonResult();
        result.requestSuccess("Logout success");
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JsonUtil.javaObject2String(result));
    }
}
