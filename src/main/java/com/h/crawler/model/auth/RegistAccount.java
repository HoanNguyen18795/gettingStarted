package com.h.crawler.model.auth;

public class RegistAccount {
	private String name;
	
	private String registEmail;
	
	private String registPassword;
	
	private String repeatRegistPassword;
	
	private String isAdmin;
	
	private String newPassword;
	
	private String repeatNewPassword;
	
	private String oldPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}

	public void setRepeatNewPassword(String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistEmail() {
		return registEmail;
	}

	public void setRegistEmail(String registEmail) {
		this.registEmail = registEmail;
	}

	public String getRegistPassword() {
		return registPassword;
	}

	public void setRegistPassword(String registPassword) {
		this.registPassword = registPassword;
	}
	
	public String getRepeatRegistPassword() {
		return repeatRegistPassword;
	}

	public void setRepeatRegistPassword(String repeatRegistPassword) {
		this.repeatRegistPassword = repeatRegistPassword;
	}
	
}
