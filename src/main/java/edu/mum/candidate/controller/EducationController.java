package edu.mum.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.candidate.entity.Education;
import edu.mum.candidate.service.CandidateService;
import edu.mum.candidate.service.EducationService;
import edu.mum.common.Helper;

@Controller
public class EducationController {
	private CandidateService candidateService;
	private EducationService educationService;
	
	@Autowired
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@Autowired
	public void setEducationService(EducationService educationService) {
		this.educationService = educationService;
	} 
	
	@RequestMapping(value = "/addEducation/{id}")
	public String addEducation(@PathVariable("id") String id, Model model) { 		
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		/*model.addAttribute("months", Helper.mapMonths().keySet());
		model.addAttribute("mapMonths", Helper.mapMonths());*/
		model.addAttribute("years", Helper.getYears());
		model.addAttribute("selectedYear", 0);
		return "candidate/addEducation";
	}
	
	@RequestMapping(value="/addEducation/{id}",method=RequestMethod.POST)	
	public String insertEducation(@ModelAttribute("education") Education education, @PathVariable String id)
	{
		//System.out.println("======================================HALO");
		String view = "redirect:../candidates/"+id; 
		candidateService.addEducation(id, education);//.addCandidate(candidate);
		return view; //"redirect:../candidates";
	}	
	@RequestMapping(value = "/editEducation/{id}")
	public String editEducation(@PathVariable("id") String id, Model model) { 
		model.addAttribute("education", educationService.getEducationById(id));
		/*model.addAttribute("months", Helper.mapMonths().keySet());
		model.addAttribute("mapMonths", Helper.mapMonths());*/
		model.addAttribute("years", Helper.getYears());
		return "candidate/editEducation";
	}
	
	@RequestMapping(value="/editEducation/{id}",method=RequestMethod.POST)
	public String updateEducation(@ModelAttribute("education") Education education, @PathVariable String id)
	{
		String view = "redirect:../candidates/"+educationService.getEducationById(id).getOwner().getId(); 
		educationService.updateEducation(id, education);//.addCandidate(candidate);
		return view; //"redirect:../candidates";
	}
	
	@RequestMapping(value="/deleteEducation/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable String id) {
		String view = "redirect:../candidates/"+educationService.getEducationById(id).getOwner().getId(); 
		educationService.delete(id);
		return view;
	}

}
