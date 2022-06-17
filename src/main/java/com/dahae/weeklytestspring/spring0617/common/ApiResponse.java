package com.dahae.weeklytestspring.spring0617.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {
    private Object data;
    private int httpStatus;
}
