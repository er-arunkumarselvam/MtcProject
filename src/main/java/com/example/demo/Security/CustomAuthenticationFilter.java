package com.example.demo.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;
    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationFailureHandler failureHandler;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper, CustomAuthenticationSuccessHandler successHandler, CustomAuthenticationFailureHandler failureHandler) {
        super.setAuthenticationManager(authenticationManager);
        this.objectMapper = objectMapper;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
        setFilterProcessesUrl("/admin/login"); // Ensure this matches your form login URL
        setAuthenticationSuccessHandler(successHandler); // Set success handler
        setAuthenticationFailureHandler(failureHandler); // Set failure handler
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Map<String, String> requestBody = objectMapper.readValue(request.getInputStream(), Map.class);
            String username = requestBody.get("username");
            String password = requestBody.get("password");
            System.out.println("Attempting authentication for user: " + username);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            return this.getAuthenticationManager().authenticate(authRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        // Custom behavior on successful authentication (e.g., return a JSON response)
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\":\"Login successful\"}");
        response.getWriter().flush();

        System.out.println("Authentication successful!");
        successHandler.onAuthenticationSuccess(request, response, authResult);

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        // Custom behavior on unsuccessful authentication (e.g., return a JSON response)
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"message\":\"Login failed\"}");
        response.getWriter().flush();

        System.out.println("Authentication failed: " + failed.getMessage());
        failureHandler.onAuthenticationFailure(request, response, failed);

    }
}
