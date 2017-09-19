package com.example.demo.exp2;/**
 * Created by huxu on 2017/9/18.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置Spring Security
 *
 * @author HUXU
 * @create 2017-09-18 23:02
 **/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //设置拦截规则，设置默认登录页面以及登录成功后的跳转页面
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //设置拦截规则
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //开启默认登录页面
                .formLogin()
                //默认登录页面
                .loginPage("/login")
                //默认登录成功跳转页面
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                //设置注销
                .logout()
                .permitAll();
    }

    //定义两个用户，设置用户名、用户密码、用户角色等信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("lenve").password("111").roles("USER")
                .and()
                .withUser("sang").password("222").roles("USER");
    }

    //方法中设置静态资源不被拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置不拦截规则
        web.ignoring().antMatchers("/resources/static/**");
    }
}