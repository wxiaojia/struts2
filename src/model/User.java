package model;

import java.util.Date;

public class User {
	public String username,password,address,email;
	Date birth;
//	public String birth;
	public User(){
		
	}
	public User(String username, String password, String address, String email, Date birth) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.birth = birth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getBirth() {
//		return birth;
//	}
//
//	public void setBirth(String birth) {
//		this.birth = birth;
//	}
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
