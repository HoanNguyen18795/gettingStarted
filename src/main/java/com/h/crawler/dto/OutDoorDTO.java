package com.h.crawler.dto;

import java.util.List;

public class OutDoorDTO {
	private Long id;
	private String name;
	private List<InDoorDTO> indoorList;
	
	public List<InDoorDTO> getIndoorList() {
		return indoorList;
	}
	public void setIndoorList(List<InDoorDTO> indoorList) {
		this.indoorList = indoorList;
	}
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

}
