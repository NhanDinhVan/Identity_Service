package com.nhandinhvan.identity_service.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    int code = 1000;
    String message;
    T result;
}
