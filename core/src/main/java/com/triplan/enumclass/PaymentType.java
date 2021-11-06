package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType implements BaseEnum {

    CREDIT_CARD("신용카드"),
    CELL_PHONE("휴대폰"),
    TRANSFER_WITHOUT_ACCOUNT("무통장 입금"),
    KAKAO_PAY("카카오페이"),
    NAVER_PAY("네이버페이");

    private final String explain;

}
