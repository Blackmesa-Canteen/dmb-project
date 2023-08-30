package com.example.dynamic_menu_builder.controller;

import com.example.dynamic_menu_builder.model.dto.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class HomeController {

    @GetMapping("/")
    public R index() {
        String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return R.ok().setData(String.format("dynamic_menu_builder. API Doc: %s/swagger-ui/index.html", baseUrl));
    }

}
