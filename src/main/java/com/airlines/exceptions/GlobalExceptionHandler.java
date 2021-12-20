package com.airlines.exceptions;

import com.airlines.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       String message = ex.getMessage();
       headers.add("desc","Method not allowed");
        String path=request.getContextPath();
       //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,message,path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc","Method Type not allowed");
        String path=request.getContextPath();
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,message,path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc","Path Variable is missing");
        String path=request.getContextPath();
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,message,path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc","Request Parameter");
        String path=request.getContextPath();
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,message,path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        String path=request.getContextPath();
        headers.add("desc","Data type mismatch");
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,message,path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }
    @ExceptionHandler(value=AirlineNotFoundException.class)
    public ResponseEntity<Object> handlePropertyNotFound(AirlineNotFoundException ex){
        String message = ex.getMessage();
        HttpHeaders headers =new HttpHeaders();
        headers.add("desc","Airline not found");
        String path="";
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_FOUND,message,path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }

    @ExceptionHandler(value= Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex){
        String message = ex.getMessage();
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","other exception"+ex.getMessage());
        String path="";

        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR,message,path);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }
}
