package com.poly.utils;

import com.poly.entity.Account;
import com.poly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;

    @Autowired
    BCryptPasswordEncoder pe;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                Account user = accountService.findById(username);
                String password = pe.encode(user.getPassword());
                String[] roles = user.getAuthorities().stream()
                        .map(er -> er.getRole().getRoleID())
                        .collect(Collectors.toList()).toArray(new String[0]);
                return User.withUsername(username).password(password).roles(roles).build();
            }catch (NoSuchElementException e){
                throw new UsernameNotFoundException(username+"not found!");
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //CSRF , CORS
        http.csrf().disable();
        http.authorizeRequests()
                        .antMatchers("/order/**").authenticated()
                        .antMatchers("/admin/**").hasRole("AD")
                        .anyRequest().permitAll();

        http.formLogin()
                        .loginPage("/security/login/form")
                        .loginProcessingUrl("/security/login")
                        .defaultSuccessUrl("/security/login/success",false)
                        .failureUrl("/security/login/error");

        http.rememberMe()
                .tokenValiditySeconds(86400);

        http.exceptionHandling()
                .accessDeniedPage("/security/unauthoried");

        http.logout()
                .logoutUrl("/security/logoff")
                .logoutSuccessUrl("/security/logoff/success");



//        //phân quyền sử dụng
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .anyRequest().permitAll();
//        //Điểu khiển lỗi truy cập kh đúng vai trò
//        http.exceptionHandling().accessDeniedPage("/auth/access/denied");
//        http.formLogin()
//                .loginPage("/auth/login/form")
//                .loginProcessingUrl("/auth/login")
//                .defaultSuccessUrl("/auth/login/success",false)
//                .failureUrl("/auth/login/error")
//                .usernameParameter("userID")
//                .passwordParameter("password");
//
//        //Đăng xuất
//        http.logout()
//                .logoutUrl("/auth/logoff")
//                .logoutSuccessUrl("/auth/logoff/success");
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
    }
}
