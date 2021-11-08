package com.triplan.service;

import com.triplan.domain.QuestionVO;

public interface QuestionService {

    void create(QuestionVO questionVO);

    QuestionVO getQuestion(int questionId);

    void update(int questionID, QuestionVO questionVO);

    void delete(int questionId);
}
