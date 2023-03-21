package com.events.eventService;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Die SpringSecurityConfig ist eine Konfigurationsklasse, die die Sicherheitseinstellungen für die Webanwendung konfiguriert.
 * Diese Klasse definiert, welche Benutzer auf welche Endpunkte der Anwendung zugreifen dürfen.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Konfiguriert die Benutzerauthentifizierung für die Anwendung.
     * In diesem Beispiel werden 2 Benutzer hinzugefügt, die für die Demo verwendet werden.
     * @param auth Das AuthenticationManagerBuilder-Objekt, das für die Konfiguration der Benutzerauthentifizierung verwendet wird.
     * @throws Exception Wenn ein Fehler bei der Konfiguration der Benutzerauthentifizierung auftritt.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}170c8581-9562-4a1b-adab-a32cc773af57").roles("USER");

    }

    /**
     * Konfiguriert die HTTP-Sicherheitseinstellungen für die Anwendung.
     * In diesem Beispiel wird HTTP Basic-Authentifizierung verwendet, um die Endpunkte der Anwendung abzusichern.
     * @param http Das HttpSecurity-Objekt, das für die Konfiguration der HTTP-Sicherheitseinstellungen verwendet wird.
     * @throws Exception Wenn ein Fehler bei der Konfiguration der HTTP-Sicherheitseinstellungen auftritt.
     */
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

