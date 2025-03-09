package com.skala_emti.emti.exception;

// 역할: 애플리케이션 전역에서 발생하는 예외를 일관되게 처리하는 핸들러
// 특징: @RestControllerAdvice 어노테이션을 사용하여 모든 컨트롤러에서 발생하는 예외를 중앙에서 처리
// 구성요소: 다양한 예외 유형에 대한 핸들러 메서드와 적절한 HTTP 상태 코드 매핑

public class BusinessException extends RuntimeException {
    private final String errorCode;

    public BusinessException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
    
}
