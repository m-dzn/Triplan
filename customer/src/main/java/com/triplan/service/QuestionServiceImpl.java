package com.triplan.service;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import com.triplan.mapper.QuestionMapper;
import com.triplan.service.inf.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionMapper questionMapper;

    @Override
    public void create(QuestionVO questionVO) {
        questionMapper.insert(questionVO);
    }

    @Override
    public QuestionVO getQuestion(Integer questionId) {
        QuestionVO result = questionMapper.select(questionId);
        return result;
    }

    @Override
    public void update(Integer questionId, QuestionVO questionVO) {
        questionVO.setQuestionId(questionId);
        questionMapper.update(questionVO);
    }

    @Override
    public void delete(Integer questionId) {
        questionMapper.delete(questionId);
    }

    @Override
    public List<QuestionDTO> questionList(Integer itemGroupId) {
        List<QuestionVO> listVO = questionMapper.getQuestionList(itemGroupId);
        List<QuestionDTO> res = listVO.stream().map(QuestionDTO::of).collect(Collectors.toList());
        return res;
    }
}
