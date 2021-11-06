package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SNSProvider implements BaseEnum {

    LOCAL("트립플랜"),
    GOOGLE("구글"),
    NAVER("네이버"),
    KAKAO("카카오");

    private final String explain;

}
