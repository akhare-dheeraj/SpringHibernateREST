package com.demo.constants;

public enum Role {
	ADMIN("admin"), 
	USER("user");
	
	private String role;
	
	private Role(String role) {
		this.role = role;
	}
	
	public String getValue() {
		return role;
	}
	
	public static Role get(String role) {
		for(Role r : Role.values()) {
			if(r.getValue().equals(role))
				return r;
		}
		return null;
	}
}
