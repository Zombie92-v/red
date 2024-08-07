package com.zombie.web;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zombie")
public class RedWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedWebApplication.class, args);
    }

}
