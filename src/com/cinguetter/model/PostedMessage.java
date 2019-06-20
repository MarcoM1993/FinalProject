package com.cinguetter.model;

import java.util.GregorianCalendar;

public abstract class PostedMessage {

	private String text;
	private String userEmail;
	private GregorianCalendar postedTime;
	private int id;

	public String getText() {
		return text;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public GregorianCalendar getPostedTime() {
		return postedTime;
	}

	public int getId() {
		return id;
	}

	public PostedMessage(String text, String userEmail, GregorianCalendar postedTime, int id) {
		this.text = text;
		this.userEmail = userEmail;
		this.postedTime = postedTime;
		this.id = id;
	}

}
