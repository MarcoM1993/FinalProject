package com.cinguetter.model;

public abstract class PostedMessage {

	private String text;
	private int userId;
	private int id;

	public PostedMessage(int id, String text, int userId) {
		this.text = text;
		this.userId = userId;
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public int getUserId() {
		return userId;
	}

	public int getId() {
		return id;
	}

}
