package com.sandrew.bootcas;


import com.sandrew.bootcas.shiro.MyCasRealm;
import com.sandrew.bootcas.shiro.MyFormAuthenticationFilter;
import com.sandrew.bootcas.shiro.session.MySqlSessionValidationScheduler;
import com.sandrew.bootcas.shiro.session.RedisSessionDAO;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  shiro 配置类
 */
@Configuration
@Log4j2
public class ShiroConfiguration
{
    @Value("${servlet.context-path}")
    private String contextPath;

    /**
     * 配置shiroFilter
     *
     * @return
     */
    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilter()
    {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();

        shiroFilter.setLoginUrl("http://10.6.22.187:8081/cas?service=http://10.6.33.142:8083/cas-client-2/cas");
        shiroFilter.setSuccessUrl("/sso");
        //shiroFilter.setUnauthorizedUrl("/");

        CasFilter casFilter = new CasFilter();
        casFilter.setFailureUrl("/casFailure.jsp");
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("http://10.6.22.187:8081/cas/logout");
        Map<String, Filter> filters = shiroFilter.getFilters();
        filters.put("anon", new AnonymousFilter());
        filters.put("authc", new MyFormAuthenticationFilter());
        filters.put("logout", logoutFilter);
        filters.put("roles", new RolesAuthorizationFilter());
        filters.put("user", new UserFilter());
        filters.put("cas", casFilter);
        //filters.put("captcha", new CaptchaValidateFilter());  如果需要验证码,打开此过滤器
//        shiroFilter.setFilters(filters);
        shiroFilter.setSecurityManager(securityManager());

        Map<String, String> filterChainDefinitionMapping = new LinkedHashMap<String, String>();
        filterChainDefinitionMapping.put("/login.html", "anon");
        filterChainDefinitionMapping.put("/casFailure.jsp", "anon");
        //filterChainDefinitionMapping.put("/", "anon");
        filterChainDefinitionMapping.put("/shutdown", "anon");
        filterChainDefinitionMapping.put("/register/**", "anon");
        filterChainDefinitionMapping.put("/assets/**", "anon");
        filterChainDefinitionMapping.put("/images/**", "anon");
        filterChainDefinitionMapping.put("/js/**", "anon");
        filterChainDefinitionMapping.put("/style/**", "anon");
        filterChainDefinitionMapping.put("/generate/**", "anon"); //生成各类
        filterChainDefinitionMapping.put("/logout", "logout");
        filterChainDefinitionMapping.put("/cas", "cas");
        filterChainDefinitionMapping.put("/**/*.html", "authc");
        filterChainDefinitionMapping.put("/**", "user");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
        log.debug("===============配置shiroFilter完毕!=============");
        return shiroFilter;
    }

    /**
     * @return
     */
    @Bean(name="securityManager")
    public SecurityManager securityManager()
    {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean(name="realm")
    //@DependsOn("lifecycleBeanPostProcessor")
    public MyCasRealm realm()
    {
        MyCasRealm myCasRealm = new MyCasRealm();
        myCasRealm.setCasServerUrlPrefix("http://10.6.22.187:8081/cas");
        myCasRealm.setCasService("http://10.6.33.142:8083/cas-client-2/cas");
        //        accountAuthorizationRealm.init();
        //        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //        matcher.setHashAlgorithmName("MD5");
        //        matcher.setStoredCredentialsHexEncoded(true);
        //        matcher.setHashIterations(1);
        //        myCasRealm.setCredentialsMatcher(matcher);
        return myCasRealm;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor()
    {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor()
    {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator()
    {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean()
    {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(securityManager());
        return methodInvokingFactoryBean;
    }

    /**
     *  定义session验证任务,定时检查session是否过期
     * @return
     */
    @Bean
    public MySqlSessionValidationScheduler sessionValidationScheduler()
    {
        MySqlSessionValidationScheduler sqlSessionValidationScheduler = new MySqlSessionValidationScheduler();
        sqlSessionValidationScheduler.setInterval(1800000);
        //sqlSessionValidationScheduler.setSessionManager(sessionManager());
        return sqlSessionValidationScheduler;
    }


    @Bean
    public DefaultSessionManager sessionManager()
    {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionValidationSchedulerEnabled(false);
        sessionManager.setSessionIdCookie(sessionIdCookie());
        return sessionManager;
    }


    /**
     *  自定义sessionDao,将session保存到redis或数据库
     * @return
     */
    @Bean
    public RedisSessionDAO sessionDAO()
    {
//      MySqlSessionDAO sessionDAO = new MySqlSessionDAO();
        RedisSessionDAO sessionDAO = new RedisSessionDAO();
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        sessionDAO.setSessionIdGenerator(sessionIdGenerator());
        return sessionDAO;
    }

    @Bean
    public SessionIdGenerator sessionIdGenerator()
    {
        SessionIdGenerator sessionIdGenerator = new JavaUuidSessionIdGenerator();
        return sessionIdGenerator;
    }

    @Bean
    public SimpleCookie sessionIdCookie()
    {
        SimpleCookie simpleCookie = new SimpleCookie("sid");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1);
        simpleCookie.setDomain("");
        simpleCookie.setPath("/");
        return simpleCookie;
    }
}
