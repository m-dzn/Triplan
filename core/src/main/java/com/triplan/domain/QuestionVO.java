package com.triplan.domain;

import com.triplan.enumclass.QuestionType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuestionVO {

    private Integer questionId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer qnaCategoryId;
    private Integer memberId;
    private Integer itemGroupId;
    private Boolean hide;
    private QuestionType type;


}
