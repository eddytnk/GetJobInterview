

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
		
		Category cat1 = new Category();
		cat1.setName("Outsource");
		
		Category cat2 = new Category();
		cat1.setName("Product");
		
		Category cat3 = new Category();
		cat1.setName("Intership");
		
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
		comp1.setEmailAddress("abc@yahoo.com");
		comp1.setWebsite("www.test.com");
		comp1.setAddress(address);
		comp1.addCategory(cat1);
	
		
		Company comp2 = new Company();
		comp1.setName("Test Architecture Company");
		comp2.setEmailAddress("abc@yahoo.com");
		comp2.setWebsite("www.test.com");
		comp2.setAddress(address);
		comp2.addCategory(cat2);
		
		Company comp3 = new Company();
		comp3.setName("Computer Solution");
		comp3.setEmailAddress("abc@yahoo.com");
		comp3.setWebsite("www.test.com");
		comp3.setAddress(address);
		comp3.addCategory(cat1);
		
		Company comp4 = new Company();
		comp4.setName("Computer Solution");
		comp4.setEmailAddress("abc@yahoo.com");
		comp4.setWebsite("www.test.com");
		comp4.setAddress(address);
		comp4.addCategory(cat2);
		
		Company comp5 = new Company();
		comp5.setName("Computer Solution");
		comp5.setEmailAddress("chauky@gmail.com");
		comp5.setWebsite("www.test.com");
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
