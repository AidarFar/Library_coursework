package com.example.library;

/**

 Data transfer object representing user registration information.
 @author Farkhutdinov Aidar
 */
public class UserRegistrationDto {

	/**

	 User's first name.
	 */
	private String firstName;
	/**

	 User's last name.
	 */
	private String lastName;
	/**

	 User's email address.
	 */
	private String email;
	/**

	 User's password.
	 */
	private String password;
	/**

	 Constructs a new UserRegistrationDto object with empty fields.
	 */
	public UserRegistrationDto() {
	}
	/**

	 Returns the user's first name.
	 @return the user's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**

	 Sets the user's first name.
	 @param firstName the user's first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**

	 Returns the user's last name.
	 @return the user's last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**

	 Sets the user's last name.
	 @param lastName the user's last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**

	 Returns the user's email address.
	 @return the user's email address
	 */
	public String getEmail() {
		return email;
	}
	/**

	 Sets the user's email address.
	 @param email the user's email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**

	 Returns the user's password.
	 @return the user's password
	 */
	public String getPassword() {
		return password;
	}
	/**

	 Sets the user's password.
	 @param password the user's password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}