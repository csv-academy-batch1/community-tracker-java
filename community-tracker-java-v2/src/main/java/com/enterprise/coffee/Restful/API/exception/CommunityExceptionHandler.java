package com.enterprise.coffee.Restful.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class CommunityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CommunityException.class)
    public final ResponseEntity<Object> communityNameAlreadyExist(CommunityException e){
        Map<String, Object> map = new LinkedHashMap<>();
        ErrorMessage errorMessage = new ErrorMessage();
        map.put("result:", errorMessage);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}

