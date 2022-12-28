package org.idb.TestSpringBoot.service;

import org.idb.TestSpringBoot.entity.CustomUserDetails;
import org.idb.TestSpringBoot.entity.User;
import org.idb.TestSpringBoot.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u= repo.findByEmail(email);
        if(u==null){
            throw new UsernameNotFoundException("This email id not found");
        }

        return new CustomUserDetails(u);
    }
}
