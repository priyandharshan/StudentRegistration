package com;

public class Users {
	private int userId;
	private String userName;
	private String email;
	private String password;
	
	public Users(String username,String email,String password)
	{
		this.userName=username;
		this.email=email;
		this.password=password;
	}
	public Users(String email,String password)
	{
		
		this.email=email;
		this.password=password;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
