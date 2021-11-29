package com.triplan.security.oauth2.userinfo;

import java.util.Map;

public class FacebookOAuth2UserInfo extends OAuth2UserInfo {

    public FacebookOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getProfileImg() {
        if (attributes.containsKey("picture")) {
            Map<String, Object> picture = (Map<String, Object>) attributes.get("picture");
            if (picture.containsKey("data")) {
                Map<String, Object> data = (Map<String, Object>) picture.get("data");
                if (data.containsKey("url")) {
                    return (String) data.get("url");
                }
            }
        }
        return null;
    }
}
