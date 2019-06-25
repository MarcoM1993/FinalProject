package com.cinguetter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		
		int idUser = UserFactory.getInstance().getUserIdFromEmail(email);
		
		int idComment = IdManager.getCorrectId("comments");
		
		String sqlNewCinguett = " insert into comments values (?, ?, to_date (?, 'yyyy-mm-dd hh24:mi:ss'), ?, ?) ";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String postTime = formatter.format(cal.getTime());
		
		try (Connection conn = DbManager.getInstance().getDbConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlNewCinguett)) {
			stmt.setInt(1, idComment);
			stmt.setString(2, text);
			stmt.setString(3, postTime);
			stmt.setInt(4, idUser);
			stmt.setInt(5, cinguettId);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("Errore in addComment esecuzione query di aggiunta");
		}
		
		return false;
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
	
	public Map<Integer, List<Comment>> getCommentsMap(List<PostedMessage> postedMessages){
		
		HashMap<Integer, List<Comment>> commentsMap = new HashMap<Integer, List<Comment>>();
		
		for(PostedMessage message : postedMessages) {
			commentsMap.put(message.getId(), getComments(message.getId()));
		}
		
		return commentsMap;
	}
	
}
