package com.triplan.domain;

import com.triplan.enumclass.RoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoleVO {

    // 식별자
    private Integer roleId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private RoleName name;

}
