package com.tanveer.CurdDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {



//    adding user and password and role : in-memory authentication
   @Bean
   public InMemoryUserDetailsManager userDetailsManager(){
      UserDetails tanveer = User.builder()
              .username("Tanveer")
              .password("{noop}Pas@12")
              .roles("EMPLOYEE")
              .build();

      UserDetails asif = User.builder()
              .username("Asif")
              .password("{noop}Pas@123")
              .roles("EMPLOYEE","MANAGER")
              .build();

      UserDetails anik = User.builder()
              .username("Anik")
              .password("{noop}Pas@1234")
              .roles("EMPLOYEE","MANAGER","ADMIN")
              .build();

      return new InMemoryUserDetailsManager(tanveer,asif,anik);
   }


//   add support for JDBC no more hardcoded users
/*   @Bean
   public UserDetailsManager userDetailsManager(DataSource dataSource){
      return new JdbcUserDetailsManager(dataSource);
   }*/

//   restrict action based on roles
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

      httpSecurity.authorizeHttpRequests(configure -> {
         configure
                 .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                 .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                 .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                 .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                 .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                 .requestMatchers("/v3/api-docs/**","/swagger-ui/**").permitAll();

      });
//      use HTTp Basic Authentication
      httpSecurity.httpBasic(Customizer.withDefaults());

//      disable cross site Request Forgery
      httpSecurity.csrf(csrf -> csrf.disable());

      return httpSecurity.build();
   }
}
