package com.demojavadj.appweb.services;

import com.demojavadj.appweb.dto.RegisterDto;
import com.demojavadj.appweb.models.Users;

import java.util.List;

public interface UserService {
    List<Users> allListUsers();

    void saveUser(RegisterDto registerDto);


}
