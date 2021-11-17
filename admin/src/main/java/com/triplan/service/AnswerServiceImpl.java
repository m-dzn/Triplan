package com.triplan.service;

import com.triplan.domain.AnswerVO;
import com.triplan.mapper.AnswerMapper;
import com.triplan.service.inf.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    @Override
    public void register(AnswerVO answerVO) {
        answerMapper.insert(answerVO);
    }

    @Override
    public AnswerVO getAnswer(Integer questionId) {
        AnswerVO result = answerMapper.select(questionId);
        return result;
    }

    @Override
    public void update(Integer questionId, AnswerVO answerVO) {
        answerVO.setQuestionId(questionId);
        answerMapper.update(questionId, answerVO);
    }

    @Override
    public void delete(Integer questionId) {
        answerMapper.delete(questionId);
    }
}
