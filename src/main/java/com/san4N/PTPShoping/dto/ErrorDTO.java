package com.san4N.PTPShoping.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {

    private String error;
    private int code;

    private String message;
}
