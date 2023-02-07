package com.example.testspringsecurity.service;

import com.example.testspringsecurity.entity.User;
import com.example.testspringsecurity.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;
    public boolean isEmailUnique(String email){
        User userByEmail=iUserRepo.getUserByEmail(email);
        return  userByEmail==null;
    }
}
