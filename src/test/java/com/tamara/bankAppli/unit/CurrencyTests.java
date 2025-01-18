package com.tamara.bankAppli.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import com.tamara.bankappli.controller.AccountController;

@WebMvcTest(AccountController.class)
public	class CurrencyTests {

	@Autowired
	private MockMvcTester mvc;

	@Test
	@WithMockUser(roles = "ADMIN")
	void requestProtectedUrlWithUser() {
		assertThat(this.mvc.get().uri("/")).doesNotHaveFailed();
	}
}

	


