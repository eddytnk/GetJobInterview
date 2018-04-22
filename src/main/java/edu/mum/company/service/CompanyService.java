package edu.mum.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.company.entity.Company;
import edu.mum.company.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	public Company findCompanyById(String companyId) {
		return companyRepository.findByCompanyId(companyId);
	}
	
	public List<Company> findByName(String name){
		return companyRepository.findByName(name);
	}

	public List<Company> getAllCompanies(){
		return (List<Company>) companyRepository.findAll();
	}
	
	public void saveCompany(Company comp) {
		companyRepository.save(comp);
	}
	
	public void deleteCompany(Company comp) {
		companyRepository.delete(comp);
	}
}
