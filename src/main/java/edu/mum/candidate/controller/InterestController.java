package edu.mum.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.candidate.entity.Interest;
import edu.mum.candidate.service.CandidateService;
import edu.mum.candidate.service.InterestService;
import edu.mum.common.Helper;

@Controller
public class InterestController {
	private CandidateService candidateService;
	private InterestService interestService;
	
	@Autowired
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@Autowired
	public void setInterestService(InterestService interestService) {
		this.interestService = interestService;
	} 
	
	@RequestMapping(value = "/addInterest/{id}")
	public String addInterest(@PathVariable("id") String id, Model model) { 		
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		return "candidate/addInterest";
	}
	
	@RequestMapping(value="/addInterest/{id}",method=RequestMethod.POST)	
	public String insertInterest(@ModelAttribute("interest") Interest interest, @PathVariable String id)
	{
		System.out.println("======================================HALO");
		candidateService.addInterest(id, interest);
		return "redirect:../candidates";
	}	
	@RequestMapping(value = "/editInterest/{id}")
	public String editInterest(@PathVariable("id") String id, Model model) { 
		model.addAttribute("interest", interestService.getInterestById(id));
		return "candidate/editInterest";
	}
	
	@RequestMapping(value="/editInterest/{id}",method=RequestMethod.POST)
	public String updateInterest(@ModelAttribute("interest") Interest interest, @PathVariable String id)
	{
		interestService.updateInterest(id, interest);
		return "redirect:../candidates";
	}

}
