package com.example.demo.Security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        System.out.println("im in onAuthenticationSuccess");

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_admin"));

        Map<String, String> result = new HashMap<>();
        if (isAdmin) {
            System.out.println("im in admin");
            result.put("message", "Welcome Admin!");
            result.put("redirectUrl", "/admins/adminHome");
            System.out.println("Redirecting to /admins/adminHome");
        } else {
            result.put("message", "Welcome User!");
            result.put("redirectUrl", "/admins/userHome");
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }
    
}
