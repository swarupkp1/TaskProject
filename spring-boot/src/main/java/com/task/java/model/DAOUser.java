package com.task.java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
public class DAOUser {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	@Column
	@JsonIgnore
	private String email;
	
	@Column
	@JsonIgnore
	private String mobileNumber;
	
	@Column
	@JsonIgnore
	private String pancard;
	
	

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

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	@Override
	public String toString() {
		return "DAOUser [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", pancard=" + pancard + "]";
	}
	
	
	

}