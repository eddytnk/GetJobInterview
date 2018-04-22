package edu.mum.candidate.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.service.CandidateService;


@Controller
@RequestMapping(value="/candidate")
public class CandidateController {
	private CandidateService candidateService;
	
	@Autowired
	public void setCustomerService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@RequestMapping(value = "/candidate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addCandidate( Candidate candidate) {
		candidateService.addCandidate(candidate);
	}
	
	@RequestMapping(value = "/candidate/{candidateId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCandidate(@PathVariable("candidateId") String candidateId) { 
		candidateService.deleteCandidate(candidateId);
	}
	
	@RequestMapping(value = "/candidate/{candidateId}", method = RequestMethod.GET)
	public @ResponseBody Candidate getCustomer(@PathVariable("candidateId") String candidateId) { 
		return candidateService.getById(candidateId);
	}
	
	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	public @ResponseBody Collection<Candidate> getCandidates() {
		return candidateService.getCandidates();
	}
	
	@RequestMapping(value = "/candidate/{candidateId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@RequestBody Candidate candidate) {
		candidateService.updateCandidate(candidate);
		//return customerService.getCustomer(customer.getCustomerNumber());
	}
	
}
