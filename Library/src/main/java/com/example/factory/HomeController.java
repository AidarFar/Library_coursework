package com.example.factory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**

 This is a controller class responsible for displaying authentication pages.

 @author Farkhutdinov Aidar
 */
@Controller
public class HomeController {

	/**

	 This method is responsible for mapping the /login URL to the login page.
	 @return The name of the login page.
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}