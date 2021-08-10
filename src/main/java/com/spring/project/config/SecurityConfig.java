package com.spring.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Base64;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 시큐리티 무시 경로
        web.ignoring().antMatchers("/webjars/**","/theme/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/signup").permitAll()
            .anyRequest().authenticated();

        http.formLogin()
            .loginProcessingUrl("/login")
            .loginPage("/login")
            .failureUrl("/login?error")
            .defaultSuccessUrl("/index",true)
            .usernameParameter("userId").usernameParameter("password")
            .and();

        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
            .logoutSuccessUrl("/login");
    }

    @Configuration
    static class AuthConfigAdapter extends GlobalAuthenticationConfigurerAdapter{

        @Autowired
        UserDetailsService userDetailsService;

        @Bean
        PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
        }
    }
}
