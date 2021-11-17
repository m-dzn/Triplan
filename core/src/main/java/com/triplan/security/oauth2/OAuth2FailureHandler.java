package com.triplan.security.oauth2;

import com.triplan.security.OAuth2RequestCookieRepository;
import com.triplan.util.CookieUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class OAuth2FailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final OAuth2RequestCookieRepository oAuth2RequestCookieRepository;

    private static final String DEFAULT_URL = "/";

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException
    {
        String targetUrl = CookieUtils.getCookie(
                        request,
                        OAuth2RequestCookieRepository.REDIRECT_URI_COOKIE_NAME
                ).map(Cookie::getValue)
                .orElse(DEFAULT_URL);

        targetUrl = UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("error", exception.getLocalizedMessage())
                .encode(StandardCharsets.UTF_8)
                .build().toUriString();

        oAuth2RequestCookieRepository.removeAuthorizationRequestCookies(request, response);

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
