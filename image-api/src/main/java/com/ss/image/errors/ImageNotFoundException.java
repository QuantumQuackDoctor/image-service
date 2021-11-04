package com.ss.image.errors;

import org.springframework.http.HttpStatus;

public class ImageNotFoundException extends BaseHttpException{
    public ImageNotFoundException(){
        super(HttpStatus.NOT_FOUND, "Image not found");
    }
}
