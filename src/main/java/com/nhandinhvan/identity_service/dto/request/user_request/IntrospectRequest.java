package com.nhandinhvan.identity_service.dto.request.user_request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

/**
 * IntrospectRequest
 * <p>
 * Version 1.0
 * <p>
 * Date:  10/30/2024
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE        AUTHOR        DESCRIPTION
 * --------------------------------------
 * 10/30/2024    NhanDinhVan    Create
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class IntrospectRequest {
    String token;
}
