package com.h.crawler.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h.crawler.model.auth.Account;
import com.h.crawler.service.auth.SecurityService;
import com.h.crawler.service.auth.UserService;
import com.h.crawler.validator.auth.AccountValidator;

@Controller
public class AuthController {
	 @Autowired
	 private UserService userService;

	 @Autowired
	 private SecurityService securityService;

	 @Autowired
	 private AccountValidator userValidator;
	 
	 

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("accountForm") Account accountForm, BindingResult bindingResult, Model model) {
        userValidator.validate(accountForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        userService.save(accountForm);

        securityService.autologin(accountForm.getUsername(), accountForm.getPassword());
        System.out.println("\n\n\n\n\n\n hhhhhhhhhhhhhhhhhhh auth");
        return "redirect:index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
            return "auth/register";
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        
        return "index";
    }
	 
	@GetMapping("/auth")
	public String showAuth(Model model) {
		model.addAttribute("accountForm", new Account());
		return "auth/register";
	}
}
