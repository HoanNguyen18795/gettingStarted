package com.h.crawler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "IN_DOOR")
public class InDoor {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "ID")
	private Long id;
	
//	@Column(name = "NAME")
	private String name;
	
//	@Column(name = "NAME")
	private String ipAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
