package edu.mum.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.candidate.entity.Skill;
import edu.mum.candidate.service.CandidateService;
import edu.mum.candidate.service.SkillService;
import edu.mum.common.Helper;

@Controller
public class SkillController {
	private CandidateService candidateService;
	private SkillService skillService;
	
	@Autowired
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@Autowired
	public void setSkillService(SkillService skillService) {
		this.skillService = skillService;
	} 
	
	@RequestMapping(value = "/addSkill/{id}")
	public String addSkill(@PathVariable("id") String id, Model model) { 		
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		return "candidate/addSkill";
	}
	
	@RequestMapping(value="/addSkill/{id}",method=RequestMethod.POST)	
	public String insertSkill(@ModelAttribute("skill") Skill skill, @PathVariable String id)
	{
		System.out.println("======================================HALO");
		candidateService.addSkill(id, skill);
		return "redirect:../candidates";
	}	
	@RequestMapping(value = "/editSkill/{id}")
	public String editSkill(@PathVariable("id") String id, Model model) { 
		model.addAttribute("skill", skillService.getSkillById(id));
		return "candidate/editSkill";
	}
	
	@RequestMapping(value="/editSkill/{id}",method=RequestMethod.POST)
	public String updateSkill(@ModelAttribute("skill") Skill skill, @PathVariable String id)
	{
		skillService.updateSkill(id, skill);
		return "redirect:../candidates";
	}

}
