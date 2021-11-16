package com.triplan.service.inf;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;

import java.util.List;

public interface QuestionService {

    void create(QuestionVO questionVO);

    QuestionVO getQuestion(Integer questionId);

    void update(Integer questionID, QuestionVO questionVO);

    void delete(Integer questionId);

    List<QuestionDTO> questionList(Integer itemGroupId);
}
