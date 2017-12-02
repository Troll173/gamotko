package com.hermestechnologies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model, HttpSession httpSession){
        model.addAttribute("loggedIn", httpSession.getAttribute("loggedIn"));
        System.out.println(httpSession.getAttribute("loggedIn"));
        return "home";
    }


}
