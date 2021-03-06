package com.yl.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * shiro配置类
 *
 * @author yi
 * @desciption
 * @date 2019/8/28
 */
@Configuration
public class ShiroConfiguration {

    @Autowired
    private SystemConfig systemConfig;

    @Bean
    public AuthRealm authRealm() {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return authRealm;
    }

    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(systemConfig.getHost());
        redisManager.setDatabase(systemConfig.getDatabase());
        redisManager.setTimeout(systemConfig.getTimeout());
        redisManager.setPort(systemConfig.getPort());
        return redisManager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm());
        securityManager.setCacheManager(cacheManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public CustomerMatcher hashedCredentialsMatcher() {
        CustomerMatcher hashedCredentialsMatcher = new CustomerMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        //bean.setUnauthorizedUrl("");
        LinkedHashMap<String, String> filter = new LinkedHashMap<>();
        filter.put("/index", "authc");
        filter.put("/img/**", "anon");
        filter.put("/login", "anon");
        filter.put("/api/**", "anon");
        filter.put("/css/**", "anon");
        filter.put("/fonts/**", "anon");
        filter.put("/images/**", "anon");
        filter.put("/js/**", "anon");
        filter.put("/lib/**", "anon");
        filter.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filter);
        return bean;
    }
}
