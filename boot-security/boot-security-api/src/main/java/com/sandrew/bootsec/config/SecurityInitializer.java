/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: SecurityInitializer
 * Author:   summer
 * Date:     2022/8/29 16:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @ClassName SecurityInitializer
 * @Description
 * @Author summer
 * @Date 2022/8/29 16:21
 **/
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer
{

    public SecurityInitializer()
    {
        super(WebSecurityConfig.class);
    }
}
