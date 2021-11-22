package com.triplan.security.oauth2.userinfo;

import com.triplan.enumclass.member.SNSProvider;
import com.triplan.exception.OAuth2ProviderException;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getUserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(SNSProvider.GOOGLE.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if(registrationId.equalsIgnoreCase(SNSProvider.FACEBOOK.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if(registrationId.equalsIgnoreCase((SNSProvider.NAVER.toString()))) {
            return new NaverOAuth2UserInfo(attributes);
        } else if(registrationId.equalsIgnoreCase((SNSProvider.KAKAO.toString()))) {
            return new KakaoOAuth2UserInfo(attributes);
        }  else {
            throw new OAuth2ProviderException(registrationId);
        }
    }

}
