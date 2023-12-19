package com.example.factory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**

 Controller class for handling user registration process.

 This class maps to the URL "/registration".
 @author Farkhutdinov Aidar
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private final UserService userService;

	/**

	 Constructor for RegistrationController.
	 @param userService instance of UserService
	 */
	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	/**

	 Returns a new UserRegistrationDto object as a model attribute.
	 @return UserRegistrationDto object as a model attribute
	 */
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	/**

	 Returns the registration page.
	 @return registration page
	 */
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	/**

	 Registers a new user account by saving the UserRegistrationDto object.
	 @param registrationDto UserRegistrationDto object to be saved
	 @return redirect to the registration page with success parameter
	 */
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}