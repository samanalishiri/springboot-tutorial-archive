package com.springboot.tutorial.step004.config;//package com.springboot.tutorial.step004securitylogininmemoryuser.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER").and()
                .withUser("admin").password("admin").roles("ADMIN", "USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").access("hasRole('USER')")
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1)
                .expiredUrl("/security/logout.action")
                .and().sessionFixation().newSession()
                .and().formLogin()
                .loginProcessingUrl("/security/login.action")
                .loginPage("/security/login.view")
                .defaultSuccessUrl("/home.view")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and().logout()
                .logoutUrl("/security/logout.action")
                .logoutSuccessUrl("/")
                .clearAuthentication(true)
                .logoutSuccessHandler(new SimpleUrlLogoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and().httpBasic()
                .and().csrf().disable();
    }
}
