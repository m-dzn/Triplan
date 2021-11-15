package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionType implements BaseEnum {
    CUSTOMER("고객 문의"),
    SELLER("판매자 문의");
    
    private String explain;
}
