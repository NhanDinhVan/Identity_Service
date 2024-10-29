package com.nhandinhvan.identity_service.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * IntrospectResponse
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
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IntrospectResponse {
    Boolean valid;
}
