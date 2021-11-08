package com.triplan.domain;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionVO {

    private Integer questionId;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private Integer qnaCategoryId;
    private Integer memberId;
    private Integer itemGroupId;
    private Boolean hide;


}
