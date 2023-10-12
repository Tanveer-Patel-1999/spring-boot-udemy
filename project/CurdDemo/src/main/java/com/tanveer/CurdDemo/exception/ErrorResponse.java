package com.tanveer.CurdDemo.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private Integer status;
    private String message;
    private Long timeStamp;
}
