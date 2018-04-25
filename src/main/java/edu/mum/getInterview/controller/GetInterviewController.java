package edu.mum.getInterview.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.repository.CandidateRepository;
import edu.mum.common.Address;
import edu.mum.common.Helper;
import edu.mum.company.entity.Category;
import edu.mum.company.entity.Company;
import edu.mum.company.service.CategoryService;
import edu.mum.company.service.CompanyService;
import edu.mum.getInterview.dtos.EmailAdress;
import edu.mum.getInterview.dtos.ResponseMessage;
import edu.mum.getInterview.dtos.SendMailDTO;
import edu.mum.getInterview.entity.CandidateCompany;
import edu.mum.getInterview.services.CandidateCompanyService;


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
	
@RequestMapping(value = { "/getinterview" }, method = RequestMethod.GET)
public String getInterviewPage(Model model) {
	List<Category> categories = categoryService.getAllCategories();
	
	model.addAttribute("categories",categories);
	return "getinterview/getinterview";
}

@RequestMapping(value = { "/getinterview" }, method = RequestMethod.POST)
public String saveInterviewPage(Model model, 
		@RequestParam( required = false ) 
			List<Long> company,
			@RequestHeader String host) {
	
	List<String> message = null;
	if(company !=null) {
		
		Candidate candidate = candService.findByName("Edward T. Tanko").get(0); //From session	
		List<CandidateCompany> candComs = company.stream()
				.distinct()
				.map(comId->{
					Company com = companyService.findById(comId);
					CandidateCompany candCom = new CandidateCompany();
					candCom.setCandidate(candidate);
					candCom.setCompany(com);
					String resumeLink = Helper.hashMd5(""+com.getId()+candidate.getId()); // a hash of companyID and CandidateID
					candCom.setResumeLink(resumeLink);
					candCom.setVisited(false); 
					candCom.setCreatedAt(new Date());
					candCom.setUpdatedAt(new Date());
					return candCom;
				}).collect(Collectors.toList());
			
				message = new ArrayList<>();
				
				
				final String uri = "http://localhost:8081/sendmails/";
				for(CandidateCompany c: candComs) {
					canComService.saveCandidateCompany(c); 
					 Company co = c.getCompany();
					 
					 SendMailDTO sendMailDTo = new SendMailDTO();
					 sendMailDTo.setSubject("GetJobIntervice - "+candidate.getName());
						String body = candidate.getSummary();
						sendMailDTo.addEmails(new EmailAdress(co.getName(), co.getEmailAddress()));
					 sendMailDTo.setMessage(body);
					 body += "Click here to see Complete Resume of "+ candidate.getName();
					 body += "<a href='"+host+"/resume/"+c.getResumeLink()+"'>"+c.getResumeLink()+"</a>";
					 
					 
				    RestTemplate restTemplate = new RestTemplate();
				    ResponseMessage result = restTemplate.postForObject(uri,sendMailDTo, ResponseMessage.class);
					
					if(result.getStatus().equals("200")){
						message.add(co.getName()+ "<i class='fas fa-envelope' style='color:skyblue'></i>");
					}else {
						message.add(co.getName()+ " <i class='fas fa-times' style='color:red'></i>");
					}
				}
	}
	
	List<Category> categories = categoryService.getAllCategories();
	model.addAttribute("categories",categories);
	model.addAttribute("message", message);
	
	return "getinterview/getinterview";
}

@RequestMapping(value = { "/resume" }, method = RequestMethod.GET)
public String getResume(Model model) {
	Candidate candidate = candService.findByName("Edward T. Tanko").get(0); //From session		
	model.addAttribute("candidate", candidate);
	model.addAttribute("mapMonths", Helper.mapMonths());
	return "getinterview/resume";
}


@RequestMapping(value = { "/resume/{code}" }, method = RequestMethod.GET)
public String viewResume(Model model) {
	Candidate candidate = candService.findByName("Edward T. Tanko").get(0); //From session		
	model.addAttribute("candidate", candidate);
	model.addAttribute("mapMonths", Helper.mapMonths());
	return "getinterview/resume";
}




@RequestMapping(value = { "/getinterviewReport" }, method = RequestMethod.GET)
public String getInterviewReport(Model model) {
	Candidate candidate = candService.findByName("Edward T. Tanko").get(0); //From session	
	List<CandidateCompany>  candidateCompanies = canComService.findByCandidate(candidate);
	Map<String, Long> candidateCompanyCount= canComService.candidateCompanyCount(candidate);
	
	model.addAttribute("candidate", candidate);
	model.addAttribute("candidateCompanies", candidateCompanies);
	model.addAttribute("candidateCompanyCount",candidateCompanyCount);
	return "getinterview/getinterviewReport";
}


}
