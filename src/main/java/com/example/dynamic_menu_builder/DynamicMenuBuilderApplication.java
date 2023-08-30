package com.example.dynamic_menu_builder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dynamic_menu_builder.mapper")
public class DynamicMenuBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicMenuBuilderApplication.class, args);
    }

}
