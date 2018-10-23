package com.h.crawler.repository.auth;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.h.crawler.model.auth.Account;

@Repository
public interface AuthRepository extends CrudRepository<Account, Long>{
	
	@Query("select acc from Account acc where acc.userName = :userName AND acc.password = :password")
    Stream<Account> findAccount(@Param("userName") String userName, @Param("password") String password);
}
