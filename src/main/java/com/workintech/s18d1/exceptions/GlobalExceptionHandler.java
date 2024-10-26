package com.workintech.s18d1.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> burgerNotFoundExceiton(BurgerException exception){
        BurgerErrorResponse response = new BurgerErrorResponse(exception.getMessage() , System.currentTimeMillis(), exception.getStatus());
        return new  ResponseEntity(response , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> generalExceptions(Exception exception){
        BurgerErrorResponse response = new BurgerErrorResponse(exception.getMessage() , System.currentTimeMillis(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response , HttpStatus.BAD_REQUEST);
    }
}
