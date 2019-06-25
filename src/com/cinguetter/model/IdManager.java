package com.cinguetter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IdManager {
	
	public static int getCorrectId(String tableName) {
		
		int id = 0;

		try (Connection conn = DbManager.getInstance().getDbConnection(); Statement stmt = conn.createStatement()) {
			String sqlMaxId = "select MAX(id) from " + tableName;
			ResultSet result = stmt.executeQuery(sqlMaxId);

			if (result.next()) {
				id = result.getInt("max(id)") + 1;
			}

			return id;
			
		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("Errore in addUser nel recuper di maxId");
		}
		
		return -1;

	}

}
