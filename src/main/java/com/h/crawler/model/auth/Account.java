package com.h.crawler.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
    @SequenceGenerator(sequenceName = "account_seq", allocationSize = 1, name = "ACCOUNT_SEQ")
    private Long id;
    
    @Column(name = "USER_NAME")
    private String userName;
    
    @Column(name = "PASSWORD")
    private String password;

    protected  Account() {
		
	}

	public Account(String userName, String postName) {
		this.userName = userName;
		this.password = postName;
	}
    
}
