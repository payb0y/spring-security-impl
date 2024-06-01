package com.example.demo.employee.filter;

import com.example.demo.employee.entity.Token;
import com.example.demo.employee.repository.EmployeRepository;
import com.example.demo.employee.repository.TokenRepository;
import com.example.demo.employee.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final EmployeRepository employeRepository;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authorization.substring(7);
        String email = jwtService.extractUsername(jwt);
        Token token = tokenRepository.findByToken(jwt).orElse(null);

        if (email != null && token != null) {
            UserDetails user = employeRepository.findByEmail(email).orElse(null);
            if (user != null && jwtService.isTokenValid(jwt, user) && !token.getIsRevoked()) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }


        filterChain.doFilter(request, response);
    }
}
