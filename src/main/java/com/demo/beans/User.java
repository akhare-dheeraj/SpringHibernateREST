package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate4.type.EncryptedStringType;

import com.demo.constants.Role;

@TypeDef(typeClass = EncryptedStringType.class, name = "encryptedPwd", parameters = {
		@Parameter(name = "encryptorRegisteredName", value = "myHibernateStringEncryptor") })

@Table(name = "USERS")
@Entity
@XmlRootElement(name = "user")
public class User implements BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4758213021280548932L;

	@Id
	@GeneratedValue
	@XmlElement(name = "id")
	private int userId;

	@Column
	@XmlElement(name = "username")
	private String userName;

	@Column
	@Type(type = "encryptedPwd")
	@XmlElement(name = "password")
	private String password;
	
	@Column
	@XmlElement(name = "role")
	private Role role;

	public User(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = Role.get(role);
	}

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role.getValue();
	}

	public void setRole(String role) {
		this.role = Role.get(role);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
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
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}
