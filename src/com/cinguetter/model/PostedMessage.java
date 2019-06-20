package com.cinguetter.model;

import java.util.GregorianCalendar;

public abstract class PostedMessage {

	private String text;
	private String userEmail;
	private GregorianCalendar postTime;
	private int id;

	public PostedMessage(String text, String userEmail, GregorianCalendar postTime, int id) {
		this.text = text;
		this.userEmail = userEmail;
		this.postTime = postTime;
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public GregorianCalendar getPostTime() {
		return postTime;
	}

	public int getId() {
		return id;
	}

}
