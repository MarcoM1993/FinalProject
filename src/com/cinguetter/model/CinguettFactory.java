package com.cinguetter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CinguettFactory {
	
	private static CinguettFactory singleton;
	
	private CinguettFactory() {
		
	}
	
	public static CinguettFactory getInstance() {
		if (singleton == null) {
			singleton = new CinguettFactory();
		}
		return singleton;
	}
	
	public boolean addCinguett(String text, String email) {
		return true;
	}

	public List<Cinguett> getCinguetts(int numberOfCinguetts) {
		
		List<Cinguett> cinguetts = new ArrayList<Cinguett>();
		
		try (Connection conn = DbManager.getInstance().getDbConnection(); Statement stmt = conn.createStatement())  {

			String sql = "select c.text, c.post_time, u.name, u.surname, u.urlimageprofile from cinguetts c, users where c.user_id = u.id and ROWNUM <= " 
					+ numberOfCinguetts +"ORDER BY c.post_time DESC;";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				cinguetts.add(new Cinguett(result.getString(columnIndex)ext, userEmail, postedTime, id));
			}

		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("errore in login dentro UserFactory");
		}	
		
		return null;
	}
	
}
