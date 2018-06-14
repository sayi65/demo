package com.example.demo.entity;

/**
 * @author 003418
 */
public enum  ResultCode {
    SUCCESS(200),
    FAIL(400),
    NOT_FOUND(404);

    public int code;

    ResultCode(int code){
        this.code = code;
    }
}
