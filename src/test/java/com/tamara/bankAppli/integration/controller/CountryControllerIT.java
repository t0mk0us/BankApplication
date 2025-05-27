package com.tamara.bankAppli.integration.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import jakarta.servlet.ServletContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class CountryControllerIT {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	@BeforeEach
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {
	    ServletContext servletContext = webApplicationContext.getServletContext();
	    
	    assertNotNull(servletContext);
	    assertTrue(servletContext instanceof MockServletContext);
	    assertNotNull(webApplicationContext.getBean("greetController"));
	}
	
	@Test
	public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
		
	    this.mockMvc.perform(get("/account/list"))
	    	//.andDo(print())
	    	.andExpect(status().isOk())
	    	.andExpect(view().name("index"));	   
	}
	
	@Test
	public void givenAccountURI_whenMockMVC_thenVerifyResponse() throws Exception {
		
	    MvcResult mvcResult = this.mockMvc.perform(get("/greet"))
	      .andDo(print()).andExpect(status().isOk())
	      .andExpect(jsonPath("$.message").value("Hello World!!!"))
	      .andReturn();
	    
	    assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
	}
	
	@Test
	public void givenAccountURIWithPathVariable_whenMockMVC_thenResponseOK() throws Exception {
		
	    this.mockMvc
	      .perform(get("/greetWithPathVariable/{name}", "John"))
	      .andDo(print()).andExpect(status().isOk())
	      .andExpect(content().contentType("application/json;charset=UTF-8"))
	      .andExpect(jsonPath("$.message").value("Hello World John!!!"));
	}
	
	@Test
	public void givenAccountURIWithQueryParameter_whenMockMVC_thenResponseOK() throws Exception {
		
	    this.mockMvc.perform(get("/greetWithQueryVariable")
	      .param("name", "John Doe")).andDo(print()).andExpect(status().isOk())
	      .andExpect(content().contentType("application/json;charset=UTF-8"))
	      .andExpect(jsonPath("$.message").value("Hello World John Doe!!!"));
	}
	
	@Test
	public void givenAccountURIWithPost_whenMockMVC_thenVerifyResponse() throws Exception {
		
	    this.mockMvc.perform(post("/greetWithPost")).andDo(print())
	      .andExpect(status().isOk()).andExpect(content()
	      .contentType("application/json;charset=UTF-8"))
	      .andExpect(jsonPath("$.message").value("Hello World!!!"));
	}
	
	@Test
	public void givenAccountURI_whenMockMVC_withVerifyResponse() throws Exception {
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/greet"))
	      .andDo(print())
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World!!!"))
	      .andReturn();
	 
	   assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
	}
}
