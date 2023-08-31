package com.example.dynamic_menu_builder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.example.dynamic_menu_builder.mapper")
@EnableSwagger2
@EnableTransactionManagement
public class DynamicMenuBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicMenuBuilderApplication.class, args);
    }

}
