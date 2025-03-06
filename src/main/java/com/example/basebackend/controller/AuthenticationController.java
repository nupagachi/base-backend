package com.example.basebackend.controller;

import com.example.basebackend.dto.request.SignInRequest;
import com.example.basebackend.dto.response.ApiResponse;
import com.example.basebackend.dto.response.AuthenticationResponse;
import com.example.basebackend.exception.AppException;
import com.example.basebackend.exception.ErrorCode;
import com.example.basebackend.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> login(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.status(200).body(authenticationService.authenticate(signInRequest));
    }
}
