package com.example.demo.config;

import com.example.demo.controller.ContactController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
    private static Logger log= LoggerFactory.getLogger(ContactController.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {

     /*   http.authorizeRequests().anyRequest().permitAll()
                .and().formLogin()
                .and().httpBasic();*/

        http.csrf().disable().
                authorizeRequests()
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/dashboard").authenticated()
                .mvcMatchers("/OpenMessages").hasRole("ADMIN")
                .mvcMatchers("/Swimming").permitAll()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/login").permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Divya").password("123").roles("USER")
                .and()
                .withUser("admin").password("123").roles("USER","ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());

    }


}

