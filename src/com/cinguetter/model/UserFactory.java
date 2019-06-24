package com.cinguetter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		String sql = "select name from users where email= ? and password= ?";

		try (Connection conn = DbManager.getInstance().getDbConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			stmt.setString(2, password);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE,null,e);
			System.out.println("errore in login dentro UserFactory");
		}
		return false;
	}

	public boolean editDetails(String newName, String newSurname, String newEmail, String newUrlImageProfile,
			String newPassword, String email) {
		return true;
	}
	
	public User getUser(String email) {
	// TO DO	
	}

}
