package com.cinguetter.model;

import java.util.GregorianCalendar;

public class User {
	private String name;
	private String surname;
	private String email;
	private String password;
	private String urlImageProfile;
	private GregorianCalendar birthday;

	public User(String name, String surname, String email, String password, String urlImageProfile,
			GregorianCalendar birthday) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.urlImageProfile = urlImageProfile;
		this.birthday = birthday;
	}
	
	public User(String name, String surname, String email, String urlImageProfile,
			GregorianCalendar birthday) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.urlImageProfile = urlImageProfile;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
		return "User: " + name + "  " + surname + "\n" + "Email: " + email + "\n" + "Password: " + password + "\n"
				+ "Profile Image: " + urlImageProfile + "\n" + "Date of Birth: " + birthday;
	}

}
