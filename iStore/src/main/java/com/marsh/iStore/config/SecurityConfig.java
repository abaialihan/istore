package com.marsh.iStore.config;

import com.marsh.iStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/auth", "/registration").permitAll()
                .antMatchers("/auth*").permitAll()
                .anyRequest().authenticated()
                    .and()
                .formLogin()
                .loginPage("/auth")
                .defaultSuccessUrl("/", true)
                    .and()
                .logout().permitAll();
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());


//                .usersByUsernameQuery("SELECT username, password, active FROM users WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT u.username, r.roles FROM users u INNER JOIN roles r ON u.id = r.user_id WHERE u.username=?");
    }

}
