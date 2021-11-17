package com.triplan.domain;

import com.triplan.enumclass.PaymentState;
import com.triplan.enumclass.PaymentType;
import com.triplan.enumclass.QuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class QuestionVO extends BaseVO {

    // 식별자 필드
    private Integer questionId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String title;
    private String content;
    private QuestionType type;

    // Default 값이 있는 NOT NULL 필드
    private Boolean hide;

    // Nullable 필드

    // 외래키
    private Integer qnaCategoryId;
    private Integer memberId;
    private Integer itemGroupId;

}
