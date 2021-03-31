package com.example.webApp.config;

import com.example.webApp.Servie.UserServiceSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceSecurity userServiceSecurity;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity

                .authorizeRequests()
               // .antMatchers("/admin/**").permitAll()
               // .antMatchers("/").hasRole("USER")
                .antMatchers("/registration", "/registration/**", "/404", "/device/sensor/value", "/test", "/test1").not().fullyAuthenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
        httpSecurity.csrf().disable();

    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceSecurity).passwordEncoder(bCryptPasswordEncoder());
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("user")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .authorities("ROLE_ADMIN");
//    }

//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(bCryptPasswordEncoder().encode("1")).roles("USER")
//                .and()
//                .withUser("user2").password(bCryptPasswordEncoder().encode("2")).roles("USER")
//                .and()
//                .withUser("admin").password(bCryptPasswordEncoder().encode("3")).roles("ADMIN");
//    }




}