package com.fileblocker.flow.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ErrorResponse {

    private final HttpStatus status;

    private final String message;

    private final String error;

    public ErrorResponse(HttpStatus status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }
}
