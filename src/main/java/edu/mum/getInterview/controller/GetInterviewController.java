package edu.mum.getInterview.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.repository.CandidateRepository;
import edu.mum.common.Address;
import edu.mum.common.Helper;
import edu.mum.common.UserType;
import edu.mum.company.entity.Category;
import edu.mum.company.entity.Company;
import edu.mum.company.service.CategoryService;
import edu.mum.company.service.CompanyService;
import edu.mum.getInterview.dtos.EmailAdress;
import edu.mum.getInterview.dtos.ResponseMessage;
import edu.mum.getInterview.dtos.SendMailDTO;
import edu.mum.getInterview.entity.CandidateCompany;
import edu.mum.getInterview.services.CandidateCompanyService;
import edu.mum.login.entity.User;
import edu.mum.login.service.UserCandidateService;
import edu.mum.login.service.UserService;


@Controller
public class GetInterviewController {

	@Autowired
	CandidateCompanyService canComService;
	@Autowired
	CompanyService companyService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CandidateRepository candService;
	@Autowired
	UserService userService;
	@Autowired
	UserCandidateService userCandService;
	
@RequestMapping(value = { "/getinterview" }, method = RequestMethod.GET)
public String getInterviewPage(Model model, Principal principal) {
	User user = userService.findByUsername(principal.getName());
	if(user.getUserType() != UserType.CANDIDATE) {		
		return "forward:/companies";				
	}
	List<Category> categories = categoryService.getAllCategories();
	
	model.addAttribute("categories",categories);
	return "getinterview/getinterview";
}

@RequestMapping(value = { "/getinterview" }, method = RequestMethod.POST)
public String saveInterviewPage(Model model, 
		@RequestParam( required = false ) 
			List<Long> company,
			@RequestHeader String host,
			Principal principal) {
	User user = userService.findByUsername(principal.getName());
	if(user.getUserType() != UserType.CANDIDATE) {		
		return "forward:/companies";				
	}
	
	List<String> message = new ArrayList<>();
	if(company !=null) {
		
		Candidate candidate = userCandService.getCandidateByUser(user);//candService.findByName("Edward T. Tanko").get(0); //From session	
		List<CandidateCompany> candComs = company.stream()
				.distinct()
				.map(comId->{
					Company com = companyService.findById(comId);
					CandidateCompany candCom = new CandidateCompany();
					candCom.setCandidate(candidate);
					candCom.setCompany(com);
					String resumeLink = Helper.hashMd5(""+com.getId()+candidate.getId()+LocalDateTime.now()); // a hash of companyID and CandidateID
					candCom.setResumeLink(resumeLink);
					candCom.setVisited(false); 
					candCom.setCreatedAt(new Date());
					candCom.setUpdatedAt(new Date());
					return candCom;
				}).collect(Collectors.toList());
			
				
				
				
				final String uri = "http://localhost:8081/sendmails/";
				for(CandidateCompany c: candComs) {
					canComService.saveCandidateCompany(c); 
					 Company co = c.getCompany();
					 
					 SendMailDTO sendMailDTo = new SendMailDTO();
					 sendMailDTo.setSubject("GetJobIntervice - "+candidate.getName());
						String body = candidate.getSummary();
						sendMailDTo.addEmails(new EmailAdress(co.getName(), co.getEmailAddress()));
					
					 body += "<br/>Click here to see Complete Resume of "+ candidate.getName();
					 body += "<a href='"+host+"/resume/link/"+c.getResumeLink()+"'>"+c.getResumeLink()+"</a>";
					 
					 sendMailDTo.setMessage(body);
					 
				    RestTemplate restTemplate = new RestTemplate();
				    ResponseMessage result = restTemplate.postForObject(uri,sendMailDTo, ResponseMessage.class);
					
					if(result.getStatus().equals("200")){
						message.add(co.getName()+ "<i class='fas fa-envelope' style='color:skyblue'></i>");
					}else {
						message.add(co.getName()+ " <i class='fas fa-times' style='color:red'></i>");
					}
				}
	}else {
		 message = new ArrayList<>();
		message.add("Please select a company <i class='fas fa-times' style='color:red'></i>");
	}
	
	List<Category> categories = categoryService.getAllCategories();
	model.addAttribute("categories",categories);
	model.addAttribute("message", message);
	
	return "getinterview/getinterview";
}

@RequestMapping(value = { "/resume" }, method = RequestMethod.GET)
public String getResume(Model model, Principal principal) {
	User user = userService.findByUsername(principal.getName());
	Candidate candidate = userCandService.getCandidateByUser(user);
	//Candidate candidate = candService.findByName("Edward T. Tanko").get(0); //From session		
	model.addAttribute("candidate", candidate);
	model.addAttribute("mapMonths", Helper.mapMonths());
	return "getinterview/resume";
}


@RequestMapping(value = { "/resume/link/{code}" }, method = RequestMethod.GET)
public String viewResume(Model model, @PathVariable("code") String code) {
	CandidateCompany candCom = canComService.findCondidateCompanyByResumeLink(code);
	Candidate candidate = candCom.getCandidate();	
	
	
	canComService.saveCandidateCompany(candCom);
	
	SendMailDTO sendMailDTo = new SendMailDTO();
	sendMailDTo.setSubject("GetJobIntervice - "+candCom.getCompany().getName());
		
	sendMailDTo.addEmails(new EmailAdress(candidate.getName(), candidate.getEmailAddress()));
	String body = candCom.getCompany().getName()+" has opened your Resume!";
	 sendMailDTo.setMessage(body);
	 
	if(!candCom.isVisited()) { 
	   final String uri = "http://localhost:8081/sendmails/";
	   RestTemplate restTemplate = new RestTemplate();
	   ResponseMessage result = restTemplate.postForObject(uri,sendMailDTo, ResponseMessage.class);
	   candCom.setVisited(true);
	   /*if(result.getStatus().equals("200")){
		   candCom.setVisited(true);
	   }*/
	   
	   canComService.saveCandidateCompany(candCom);
	}
	
	model.addAttribute("candidate", candidate);
	model.addAttribute("mapMonths", Helper.mapMonths());
	return "getinterview/candidate_resume";
}




@RequestMapping(value = { "/getinterviewReport" }, method = RequestMethod.GET)
public String getInterviewReport(Model model, Principal principal) {
	//Candidate candidate = candService.findByName("Edward T. Tanko").get(0); //From session	
	User user = userService.findByUsername(principal.getName());
	Candidate candidate = userCandService.getCandidateByUser(user);
	List<CandidateCompany>  candidateCompanies = canComService.findByCandidate(candidate);
	Map<String, Long> candidateCompanyCount= canComService.candidateCompanyCount(candidate);
	
	model.addAttribute("candidate", candidate);
	model.addAttribute("candidateCompanies", candidateCompanies);
	model.addAttribute("candidateCompanyCount",candidateCompanyCount);
	return "getinterview/getinterviewReport";
}


}
