package com.likelion.spoonclass.config.auth.security;

import com.likelion.spoonclass.config.auth.jwt.JwtEntryPoint;
import com.likelion.spoonclass.config.auth.jwt.JwtFilter;
import com.likelion.spoonclass.config.auth.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtProvider jwtProvider;
    private final AuthenticationEntryPoint jwtEntryPoint;
    private final String[] AUTHENTICATED_URI_LIST = {
            "/lesson/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // authentication
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .exceptionHandling()
                    .authenticationEntryPoint(jwtEntryPoint)
                .and()

                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                // authorization
                .authorizeRequests()
                    // authenticated
                .antMatchers(HttpMethod.GET,"/lesson/**").permitAll()
                    .antMatchers(AUTHENTICATED_URI_LIST).authenticated()
                    // permitAll
                    .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                    .antMatchers(HttpMethod.GET,"/**").permitAll()
                    .antMatchers(HttpMethod.POST,"/**").permitAll()
                    .antMatchers(HttpMethod.DELETE,"/**").permitAll()
                    .anyRequest().permitAll()
                .and()

                //JWT
                .addFilterBefore(new JwtFilter(jwtProvider),
                        UsernamePasswordAuthenticationFilter.class)
                ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/docs/**","/webjars/**");
    }
}
