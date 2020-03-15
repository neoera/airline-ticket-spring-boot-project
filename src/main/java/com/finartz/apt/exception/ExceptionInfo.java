package com.finartz.apt.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionInfo {
    private String errorCode;
    private String message;
    private String messageType;
    private String detailMessage;
    private String type;

    public ExceptionInfo(){}

    public ExceptionInfo(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

}
