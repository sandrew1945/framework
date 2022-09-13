/**
 * Copyright (C), 2015-2022, 东北证券股份有限公司
 * FileName: WebSecurityConfig
 * Author:   summer
 * Date:     2022/8/29 16:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 **/

package com.sandrew.bootsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author summer
 * @Date 2022/8/29 16:13
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.formLogin()
//                .loginPage("/login").permitAll()
                .and().authorizeRequests()
                .anyRequest().authenticated();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
    }
    // @formatter:off
    //    @Bean
    //    public UserDetailsService userDetailsService() {
    //        UserDetails user = User.withDefaultPasswordEncoder()
    //                .username("user")
    //                .password("password")
    //                .roles("USER")
    //                .build();
    //        return  new InMemoryUserDetailsManager(user);
    //    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new MyPasswordEncoder();
    }

}