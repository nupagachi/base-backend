package com.example.basebackend.exception;

public enum ErrorCode {
    USER_NOT_FOUND(404, "User not found"),
    INVALID_REQUEST(400, "Invalid request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;

    ErrorCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
