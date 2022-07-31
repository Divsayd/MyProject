package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.services.services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class dashboardController {
    @RequestMapping("/dashboard")
    public String displayDash (Model model, Authentication authentication) throws Exception{
        model.addAttribute("User",authentication.getName());
        model.addAttribute("role",authentication.getAuthorities().toString());
       // throw new RuntimeException("Oops !! Got an error !!!");
       return "dashboard.html";
    }


}
