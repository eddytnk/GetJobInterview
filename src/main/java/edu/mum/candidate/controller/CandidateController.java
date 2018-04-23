package edu.mum.candidate.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.entity.Experience;
import edu.mum.candidate.service.CandidateService;
import edu.mum.common.Helper;



@Controller
//@RequestMapping(value="/candidate")
public class CandidateController {
	private CandidateService candidateService;
	
	@Autowired
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	} 
	
	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("candidates", candidateService.getCandidates());
		return "candidate/candidates";
	}
	
	@RequestMapping(value = "/candidates/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, Model model) { 
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		model.addAttribute("mapMonths", Helper.mapMonths());
		return "candidate/candidateDetail";
	}
	
	@RequestMapping(value = "/editCandidate/{id}")
	public String edit(@PathVariable("id") String id, Model model) { 
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		return "candidate/editCandidate";
	}
	@RequestMapping(value="/editCandidate/{id}",method=RequestMethod.POST)
	public String update(@ModelAttribute("candidate") Candidate candidate, @PathVariable String id)
	{
		candidateService.updateCandidate(id, candidate);//.addCandidate(candidate);
		return "redirect:../candidates";
	}
	
	@RequestMapping(value = "/addCandidate")
	public String add(Model model, @ModelAttribute("candidate")Candidate candidate) {
		return "candidate/addCandidate";
	}
	
	@RequestMapping(value="/addCandidate",method=RequestMethod.POST)
	public String insert(Model model,@ModelAttribute("candidate") Candidate candidate)
	{
		candidateService.addCandidate(candidate);
		return "redirect:candidates";
	}
	
	@RequestMapping(value = "/addExperience/{id}")
	public String addExperience(@PathVariable("id") String id, Model model) { 		
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		model.addAttribute("months", Helper.mapMonths().keySet());
		model.addAttribute("mapMonths", Helper.mapMonths());
		model.addAttribute("years", Helper.getYears());
		model.addAttribute("selectedYear", 0);
		return "candidate/addExperience";
	}
	
	@RequestMapping(value="/addExperience/{id}",method=RequestMethod.POST)	
	public String insertExperience(@ModelAttribute("experience") Experience experience, @PathVariable String id)
	{
		System.out.println("======================================HALO");
		candidateService.addExperience(id, experience);//.addCandidate(candidate);
		return "redirect:../candidates";
	}	
	@RequestMapping(value = "/editExperience/{id}")
	public String editExperience(@PathVariable("id") String id, Model model) { 
		model.addAttribute("experience", candidateService.getExperienceById(id));
		model.addAttribute("months", Helper.mapMonths().keySet());
		model.addAttribute("mapMonths", Helper.mapMonths());
		model.addAttribute("years", Helper.getYears());
		return "candidate/editExperience";
	}
	
	@RequestMapping(value="/editExperience/{id}",method=RequestMethod.POST)
	public String updateExperience(@ModelAttribute("experience") Experience experience, @PathVariable String id)
	{
		candidateService.updateExperience(id, experience);//.addCandidate(candidate);
		return "redirect:../candidates";
	}
	
}
