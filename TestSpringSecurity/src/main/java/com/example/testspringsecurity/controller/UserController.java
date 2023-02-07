package com.example.testspringsecurity.controller;

import com.example.testspringsecurity.entity.Role;
import com.example.testspringsecurity.entity.User;
import com.example.testspringsecurity.repo.IRoleRepo;
import com.example.testspringsecurity.repo.IUserRepo;
import com.example.testspringsecurity.service.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private IUserRepo iUserRepo;

     @Autowired
    private IRoleRepo iRoleRepo;




    @RequestMapping("/users")
    public String home(Model m){
        m.addAttribute("userList", iUserRepo.findAll());
        return "user_list";
    }

    @RequestMapping("/alluser")
    public String allUser(Model m){
    m.addAttribute("userList", iUserRepo.findAll());
        return "user_list";
    }
    @RequestMapping("/users/new")
    public String userSaveForm(Model m){
        m.addAttribute("user", new User());
        return "user_reg_form";
    }
    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public String userSave(@ModelAttribute("user")User u, Model m,
                           @RequestParam("image")MultipartFile multipartFile) throws IOException {
if (!multipartFile.isEmpty()){
    System.out.println(multipartFile.getOriginalFilename());
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    u.setPassword(encoder.encode(u.getPassword()));
    u.setEnabled(true);
    u.addRole(new Role(3));

    String filename= StringUtils.cleanPath(multipartFile.getOriginalFilename());

    u.setPhoto(filename);
    User savedUser=iUserRepo.save(u);

    String uploadDir="user-photos/"+savedUser.getId();
    FileUploadUtil.saveFile(uploadDir,filename,multipartFile);
    m.addAttribute("user", new User());
}
else{

}




        return "redirect:/alluser";
    }




}
