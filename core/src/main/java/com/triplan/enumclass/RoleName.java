package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleName implements BaseEnum {

    ADMIN("ROLE_ADMIN", "사이트 관리자"),
    SELLER("ROLE_SELLER", "여행 상품 판매자"),
    USER("ROLE_USER", "고객");

    private final String key;
    private final String explain;

}
