package com.example.dynamic_menu_builder.exception;

import org.springframework.http.HttpStatus;

public class NotImplementedException extends BaseException {
    public NotImplementedException() {
        super("API not implemented", HttpStatus.NOT_IMPLEMENTED.value());
    }
}
