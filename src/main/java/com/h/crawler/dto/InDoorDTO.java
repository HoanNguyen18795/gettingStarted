package com.h.crawler.dto;

import java.util.List;

public class InDoorDTO {
	private Long id;
	private String name;
	private String ipAddress;
	List<InDoorDetailDTO> indoorDetailList;
	
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
	public List<InDoorDetailDTO> getIndoorDetailList() {
		return indoorDetailList;
	}
	public void setIndoorDetailList(List<InDoorDetailDTO> indoorDetailList) {
		this.indoorDetailList = indoorDetailList;
	}
}
