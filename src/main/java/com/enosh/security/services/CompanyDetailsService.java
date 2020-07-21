package com.enosh.security.services;

import com.enosh.security.model.Company;
import com.enosh.security.model.CompanyDetails;
import com.enosh.security.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompanyDetailsService implements UserDetailsService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("\n\n" +  username + "\n\n");
        return repository.findByEmail(username)
                .map(CompanyDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Company by the email: " + username + " does not exists"
                ));
    }
}
