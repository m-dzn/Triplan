package com.triplan.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

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
    private String type;


}
