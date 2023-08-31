package com.example.dynamic_menu_builder.exception;

import org.springframework.http.HttpStatus;

/**
 * if the data is duplicated, this exception will be thrown
 */
public class DuplicatedDataException extends BaseException {
    public DuplicatedDataException(String message) {
        super(message, HttpStatus.BAD_REQUEST.value());
    }
}
