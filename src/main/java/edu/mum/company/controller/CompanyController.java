package edu.mum.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import edu.mum.company.entity.Company;
import edu.mum.company.service.CategoryService;
import edu.mum.company.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	CategoryService categoryService;

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

	@RequestMapping("/addCompany")
	public String addCompany(Model model, @ModelAttribute("company") Company company) {
//		model.addAttribute("categories", categoryService.getAllCategories());
		return "company/addCompany";
	}

	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public String saveCompany(Model model, @ModelAttribute("company") @Valid Company company, BindingResult result) {
		String view = "redirect:/companies";
		if (!result.hasErrors()) {
			companyService.saveCompany(company);
		} else {
			view = "company/addCompany";
		}
		return view;
	}

	@RequestMapping(value = "/companies/{id}", method = RequestMethod.POST)
	public String updateCompany(Model model, @ModelAttribute("company") @Valid Company company, BindingResult result) {
		String view = "redirect:/companies";
		if (!result.hasErrors()) {
			companyService.saveCompany(company);
		} else {
			view = "company/companyDetail";
		}
		return view;
	}

	@RequestMapping(value = "/deleteCompany/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		companyService.deleteCompany(companyService.findById(id));
		return "redirect:/companies";
	}

}
