package com.taihouproject.api.takao.security;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;

import org.apache.commons.lang3.time.DateUtils;

public class JWTProvider {

    private static final String issuer = "taihouproject";

    /**
     * Create jwt string.
     *
     * @param subject       the subject
     * @param payloadClaims the payload claims
     * @return the JWT string
     */
    public static String createJwt(String subject, Map<String, JsonNode> payloadClaims) {
        JWTCreator.Builder builder =  JWT.create()
                .withSubject(subject)
                .withIssuer(issuer)
                .withIssuedAt(new Date())
                .withExpiresAt(DateUtils.addDays(new Date(), 30));

        if (payloadClaims != null && !payloadClaims.isEmpty()) {
            for (Map.Entry entry : payloadClaims.entrySet()) {
                builder.withClaim((String)entry.getKey(), entry.getValue().toString());
            }
        }
        return builder.sign(Algorithm.HMAC256(SecurityConfig.secret));
    }

    /**
     * Verify jwt decoded.
     *
     * @param jwt the JWT string
     * @return the decoded JWT
     */
    public static DecodedJWT verifyJwt(String jwt) {
        return JWT.require(Algorithm.HMAC256(SecurityConfig.secret)).build().verify(jwt);
    }

    private JWTProvider() {}
}