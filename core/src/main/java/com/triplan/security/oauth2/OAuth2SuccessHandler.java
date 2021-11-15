package com.triplan.security.oauth2;

import com.triplan.exception.ResourceNotFoundException;
import com.triplan.security.OAuth2RequestCookieRepository;
import com.triplan.util.CookieUtils;
import com.triplan.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Value("${app.oauth2.authorizedRedirectUris}")
    private List<String> authorizedRedirectUris;
    private static final String TOKEN_PARAMETER_NAME = "token";

    private final JwtUtils jwtUtils;
    private final OAuth2RequestCookieRepository oAuth2RequestCookieRepository;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication auth) throws IOException, ServletException
    {
        String targetUrl = determineTargetUrl(request, response, auth);

        clearAuthenticationAttributes(request, response);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(
            HttpServletRequest request, HttpServletResponse response, Authentication auth)
    {
        Optional<String> redirectUri = CookieUtils.getCookie(
                request,
                OAuth2RequestCookieRepository.REDIRECT_URI_COOKIE_NAME).map(Cookie::getValue);

        if (redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw new ResourceNotFoundException("RedirectURI Not Found");
        }

        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());
        String token = jwtUtils.generateToken(auth);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam(TOKEN_PARAMETER_NAME, token)
                .build().toUriString();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        oAuth2RequestCookieRepository.removeAuthorizationRequestCookies(request, response);
    }

    private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);

        return authorizedRedirectUris.stream()
                .anyMatch(authorizedRedirectUri -> {
                    URI authorizedURI = URI.create(authorizedRedirectUri);

                    if (authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                        && authorizedURI.getPort() == clientRedirectUri.getPort())
                    {
                        return true;
                    }

                    return false;
                });
    }

}
