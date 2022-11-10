package io._10a.academy.security.entity;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = "Users.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username")
})
public class User {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password_hash")
	private String passwordHash;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@ElementCollection
	@CollectionTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "username", referencedColumnName = "username")
	})
	@Enumerated(EnumType.STRING)
	@Column(name = "role_name")
	private Set<UserRole> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
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

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	@Override public String toString() {
		return "User{" + "username='" + username + '\'' + ", passwordHash='" + passwordHash + '\'' + ", firstName='" + firstName + '\'' + ", lastName='"
				+ lastName + '\'' + ", roles=" + roles + '}';
	}
}
