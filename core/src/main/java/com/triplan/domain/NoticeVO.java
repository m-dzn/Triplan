package com.triplan.domain;

import com.triplan.enumclass.Target;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class NoticeVO {

    private Integer noticeId;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String content;
    private Target target;



}
