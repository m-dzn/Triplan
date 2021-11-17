package com.triplan.security;

import com.triplan.util.CookieUtils;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class OAuth2RequestCookieRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

    public static final String OAUTH2_COOKIE_NAME = "oauth2";
    public static final String REDIRECT_URI_COOKIE_NAME = "redirect_uri";
    private static final int cookieExpiration = 60 * 60;

    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        return CookieUtils.getCookie(request, OAUTH2_COOKIE_NAME)
                .map(cookie -> CookieUtils.deserialize(cookie, OAuth2AuthorizationRequest.class))
                .orElse(null);
    }

    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest request, HttpServletResponse response) {
        if (authorizationRequest == null) {
            CookieUtils.deleteCookie(request, response, OAUTH2_COOKIE_NAME);
            CookieUtils.deleteCookie(request, response, REDIRECT_URI_COOKIE_NAME);
            return;
        }

        CookieUtils.addCookie(OAUTH2_COOKIE_NAME, CookieUtils.serialize(authorizationRequest), cookieExpiration, response);
        String redirectURIAfterLogin = request.getParameter(REDIRECT_URI_COOKIE_NAME);

        if (StringUtils.hasText(redirectURIAfterLogin)) {
            CookieUtils.addCookie(REDIRECT_URI_COOKIE_NAME, redirectURIAfterLogin, cookieExpiration, response);
        }
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request) {
        return this.loadAuthorizationRequest(request);
    }

    public void removeAuthorizationRequestCookies(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, OAUTH2_COOKIE_NAME);
        CookieUtils.deleteCookie(request, response, REDIRECT_URI_COOKIE_NAME);
    }

}
