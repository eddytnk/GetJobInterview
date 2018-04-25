package edu.mum.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.company.entity.Company;
import edu.mum.company.service.CompanyService;

@Component
public class FlowHelper {
	
	@Autowired
	CompanyService companyService;
	
	public boolean saveCompany(Company comp) {
		companyService.saveCompany(comp);		
		return true;
	}
}
