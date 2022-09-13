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

package com.sandrew.bootsec.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author summer
 * @Date 2022/8/29 16:13
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Resource
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Resource
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Resource
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Resource
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Resource
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
//        http.authorizeRequests()
//                .antMatchers("/*").hasAnyRole();
        http.cors().and().csrf().disable();

        http.formLogin().loginProcessingUrl("/login")
                .permitAll().failureHandler(myAuthenticationFailureHandler).successHandler(myAuthenticationSuccessHandler)
                .and().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .deleteCookies("JSESSIONID");   // 删除cookie

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler)
                .authenticationEntryPoint(myAuthenticationEntryPoint);
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