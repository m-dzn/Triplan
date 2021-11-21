package com.triplan.dto.customer.reponse;

import com.triplan.domain.MemberVO;
import com.triplan.domain.QuestionVO;
import com.triplan.enumclass.QuestionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    // QuestionVO의 필드
    private Integer questionId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Boolean hide;
    private Integer memberId;
    private Integer qnaCategoryId;
    private Integer itemGroupId;
    private QuestionType type;

    // 기타 필드
    private String nickname;

    public static QuestionDTO of(QuestionVO vo) {

        return QuestionDTO.builder()
                .questionId(vo.getQuestionId())
                .title(vo.getTitle())
                .content(vo.getContent())
                .createdAt(vo.getCreatedAt())
                .hide(vo.getHide())
                .memberId((vo.getMemberId()))
                .qnaCategoryId((vo.getQnaCategoryId()))
                .itemGroupId(vo.getItemGroupId())
                .type(vo.getType())
                .build();
    }

    public static QuestionDTO of(QuestionVO questionVO, MemberVO memberVO) {
        QuestionDTO questionDTO = QuestionDTO.of(questionVO);
        questionDTO.setNickname(memberVO.getNickname());
        return questionDTO;
    }

}