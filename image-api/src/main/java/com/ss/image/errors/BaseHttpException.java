package com.ss.image.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
class BaseHttpException extends Exception{
    private final HttpStatus httpStatus;
    public BaseHttpException(HttpStatus httpStatus, String message){
        super(message);
        this.httpStatus = httpStatus;
    }
}
