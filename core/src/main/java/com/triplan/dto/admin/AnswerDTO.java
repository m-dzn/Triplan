package com.triplan.dto.admin;

import com.triplan.domain.AnswerVO;
import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    private Integer questionId;
    @NotBlank
    private String content;
    private Boolean isAnswered;

    public static AnswerDTO of(AnswerVO vo) {
        return AnswerDTO.builder()
                .questionId(vo.getQuestionId())
                .content(vo.getContent())
                .build();
    }
}
