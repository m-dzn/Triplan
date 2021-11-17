package com.triplan.domain;


import lombok.Data;

import javax.validation.constraints.*;
import java.sql.Timestamp;

@Data
public class NoticeVO {

    private Integer noticeId;

    @NotBlank
    @Size(min = 2)
    private String title;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @NotBlank
    private String content;

    @NotNull
    private String target;


}
