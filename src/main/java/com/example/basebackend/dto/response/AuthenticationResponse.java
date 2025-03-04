package com.example.basebackend.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse implements Serializable {
    String accessToken;
    LocalDate expireTime;
    String refreshToken;
    LocalDate refreshExpireTime;
}
