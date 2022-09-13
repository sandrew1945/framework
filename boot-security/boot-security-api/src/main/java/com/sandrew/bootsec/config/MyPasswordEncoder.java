/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: MyPasswordEncoder
 * Author:   summer
 * Date:     2022/8/30 15:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config;

import com.sandrew.bootsec.core.util.MD5Encrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName MyPasswordEncoder
 * @Description
 * @Author summer
 * @Date 2022/8/30 15:42
 **/
public class MyPasswordEncoder implements PasswordEncoder
{
    @Override
    public String encode(CharSequence rawPassword)
    {

        return MD5Encrypt.MD5Encode(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword)
    {
        return encodedPassword.equals(MD5Encrypt.MD5Encode(rawPassword.toString()));
    }
}
