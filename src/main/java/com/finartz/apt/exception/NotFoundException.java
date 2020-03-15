package com.finartz.apt.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends ApiException {
  private int code;
  public NotFoundException (int code, String msg) {
    super(code, msg);
    this.code = code;
  }
}
