package com.triplan.util;

import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.util.SerializationUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Optional;

public final class CookieUtils {

    public static final int COOKIE_EXPIRATION = 60 * 60 * 24;

    public static Optional<Cookie> getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();

        // HTTP 요청에 담긴 쿠키 목록에서 key에 해당하는 쿠키 검색
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return Optional.of(cookie);
                }
            }
        }

        return Optional.empty();
    }

    public static Cookie addCookie(String key, String value, int maxAge) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    // addCookie(키, 값, 만료시간) 메서드를 오버라이딩한 메서드
    public static void addCookie(String key, String value, int maxAge, HttpServletResponse response) {
        Cookie cookie = addCookie(key, value, maxAge);
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie[] cookies = request.getCookies();

        // 쿠키가 비어 있으면 탈출
        if (cookies == null || cookies.length <= 0) return;

        // 찾는 쿠키가 있으면 삭제
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key)) {
                cookie.setValue("/");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

    // 쿠키를 Base64로 인코딩된 문자열로 직렬화하는 메서드
    public static String serialize(Object object) {
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(object));
    }

    // 쿠키
    public static <T> T deserialize(Cookie cookie, Class<T> clazz) {
        return clazz.cast(SerializationUtils.deserialize(
                Base64.getUrlDecoder().decode(cookie.getValue())
        ));
    }
}
