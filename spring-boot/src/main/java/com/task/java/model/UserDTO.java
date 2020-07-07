package com.task.java.model;

import java.io.Serializable;


import javax.validation.constraints.Pattern;

//import com.task.java.customvalidator.Customer;


//@Customer(message="pancard is already exist")
public class UserDTO implements Serializable{
	
	private String username;
	private String password;
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="Please Enter valid emailid")
	private String email;
	@Pattern(regexp="^((?!(0))[0-9]{10})",message="Please Enter valid mobile number")
	private String mobileNumber;
	@Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]{1}",message="Please Enter valid Pancard")
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
	
	
	
}