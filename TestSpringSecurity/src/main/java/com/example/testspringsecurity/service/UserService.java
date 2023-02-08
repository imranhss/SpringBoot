package com.example.testspringsecurity.service;

import com.example.testspringsecurity.entity.User;
import com.example.testspringsecurity.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;
    public boolean isEmailUnique(Integer id,String email){
        User userByEmail=iUserRepo.getUserByEmail(email);
        if(userByEmail==null)
            return true;

        boolean isCreatedNew=(id==null);

        if(isCreatedNew){
            if(userByEmail !=null){
                return  false;
            }
        }
        else{
            if(userByEmail.getId() !=id){
                return  false;
            }
        }

        return  true;
    }
}
