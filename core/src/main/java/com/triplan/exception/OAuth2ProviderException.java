package com.triplan.exception;

import org.springframework.security.core.AuthenticationException;

public class OAuth2ProviderException extends AuthenticationException {

    public OAuth2ProviderException(String registrationId) {
        super(registrationId);
    }

}
