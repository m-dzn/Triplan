package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {

    CreditCard("신용카드"),
    CellPhone("휴대폰"),
    WithoutBankbook("무통장"),
    Pay("카카오페이,네이버페이 등등 ");

    private String explain;

}
