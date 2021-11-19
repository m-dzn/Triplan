package com.triplan.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewResponseDTO {

    // ReviewVO 관련
    private Integer reviewId;
    private String content;
    private Integer reviewScore;
    private String reviewImg;
    private Integer itemId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // MemberVO 관련
    private String nickname;
    private String profileImg;

}
