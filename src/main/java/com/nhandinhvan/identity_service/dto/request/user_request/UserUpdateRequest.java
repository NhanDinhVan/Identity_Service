package com.nhandinhvan.identity_service.dto.request.user_request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * UserUpdationRequest
 * <p>
 * Version 1.0
 * <p>
 * Date:  10/14/2024
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 10/14/2024    NhanDinhVan    Create
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
