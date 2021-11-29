package com.triplan.security.oauth2.userinfo;

import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {

    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return ((Integer) attributes.get("id")).toString();
    }

    @Override
    public String getName() {
        if (attributes.containsKey("properties")) {
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            if (properties.containsKey("nickname")) {
                return (String) properties.get("nickname");
            }
        }
        return null;
    }

    @Override
    public String getEmail() {
        if (attributes.containsKey("kakao_account")) {
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            if (kakaoAccount.containsKey("email")) {
                return (String) kakaoAccount.get("email");
            }
        }
        return null;
    }

    @Override
    public String getProfileImg() {
        if (attributes.containsKey("properties")) {
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            if (properties.containsKey("profile_image")) {
                    return (String) properties.get("profile_image");
            }
        }
        return null;
    }
}
