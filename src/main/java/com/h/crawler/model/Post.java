package com.h.crawler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_SEQ")
    @SequenceGenerator(sequenceName = "post_seq", allocationSize = 1, name = "POST_SEQ")
    private Long id;
    
    @Column(name = "NAME")
    private String userName;
    
    @Column(name = "POST_NAME")
    private String postName;

    protected  Post() {
		
	}

	public Post(String userName, String postName) {
		this.userName = userName;
		this.postName = postName;
	}
    
}
