package com.hermestechnologies.controller;

import com.hermestechnologies.domain.User;
import com.hermestechnologies.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("")
    public String loginProcess(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        model.addAttribute("message", "Successfully saved person: " + user.toString());
        User userRes =  userService.login(user);
        System.out.println(userRes);
        return "login";
    }
}
