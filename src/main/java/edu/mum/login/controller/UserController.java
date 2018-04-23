package edu.mum.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.login.service.UserService;

/**
 * @author: ChauKy
 * @Date: Apr 22, 2018
 * Reference: https://www.ashtpoint.com/spring-boot/spring-boot-login-example.html
 */

@Controller
public class UserController {		
	
	@Autowired
	 private UserService userService;


	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String login(Model model, String error, String logout) {
	 if (error != null)
	 model.addAttribute("error", "Your username and password is invalid.");

	 if (logout != null)
	 model.addAttribute("message", "You have been logged out successfully.");

	 return "/login";
	 }

	 @RequestMapping(value = {"/", }, method = RequestMethod.GET)
	 public String welcome(Model model) {
	 return "forward:/candidates";
	 }

}