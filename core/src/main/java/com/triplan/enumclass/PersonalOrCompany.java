package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PersonalOrCompany {
    PERSONAL("개인"),
    COMPANY("기업");
    private String explain;

}
