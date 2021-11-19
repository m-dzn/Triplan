package com.triplan.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AnswerVO {

    private Integer questionId;
    @NotBlank
    private String content;

}
