package edu.mum.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.candidate.entity.Experience;
import edu.mum.candidate.service.CandidateService;
import edu.mum.candidate.service.ExperienceService;
import edu.mum.common.Helper;

@Controller
public class ExperienceController {
	private CandidateService candidateService;
	private ExperienceService experienceService;
	
	@Autowired
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@Autowired
	public void setExperienceService(ExperienceService experienceService) {
		this.experienceService = experienceService;
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
		//System.out.println("======================================HALO");
		String view = "redirect:../candidates/"+id; 
		candidateService.addExperience(id, experience);//.addCandidate(candidate);
		return view; //"redirect:../candidates";
	}	
	@RequestMapping(value = "/editExperience/{id}")
	public String editExperience(@PathVariable("id") String id, Model model) { 
		model.addAttribute("experience", experienceService.getExperienceById(id));
		model.addAttribute("months", Helper.mapMonths().keySet());
		model.addAttribute("mapMonths", Helper.mapMonths());
		model.addAttribute("years", Helper.getYears());
		return "candidate/editExperience";
	}
	
	@RequestMapping(value="/editExperience/{id}",method=RequestMethod.POST)
	public String updateExperience(@ModelAttribute("experience") Experience experience, @PathVariable String id)
	{
		String view = "redirect:../candidates/"+experienceService.getExperienceById(id).getOwner().getId();  
		experienceService.updateExperience(id, experience);//.addCandidate(candidate);
		return view; //"redirect:../candidates";
	}
	
	@RequestMapping(value="/deleteExperience/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable String id) {
		String view = "redirect:../candidates/"+experienceService.getExperienceById(id).getOwner().getId(); 
		experienceService.delete(id);
		return view;
	}

}
