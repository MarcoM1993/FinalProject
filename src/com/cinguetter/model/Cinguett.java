package com.cinguetter.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Cinguett extends PostedMessage {
	private ArrayList<Comment> commentsList = new ArrayList<Comment>();

	public Cinguett(String text, String userEmail, GregorianCalendar postedTime, int id) {
		super(text, userEmail, postedTime, id);

	}

}
