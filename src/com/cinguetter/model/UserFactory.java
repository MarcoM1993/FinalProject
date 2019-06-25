package com.cinguetter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public boolean editDetails(String newName, String newSurname, String newEmail, String newPassword,
			String newUrlImageProfile, String newBirthday, String email) {
		try (Connection conn = DbManager.getInstance().getDbConnection()) {
			conn.setAutoCommit(false); //Iniza la transazione perch� se due persone entrano in concorrenza in questo metodo potrebbero superare il successivo controllo e impostare assieme la stessa mail
			if (!newEmail.equals(email)) { //Se la vecchia mail � diversa dalla nuova verifico che non siano presenti mail uguali in database prima di permettere il cambio
				String sqlCheckEmail = "select email from users where email = ? "; 
				try (PreparedStatement stmt = conn.prepareStatement(sqlCheckEmail)) {
					stmt.setString(1, newEmail);
					ResultSet result = stmt.executeQuery();
					if (result.next()) {
						return false; //se trova risultati la mail esiste quindi interrompo l'esecuzione la modifica non si pu� fare
					}

				} catch (SQLException e) {
					conn.rollback();// elimino le modifiche effettuate in transazione
					Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
					System.out.println("Errore in editDetails 72");
				}
			}
			int idUser = 0; //inizializzo la variabile che conterr� l'id dell'utente
			String sqlGetId = "select id from users where email = ? "; //cerco l'id dell'utente tramite la sua mail
			try (PreparedStatement stmt = conn.prepareStatement(sqlGetId)) {
				stmt.setString(1, email);
				ResultSet result = stmt.executeQuery();
				if (result.next()) {
					idUser = result.getInt("id"); //a questo punto � impossibile che non trovi corrispondenza perch� altrimenti l'utente non potrebbe essere loggato

				}

			} catch (SQLException e) {
				conn.rollback(); // elimino le modifiche effettuate in transazione
				Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("Errore in editDetails");
			}

			String sqlEditUserDetails = " update users set name = ?, surname= ?, email=?, password=?, urlimageprofile=?, birthday=to_date (?, 'yyyy-mm-dd') where id = ? ";
			try (PreparedStatement stmt = conn.prepareStatement(sqlEditUserDetails)) {
				stmt.setString(1, newName);
				stmt.setString(2, newSurname);
				stmt.setString(3, newEmail);
				stmt.setString(4, newPassword);
				stmt.setString(5, newUrlImageProfile);
				stmt.setString(6, newBirthday);
				stmt.setInt(7, idUser);
				stmt.executeUpdate();
				conn.commit(); //committo le modifiche, tutto � andato a buon fine
				return true;//operazione conclusa con successo
			} catch (SQLException e) {
				conn.rollback();//elimino le modifiche effettuate in transazione
				Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("Errore in editDetails 106");
			}
		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("Errore in editDetails 110");
		}
		return false; // se sono arrivato a questo punto qualche metodo ha lanciato un'eccezione
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
				GregorianCalendar birthday = userBirthdayManager(result.getString("birthday"));
				User user = new User(name, surname, email, urlImageProfile, birthday);
				return user;
			}

		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("errore in getUser dentro UtenteFactory");

		}
		return null;

	}

	public GregorianCalendar userBirthdayManager(String birthdayString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		GregorianCalendar birthday = (GregorianCalendar) Calendar.getInstance();
		try {
			birthday.setTime(formatter.parse(birthdayString));
			return birthday;
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Il formatter sta facendo cose sbagliate, errore in userBithdayManager");
		}
		return null;
	}

	public boolean addUser(String name, String surname, String email, String password, String urlImageProfile,
			String birthday) {
		
		System.out.println(birthday);

		if (getUser(email) == null) { // se l'Utente non ce lo aggiungo, altrimenti return false;

			int idUser = 0;

			try (Connection conn = DbManager.getInstance().getDbConnection(); Statement stmt = conn.createStatement()) {
				String sqlMaxId = "select MAX(id) from users";
				ResultSet result = stmt.executeQuery(sqlMaxId);

				if (result.next()) {
					idUser = result.getInt("max(id)") + 1;
				}

			} catch (SQLException e) {
				Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("Errore in addUser nel recuper di maxId");
			}

			String sqlNewUser = " insert into users values (?, ?, ?, ?, ?, ?, to_date (?, 'yyyy-mm-dd')) ";
			try (Connection conn = DbManager.getInstance().getDbConnection();
					PreparedStatement stmt = conn.prepareStatement(sqlNewUser)) {
				stmt.setDouble(1, idUser);
				stmt.setString(2, name);
				stmt.setString(3, surname);
				stmt.setString(4, email);
				stmt.setString(5, password);
				stmt.setString(6, urlImageProfile);
				stmt.setString(7, birthday);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
				System.out.println("Errore in addUser esecuzione query di aggiunta");
			}

		}
		return false;
	}
}
