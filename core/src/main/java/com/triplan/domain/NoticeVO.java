package com.triplan.domain;

import com.triplan.enumclass.NoticeTarget;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeVO extends BaseVO {
    // 식별자 필드
    private Integer noticeId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private String title;
    private String content;
    private NoticeTarget noticeTarget;

    // Default 값이 있는 NOT NULL 필드

    // Nullable 필드

    // 외래키

}
