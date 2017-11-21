package com.hermestechnologies.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hermestechnologies.domain.User;
import com.hermestechnologies.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String login(HttpSession httpSession, HttpServletRequest req, Model model){

        if(req.getParameter("logout") != null){
            httpSession.removeAttribute("loggedIn");
        }
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("")
    public String loginProcess(@ModelAttribute User user, Model model, HttpSession session, HttpServletResponse response) throws IOException {
        User userRes =  userService.login(user);
        System.out.println(userRes);
        if(userRes != null){
            ObjectMapper mapper = new ObjectMapper();
            String jsonUser = mapper.writeValueAsString(userRes);
            model.addAttribute("noty", "Welcome");
            session.setAttribute("loggedIn", userRes);
            response.sendRedirect("/");
        }else{
            model.addAttribute("noty", "Invalid");
        }

        user.setUsername("");
        user.setPassword("");
        return "login";
    }
}
