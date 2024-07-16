package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PojoClass.LoginUser;
import com.example.demo.Security.MyUserDetailsService;
import com.example.demo.webToken.JwtServices;

@RestController
public class webTokenController {
    
    @Autowired
    private JwtServices jwtServiceObj;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired 
    private MyUserDetailsService myUserDetailsService;
    
    @PostMapping("/Authenticate")
    public String authenticateToken(@RequestBody LoginUser loginUserObj) {
    	System.out.println("im in aurhrntication token ------");
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserObj.getUsername(), loginUserObj.getPassword())
            );
            if (authentication.isAuthenticated()) {
            	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                return jwtServiceObj.generateToken(myUserDetailsService.loadUserByUsername(loginUserObj.getUsername()));
            } else {
                throw new UsernameNotFoundException("Invalid credentials");
            }
        } catch (AuthenticationException e) {
            throw new UsernameNotFoundException("Invalid credentials", e);
        }
    }
}
