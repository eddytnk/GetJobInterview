package edu.mum.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.mum.company.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

	List<Company> findByName(String name);

}
