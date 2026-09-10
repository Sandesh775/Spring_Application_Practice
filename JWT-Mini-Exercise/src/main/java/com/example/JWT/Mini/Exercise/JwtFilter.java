package com.example.JWT.Mini.Exercise;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        // your turn:
        // 1. check if authHeader exists and starts with "Bearer "
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            // 2. extract token (substring after "Bearer ")
            token = authHeader.substring(7);
            username = jwtUtil.extractUsername(token);
        }

        // 3. validate token
        if(username != null && jwtUtil.validateToken(token)){
            // 4. if valid → set authentication in SecurityContext
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(username, null, List.of());
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        // 5. filterChain.doFilter(request, response)
        filterChain.doFilter(request,response);
    }
}
