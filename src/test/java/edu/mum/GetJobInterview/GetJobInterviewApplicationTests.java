package edu.mum.GetJobInterview;

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

import edu.mum.candidate.repository.CandidateRepository;
import edu.mum.company.entity.Address;
import edu.mum.company.entity.Category;
import edu.mum.company.entity.Company;
import edu.mum.company.repository.CompanyRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@DataJpaTest
public class GetJobInterviewApplicationTests {

//	@Autowired
//	ApplicationContext context;
	
	//@Autowired
	//CompanyRepository compRepo;
	//CandidateRepository can;
	
	@Test
	public void saveCompany() {
		//CompanyRepository compRepo = context.getBean(CompanyRepository.class);
		
		// Create Category
		Category cat = new Category();
		cat.setId(1L);
		cat.setName("ChauKy");
		
		//Create addresss
		Address address = new Address();
		address.setStreet("123 ABC street");
		address.setState("IA");
		address.setCountry("US");
		address.setZipcode(12345);
		
		//Create Compnay
		Company comp = new Company();
		comp.setId(2L);
		comp.setName("Test Company");
		comp.setEmailAddress("abc@yahoo.com");
		comp.setWebsite("www.test.com");
		comp.setAddress(address);
		comp.addCategory(cat);
		
		//Save company
		//compRepo.save(comp);
		
	}

}
