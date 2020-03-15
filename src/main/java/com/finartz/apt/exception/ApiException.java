package com.finartz.apt.exception;

class ApiException extends Exception{
  ApiException(int code, String msg) {
    super(msg);
  }
}
