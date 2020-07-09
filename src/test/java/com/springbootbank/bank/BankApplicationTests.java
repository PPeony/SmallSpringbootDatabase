package com.springbootbank.bank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class BankApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(HttpStatus.OK.value());
    }

}
