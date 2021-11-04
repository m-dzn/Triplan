package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentState {

    PaymentCompleted("결제완료"),
    PaymentFailed("결제실패");

    private String explain;

}
