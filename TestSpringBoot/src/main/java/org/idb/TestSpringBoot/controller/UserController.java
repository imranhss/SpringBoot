package org.idb.TestSpringBoot.controller;

import org.idb.TestSpringBoot.entity.ConfirmationToken;
import org.idb.TestSpringBoot.entity.Role;
import org.idb.TestSpringBoot.entity.User;
import org.idb.TestSpringBoot.repository.IConfirmationTokenRepository;
import org.idb.TestSpringBoot.repository.IUserRepo;
import org.idb.TestSpringBoot.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    long startTime= 0;

    @Autowired
    private IUserRepo repo;

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    private IConfirmationTokenRepository tokenRepository;

    @RequestMapping("/user_reg_form")
    public String userRegForm(Model m) {
        m.addAttribute("user", new User());
        m.addAttribute("title", "User Registration");
        return "user_reg_form";
    }

    @RequestMapping(value = "/user_reg", method = RequestMethod.POST)
    public String userReg(@ModelAttribute("user") User u, Model m) {
        long s=System.currentTimeMillis();
        startTime+=s+20000;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPass = encoder.encode(u.getPassword());
        u.setPassword(encPass);
        String userFullName = u.getFirstName() + " " + u.getLastName();
        repo.save(u); // come from Repo no service available

        //  Send validation Email
        ConfirmationToken confirmationToken = new ConfirmationToken(u);
        tokenRepository.save(confirmationToken);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(u.getEmail());
        message.setSubject("Confirm Registration");
        message.setFrom("info@emranhss.com");
        message.setText("Dear " + userFullName + ", ");
        System.out.println(userFullName + " +++++++++++++++++++++++++++++++++++++++++++++++++++");
        message.setText("Dear " + userFullName + "\n" + "To confirm your account, please click here :" +
                "http://localhost:8082/confirm-account?token=" + confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(message);

        m.addAttribute("msg", "User Registration Successful");
        return "redirect:/";
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(@RequestParam("token") String token, Model m) {
        Role r=new Role();

        ConfirmationToken confirmationToken = tokenRepository.findByConfirmationToken(token);
        if(token != null){
            long endTime=System.currentTimeMillis();
            if (startTime>endTime){
                User user = repo.findByEmail(confirmationToken.getUser().getEmail());
                user.setEnabled(true);
                repo.save(user);
                m.addAttribute("message","Account Verified" );

            }else{
                System.out.println("Time-----------Out");
            }

        } else {
            m.addAttribute("message", "The link is invalid or broken!");

        }

        return "redirect:/";
    }


}
