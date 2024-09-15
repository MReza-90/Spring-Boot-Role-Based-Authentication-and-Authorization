package com.code2go.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


   //Adding support for JDBC

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){

        return new JdbcUserDetailsManager(datasource);

    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/managers/**").hasRole("MANAGER")
                        .requestMatchers("/system/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).exceptionHandling(configurer ->
                configurer
                        .accessDeniedPage("/access-denied")
        ).formLogin(form ->
                form
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                ).logout(logout -> logout.permitAll()
        );

        // HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

//    Following method is for the time you want to hard code the users and respective roles
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john= User.builder()
//                .username("john")
//                .password("{noop}1234")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary= User.builder()
//                .username("mary")
//                .password("{noop}1234")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails raha= User.builder()
//                .username("raha")
//                .password("{noop}1234")
//                .roles("EMPLOYEE","MANAGER" , "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,raha);
//    }
}
