package com.example.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class myConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/all/**").permitAll();
        http.authorizeRequests()
                .antMatchers("/user1/**").hasRole("user1")
                .antMatchers("/user2/**").hasRole("user2")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .failureHandler()
                .successHandler()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint();
    }


}
