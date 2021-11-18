package com.example.library.configuration;

import com.example.library.controller.CustomerDuplicatedException;
import com.example.library.controller.NonExistentCustomerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

@ControllerAdvice
public class ExceptionCustomerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NonExistentCustomerException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "User not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({CustomerDuplicatedException.class})
    protected ResponseEntity<Object> handleDuplicate(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "User duplicated", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
