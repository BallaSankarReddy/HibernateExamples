package com.flipkart.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopingControllerTest {
	
	
	private MockMvc  mockMvc; 
	
	@InjectMocks
	private ShopingController shopingController;

	
	@org.junit.Before
	public  void setup() {
		
		mockMvc=MockMvcBuilders.standaloneSetup(shopingController)
								.build();
	}
	
	@Test
	public void onlieShoping() throws Exception {
		mockMvc.perform(get("/Shoping/online/hi")).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello Sankar"));
	}
	
	@Test
	public void getListOfCustomerTest() throws Exception {
	MvcResult mvcResult= mockMvc.perform(get("/Shoping/online/getAll").content(org.springframework.http.MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk()).andReturn();
	String result_String = mvcResult.getResponse().getContentAsString();
	
			
	
	}

}
