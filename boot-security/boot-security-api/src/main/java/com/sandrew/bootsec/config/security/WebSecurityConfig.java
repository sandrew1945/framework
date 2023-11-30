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

import com.sandrew.bootsec.config.security.oauth.IDAASAuthorizationCodeTokenResponseClient;
import com.sandrew.bootsec.config.security.oauth.IDAASOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author summer
 * @Date 2022/8/29 16:13
 **/
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    private static List<String> clients = Arrays.asList("idaas");

    @Resource
    private JSONAuthenticationEntryPoint jsonAuthenticationEntryPoint;      // 前后端分离模式下的认证异常处理

    @Resource
    private OAuthAuthenticationEntryPoint oauthAuthenticationEntryPoint;    // oauth2模式下的认证异常处理

    @Resource
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

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
        http.cors().and().csrf().disable();

        http.formLogin().loginProcessingUrl("/login")
//            .permitAll()
            .failureHandler(myAuthenticationFailureHandler)     // 登录认证失败handler
            .successHandler(myAuthenticationSuccessHandler)     // 登录成功handler
        .and()
            .authorizeRequests()
            .antMatchers("/login/oauth2/**").permitAll()
            .antMatchers("/oauth2/**").permitAll()
//            .anyRequest().authenticated()
        .and()
            .logout().permitAll()
            .logoutSuccessHandler(myLogoutSuccessHandler)
            .deleteCookies("JSESSIONID")   // 删除cookie
        .and()
            .oauth2Login(
                httpSecurityOAuth2LoginConfigurer -> {
                    // 覆盖获取accessToken的client
                    httpSecurityOAuth2LoginConfigurer.tokenEndpoint(tokenEndpointConfig -> {
                        tokenEndpointConfig.accessTokenResponseClient(new IDAASAuthorizationCodeTokenResponseClient());
                    });
                    // 覆盖解析user信息的service
                    httpSecurityOAuth2LoginConfigurer.userInfoEndpoint(userInfoEndpointConfig -> {
                        userInfoEndpointConfig.userService(new IDAASOAuth2UserService());
                    });
                }
            )
            .authorizeRequests()
            .antMatchers("/login/oauth2/**").permitAll()
            .antMatchers("/oauth2/**").permitAll()
            .anyRequest().authenticated();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler)
                .authenticationEntryPoint(oauthAuthenticationEntryPoint);
    }


    /*
    @Configuration
    @Order(2)
    class OAuth2SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter
    {
        private final String LOGIN_URL = "/oauth2/**";


        @Override
        protected void configure(HttpSecurity http) throws Exception {
//            http.cors().and().csrf().disable();

            http
                    .antMatcher(LOGIN_URL)
                    .oauth2Login(
                            httpSecurityOAuth2LoginConfigurer -> {
                                // 覆盖获取accessToken的client
                                httpSecurityOAuth2LoginConfigurer.tokenEndpoint(tokenEndpointConfig -> {
                                    tokenEndpointConfig.accessTokenResponseClient(new IDAASAuthorizationCodeTokenResponseClient());
                                });
                                // 覆盖解析user信息的service
                                httpSecurityOAuth2LoginConfigurer.userInfoEndpoint(userInfoEndpointConfig -> {
                                    userInfoEndpointConfig.userService(new IDAASOAuth2UserService());
                                });
                            }
                    )
                    .authorizeRequests()
                    //        .antMatchers("/").permitAll()
                    .antMatchers("/login/oauth2/**").permitAll()
                    .antMatchers("/oauth2/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .logout().permitAll()
                    .logoutSuccessHandler(myLogoutSuccessHandler)
                    .deleteCookies("JSESSIONID");   // 删除cookie

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

            http.exceptionHandling()
                    .accessDeniedHandler(myAccessDeniedHandler)
                    .authenticationEntryPoint(oauthAuthenticationEntryPoint);
        }
    }

    @Configuration
    @Order(1)
    class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter
    {
        private final String LOGIN_URL = "/login";

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable();
            http
                    .antMatcher(LOGIN_URL)
                    .formLogin()//.loginProcessingUrl("/login")
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
                    .authenticationEntryPoint(jsonAuthenticationEntryPoint);
        }
    }
    */



    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new MyPasswordEncoder();
    }

}