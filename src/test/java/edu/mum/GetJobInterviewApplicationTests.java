package edu.mum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mum.company.entity.Address;
import edu.mum.company.entity.Category;
import edu.mum.company.entity.Company;
import edu.mum.company.repository.CategoryRepository;
import edu.mum.company.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GetJobInterviewApplicationTests {

	@Autowired
	ApplicationContext context;
	
	
	@Test
	public void saveCompany() {
		CompanyRepository compRepo = context.getBean(CompanyRepository.class);
		CategoryRepository category = context.getBean(CategoryRepository.class);
		
		// Create Category
		Category cat = new Category();
		cat.setName("Intership");
		
		
		//Create addresss
		Address address = new Address();
		address.setStreet("123 ABC street");
		address.setState("IA");
		address.setCountry("US");
		address.setZipcode(12345);
		
		//Create Compnay
		Company comp = new Company();
		comp.setName("Test Company");
		comp.setEmailAddress("abc@yahoo.com");
		comp.setWebsite("www.test.com");
		comp.setAddress(address);
		comp.addCategory(cat);
		
//		Save company
		category.save(cat);
		compRepo.save(comp);
		
	}

}
