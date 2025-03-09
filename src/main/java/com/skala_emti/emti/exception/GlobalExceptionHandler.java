package com.skala_emti.emti.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

// 역할: 비즈니스 로직 수행 중 발생하는 예외를 나타내는 커스텀 예외 클래스
// 특징: 일반적인 시스템 예외와 구분하여 비즈니스 규칙 위반 시 발생하는 예외를 명확히 표현
// 구성요소: 에러 코드와 메시지를 포함

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        logger.error("Business exception occurred: {}", e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(e.getErrorCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        logger.error("Entity not found: {}", e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse("ENTITY_NOT_FOUND", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        logger.error("Validation error: {}", e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse("INVALID_INPUT", "Invalid input parameters"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        logger.error("Unhandled exception occurred: {}", e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}