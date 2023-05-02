package com.example.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**

 This interface defines the operations to be performed on the user entity in the database.

 It extends JpaRepository which provides the basic CRUD operations.

 The findByEmail method is used to retrieve a user from the database using their email.
 @author Farkhutdinov Aidar
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**

	 Retrieve a user from the database using their email.
	 @param email the email of the user to retrieve
	 @return the user with the specified email or null if no user with that email exists
	 */
	User findByEmail(String email);
}