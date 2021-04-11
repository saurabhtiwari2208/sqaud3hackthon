package com.bankdetailssvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private ServiceBasicAuthEntryPoint authenticationEntryPoint;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ServicePropertiesConfig config;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(authenticationEntryPoint);
    } 

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser(config.getBasicAuthUsername()).password(passwordEncoder.encode(config.getBasicAuthPassword()))
          .authorities("ROLE_USER");
    }

}
