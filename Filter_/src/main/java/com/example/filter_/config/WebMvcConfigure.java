package com.example.filter_.config;

import com.example.filter_.interceptor.inter1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new inter1());
        interceptorRegistration.addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
