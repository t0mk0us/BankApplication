package com.tamara.bankappli;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tamara.bankappli.controller.AccountController;
import com.tamara.bankappli.service.AccountService;

@SpringBootTest
class BankApplicationContextTests {

    @Autowired
    private AccountController accController;

    @Autowired
    private AccountService accService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(accController).isNotNull();
        assertThat(accService).isNotNull();
    }

}
