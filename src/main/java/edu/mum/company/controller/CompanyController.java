package edu.mum.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {
	
@RequestMapping(value = { "/", "/index", "/home" }, method = RequestMethod.GET)
public String getHome() {
	System.out.println("===============================Hello================================");
	return "abc";
}

}
