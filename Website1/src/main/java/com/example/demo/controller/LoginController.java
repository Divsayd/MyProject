package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayloginPage(@RequestParam(value = "error", required = false) String error,
                                   @RequestParam(value = "logout", required = false) String logout, Model model) {

        String errormessage = null;
        if (error != null) {
            errormessage = "Username or password not correct";

        }
        if (logout != null) {
            errormessage = "You have been sucessfully logged out ";
        }
        model.addAttribute("errorMessage", errormessage);
        return "Login.html";
    }

    @RequestMapping(value="/logout" , method={RequestMethod.GET})
    public String logoutPage(HttpServletRequest request , HttpServletResponse response)
    {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(auth !=null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/login?logout=true";
    }
}

