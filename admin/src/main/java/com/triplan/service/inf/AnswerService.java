package com.triplan.service.inf;

import com.triplan.domain.AnswerVO;

public interface AnswerService {
   void register(AnswerVO answerVO);

    AnswerVO getAnswer(Integer questionId);

    void update(Integer questionId, AnswerVO answerVO);

    void delete(Integer questionId);
}
