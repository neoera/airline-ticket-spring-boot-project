package com.finartz.apt.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequestException extends ApiException{
  private int code;
  public RequestException(int code, String msg) {
    super(code, msg);
    this.code = code;
  }
}
