package net.lowerytech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN", "USER")
                .and().withUser("user").password(passwordEncoder.encode("user")).roles( "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/index/**", "/product/**", "/checkout", "/docheckout").permitAll()
                .and().authorizeRequests().antMatchers("/login","logout").permitAll()
                .and().authorizeRequests().antMatchers("/static/css/**","/js/**", "/images/**", "/**/favicon.ico").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
                .and().logout()
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout-success")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        ;
    }



}
