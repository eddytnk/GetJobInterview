package edu.mum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import edu.mum.company.entity.Address;
import edu.mum.company.entity.Category;
import edu.mum.company.entity.Company;
import edu.mum.company.repository.CategoryRepository;
import edu.mum.company.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetJobInterviewApplicationTests {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void saveCompany() {
		
		CompanyRepository compRepo = context.getBean(CompanyRepository.class);
		CategoryRepository category = context.getBean(CategoryRepository.class);
		
		compRepo.deleteAll();
		category.deleteAll();
		
		Category cat1 = new Category();
		cat1.setName("Outsource");
		
		Category cat2 = new Category();
		cat2.setName("Product");
		
		Category cat3 = new Category();
		cat3.setName("Intership");
		
		//Create addresss
		Address address = new Address();
		address.setStreet("123 ABC street");
		address.setCity("FairField");
		address.setState("IA");
		address.setCountry("US");
		address.setZipcode(12345);
		
		//Create Compnay
		Company comp1 = new Company();
		comp1.setName("EA Company");
		comp1.setEmailAddress("chauky@yahoo.com");
		comp1.setWebsite("www.chauky.com");
		comp1.setAddress(address);
		comp1.addCategory(cat1);
	
		
		Company comp2 = new Company();
		comp2.setName("Test Architecture Company");
		comp2.setEmailAddress("company@yahoo.com");
		comp2.setWebsite("www.company.com");
		comp2.setAddress(address);
		comp2.addCategory(cat2);
		
		Company comp3 = new Company();
		comp3.setName("Computer Solution");
		comp3.setEmailAddress("computer@yahoo.com");
		comp3.setWebsite("www.company.com");
		comp3.setAddress(address);
		comp3.addCategory(cat1);
		
		Company comp4 = new Company();
		comp4.setName("Computer Solution");
		comp4.setEmailAddress("testing@yahoo.com");
		comp4.setWebsite("www.testing.com");
		comp4.setAddress(address);
		comp4.addCategory(cat2);
		
		Company comp5 = new Company();
		comp5.setName("Computer Solution");
		comp5.setEmailAddress("solution@yahoo.com");
		comp5.setWebsite("www.solution.com");
		comp5.setAddress(address);
		comp5.addCategory(cat3);
		
		
//		Save company
		category.save(cat1);
		category.save(cat2);
		category.save(cat3);
		
		compRepo.save(comp1);
		compRepo.save(comp2);
		compRepo.save(comp3);
		compRepo.save(comp4);
		compRepo.save(comp5);
	}

}
