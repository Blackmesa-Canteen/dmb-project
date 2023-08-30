package com.example.dynamic_menu_builder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.example.dynamic_menu_builder.mapper")
@EnableSwagger2
public class DynamicMenuBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicMenuBuilderApplication.class, args);
    }

}
