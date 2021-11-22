package com.rest.webservices.restfulwebservices.controllers;

import com.rest.webservices.restfulwebservices.Exceptions.ExceptionResponse;
import com.rest.webservices.restfulwebservices.Exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice

public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(NotFoundException e, WebRequest req){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timeStamp(new Date())
                .message(e.getMessage()).details(req.getDescription(false)).build();
        return new ResponseEntity(exceptionResponse ,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NumberFormatException.class)
    public final ResponseEntity<Object> handleBadRequestException(NumberFormatException e ,WebRequest req){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),e.getMessage(),req.getDescription(false));
        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest req) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"not valid arguments"
                ,e.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
