package edu.mum.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.lang.*;
import edu.mum.company.entity.Company;
import edu.mum.company.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public String getAllCompanies(Model model) {
		model.addAttribute("companies", companyService.getAllCompanies());
		return "company/companies";
	}

	@RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) {
		model.addAttribute("company", companyService.findById(id));
		return "company/companyDetail";
	}

	@GetMapping("/addCompany")
	public String addCompany() {
		return "company/addCompany";
	}

	@RequestMapping(value = "/companies", method = RequestMethod.POST)
	public String saveCompany(Model model, @ModelAttribute("company") Company company) {
		companyService.saveCompany(company);
		return "redirect:companies";
	}
	
	@RequestMapping(value = "/companies/{id}", method = RequestMethod.POST)
	public String uupdateCompany(Model model, @ModelAttribute("company") Company company) {
		companyService.saveCompany(company);
		return "redirect:/companies";
	}
	
    @RequestMapping(value = "/deleteCompany/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
    	companyService.deleteCompany(companyService.findById(id));
        return "redirect:/companies";
    }
	
}
