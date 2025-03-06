package com.example.basebackend.service;

import com.example.basebackend.dto.request.SignInRequest;
import com.example.basebackend.dto.response.ApiResponse;
import com.example.basebackend.dto.response.AuthenticationResponse;

public interface IAuthenticationService {
    ApiResponse<AuthenticationResponse> authenticate(SignInRequest signInRequest);
}
