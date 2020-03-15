package com.finartz.apt.util.web;

import com.finartz.apt.exception.ExceptionInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BaseResponse<T> {
    private T data;
    private boolean success = true;
    private ExceptionInfo exceptionInfo;
    private List<ValidationInfo> validationInfos;

    public BaseResponse(){}

    public BaseResponse(T data){
        this.data = data;
    }

    public BaseResponse(T data, boolean success){
        this.data = data;
        this.success = success;
    }

    public BaseResponse(boolean success, ExceptionInfo exceptionInfo){
        super();
        this.success = success;
        this.exceptionInfo = exceptionInfo;
    }

    public BaseResponse(T data, boolean success, ExceptionInfo exceptionInfo){
        super();
        this.data = data;
        this.success = success;
        this.exceptionInfo = exceptionInfo;
    }
}
