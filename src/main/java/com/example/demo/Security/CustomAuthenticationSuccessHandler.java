package com.example.demo.Security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.RepositoryClass.StaffDetailsRepository;
import com.example.demo.webToken.JwtServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private StaffDetailsRepository staffRepo;
	
    @Autowired 
    private MyUserDetailsService myUserDetailsService;
    
    @Autowired
    private JwtServices jwtServiceObj;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        System.out.println("im in onAuthenticationSuccess");
        

        String username = authentication.getName();
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
        String token = jwtServiceObj.generateToken(userDetails);
        
        StaffDetailsEntity staffDetails = getUserDetails(username);
        Map<String, String> result = new HashMap<>();
        result.put("staffName", staffDetails.getStaffNameEntity());
        result.put("staffNumber", staffDetails.getStaffNumberEntity());
        result.put("Designation", staffDetails.getStaffDesignationEntity());
        boolean isAdmin = authentication.getAuthorities().stream()
               .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_admin"));
        if (isAdmin) {
            System.out.println("im in admin");
            result.put("role", "admin");
            result.put("token",token);
        } else {
        	 result.put("role", "user");
            result.put("token",token);
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }
    
    public StaffDetailsEntity getUserDetails(String staffNumber)
    {
    	Optional<StaffDetailsEntity> staffData = staffRepo.findById(staffNumber);
    	if(staffData.isPresent())
    	{
    		return staffData.get();
    	}
    	else
    		return null;
    	
    }
    
}
