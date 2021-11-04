package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PassengerType {
    ADULT("대인"),
    CHILD("소인");


    private String person;
}
