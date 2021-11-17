package com.likelion.spoonclass.config.auth.security;

import com.likelion.spoonclass.config.auth.jwt.JwtEntryPoint;
import com.likelion.spoonclass.config.auth.jwt.JwtFilter;
import com.likelion.spoonclass.config.auth.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtProvider jwtProvider;
    private final AuthenticationEntryPoint jwtEntryPoint;

    private final String[] AUTHENTICATED_URI_LIST = {
            "/member/**"
    };

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // authentication
                .httpBasic().disable()
                .formLogin().disable()
                .csrf().disable()
                .cors()
                .and()

                .exceptionHandling()
                    .authenticationEntryPoint(jwtEntryPoint)
                .and()

                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                // authorization
                .authorizeRequests()
                    // authenticated
                    .antMatchers(AUTHENTICATED_URI_LIST).authenticated()
                    // permitAll
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
