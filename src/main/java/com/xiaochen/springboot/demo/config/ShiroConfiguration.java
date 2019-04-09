package com.xiaochen.springboot.demo.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 04-01 14:44
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        //设置那个页面是登录页面
        bean.setLoginUrl("/login");
        //设置成功验证成功跳转的页面
        bean.setSuccessUrl("/hello");
        //设置没有权限时跳转的页面
        bean.setUnauthorizedUrl("/unauthorized.html");
        //设置哪些页面需要受保护，
        // anon 可以被匿名访问
        // authc 必须认证(即登录)后才可能访问的页面.
        // logout 登出.
        // roles 角色过滤器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //后边的页面全部添加到这个map里边
        // 示例1：filterChainDefinitionMap.put("/guest/**", "anon");
        // 示例2：filterChainDefinitionMap.put("/user/**", "roles[user]");
        filterChainDefinitionMap.put("/tuichu","logout");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }
    //配置核心安全事务管理器
    @Bean
    public DefaultWebSecurityManager securityManager() {
        System.err.println("--------------shiro已经加载----------------");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm());
        return manager;
    }
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm=new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }
    //加密算法
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }
}
