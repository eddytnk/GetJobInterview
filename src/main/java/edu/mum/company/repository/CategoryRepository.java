package edu.mum.company.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.company.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Category findOneByName(String name);

	
}
