package com.example.demo.Security;

import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.RepositoryClass.StaffDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    StaffDetailsRepository staffDetailsRepoObj;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("---------------"+username);
        Optional<StaffDetailsEntity> user = staffDetailsRepoObj.findByStaffNumberEntity(username);
        if (user.isPresent()) {
            var userObj = user.get();
            System.out.println("---------im loadUserByUsername if ");
            return User.builder()
                    .username(userObj.getStaffNumberEntity())
                    .password(userObj.getStaffPasswordEntity())
                    .roles(getRoles(userObj))
                    .build();

        } else {
        	System.out.println("---------im loadUserByUsername else --if ");
            throw new UsernameNotFoundException(username);
        }

    }

    private String[] getRoles(StaffDetailsEntity userObj) {
        if (userObj.getStaffRoleEntity() == null) {
            return new String[]{"user"};
        }
        return userObj.getStaffRoleEntity().split(",");
    }

}
