package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentState implements BaseEnum {

    UNPAID("미결제"),
    PAID("결제완료"),
    FAILED("결제실패");

    private final String explain;

}
