package com.demojavadj.appweb.services.impl;

import com.demojavadj.appweb.dto.RegisterDto;
import com.demojavadj.appweb.models.Role;
import com.demojavadj.appweb.models.Users;
import com.demojavadj.appweb.repository.UserRepository;
import com.demojavadj.appweb.services.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

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

    @Override
    public List<Users> allListUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(RegisterDto registerDto) {

        var bcryptPasswordEncoder = new BCryptPasswordEncoder();

        Users user = new Users();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setDni(registerDto.getDni());
        user.setDirection(registerDto.getDirection());
        user.setRoles(Arrays.asList(new Role("USER")));
        user.setCreateAt(new Date());
        user.setEmail(registerDto.getEmail());
        user.setPassword(bcryptPasswordEncoder.encode(registerDto.getPassword()));
        userRepository.save(user);
    }
}
