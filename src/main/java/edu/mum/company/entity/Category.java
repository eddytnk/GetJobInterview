package edu.mum.company.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author: ChauKy
 * @Date: Apr 21, 2018
 */

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String name;
	
	@ManyToMany(mappedBy="categories")
	private List<Company> companies;
	


	public Category() {
	}

	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	public void addCompanies(Company company) {
		companies.add(company);
		company.addCategory(this);
	}

	@Override
	public String toString() {
		return "Category [Id=" + Id + ", name=" + name + "]";
	}
	
	
}
