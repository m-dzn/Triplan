package com.triplan.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewVO {

    private Integer reviewId;
    private Integer memberId;
    private Integer itemId;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private Boolean reviewGrade;


}
