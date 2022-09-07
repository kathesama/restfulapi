//package com.kathesama.restfulapi.config;
//
//import com.kathesama.restfulapi.service.implementation.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserDetailServiceImpl userDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic(withDefaults())
////                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/v1/public/**").permitAll() // the public endpoints
//                .antMatchers("/api/v1/authenticate/**").permitAll() // the public endpoints
//                .antMatchers("/api/v1/admin/**").hasRole("ADMIN") //the admin endpoints
//                .anyRequest().authenticated(); //the others endpoints
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////        auth
////                .inMemoryAuthentication()
////                .withUser("kaguirre").password("{noop}" + "secreto").roles("USER")
////                .and()
////                .withUser("admin1").password("{noop}" + "secreto").roles("ADMIN");
////
////    }
//}
