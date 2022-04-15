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
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/","/login", "/registration").permitAll()
                    .antMatchers("/login*").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                .and()
                    .logout().permitAll();
    }

    @Override
    protected void configure (final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(getPasswordEncoder().encode("user1")).roles("USER")
                .and()
                .withUser("user2").password(getPasswordEncoder().encode("user2")).roles("USER");

//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(getPasswordEncoder())
//                .usersByUsernameQuery("select " +
//                        "login, password from users where login = ?")
//                .authoritiesByUsernameQuery("select u.login, r.roles " +
//                        "from users u inner join roles r " +
//                        "on u.id = r.user_id where u.login = ?");
    }
}
