package edu.mum.candidate.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		candidateService.updateCandidate(id, candidate);
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
	
	@RequestMapping(value = "/editProfilePict/{id}")
	public String editProfilePict(@PathVariable("id") String id, Model model) { 
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		return "candidate/editProfilePict";
	}

	@RequestMapping(value="/editProfilePict/{id}",method=RequestMethod.POST)
	public String updateProfilePict(@ModelAttribute("candidate") Candidate candidate, @PathVariable String id,
			@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes)
	{
		//String UPLOADED_FOLDER = "F://temp//";
	    String UPLOADED_FOLDER = "C://Temp//ea_final_project//";
		//String UPLOADED_FOLDER = "../"; 
		
		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:../candidates/"+id;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String pictureLocalURL = UPLOADED_FOLDER + file.getOriginalFilename();
            Path path = Paths.get(pictureLocalURL);
            Files.write(path, bytes);
            
            candidateService.updatePictureLocalURL(id,pictureLocalURL);

            redirectAttributes.addFlashAttribute("message", 
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", 
                    "NOT SUCCESS '" + file.getOriginalFilename() + "'");
        }

        return "redirect:../candidates/"+id;
	}
	
}
