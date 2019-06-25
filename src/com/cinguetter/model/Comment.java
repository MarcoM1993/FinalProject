package com.cinguetter.model;

public class Comment extends PostedMessage {

	private int cinguettId;

	public Comment(String text, String userId, int id, int cinguettId) {
		super(text, userId, id);
		this.cinguettId = cinguettId;

	}

	public int getCinguettId() {
		return cinguettId;
	}

}
