package edu.mum.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.company.entity.Category;
import edu.mum.company.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public List<Category> findByName(String name){
		return categoryRepository.findByName(name);
	}
	
	public void Delete(Category cat) {
		categoryRepository.delete(cat);
	}
	
	public void Save(Category cat) {
		categoryRepository.save(cat);
	}

}
