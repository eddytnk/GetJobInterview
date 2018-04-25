package edu.mum.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.company.entity.Category;
import edu.mum.company.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public void Delete(Category cat) {
		categoryRepository.delete(cat);
	}
	
	public void Save(Category cat) {
		categoryRepository.save(cat);
	}
	
	public Long getCategoryIdByName(String name) {
		Category cat;
		cat= categoryRepository.findOneByName(name);
		return cat.getId();
	}
	
	public Optional<Category> getCategoryById(Long id) {
		Optional<Category> cat= categoryRepository.findById(id);
		return cat;
		
	}
}
