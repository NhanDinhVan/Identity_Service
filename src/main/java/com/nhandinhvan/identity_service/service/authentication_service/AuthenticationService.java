package com.nhandinhvan.identity_service.service.authentication_service;

import com.nhandinhvan.identity_service.dto.request.user_request.AuthenticationRequest;

/**
 * AuthenticationService
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

public interface AuthenticationService {
    boolean authenticate(AuthenticationRequest request);
}
