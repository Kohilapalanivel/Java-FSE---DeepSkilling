package com.example.jwt_authentication.jwt;
import java.io.IOException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtTokenFilter extends OncePerRequestFilter 
{
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws ServletException, IOException {
        System.out.println("======================================");
        System.out.println("Request URI : " + request.getRequestURI());
        String token = resolveToken(request);
        System.out.println("Received Token : " + token);
        if (token != null && jwtTokenProvider.validateToken(token))
        {
            System.out.println("Token is VALID");
            String username = jwtTokenProvider.getUsername(token);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,null,Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Authenticated User : " + username);
        }
        else
        {
            System.out.println("Token is INVALID or NULL");
        }
        System.out.println("======================================");
        filterChain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) 
    {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer "))
        {
            return bearerToken.substring(7);
        }
        return null;
    }
}
