package com.example.testspringsecurity.controller;

import com.example.testspringsecurity.entity.Role;
import com.example.testspringsecurity.entity.User;
import com.example.testspringsecurity.repo.IRoleRepo;
import com.example.testspringsecurity.repo.IUserRepo;
import com.example.testspringsecurity.service.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private IRoleRepo iRoleRepo;


    @RequestMapping("/users")
    public String home(Model m) {
        m.addAttribute("userList", iUserRepo.findAll());
        return "user_list";
    }


    @RequestMapping("/users/new")
    public String userSaveForm(Model m) {
        m.addAttribute("user", new User());
        return "user_reg_form";
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public String userSave(@ModelAttribute("user") User u, Model m,
                           @RequestParam("image") MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            System.out.println(multipartFile.getOriginalFilename());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            u.setPassword(encoder.encode(u.getPassword()));
            u.setEnabled(true);
            u.addRole(new Role(3));

            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            u.setPhoto(filename);
            User savedUser = iUserRepo.save(u);

            String uploadDir = "user-photos/" + savedUser.getId();
            FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
            m.addAttribute("user", new User());
        }

        return "redirect:/alluser";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        try{
            User user =iUserRepo.findById(id).get();
            model.addAttribute("user", user);
            return "user_reg_form";
        }
        catch(UsernameNotFoundException  e){
            redirectAttributes.addAttribute("message", "User Not found with this ID");
            return "redirect:/alluser";
        }


    }




}
