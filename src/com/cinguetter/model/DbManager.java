package com.cinguetter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

	private static DbManager singleton;
	private static final String URL_DB = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "SYSTEM";
	private static final String PASSWORD = "admin";

	private DbManager() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Errore nel costruttore di DbManger");
		}
	}

	public Connection getDbConnection() {
		try {
			Connection conn = DriverManager.getConnection(URL_DB, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore in getDbConnection, VERIFICA LA PASSWORD IN DBMANAGER PRIMA DI ENTRARE IN PANICO oppure mi stai passando dati di utente con valore null");
		}
		return null;
	}

	public static DbManager getInstance() {
		if (singleton == null) {
			singleton = new DbManager();
		}
		return singleton;
	}

}
