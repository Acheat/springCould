package com.wcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "wcd.*")
public class CustermApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustermApplication.class,args);
    }


}
