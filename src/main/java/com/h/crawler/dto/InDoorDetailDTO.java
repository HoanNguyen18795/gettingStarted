package com.h.crawler.dto;

import java.math.BigDecimal;
import java.util.Date;

public class InDoorDetailDTO {
	
	private String ipAddress;
	private Date day;
	private BigDecimal costPerDay;
	private Long timeInUse;
	private Long powerConsumtionPerDay;
	private Long status;
	private String dayToString;
	
	public String getDayToString() {
		return dayToString;
	}
	public void setDayToString(String dayToString) {
		this.dayToString = dayToString;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public BigDecimal getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(BigDecimal costPerDay) {
		this.costPerDay = costPerDay;
	}
	public Long getTimeInUse() {
		return timeInUse;
	}
	public void setTimeInUse(Long timeInUse) {
		this.timeInUse = timeInUse;
	}
	public Long getPowerConsumtionPerDay() {
		return powerConsumtionPerDay;
	}
	public void setPowerConsumtionPerDay(Long powerConsumtionPerDay) {
		this.powerConsumtionPerDay = powerConsumtionPerDay;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}
