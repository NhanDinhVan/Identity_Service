package com.nhandinhvan.identity_service.controller;

import com.nhandinhvan.identity_service.dto.request.user_request.AuthenticationRequest;
import com.nhandinhvan.identity_service.dto.request.user_request.IntrospectRequest;
import com.nhandinhvan.identity_service.dto.response.ApiResponse;
import com.nhandinhvan.identity_service.dto.response.AuthenticationResponse;
import com.nhandinhvan.identity_service.dto.response.IntrospectResponse;
import com.nhandinhvan.identity_service.service.authentication_service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * AuthenticationController
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
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ApiResponse.<AuthenticationResponse>builder()
                .result(authenticationService.authenticate(request))
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        return ApiResponse.<IntrospectResponse>builder()
                .result(authenticationService.introspect(request))
                .build();
    }

}
