package com.events.eventService;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}170c8581-9562-4a1b-adab-a32cc773af57").roles("USER");

    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/eventController/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/eventController/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/eventController/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/eventController/**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
