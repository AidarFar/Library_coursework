package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**

 This class implements the UserService interface and provides the implementation for the methods in the interface.
 @author Farkhutdinov Aidar
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**

	 Constructor for UserServiceImpl class that takes a UserRepository object as a parameter.
	 @param userRepository a UserRepository object that will be used to interact with the database
	 */
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	/**

	 Creates and saves a new User object in the database based on the provided UserRegistrationDto object.
	 @param registrationDto a UserRegistrationDto object containing the registration information for the new user
	 @return a User object representing the newly created user
	 */
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}
	/**

	 Loads a user by their email address and returns a UserDetails object that can be used by Spring Security.
	 @param username the email address of the user to load
	 @return a UserDetails object representing the user
	 @throws UsernameNotFoundException if a user with the given email address cannot be found in the database
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	/**

	 Maps a collection of Role objects to a collection of GrantedAuthority objects that can be used by Spring Security.
	 @param roles a collection of Role objects to map
	 @return a collection of GrantedAuthority objects
	 */
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	/**

	 Returns a list of all users in the database.
	 @return a list of User objects representing all users in the database
	 */
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
}
