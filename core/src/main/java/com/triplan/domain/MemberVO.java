package com.triplan.domain;

import com.triplan.enumclass.MemberGrade;
import com.triplan.enumclass.MemberState;
import com.triplan.enumclass.SNSProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberVO extends BaseVO {

    // 식별자 필드
    private Integer memberId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String email;
    private String password;
    private String nickname;

    // Default 값이 있는 NOT NULL 필드
    private Boolean emailConfirm;
    private MemberState state;
    private MemberGrade grade;
    private SNSProvider provider;

    // Nullable 필드
    private String profileImg;
    private Integer point;
    private String account;
    private LocalDateTime deletedAt;

    // 외래키
    
}
