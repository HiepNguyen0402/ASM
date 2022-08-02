package com.poly.utils;

import com.poly.entity.Account;
import com.poly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    AccountService account;

//    @Autowired
//    BCryptPasswordEncoder pe;
//
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userID ->{
//        try{
//            Account user = account.findById(userID);
//            String password = pe.encode(user.getPassword());
////       S
//        }catch (NoSuchElementException e){
//
//        }
//    });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //CSRF , CORS
        http.csrf().disable().cors().disable();

        //phân quyền sử dụng
        http.authorizeRequests().anyRequest().permitAll();
        //Điểu khiển lỗi truy cập kh đúng vai trò
        http.exceptionHandling().accessDeniedPage("/auth/access/denied");
        http.formLogin()
                .loginPage("/auth/login/form")
                .loginProcessingUrl("/auth/login")
                .defaultSuccessUrl("/auth/login/success",false)
                .failureUrl("/auth/login/error")
                .usernameParameter("userID")
                .passwordParameter("password");

        //Đăng xuất
        http.logout()
                .logoutUrl("/auth/logoff")
                .logoutSuccessUrl("/auth/logoff/success");
    }
}
