package com.skala_emti.emti.exception;

import java.time.LocalDateTime;

// 역할: 클라이언트에게 반환할 에러 응답 형식을 정의하는 DTO(Data Transfer Object)
// 특징: 일관된 에러 응답 형식을 제공하여 클라이언트가 쉽게 에러를 처리할 수 있게 함
// 구성요소: 에러 코드, 메시지, 타임스탬프 등의 정보를 포함

public class ErrorResponse {
    private final String code;
    private final String message;
    private final LocalDateTime timestamp;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
}
