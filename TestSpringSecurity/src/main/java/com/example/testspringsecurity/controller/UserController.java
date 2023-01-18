package com.example.testspringsecurity.controller;

import com.example.testspringsecurity.entity.Role;
import com.example.testspringsecurity.entity.User;
import com.example.testspringsecurity.repo.IRoleRepo;
import com.example.testspringsecurity.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private IUserRepo iUserRepo;

     @Autowired
    private IRoleRepo iRoleRepo;




    @RequestMapping("/")
    public String home(){

        return "hello";
    }

    @RequestMapping("/alluser")
    public String allUser(Model m){
    m.addAttribute("userList", iUserRepo.findAll());
        return "user_list";
    }
    @RequestMapping("/user_save_form")
    public String userSaveForm(Model m){
        m.addAttribute("user", new User());
        return "user_reg_form";
    }
    @RequestMapping(value = "/user_save", method = RequestMethod.POST)
    public String userSave(@ModelAttribute("user")User u, Model m){
        List<Role> listRole= iRoleRepo.findAll();

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        u.setPassword(encoder.encode(u.getPassword()));
        iUserRepo.save(u);
        m.addAttribute("user", new User());
        m.addAttribute("listRole",listRole);

        return "redirect:/alluser";
    }




}
