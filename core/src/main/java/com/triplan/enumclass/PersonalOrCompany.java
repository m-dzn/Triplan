package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PersonalOrCompany {

    Personal(0,"개인"),
    Company(1,"기업");

    private Integer code;
    private String explain;

}
