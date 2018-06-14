package com.example.demo.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 003418
 */
@Slf4j
@Data
public class Result {

    private int code;
    private String message;
    private  Object data;

    public Result setCode(ResultCode resultCode){
        this.code = resultCode.code;
        return this;
    }
}
