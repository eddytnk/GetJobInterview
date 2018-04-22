package edu.mum.getInterview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GetInterviewController {

	
@RequestMapping(value = { "/getinterview" }, method = RequestMethod.GET)
public String getInterviewPage() {
	System.out.println("===============================Hello================================");
	return "abc";
}

}
