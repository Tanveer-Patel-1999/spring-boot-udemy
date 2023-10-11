package com.tanveer.CurdDemo.exception;

import lombok.Data;

@Data
public class StudentErrorResponse {
    private Integer status;
    private String message;
    private Long timeStamp;
}
