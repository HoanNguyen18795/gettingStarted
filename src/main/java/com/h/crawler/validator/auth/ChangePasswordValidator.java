package com.h.crawler.validator.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.h.crawler.model.auth.Account;
import com.h.crawler.model.auth.RegistAccount;
import com.h.crawler.repository.auth.AuthRepository;
import com.h.crawler.util.Constants;
import com.h.crawler.util.UserUtil;

@Component
public class ChangePasswordValidator implements Validator{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AuthRepository authRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistAccount account = (RegistAccount) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatNewPassword", "NotEmpty");
		if(errors.hasErrors()) {
        	return;
        }
		String storedPassword = authRepo.findByUsername(UserUtil.getUserName()).getPassword();
        if (!bCryptPasswordEncoder.matches(account.getOldPassword(), storedPassword)) {
            errors.rejectValue("oldPassword", "changePassword.oldPassword.notMatch");
        }
        if (account.getNewPassword().length() < Constants.MIN_PASSWORD_LENGTH || account.getNewPassword().length() > Constants.MAX_PASSWORD_LENGTH) {
            errors.rejectValue("newPassword", "Size.userForm.password");
        }
        if(!account.getNewPassword().equals(account.getRepeatNewPassword())) {
        	errors.rejectValue("newPassword", "Diff.userForm.passwordConfirm");
        }
    }
}
