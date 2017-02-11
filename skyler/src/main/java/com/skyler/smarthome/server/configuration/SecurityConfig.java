package com.skyler.smarthome.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PersistentTokenRepository tokenRepository;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/internal/**").access("hasRole('ROLE_ANONYMOUS') or hasRole('ROLE_ADMIN') and hasIpAddress('0:0:0:0:0:0:0:1') or hasIpAddress('192.168.0.1/255') or hasIpAddress('127.0.0.1/255')")
                .antMatchers("/login").permitAll().antMatchers("/home").hasRole("ADMIN").anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll().and().logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .permitAll().and().sessionManagement()
                .sessionFixation().changeSessionId()
                .maximumSessions(1).maxSessionsPreventsLogin(true)
                .and().and().csrf().and().exceptionHandling().accessDeniedPage("/error?error");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
                "remember-me", userDetailsService, tokenRepository);
        return tokenBasedservice;
    }
}