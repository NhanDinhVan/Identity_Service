package com.nhandinhvan.identity_service.service.authentication_service;

import com.nhandinhvan.identity_service.dto.request.user_request.AuthenticationRequest;
import com.nhandinhvan.identity_service.dto.request.user_request.IntrospectRequest;
import com.nhandinhvan.identity_service.dto.response.AuthenticationResponse;
import com.nhandinhvan.identity_service.dto.response.IntrospectResponse;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;

import java.sql.Time;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;

    String generateToken(String username);
}







