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

	public List<PostedMessage> getCinguetts(int numberOfCinguetts) {
		
		List<PostedMessage> cinguetts = new ArrayList<PostedMessage>();
		
		try (Connection conn = DbManager.getInstance().getDbConnection(); Statement stmt = conn.createStatement())  {

			String sql = "select id, text, user_id from cinguetts where ROWNUM <= "+ numberOfCinguetts +"ORDER BY post_time DESC";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				cinguetts.add(new Cinguett(result.getInt("id"), result.getString("text"), result.getInt("user_id")));
			}

			return cinguetts;
					
		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("errore in getCinguetts dentro CinguettsFactory");
		}	
		
		return null;
	}
	
}
