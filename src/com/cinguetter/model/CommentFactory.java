package com.cinguetter.model;

import java.util.List;

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
	
	public List<Comment> getComments(int cinguettId) {
		return null;
	}
}
