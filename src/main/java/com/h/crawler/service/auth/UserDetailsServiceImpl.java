package com.h.crawler.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h.crawler.repository.auth.AuthRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AuthRepository authRepo; 
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
