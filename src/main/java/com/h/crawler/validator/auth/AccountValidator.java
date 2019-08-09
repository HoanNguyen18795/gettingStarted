package com.h.crawler.validator.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.h.crawler.model.auth.Account;
import com.h.crawler.model.auth.RegistAccount;
import com.h.crawler.service.auth.UserService;
import com.h.crawler.util.Constants;

@Component
public class AccountValidator implements Validator{

	private static final 
	String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistAccount account = (RegistAccount) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registPassword", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatRegistPassword", "NotEmpty");
		if(errors.hasErrors()) {
        	return;
        }
        if (account.getName().length() < Constants.MIN_USER_NAME_LENGTH || account.getName().length() > Constants.MAX_USER_NAME_LENGTH) {
            errors.rejectValue("name", "Size.userForm.username");
        }
        if (account.getRegistPassword().length() < Constants.MIN_PASSWORD_LENGTH || account.getRegistPassword().length() > Constants.MAX_PASSWORD_LENGTH) {
            errors.rejectValue("registPassword", "Size.userForm.password");
        }
        if(!account.getRegistPassword().equals(account.getRepeatRegistPassword())) {
        	errors.rejectValue("registPassword", "Diff.userForm.passwordConfirm");
        }
        if(errors.hasErrors()) {
        	return;
        }
        if (userService.findByUsername(account.getName()) != null) {
            errors.rejectValue("name", "Duplicate.userForm.username");
            return;
        }
    }
}
