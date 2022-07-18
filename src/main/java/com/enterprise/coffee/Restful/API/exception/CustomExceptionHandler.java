package com.enterprise.coffee.Restful.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CommunityTrackerException.class)
    public final ResponseEntity<Map<String, Object>> communityError(CommunityTrackerException ex){
        ErrorMessage exceptionResponse = new ErrorMessage();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result:", exceptionResponse);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}

