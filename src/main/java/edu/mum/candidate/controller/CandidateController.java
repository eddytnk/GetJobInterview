package edu.mum.candidate.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.service.CandidateService;
import edu.mum.company.entity.Company;


@Controller
//@RequestMapping(value="/candidate")
public class CandidateController {
	private CandidateService candidateService;
	
	@Autowired
	public void setCustomerService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	public String getCandidates(Model model) {
		model.addAttribute("candidates", candidateService.getCandidates());
		return "candidate/candidates";
	}
	
	@RequestMapping(value = "/candidates/{id}", method = RequestMethod.GET)
	public String getCustomer(@PathVariable("id") String id, Model model) { 
		model.addAttribute("candidate", candidateService.getById(id));
		return "candidate/candidateDetail";
	}
	
	@RequestMapping(value = "/addCandidate")
	public String addCandidate(Model model, @ModelAttribute("candidate")Candidate candidate) {
		return "candidate/addCandidate";
	}
	
	@RequestMapping(value="/addCandidate",method=RequestMethod.POST)
	public String saveCandidate(Model model,@ModelAttribute("candidate") Candidate candidate)
	{
		candidateService.addCandidate(candidate);
		return "redirect:/candidate/candidates";
	}
	
}
