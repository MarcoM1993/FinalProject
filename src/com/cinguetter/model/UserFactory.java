package com.cinguetter.model;

import java.util.GregorianCalendar;

public class UserFactory {

	private static UserFactory singleton;

	private UserFactory() {

	}

	public static UserFactory getInstance() {
		if (singleton == null) {
			singleton = new UserFactory();
		}
		return singleton;
	}

	public boolean signUp(String name, String surname, String email, String urlImageProfile,
			GregorianCalendar birthday) {
		return true;
	}
	
	public boolean login(String email, String password) {
		return true;
	}
	
	public boolean editDetails(String newName, String newSurname, String newEmail, String newUrlImageProfile, String newPassword, String email) {
		return true;
	}

}
