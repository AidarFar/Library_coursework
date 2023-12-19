package com.example.factory;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * Represents a user in the system.
 * @author Farkhutdinov Aidar
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	/**
	 * The unique identifier for this user.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The first name of this user.
	 */
	@Column(name = "first_name")
	private String firstName;

	/**
	 * The last name of this user.
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * The email address of this user.
	 */
	private String email;

	/**
	 * The password for this user's account.
	 */
	private String password;

	/**
	 * The roles that this user has.
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

	/**
	 * Default constructor for a user.
	 */
	public User() {

	}

	/**
	 * Creates a new user with the given information.
	 *
	 * @param firstName the first name of the user
	 * @param lastName the last name of the user
	 * @param email the email address of the user
	 * @param password the password for the user's account
	 * @param roles the roles that the user has
	 */
	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}


	/**

	 Gets the ID of the user.
	 @return the ID of the user.
	 */
	public Long getId() {
		return id;
	}
	/**

	 Gets the first name of the user.
	 @return the first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**

	 Sets the first name of the user.
	 @param firstName the first name to be set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**

	 Gets the last name of the user.
	 @return the last name of the user.
	 */
	public String getLastName() {
		return lastName;
	}
	/**

	 Sets the last name of the user.
	 @param lastName the last name to be set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**

	 Gets the email of the user.
	 @return the email of the user.
	 */
	public String getEmail() {
		return email;
	}
	/**

	 Sets the email of the user.
	 @param email the email to be set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**

	 Gets the password of the user.
	 @return the password of the user.
	 */
	public String getPassword() {
		return password;
	}
	/**

	 Sets the password of the user.
	 @param password the password to be set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**

	 Gets the roles associated with the user.
	 @return the roles associated with the user.
	 */
	public Collection<Role> getRoles() {
		return roles;
	}
	/**

	 Sets the roles associated with the user.
	 @param roles the roles to be set.
	 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
