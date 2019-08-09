package com.h.crawler.controller.auth;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h.crawler.model.Cart.Cart;
import com.h.crawler.model.auth.Account;
import com.h.crawler.model.auth.RegistAccount;
import com.h.crawler.service.auth.SecurityService;
import com.h.crawler.service.auth.UserService;
import com.h.crawler.util.UserUtil;
import com.h.crawler.validator.auth.AccountValidator;
import com.h.crawler.validator.auth.ChangePasswordValidator;

@Controller
public class AuthController {
	 @Autowired
	 private UserService userService;

	 @Autowired
	 private SecurityService securityService;

	 @Autowired
	 private AccountValidator userValidator;
	 
	 @Autowired
	 private ChangePasswordValidator changePassWordValidator;
	 
	 

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("accountForm") RegistAccount accountForm
    						, BindingResult bindingResult
    						, Model model) {
        userValidator.validate(accountForm, bindingResult);
        
        if (bindingResult.hasErrors()) {
        	model.addAttribute("accountLogin", new Account());
            return "auth/register";
        }
        Cart cart = new Cart();
        LocalDate localDate = LocalDate.now();
        cart.setInsDate(Date.valueOf(localDate));
        cart.setUpdDate(Date.valueOf(localDate));
        
        Account account = new Account(accountForm.getName(), accountForm.getRegistPassword(), accountForm.getRegistEmail(), UserUtil.ADMIN);
        
        account.setCart(cart);
        cart.setAccount(account);
        userService.save(account);
      
        securityService.autologin(account.getUsername(), account.getPassword());
        return "redirect:/";
    }
    
    @RequestMapping(value="/showAdminRegistration", method = RequestMethod.GET)
    public String showAdminRegistration(Model model) {
    	model.addAttribute("accountForm", new RegistAccount());
    	return "auth/adminRegister";
    }
    
    @RequestMapping(value="/adminRegistration", method = RequestMethod.POST)
    public String adminRegistration(@ModelAttribute("accountForm") RegistAccount accountForm
    								, BindingResult bindingResult
    								, Model model) {
    	 userValidator.validate(accountForm, bindingResult);
    	 if (bindingResult.hasErrors()) {
            return "auth/adminRegister";
         }
    	 Account account = new Account(accountForm.getName(), accountForm.getRegistPassword(), UserUtil.FIXED_EMAIL, StringUtils.isEmpty(accountForm.getIsAdmin()) ? UserUtil.USER : UserUtil.ADMIN);
    	 account.setCreatorId(UserUtil.getUserSession().getId());
    	 account.setCreatedDate(Date.valueOf(LocalDate.now()));
    	 userService.save(account);
    	 return "redirect:/";
    }
    
    @RequestMapping(value="/changePassword", method = RequestMethod.GET)
    public String adminChangePassword(Model model) {
    	model.addAttribute("accountForm", new RegistAccount());
    	return "auth/changePassword";
    }
    
    @RequestMapping(value="/doChangePassword", method = RequestMethod.POST)
    public String doChangePassword(@ModelAttribute("accountForm") RegistAccount accountForm
    								, BindingResult bindingResult
    								, Model model) {
    	changePassWordValidator.validate(accountForm, bindingResult);
    	 if (bindingResult.hasErrors()) {
            return "auth/changePassword";
         }
    	 userService.changePassword(accountForm.getNewPassword(), UserUtil.getUserSession().getId());
    	 return "redirect:/";
    }

	@GetMapping("/auth")
	public String showAuth(Model model) {
		model.addAttribute("accountLogin", new Account());
		model.addAttribute("accountForm", new RegistAccount());
		return "auth/register";
	}
	
	@GetMapping(value="/happyLandLogin")
	public String happyLandLogin(Model model) {
		model.addAttribute("accountLogin", new Account());
		return "auth/login";
	}
}
