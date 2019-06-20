package com.cinguetter.model;

import java.util.GregorianCalendar;

public class Comment extends PostedMessage {

	private int cinguettId;

	public Comment(String text, String userEmail, GregorianCalendar postedTime, int id, int cinguettId) {
		super(text, userEmail, postedTime, id);
		this.cinguettId = cinguettId;

	}

	public int getCinguettId() {
		return cinguettId;
	}

}
