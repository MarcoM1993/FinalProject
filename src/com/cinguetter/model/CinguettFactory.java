package com.cinguetter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		
		int idUser = UserFactory.getInstance().getUserIdFromEmail(email);
		
		int idCinguett = IdManager.getCorrectId("cinguetts");
		
		String sqlNewCinguett = " insert into cinguetts values (?, ?, ?, to_date (?, 'yyyy-mm-dd hh24:mi:ss')) ";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String postTime = formatter.format(cal.getTime());
		
		try (Connection conn = DbManager.getInstance().getDbConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlNewCinguett)) {
			stmt.setInt(1, idCinguett);
			stmt.setString(2, text);
			stmt.setInt(3, idUser);
			stmt.setString(4, postTime);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("Errore in addCinguett esecuzione query di aggiunta");
		}
		
		return false;
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
