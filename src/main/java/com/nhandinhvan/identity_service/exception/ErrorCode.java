package com.nhandinhvan.identity_service.exception;/**
 * ErrorCode
 *
 * Version 1.0
 *
 * Date:  10/21/2024
 *
 * Copyright
 *
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 10/21/2024    NhanDinhVan    Create
 */

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "Uncategorized Error !"),
    USER_EXISTED(1001, "User existed !"),
    USERNAME_INVALID(1002, "Username must be at least 3 characters !"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters !"),
    INVALID_KEY(1004, "Invalid message key !"),
    USER_NOT_EXISTED(1004, "User not existed !"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
