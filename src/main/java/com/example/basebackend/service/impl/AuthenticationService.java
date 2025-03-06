package com.example.basebackend.service.impl;

import com.example.basebackend.dto.request.SignInRequest;
import com.example.basebackend.dto.response.ApiResponse;
import com.example.basebackend.dto.response.AuthenticationResponse;
import com.example.basebackend.exception.AppException;
import com.example.basebackend.exception.ErrorCode;
import com.example.basebackend.repository.IUserRepository;
import com.example.basebackend.service.IAuthenticationService;
import com.example.basebackend.service.JwtService;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class AuthenticationService implements IAuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public ApiResponse<AuthenticationResponse> authenticate(SignInRequest signInRequest) {
        log.info("Processing authenticate user {}", signInRequest.getUsername());
        ApiResponse<AuthenticationResponse> authenticationServiceApiResponse = new ApiResponse<>();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        authenticationServiceApiResponse.setData(AuthenticationResponse.builder()
                .accessToken(token)
                .userId("userId")
                .refreshToken("refresh token")
                .build());
        return authenticationServiceApiResponse;
    }
}
