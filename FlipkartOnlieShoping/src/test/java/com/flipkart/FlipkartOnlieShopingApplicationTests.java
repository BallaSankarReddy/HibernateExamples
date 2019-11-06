package com.flipkart;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.flipkart.expections.CustomerExpection;
import com.flipkart.model.Customer;
import com.flipkart.model.Electronics;
import com.flipkart.repository.CustomerRepo;
import com.flipkart.repository.ElectronicsRepo;
import com.flipkart.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlipkartOnlieShopingApplicationTests {

	@Autowired
	private CustomerService customerService;
	@MockBean
	private CustomerRepo customerRepo;
	@MockBean
	private ElectronicsRepo electronicsRepo;
	
	@Test
	public void getCustomerListTest() {
		
		List<Electronics> elecList = new ArrayList<Electronics>();
	
			Electronics  e1 = new Electronics();
			e1.setProductId(121);
			e1.setProductName("Redmi Note4");
			e1.setProductCost(13000.00);
			
			Electronics  e2 = new Electronics();
			e2.setProductId(122);
			e2.setProductName("Redmi Note4 Pro");
			e2.setProductCost(13500.00);
			
			elecList.add(e1);
			elecList.add(e2);
			
			Customer c= new Customer();
			c.setCustomerId(1562747);
			c.setCustomerName("Balla");
			c.setElectronics(elecList);
			
			Customer c1= new Customer();
			c1.setCustomerId(1562748);
			c1.setCustomerName("Mohan");
			c1.setElectronics(elecList);
			
		List<Customer> custList = new ArrayList<Customer>();
		custList.add(c);
		custList.add(c1);
		
		
		when(customerRepo.findAll())
			.thenReturn(custList);
		System.out.println("Custoner Size().."+custList.size());
			//.thenThrow(CustomerExpection.class);
		assertEquals(2, customerService.getCustomerList().size());
	}
	
	@Test
	public void customerCreationTest() throws CustomerExpection {
		List<Electronics> elecList = new ArrayList<Electronics>();
	
		Electronics  e1 = new Electronics();
		e1.setProductId(121);
		e1.setProductName("Redmi Note4");
		e1.setProductCost(13000.00);
		
		Electronics  e2 = new Electronics();
		e2.setProductId(122);
		e2.setProductName("Redmi Note4 Pro");
		e2.setProductCost(13500.00);
		
		elecList.add(e1);
		elecList.add(e2);
		
		Customer c= new Customer();
		c.setCustomerId(1562747);
		c.setCustomerName("Balla");
		c.setElectronics(elecList);
		
		Customer c1= new Customer();
		c1.setCustomerId(1562748);
		c1.setCustomerName("Mohan");
		c1.setElectronics(elecList);
		
	List<Customer> custList = new ArrayList<Customer>();
	custList.addAll(custList);
	
	when(customerRepo.save(c))
	.thenReturn(c);
	//.thenThrow(CustomerExpection.class);
assertEquals(c1.getCustomerId(), customerService.customerCreation(c).getCustomerId());
}

	}


