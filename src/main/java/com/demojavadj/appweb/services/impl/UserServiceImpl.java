package com.demojavadj.appweb.services.impl;

import com.demojavadj.appweb.models.Users;
import com.demojavadj.appweb.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(email);

        if (users !=null){
            var auth = User.withUsername(users.getEmail())
                    .password(users.getPassword())
                    .roles("USER")
                    .build();
            return auth;
        }

        return null;
    }
}
