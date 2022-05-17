package com.pack.model;

public class User {

	private Integer UserId;
	private String Name;
	private String Email;
	private String Password;
	private int Role;
	private String Address;
	private String PreferredType;

	public User() {

	}

	public User(String name, String email, String pass, String add, String pt) {
		super();

		this.Name = name;
		this.Email = email;
		this.Password = pass;
		this.Role = 0;
		this.Address = add;
		this.PreferredType = pt;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getRole() {
		return Role;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPreferredType() {
		return PreferredType;
	}

	public void setPreferredType(String preferredType) {
		PreferredType = preferredType;
	}

}
