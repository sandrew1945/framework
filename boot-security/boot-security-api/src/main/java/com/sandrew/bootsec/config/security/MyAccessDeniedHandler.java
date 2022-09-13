/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: MyAccessDeniedHandler
 * Author:   summer
 * Date:     2022/9/13 14:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config.security;

import com.sandrew.bootsec.core.common.JsonResult;
import com.sandrew.bootsec.core.util.JsonUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAccessDeniedHandler
 * @Description
 * @Author summer
 * @Date 2022/9/13 14:16
 **/
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler
{
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException
    {
        JsonResult result = new JsonResult();
        result.requestSuccess("You are not permitted to access");
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JsonUtil.javaObject2String(result));
    }
}
