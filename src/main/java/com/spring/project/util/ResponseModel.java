package com.spring.project.util;

import lombok.Getter;
import lombok.ToString;

/**
 * responseForm Model
 */
@Getter
@ToString
public class ResponseModel {
    private int affected;
    private String message;
    private Object object;

    public ResponseModel(int affected) {
        this.affected = affected;
        this.message = "처리 되었습니다.";
    }

    public ResponseModel(int affected, String message) {
        this.affected = affected;
        this.message = message;
    }

    public ResponseModel(int affected, String message, Object object) {
        this.affected = affected;
        this.message = message;
        this.object = object;
    }
}
