package com.company.coffeeshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
public class CsSecurityConfig extends WebSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers(matchers -> matchers.antMatchers("/jasperserver-pro/**"))
                .headers(headers -> headers.frameOptions().sameOrigin());
    }
}
