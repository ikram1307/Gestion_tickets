package com.Gst_tickets.Gst_tickets.Configuration;

import com.Gst_tickets.Gst_tickets.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http ) throws Exception {
        http
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/ListOrg").hasRole("ADMIN")
                        .requestMatchers("/ticket").hasRole("ADMIN")

                        .requestMatchers("/home","/evenement","/css/*", "/fonts/*","/images/*").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/ListOrg")
                        .permitAll()
                )
           ;
        return http.build();
    }
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password(bCryptPasswordEncoder().encode("123"))
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }


}
