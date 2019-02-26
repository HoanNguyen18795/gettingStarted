package com.h.crawler.service.auth;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h.crawler.model.auth.Account;
import com.h.crawler.model.auth.UserAccount;
import com.h.crawler.repository.auth.AuthRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AuthRepository authRepo; 
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Account account = authRepo.findByUsername(userName);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ADM"));
		
		return new UserAccount(account.getUsername(), account.getPassword(), grantedAuthorities, account.getId());
	}

}
