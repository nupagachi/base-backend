package com.example.basebackend.controller;

import com.example.basebackend.dto.response.ApiResponse;
import com.example.basebackend.dto.response.AuthenticationResponse;
import com.example.basebackend.exception.AppException;
import com.example.basebackend.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> login(){
        ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>();
        throw new AppException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
