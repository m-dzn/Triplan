package com.triplan.enumclass.member;

import com.triplan.enumclass.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleName implements BaseEnum {

    ADMIN(1, "ROLE_ADMIN", "사이트 관리자"),
    SELLER(2, "ROLE_SELLER", "여행 상품 판매자"),
    MEMBER(3, "ROLE_MEMBER", "고객");

    private final Integer id;
    private final String key;
    private final String explain;

}
