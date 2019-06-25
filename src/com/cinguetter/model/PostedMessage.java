package com.cinguetter.model;

public abstract class PostedMessage {

	private String text;
	private String userId;
	private int id;

	public PostedMessage(String text, String userId, int id) {
		this.text = text;
		this.userId = userId;
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public String getUserId() {
		return userId;
	}

	public int getId() {
		return id;
	}

}
