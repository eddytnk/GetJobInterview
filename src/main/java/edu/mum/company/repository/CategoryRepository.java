package edu.mum.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.mum.company.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
