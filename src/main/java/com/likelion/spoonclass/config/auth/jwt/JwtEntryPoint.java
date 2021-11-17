package com.likelion.spoonclass.config.auth.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component()
@RequiredArgsConstructor
public class JwtEntryPoint implements AuthenticationEntryPoint {
    private final JwtProvider jwtProvider;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        String message = jwtProvider.setInvalidJwtMessage(jwtProvider.resolve(request));

        response.sendError(HttpServletResponse.SC_FORBIDDEN, message);
    }
}
