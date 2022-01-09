package com.taihouproject.api.takao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static String secret;
    public static String param;
    public static String prefix;

    @Autowired
    public SecurityConfig(Environment env) {
        SecurityConfig.secret = env.getProperty("security.secret");
        SecurityConfig.param = env.getProperty("security.param");
        SecurityConfig.prefix = env.getProperty("security.prefix");
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.cors().and().csrf().disable();

        security
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(new com.taihouproject.api.takao.security.AuthorizationFilter(authenticationManager()))
            .authorizeRequests()
            .antMatchers("/api/v1/h/title/**").permitAll()
            .antMatchers("/api/v1/h/series/**").permitAll()
            .antMatchers("/api/v1/h/genres/**").permitAll()
            .antMatchers("/api/v1/h/characters/**").permitAll()
            .anyRequest().authenticated();
    }
}