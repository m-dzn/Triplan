package com.triplan.domain;


import lombok.Data;

import javax.validation.constraints.*;
import java.sql.Timestamp;

@Data
public class NoticeVO {

    private Integer noticeId; //


    @NotEmpty(message = "title은 필수값입니다.")
    private String title; //

    private Timestamp createdAt; //

    private Timestamp updatedAt;

    private String content;

    @NotBlank
    private String target; //


}
