package org.idb.TestSpringBoot.controller;

import org.idb.TestSpringBoot.entity.User;
import org.idb.TestSpringBoot.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private IUserRepo repo;

    @RequestMapping("/user_reg_form")
    public String userRegForm(Model m) {
        m.addAttribute("user", new User());
        m.addAttribute("title", "User Registration");
        return "user_reg_form";
    }

    @RequestMapping(value = "/user_reg", method = RequestMethod.POST)
    public String userReg(@ModelAttribute("user") User u, Model m) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encPass=encoder.encode(u.getPassword());
        u.setPassword(encPass);
        repo.save(u); // come from Repo no service available
        m.addAttribute("msg", "User Registration Successful");
        return "redirect:/";
    }

}
