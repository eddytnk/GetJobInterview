package edu.mum.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.company.entity.Category;
import edu.mum.company.entity.Company;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByName(String name);

	
}
