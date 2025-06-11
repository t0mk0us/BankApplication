package com.tamara.bankAppli.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import com.tamara.bankappli.controller.AccountController;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Currency;

import lombok.extern.slf4j.Slf4j;

@WebMvcTest(AccountController.class)
@Slf4j
public class AccountTests {
	
	//@Autowired
	private MockMvcTester mvc;
	
	private static Account account;
	private static Currency currency;
	
	@BeforeAll
	static void setup() {
		
		account = new Account();
		account.setBalance(50000.50F);
		currency = new Currency();
		currency.setName("Test");
		currency.setCode("T");		
		account.setCurrency(currency);
	    log.info("@BeforeAll - executes once before all test methods in this class");
	}

	@BeforeEach
	void init() {
	    log.info("@BeforeEach - executes before each test method in this class");
	}
	
	@DisplayName("Single test successful")
	@Test
	void testSingleSuccessTest() {
	    log.info("Success");
	}

	@Test
	void testSettingAccFields() {	
		assertEquals(account.getBalance(), 50000.50F);
	}
	
	@Test
	void testSettingAccCurrency() {
		assertEquals(account.getCurrency().getName(), "Test");
	}
	
	@Test
	@Disabled("Not implemented yet")
	void testShowSomething() {
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	void requestProtectedUrlWithUser() {
		assertThat(this.mvc.get().uri("/")).doesNotHaveFailed();
	}
	
	/*
	 * @Test void lambdaExpressions() { List numbers = Arrays.asList(1, 2, 3);
	 * assertTrue(numbers.stream() .mapToInt(Integer::intValue) .sum() > 5, () ->
	 * "Sum should be greater than 5"); }
	 */
	
	@Test
	void shouldThrowException() {
	    Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
	      throw new UnsupportedOperationException("Not supported");
	    });
	    assertEquals("Not supported", exception.getMessage());
	}

	@Test
	void assertThrowsException() {
	    String str = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	      Integer.valueOf(str);
	    });
	}
	
	@AfterEach
	void tearDown() {
	    log.info("@AfterEach - executed after each test method.");
	}

	@AfterAll
	static void done() {
	    log.info("@AfterAll - executed after all test methods.");
	}
}

	


