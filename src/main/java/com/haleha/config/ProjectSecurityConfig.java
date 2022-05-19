package com.haleha.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * /account - Secured
     * /balance - Secured
     * /loans - Secured
     * /cards - Secured
     * /notices - Not Secured
     * contact - Not Secured
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/account").authenticated()
                .antMatchers("/balance").authenticated()
                .antMatchers("/loans").authenticated()
                .antMatchers("/cards").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll().and()
                .formLogin().and()
                .httpBasic();
    }
}
