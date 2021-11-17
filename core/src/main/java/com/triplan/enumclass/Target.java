package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Target implements BaseEnum{

    MEMBER("회원"),
    SELLER("판매자");


    private final String explain;
}
