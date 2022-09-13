package com.alkemy.disney.auth.config;

import com.alkemy.disney.auth.filter.JwtRequestFilter;
import com.alkemy.disney.auth.services.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsCustomService userDetailsCustomService;
        @Autowired
        private JwtRequestFilter jwtRequestFilter;

        @Bean
        public DaoAuthenticationProvider authProvider(){
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsCustomService);
            authProvider.setPasswordEncoder(encoder());
            return authProvider;
        }
        @Bean
        public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.authenticationProvider(authProvider());
        }


        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception{
            httpSecurity.csrf().disable()
                    .authorizeRequests().antMatchers("/auth/*").permitAll()
                    .anyRequest().authenticated()
                    .and().exceptionHandling()
                    .and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        }
}
