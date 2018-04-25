package com.getjobinterviewEMS.GetJobInterviewEMS.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.getjobinterviewEMS.GetJobInterviewEMS.dtos.ResponseMessage;
import com.getjobinterviewEMS.GetJobInterviewEMS.dtos.SendMailDTO;
import com.getjobinterviewEMS.GetJobInterviewEMS.services.SendEmailService;

@RestController
public class ServiceController {
	
	@Autowired	
	private SendEmailService sendMailSender;
	
	@RequestMapping(value = {"/sendmails"}, method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.OK)
	public ResponseMessage  sendEmail(@RequestBody SendMailDTO request) {
		
		ResponseMessage  res = new ResponseMessage();
		try {
			sendMailSender.sendEmail(request);
			res.setStatus("200");
			res.setMessage("Email(s) sent successfully");
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus("500");
			res.setMessage(e.getMessage());
		}
		System.out.println(res);
		return res;
	}
	
}
