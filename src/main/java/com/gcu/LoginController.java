package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

import business.SecurityServiceInterface;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    SecurityServiceInterface securityService;
    
    @GetMapping("/")
    public String display(Model model){
        
        // display login form view
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult , Model model){
        
        // check for validation errors
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login Form");
            return "login";
        }

        // check for valid login name and pass
        if(securityService.isAuthenticated(loginModel)){
            model.addAttribute("model", loginModel);
            return "loginSuccess";
        }
        else{
            // return to login screen if invalid pw
            return "login";
        }
    }
}
