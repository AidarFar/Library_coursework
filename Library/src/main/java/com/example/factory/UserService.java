package com.example.factory;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**

 Service interface for managing User entities.
 @author Farkhutdinov Aidar
 */
public interface UserService extends UserDetailsService {

	/**

	 Saves a new User with the given registration details.
	 @param registrationDto the registration details of the user to save
	 @return the saved User object
	 */
	User save(UserRegistrationDto registrationDto);
	/**

	 Retrieves all Users in the system.
	 @return a List of all Users in the system
	 */
	List<User> getAll();
}