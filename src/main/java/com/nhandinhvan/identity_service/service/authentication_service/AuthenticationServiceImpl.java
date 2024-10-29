package com.nhandinhvan.identity_service.service.authentication_service;

import com.nhandinhvan.identity_service.dto.request.user_request.AuthenticationRequest;
import com.nhandinhvan.identity_service.dto.request.user_request.IntrospectRequest;
import com.nhandinhvan.identity_service.dto.response.AuthenticationResponse;
import com.nhandinhvan.identity_service.dto.response.IntrospectResponse;
import com.nhandinhvan.identity_service.exception.AppException;
import com.nhandinhvan.identity_service.exception.ErrorCode;
import com.nhandinhvan.identity_service.repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * AuthenticationServiceImpl
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
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationServiceImpl implements AuthenticationService{

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    UserRepository userRepository;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if(authenticated)
            throw new AppException(ErrorCode.UNAUTHENTICATED);

        var token = generateToken(request.getUsername());

        return AuthenticationResponse.builder()
                .authenticated(authenticated)
                .token(token)
                .build();
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);

        var verified = signedJWT.verify(verifier);
        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        return IntrospectResponse.builder()
                .valid(verified && expiryTime.after(new Date()))
                .build();
    }

    @Override
    public String generateToken(String username) {
            JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
            JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                    .subject(username)
                    .issuer("vannhandinh.tech")
                    .issueTime(new Date())
                    .expirationTime(new Date(
                            Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                    ) )
                    .claim("userId", "Custom")
                    .build();
            Payload payload = new Payload(jwtClaimsSet.toJSONObject());

            JWSObject jwsObject = new JWSObject(jwsHeader, payload);

            try {
                jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
                return jwsObject.serialize();
            }catch (Exception e){
                log.error("Cannot generate token", e);
                throw new RuntimeException();
            }
    }
}
