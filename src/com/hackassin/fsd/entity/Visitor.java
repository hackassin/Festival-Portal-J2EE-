package com.hackassin.fsd.entity;

public class Visitor {
	
	private int visitorId;
	
	private String address;
	
	private String username;
	
	private String password;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String phonenumber;
	
	private String role;
	
	public int getVisitorId() {
		return visitorId;
	}
	
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Visitor [visitorId=" + visitorId + ", address=" + address + ", username=" + username + ", password="
				+ password + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", role=" + role + "]";
	}
}
