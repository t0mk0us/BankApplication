package com.tamara.bankappli.dto;

public class LoginResponse {
    private String username;
    private Long customerId;
    //private String token; // If using JWT tokens later

    public LoginResponse(String username, Long customerId) {
        this.username = username;
        this.customerId = customerId;
    }
    // Getters and Setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
}
