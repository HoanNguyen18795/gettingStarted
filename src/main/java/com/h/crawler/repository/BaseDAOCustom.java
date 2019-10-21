package com.h.crawler.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAOCustom {

	@Autowired
	public EntityManager entityManager;
}
