package com.bu.fpo;

import com.bu.fpo.service.DataInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FpoApplication {

    @Autowired
    private DataInstanceService dataInstanceService;
    
    public static void main(String[] args) {
        SpringApplication.run(FpoApplication.class, args);
    }

}
