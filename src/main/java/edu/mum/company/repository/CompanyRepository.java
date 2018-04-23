package edu.mum.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.company.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

	Optional<Company> findById(Long id);
	List<Company> findByName(String name);

}
