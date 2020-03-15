package com.finartz.apt.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotCompatibleException extends ApiException{
  private int code;
  public NotCompatibleException(int code, String msg) {
    super(code, msg);
    this.code = code;
  }
}
