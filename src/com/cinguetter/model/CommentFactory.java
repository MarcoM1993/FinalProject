package com.cinguetter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommentFactory {
	
	private static CommentFactory singleton;
	
	private CommentFactory() {
		
	}
	
	public static CommentFactory getInstance() {
		if (singleton == null) {
			singleton = new CommentFactory();
		}
		return singleton;
	}

	public boolean addComment(String text, int cinguettId, String email) {
		return true;
	}
	
	// Resituisce i commenti per il cinguett con id passato come parametro
	public List<Comment> getComments(int cinguettId) {
		
		
		List<Comment> comments = new ArrayList<Comment>();
		
		try (Connection conn = DbManager.getInstance().getDbConnection(); Statement stmt = conn.createStatement())  {

			String sql = "select id, text, user_id, cinguett_id from comments where cinguett_id= "+ cinguettId + "ORDER BY post_time DESC";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				comments.add(new Comment(result.getInt("id"), result.getString("text"), result.getInt("user_id"), result.getInt("cinguett_id")));
			}

			return comments;
					
		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("errore in getCinguetts dentro CinguettsFactory");
		}	
		
		return null;
	}
}
