package edu.mum.company.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Persistent;

/**
 * @author: ChauKy
 * @Date: Apr 21, 2018
 */

@Entity
public class Company {
	@Id
	@Persistent
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String name;
	@Email @NotEmpty
	private String emailAddress;
	@NotEmpty
	private String website;
	
	@ManyToMany
	@JoinTable(name="Company_Category", joinColumns= @JoinColumn(name="Company_ID"), inverseJoinColumns= @JoinColumn(name="Category_ID"))
	private List<Category> categories = new ArrayList<Category>();
	
	@Embedded
	private Address address;

	
	public Company() {
	}


	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "Company [Id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", website=" + website
				+ ", categories=" + categories + ", address=" + address + "]";
	}

	
}