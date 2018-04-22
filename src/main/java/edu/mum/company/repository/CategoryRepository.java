package edu.mum.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.company.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByName(String name);

}
