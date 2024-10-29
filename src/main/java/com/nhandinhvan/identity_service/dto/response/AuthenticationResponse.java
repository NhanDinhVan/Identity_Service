package com.nhandinhvan.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * AuthenticationReponse
 * <p>
 * Version 1.0
 * <p>
 * Date:  10/29/2024
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 10/29/2024    NhanDinhVan    Create
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    boolean authenticated;
}
