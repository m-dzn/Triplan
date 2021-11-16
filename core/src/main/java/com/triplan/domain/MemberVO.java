package com.triplan.domain;

import com.triplan.consts.Constraints;
import com.triplan.enumclass.MemberGrade;
import com.triplan.enumclass.MemberState;
import com.triplan.enumclass.SNSProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberVO extends BaseVO {

    // 식별자 필드
    private Integer memberId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    @NotBlank
    @Email
    @Size(max = Constraints.EMAIL_MAX_LENGTH)
    /* 이메일 = EMAIL_MAX_LENGTH = 100 */
    private String email;

    @NotBlank
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}")
    /* 비밀번호 = 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다. */
    private String password;

    @NotBlank
    @Pattern(regexp="^[ㄱ-ㅎ가-힣a-zA-Z0-9]{2,20}$")
    /* 닉네임 = 최소 2자리 ~ 최대 20자리(특수문자x,한글o,영문 대소문자o,숫자o) */
    private String nickname;

    // Default 값이 있는 NOT NULL 필드
    private Boolean emailConfirm;
    private MemberState state;
    private MemberGrade grade;
    private SNSProvider provider;

    // Nullable 필드
    private String profileImg;

    @PositiveOrZero
    /* 포인트 = 양수와 0만 가능 */
    private Integer point;

    private String account;
    private LocalDateTime deletedAt;

    // 외래키
    
}
