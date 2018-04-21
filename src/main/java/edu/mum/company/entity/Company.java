package edu.mum.company.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String name;
	private String emailAddress;
	private String website;
	
	@OneToMany
	@JoinColumn(name="company_id")
	private List<Category> categories = new ArrayList<Category>();
	
	@Embedded
	private Address address;

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

	
	public String getEmailAddress() {
		return emailAddress;
	}

	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	public String getWebsite() {
		return website;
	}

	
	public void setWebsite(String website) {
		this.website = website;
	}

	
	public List<Category> getCategories() {
		return categories;
	}

	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	public void addCategory(Category cat) {
		categories.add(cat);
	}

	public Address getAddress() {
		return address;
	}

	
	public void setAddress(Address address) {
		this.address = address;
	}

}