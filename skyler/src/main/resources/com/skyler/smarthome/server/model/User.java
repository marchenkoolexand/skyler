package com.skyler.smarthome.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
	@Column(name = "s_email", unique = true,nullable = false, length = 45)
	private String email;
	@Column(name = "s_recovery_email",nullable = false, length = 45)
	private String recoveryEmail;
	@Column(name = "s_password",nullable = false, length = 60)
	private String password;
	@Column(name = "s_phone_number")
	private String phoneNumber;
	@Column(name = "s_enabled")
	private boolean enabled;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "s_joined_user_roles", joinColumns = @JoinColumn(name = "s_user_fk"), inverseJoinColumns = @JoinColumn(name = "s_role_fk"))
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public User() {
	}

	public User(String firstName, String email, String password) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, String recoveryEmail, String password,
			String phoneNumber,boolean enabled) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.recoveryEmail = recoveryEmail;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.enabled =enabled;
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

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", recoveryEmail=" + recoveryEmail + "[password]"+ ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		if (id != user.id) return false;
		if (enabled != user.enabled) return false;
		if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
		if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
		if (email != null ? !email.equals(user.email) : user.email != null) return false;
		if (recoveryEmail != null ? !recoveryEmail.equals(user.recoveryEmail) : user.recoveryEmail != null)
			return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
		return userRole != null ? userRole.equals(user.userRole) : user.userRole == null;

	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (recoveryEmail != null ? recoveryEmail.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		result = 31 * result + (enabled ? 1 : 0);
		result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
		return result;
	}
}
