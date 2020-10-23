package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: Cafebabe ;)
 */
@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication
public class AppDriver {

    public static void main(String[] args) {
        SpringApplication.run(AppDriver.class, args);
    }

}
