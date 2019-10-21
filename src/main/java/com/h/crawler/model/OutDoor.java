package com.h.crawler.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "OUT_DOOR")
public class OutDoor {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "ID")
	private Long id;
	
//	@Column(name = "NAME")
	private String name;
	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "OUT_DOOR_ID")
	private Set<InDoor> indoorList;

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

	public Set<InDoor> getIndoorList() {
		return indoorList;
	}

	public void setIndoorList(Set<InDoor> indoorList) {
		this.indoorList = indoorList;
	}
}
