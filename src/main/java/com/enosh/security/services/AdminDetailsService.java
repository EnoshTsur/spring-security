package com.enosh.security.services;

import com.enosh.security.model.AdminDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsService implements UserDetailsService {

    @Value("${admin.password}")
    private String password;

    @Value("${admin.username}")
    private String adminUsername;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!username.equals(adminUsername)) throw new UsernameNotFoundException("Not admin name");
        return new AdminDetails(password, adminUsername);
    }
}
