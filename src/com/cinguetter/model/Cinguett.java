package com.cinguetter.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Cinguett extends PostedMessage {
	private ArrayList<Comment> commentsList;

	public ArrayList<Comment> getComments() {
		return commentsList;
	}

	public void setComments(ArrayList<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	public Cinguett(String text, String userEmail, GregorianCalendar postedTime, int id) {
		super(text, userEmail, postedTime, id);

	}

}
