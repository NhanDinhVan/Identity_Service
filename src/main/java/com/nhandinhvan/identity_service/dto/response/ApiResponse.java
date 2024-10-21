package com.nhandinhvan.identity_service.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ApiResponse
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int code = 1000;
    private String message;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
