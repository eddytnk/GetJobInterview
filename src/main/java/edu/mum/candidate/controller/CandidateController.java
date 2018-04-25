package edu.mum.candidate.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import edu.mum.common.UserType;
import edu.mum.login.entity.User;
import edu.mum.login.service.UserService;
import edu.mum.login.service.UserCandidateService;



@Controller
//@RequestMapping(value="/candidate")
public class CandidateController {
	private CandidateService candidateService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCandidateService userCandidateService;
	@Autowired
	private ServletContext context;
	
	@Autowired
	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	} 
	
	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("candidates", candidateService.getCandidates());
		return "candidate/candidates";
	}
	
	/*@RequestMapping(value = "/candidates/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, Model model) { 
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		model.addAttribute("mapMonths", Helper.mapMonths());
		return "candidate/candidateDetail";
	}*/
	@RequestMapping(value = "/candidates/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, Model model, Principal principal) { 
		User u = userService.findByUsername(principal.getName());
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		if(u.getUserType() == UserType.CANDIDATE) {
			model.addAttribute("userCandidate", userCandidateService.getCandidateByUserName(principal.getName()));
		}
		model.addAttribute("mapMonths", Helper.mapMonths());
		return "candidate/candidateDetail";
	}
	@RequestMapping(value = "/myProfile")
	public String get( Model model, Principal principal) { 
		String view = "candidate/candidateDetail";		
		if(principal != null ) {
			System.out.println("principal.getName(): "+principal.getName());
				//User user = userService.findByUsername(principal.getName());
				/*System.out.println(user.getUserType());
				if(user.getUserType() == UserType.CANDIDATE) {
					System.out.println("user.getUserType() == UserType.CANDIDATE)");
				}*/
				model.addAttribute("candidate", userCandidateService.getCandidateByUserName(principal.getName()));
				model.addAttribute("userCandidate", userCandidateService.getCandidateByUserName(principal.getName()));
				model.addAttribute("mapMonths", Helper.mapMonths());
			
		}
		else {
			view = "candidate/accessDenied";
		}		
		return view;
	}

	
	@RequestMapping(value = "/addCandidate")
	public String add(Model model, @ModelAttribute("candidate")Candidate candidate) {
		return "candidate/addCandidate";
	}
	
	@RequestMapping(value="/addCandidate",method=RequestMethod.POST)
	public String insert(Model model,@ModelAttribute("candidate") @Valid Candidate candidate, BindingResult result)
	{
		String view = "redirect:candidates";
		if(!result.hasErrors()) {
			candidateService.addCandidate(candidate);
		}
		else {
			view="candidate/addCandidate";
		}
		
		
		return view;
	}
	
	@RequestMapping(value = "/editBasicInfo/{id}")
	public String edit(@PathVariable("id") String id, Model model) { 
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		return "candidate/editBasicInfo";
	}
	
	@RequestMapping(value="/editBasicInfo/{id}",method=RequestMethod.POST)
	public String update(@ModelAttribute("candidate") @Valid Candidate candidate, BindingResult result, @PathVariable String id)
	{	
		String view = "redirect:../candidates/"+id; 
		if(!result.hasErrors()) {
			candidateService.updateCandidate(id, candidate);
		}
		else {
			view="candidate/editBasicInfo";
		}
		
		
		return view;
	}
	
	@RequestMapping(value = "/editAddress/{id}")
	public String editAddress(@PathVariable("id") String id, Model model) { 
		System.out.println("===============editAddress=========");
		model.addAttribute("candidate", candidateService.getCandidateById(id));
		return "candidate/editAddress";
	}	
	
	@RequestMapping(value="/editAddress/{id}",method=RequestMethod.POST)
	public String updateAddress(@ModelAttribute("candidate") Candidate candidate, @PathVariable String id)
	{
		String view = "redirect:../candidates/"+id;
		candidateService.updateAddress(id, candidate);
		return view; //"redirect:../candidates";
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
		String UPLOADED_FOLDER; //= "F://temp//";
	    String relativeWebPath = "/resources/images/";
	    String absoluteFilePath = context.getRealPath(relativeWebPath);
	    UPLOADED_FOLDER = absoluteFilePath;
	    //File uploadedFile = new File(absoluteFilePath, "your file name");
		
		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:../candidates/"+id;
        }
		
        try {
        	String fileExt= Helper.getImageExt(file.getOriginalFilename());
        	
        	if(fileExt.equals("")) {
        		redirectAttributes.addFlashAttribute("message", "File is not uploadable. Only .jpg and some other image files allowed.");
                return "redirect:../candidates/"+id;
        	}
        	
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            //String pictureLocalURL = UPLOADED_FOLDER + file.getOriginalFilename();
            
            String fileName = "candidate"+id+fileExt;
            String pictureLocalURL = absoluteFilePath + fileName;//file.getOriginalFilename();
            Path path = Paths.get(pictureLocalURL);
            Files.write(path, bytes);
            
            
            candidateService.updatePictureLocalURL(id,relativeWebPath+fileName);

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
