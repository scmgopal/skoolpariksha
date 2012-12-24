package com.prabhat.hibernate.entity;

public enum Role {
	ADMIN("Admin"), TEACHER("Teacher"), USER("User");
	String userRole;
	Role(String userRole) {
		this.userRole = userRole;
	}
	
}
