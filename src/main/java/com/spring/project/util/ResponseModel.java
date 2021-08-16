package com.spring.project.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * responseForm Model
 */
@Getter
@ToString
@AllArgsConstructor
public class ResponseModel {
    private LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String message;
    private Object data;

    public ResponseModel(){
        this.message = "처리 되었습니다.";
    }

    public static ResponseModel create(){
        return new ResponseModel();
    }

    public ResponseModel status(int status){
        this.status = status;
        return this;
    }

    public ResponseModel message(String message){
        this.message = message;
        return this;
    }

    public ResponseModel data(Object object){
        this.data = object;
        return this;
    }
}
