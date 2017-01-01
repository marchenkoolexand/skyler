package com.skyler.smarthome.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "s_users")
public class User implements Serializable {

	@Transient
	private static final long serialVersionUID = -8194115914687147099L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue
	private int id;
	@Column(name = "s_first_name")
	private String firstName;
	@Column(name = "s_last_name")
	private String lastName;
	@Column(name = "s_email")
	private String email;
	@Column(name = "s_recovery_email")
	private String recoveryEmail;
	@Column(name = "s_password")
	private String password;
	@Column(name = "s_phone_number")
	private String phoneNumber;

	public User() {
	}

	public User(String firstName, String email, String password) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, String recoveryEmail, String password,
			String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.recoveryEmail = recoveryEmail;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecoveryEmail() {
		return recoveryEmail;
	}

	public void setRecoveryEmail(String recoveryEmail) {
		this.recoveryEmail = recoveryEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", recoveryEmail=" + recoveryEmail + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((recoveryEmail == null) ? 0 : recoveryEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (recoveryEmail == null) {
			if (other.recoveryEmail != null)
				return false;
		} else if (!recoveryEmail.equals(other.recoveryEmail))
			return false;
		return true;
	}

}
