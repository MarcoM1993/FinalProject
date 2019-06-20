package com.cinguetter.model;


public class UserFactory {

		private static UserFactory singleton;
		
		private UserFactory() {
			
		}
		
		public static UserFactory getInstance() {
			if (singleton == null) {
				singleton = new UserFactory();
			}
			return singleton;
		}
}
