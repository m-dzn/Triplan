package com.triplan.enumclass.member;

import com.triplan.enumclass.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SNSProvider implements BaseEnum {

    LOCAL("트립플랜"),
    GOOGLE("구글"),
    FACEBOOK("페이스북"),
    NAVER("네이버"),
    KAKAO("카카오");

    private final String explain;

}
