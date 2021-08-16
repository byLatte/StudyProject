package com.spring.project.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> exception( Exception e){
        log.info(e.toString());
        ResponseModel responseModel = ResponseModel
                                        .create()
                                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                        .message(e.toString());
        return new ResponseEntity<>(responseModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
