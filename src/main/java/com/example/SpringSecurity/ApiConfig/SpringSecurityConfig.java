package com.example.SpringSecurity.ApiConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.inMemoryAuthentication().withUser("nihalMemory").password("password").roles("Admin");
                auth.inMemoryAuthentication().withUser("nikhil").password("nikhil").roles("Student");
                auth.inMemoryAuthentication().withUser("sai").password("sai").roles("Employe");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
           //     http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
                http.authorizeHttpRequests()
                        .antMatchers("/home").permitAll()
                        .antMatchers("/welcome").authenticated()
                        .antMatchers("/admin").hasAuthority("Admin")
                        .antMatchers("/student").hasAuthority("Student")
                        .antMatchers("/employe").hasAuthority("Employe").and().httpBasic();

        }
        @Bean
        public static PasswordEncoder PasswordEncoder(){
                return NoOpPasswordEncoder.getInstance();
        }
}
