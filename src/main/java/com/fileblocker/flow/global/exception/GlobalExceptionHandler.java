package com.fileblocker.flow.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /* SQL UNIQUE 제약 조건 위배시  */
    @ExceptionHandler({DataIntegrityViolationException.class, SQLIntegrityConstraintViolationException.class})
    protected ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(
            Exception ex)
    {
        String error = "이미 차단된 확장자를 입력하셨습니다.";

        return ResponseEntity.badRequest().body(error);
    }

    /* valid 유효성 검사 실패시 */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

        //지정한 메세지를 변수로 선언
        String error = ex.getFieldError().getDefaultMessage();

        return ResponseEntity.badRequest().headers(headers).body(error);
    }



}
