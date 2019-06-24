package com.cinguetter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("errore in login dentro UserFactory");
		}
		return false;
	}

	public boolean editDetails(String newName, String newSurname, String newEmail, String newUrlImageProfile, 
			String newPassword, String email) {
		if(UserFactory.getInstance().getUser(email) != null) {  // se esiste l'Utente, lo modifico, altrimenti return false;
			String sql = " delete from users where email = ? ";
			try (Connection conn = DbManager.getInstance().getDbConnection();
					PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, newName);
				stmt.setString(2, newSurname);
				stmt.setString(3, email);
				stmt.setString(4, newPassword);
				stmt.setString(5, newUrlImageProfile);
//				stmt.setString(6, birthday);
//				
//				ResultSet result = stmt.executeUpdate(sql);
				return true;
			} catch(SQLException e) {
				Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("Errore in addUser");
			}
			
		}
		return false;
	}

	public User getUser(String email) {
		String sql = "select name, surname, email, urlimageprofile, birthday from users where email= ?";

		try (Connection conn = DbManager.getInstance().getDbConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				String name = result.getString("name");
				String surname = result.getString("surname");
				String urlImageProfile = result.getString("urlImageProfile");
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				GregorianCalendar birthday = (GregorianCalendar) Calendar.getInstance();
				try {
					birthday.setTime(formatter.parse(result.getString("birthday")));
				} catch (ParseException e) {
					e.printStackTrace();
					System.out.println("La mamma egua del formatter sta facendo cose sbagliate");
				}
				User user = new User(name, surname, email, urlImageProfile, birthday);
				return user;
			}

		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("errore in getUser dentro UtenteFactory");

		}
		return null; 

	}

	public boolean addUser(String name, String surname, String email, String password, String urlImageProfile, GregorianCalendar birthday) {

		if(UserFactory.getInstance().getUser(email) == null) {   // se l'Utente non c'è lo aggiungo, altrimenti return false;
			String sql = " insert into users values (?, ?, ?, ?, ?, ?) ";
			try (Connection conn = DbManager.getInstance().getDbConnection();
					PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, name);
				stmt.setString(2, surname);
				stmt.setString(3, email);
				stmt.setString(4, password);
				stmt.setString(5, urlImageProfile);
//				stmt.setString(6, birthday);
				
//				ResultSet result = stmt.executeUpdate(sql);
				return true;
			} catch(SQLException e) {
				Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("Errore in addUser");
			}
		
		
		}
		return false;
	}
}
