package com.triplan.domain;

import com.triplan.enumclass.Target;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeVO {

    private Integer noticeId;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String content;
    private Target target;

}
