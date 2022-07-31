package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontrollerr {

        @RequestMapping(value={"", "/", "home"})
        public String displayHomePage(Model model, Authentication authentication)
        {
                //model.addAttribute("User",authentication.getName());
                return "home.html";
        }

}
