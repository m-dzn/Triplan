package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum State {

    UNREGISTER(1,"탈퇴"),
    REGISTER(2,"등록"),
    ACCOUNT_SUSPENSION(3,"계정 정지");

    private Integer code;
    private String explain;

    State(String explain){
        this.explain = explain;
    }


}
