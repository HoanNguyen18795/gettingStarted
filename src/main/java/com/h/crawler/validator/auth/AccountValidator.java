package com.h.crawler.validator.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.h.crawler.model.auth.Account;
import com.h.crawler.model.auth.RegistAccount;
import com.h.crawler.service.auth.UserService;

@Component
public class AccountValidator implements Validator{

	private static final 
	String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistAccount account = (RegistAccount) target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registPassword", "NotEmpty");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registEmail", "NotEmpty");
        if (account.getName().length() < 6 || account.getName().length() > 32) {
            errors.rejectValue("name", "Size.userForm.username");
        }
        if (userService.findByUsername(account.getName()) != null) {
            errors.rejectValue("name", "Duplicate.userForm.username");
        }
//        if (!account.getRegistEmail().matches(EMAIL_PATTERN)) {
//        	errors.rejectValue("registEmail", "Format.userForm.email");
//		}
        
//        if (userService.existByEmail(account.getRegistEmail())) {
//        	errors.rejectValue("registEmail", "Duplicate.userForm.email");
//		}

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registPassword", "NotEmpty");
        if (account.getRegistPassword().length() < 8 || account.getRegistPassword().length() > 32) {
            errors.rejectValue("registPassword", "Size.userForm.password");
        }
    }
		
}
