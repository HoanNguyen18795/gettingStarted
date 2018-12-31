package com.h.crawler.repository.auth;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h.crawler.model.auth.Account;

@Repository
public interface AuthRepository extends CrudRepository<Account, Long>{
	
	Account findByUsername(String username);
	
	@Query("SELECT CASE WHEN COUNT(1) > 0 THEN 'true' ELSE 'false' END FROM Account WHERE EMAIL = ?1")
	boolean existByEmail(String email);
}
