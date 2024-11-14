package com.logicorp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/rfid/**").hasRole("USER")
                .antMatchers("/api/rfid/update", "/api/rfid/update-location").hasRole("ADMIN")
                .antMatchers("/api/predict/**").permitAll()
            .and()
            .httpBasic();
    }
}
