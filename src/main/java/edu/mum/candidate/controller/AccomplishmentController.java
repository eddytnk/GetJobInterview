package edu.mum.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.candidate.entity.Accomplishment;
import edu.mum.candidate.service.CandidateService;
import edu.mum.candidate.service.AccomplishmentService;
import edu.mum.common.Helper;

@Controller
public class AccomplishmentController {
	private CandidateService candidateService;
	private AccomplishmentService accomplishmentService;
	
	@Autowired
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@Autowired
	public void setAccomplishmentService(AccomplishmentService accomplishmentService) {
		this.accomplishmentService = accomplishmentService;
	} 
	
	@RequestMapping(value = "/addAccomplishment/{id}")
	public String addAccomplishment(@PathVariable("id") String id, Model model) { 		
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		return "candidate/addAccomplishment";
	}
	
	@RequestMapping(value="/addAccomplishment/{id}",method=RequestMethod.POST)	
	public String insertAccomplishment(@ModelAttribute("accomplishment") Accomplishment accomplishment, @PathVariable String id)
	{
		System.out.println("======================================HALO");
		candidateService.addAccomplishment(id, accomplishment);
		return "redirect:../candidates";
	}	
	@RequestMapping(value = "/editAccomplishment/{id}")
	public String editAccomplishment(@PathVariable("id") String id, Model model) { 
		model.addAttribute("accomplishment", accomplishmentService.getAccomplishmentById(id));
		return "candidate/editAccomplishment";
	}
	
	@RequestMapping(value="/editAccomplishment/{id}",method=RequestMethod.POST)
	public String updateAccomplishment(@ModelAttribute("accomplishment") Accomplishment accomplishment, @PathVariable String id)
	{
		accomplishmentService.updateAccomplishment(id, accomplishment);
		return "redirect:../candidates";
	}

}
