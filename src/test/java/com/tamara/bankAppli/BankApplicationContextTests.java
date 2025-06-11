package com.tamara.bankAppli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
