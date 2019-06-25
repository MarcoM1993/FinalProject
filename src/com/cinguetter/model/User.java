package com.cinguetter.model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class User {
	private String name;
	private String surname;
	private String email;
	private String urlImageProfile;
	private GregorianCalendar birthday;


	public User(String name, String surname, String urlImageProfile) {
		this.name = name;
		this.surname = surname;
		this.urlImageProfile = urlImageProfile;
	}

	public User(String name, String surname, String email, String urlImageProfile, GregorianCalendar birthday) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.urlImageProfile = urlImageProfile;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getUrlImageProfile() {
		return urlImageProfile;
	}

	public GregorianCalendar getBirthday() {
		return birthday;
	}
	
	public String getBirthdayString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		formatter.setCalendar(birthday);
		return formatter.format(birthday.getTime());
		
	}

	public String toString() {
		return "User: " + name + "  " + surname + "\n" + "Email: " + email + "\n" 
				+ "Profile Image: " + urlImageProfile + "\n" + "Date of Birth: " + birthday;
	}

}
