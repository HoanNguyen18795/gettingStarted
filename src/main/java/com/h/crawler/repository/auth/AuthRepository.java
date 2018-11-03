package com.h.crawler.repository.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h.crawler.model.auth.Account;

@Repository
public interface AuthRepository extends CrudRepository<Account, Long>{
	Account findByUsername(String username);
}
