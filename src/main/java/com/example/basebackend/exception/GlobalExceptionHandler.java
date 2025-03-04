package com.example.basebackend.exception;

import com.example.basebackend.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse<Object>> handleCustomException(AppException ex) {
        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .code(ex.getErrorCode().getStatusCode())
                .message(ex.getErrorCode().getMessage())
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
