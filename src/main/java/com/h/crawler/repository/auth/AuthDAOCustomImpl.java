package com.h.crawler.repository.auth;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.h.crawler.repository.BaseDAOCustom;

@Repository
@Transactional
public class AuthDAOCustomImpl extends BaseDAOCustom implements AuthDAOCustom{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void changePassword(String newPassword, Long userId) {
		String sql = "UPDATE ACCOUNT SET PASSWORD = :newPassword WHERE ID = :userId";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("newPassword", bCryptPasswordEncoder.encode(newPassword));
		query.setParameter("userId", userId);
		query.executeUpdate();
	}

}
