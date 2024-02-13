package com.example.remind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;


//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class RemindApplication {



    public static void main(String[] args) {
        SpringApplication.run(RemindApplication.class, args);

    }


}
