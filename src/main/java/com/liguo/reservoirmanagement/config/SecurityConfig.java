package com.liguo.reservoirmanagement.config;

import com.liguo.reservoirmanagement.interceptor.MyAuthenctiationFailureHandler;
import com.liguo.reservoirmanagement.interceptor.MyAuthenticationSuccessHandler;
import com.liguo.reservoirmanagement.interceptor.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author nongChaTea
 * @date 2022/5/15 16:53
 */
@Configuration
@EnableWebSecurity// 开启Security

@EnableGlobalMethodSecurity(prePostEnabled = true)//开启Spring方法级安全
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Secutiry 处理链
//    SecurityContextPersistenceFilter
//    --> UsernamePasswordAuthenticationFilter
//    --> BasicAuthenticationFilter
//    --> ExceptionTranslationFilter
//    --> FilterSecurityInterceptor
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;


    @Autowired
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Autowired
    private MyUserDetailService myUserDetailService;//密码加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 自定义认证配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/images/**","/login","/register").permitAll() //不需要保护的资源，可以多个
                .antMatchers("/**").authenticated()// 需要认证得资源，可以多个
                .and()
                .formLogin().loginPage("/")
                .loginProcessingUrl("/login") //登录处理地址
                .successHandler(myAuthenticationSuccessHandler) // 登陆成功处理器
                .failureHandler(myAuthenctiationFailureHandler) // 登陆失败处理器
                .permitAll()
                .and()
                .userDetailsService(myUserDetailService);
        http.headers().cacheControl(); //禁用缓存
        http.csrf().disable(); //禁用csrf校验
    }

}