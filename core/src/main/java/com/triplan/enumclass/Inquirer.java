package com.triplan.enumclass;

import com.triplan.domain.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Inquirer {
    CUSTOMER_TO_SELLER("고객_판매자"),
    CUSTOMER_TO_ADMIN("고객_관리자"),
    SELLER_TO_ADMIN("판매자_관리자");

    private String explain;

}