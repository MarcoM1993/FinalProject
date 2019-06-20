package com.cinguetter.model;

import java.util.List;

public class CinguettFactory {
	
	private static CinguettFactory singleton;
	
	private CinguettFactory() {
		
	}
	
	public static CinguettFactory getInstance() {
		if (singleton == null) {
			singleton = new CinguettFactory();
		}
		return singleton;
	}
	
	public boolean addCinguett(String text, String email) {
		return true;
	}

	public List<Cinguett> getCinguetts(int numberOfCinguetts) {
		
		return null;
	}
	
}
