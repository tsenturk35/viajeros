package com.viajeros.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "User.findUserByUserIdAndPassword", query = "select user from User user where user.userId=:userId and "
		+ "user.password=:password") })
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "password")
	private String password;

	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "role_id")
	private Integer roleId;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "last_login_time")
	private Date lastLoginTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public boolean equals(Object anObj) {
		if (anObj == null)
			return false;
		if (this == anObj)
			return true;

		if (!(anObj instanceof User))
			return false;
		User user = (User) anObj;

		if (!this.userId.equals(user.getUserId()))
			return false;
		if (!this.password.equals(user.getPassword()))
			return false;
		if (lastLoginTime == null)
			return false;
		if (!this.lastLoginTime.equals(lastLoginTime))
			return false;
		return false;
	}

	@Override
	public int hashCode() {
		int result = 17;

		if (userId != null)
			result = 37 * result + userId.hashCode();
		if (password != null)
			result = 37 * result + password.hashCode();
		return result;
	}
}
