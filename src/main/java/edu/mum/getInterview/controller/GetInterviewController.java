package edu.mum.getInterview.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.candidate.entity.Candidate;
import edu.mum.candidate.repository.CandidateRepository;
import edu.mum.common.Address;
import edu.mum.company.entity.Category;
import edu.mum.company.entity.Company;
import edu.mum.company.service.CategoryService;
import edu.mum.company.service.CompanyService;
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
	System.out.println(categories);

	
	model.addAttribute("categories",categories);
	return "getinterview/getinterview";
}
@RequestMapping(value = { "/getinterview" }, method = RequestMethod.POST)
public String saveInterviewPage(Model model, @RequestParam( required = false ) List<Long> company) {
	
	/*if(company !=null) {
		
		Candidate candidate = candService.findCandidateById(new Long(10)); //From session	
		
		List<CandidateCompany> candComs = company.stream()
				.distinct()
				.map(comId->{
					Company com = (Company)companyService.findCompanyById(comId).get();
					CandidateCompany candCom = new CandidateCompany();
					candCom.setCandidate(candidate);
					candCom.setCompany(com);
					String resumeLink = "link";
					candCom.setResumeLink(resumeLink);
					candCom.setVisited(false); 
					return candCom;
				}).collect(Collectors.toList());
			
				for(CandidateCompany c: candComs) {
					canComService.saveCandidateCompany(c); 
				}
	}
	*/
	List<Category> categories = categoryService.getAllCategories();
	model.addAttribute("categories",categories);
	return "getinterview/getinterview";
}

@RequestMapping(value = { "/resume" }, method = RequestMethod.GET)
public String getResume(Model model) {
	//Candidate candidate = candService.findCandidateById(new Long(10)); //From session	
	//model.addAttribute("candidate", candidate);
	return "getinterview/resume";
}



}
