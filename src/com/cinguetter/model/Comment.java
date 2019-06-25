package com.cinguetter.model;

public class Comment extends PostedMessage {

	private int cinguettId;

	public Comment( int id, String text, int userId, int cinguettId) {
		super(id, text, userId);
		this.cinguettId = cinguettId;

	}

	public int getCinguettId() {
		return cinguettId;
	}

}
