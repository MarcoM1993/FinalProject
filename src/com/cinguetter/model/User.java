package com.cinguetter.model;
import java.util.GregorianCalendar;

public class User {
	private String name;
	private String surName;
	private String email;
	private String password;
	private String urlImageProfile;
	private GregorianCalendar birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrlImageProfile() {
		return urlImageProfile;
	}
	public void setUrlImageProfile(String urlImageProfile) {
		this.urlImageProfile = urlImageProfile;
	}
	public GregorianCalendar getBirthday() {
		return birthday;
	}
	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}
	
	public String toString() {
		return "User: " + name + "  " + surName + "\n" + "Email: "+email+"\n"+"Password: "+password+"\n"+"Profile Image: "+urlImageProfile+"\n"+"Date of Birth: "+birthday;
	}
	
//	GregorianCalendar(int year, int month, int dayOfMonth);
}
