package com.triplan.service;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.QuestionType;
import com.triplan.mapper.AnswerMapper;
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
    private final AnswerMapper answerMapper;

    @Override
    public void create(QuestionVO questionVO) {
        questionMapper.insert(questionVO);
    }

    @Override
    public QuestionDTO getQuestion(Integer questionId) {
        QuestionVO result = questionMapper.select(questionId);
        QuestionDTO dto = QuestionDTO.of(result);
        dto.setIsAnswered(answerMapper.isAnswered(result.getQuestionId()));
        return dto;
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
    public Pagination<QuestionDTO> listByItemGroupId(Integer pageSize, Integer currentPage, Integer itemGroupId) {
        List<QuestionDTO> questionListByItemGroupIdListPage = questionMapper.listByItemGroupId(pageSize, currentPage, itemGroupId)
                 .stream().map(vo -> {
                    QuestionDTO dto = QuestionDTO.of(vo);
                    dto.setIsAnswered(answerMapper.isAnswered(vo.getQuestionId()));
                    return dto;
                 }).collect(Collectors.toList());
        int totalReviews = questionMapper.countByItemGroupId(QuestionType.CUSTOMER);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByItemGroupIdListPage);
    }

    @Override
    public Pagination<QuestionDTO> listBySellerId(Integer pageSize, Integer currentPage, Integer sellerId) {
        List<QuestionDTO> questionListBySellerIdListPage = questionMapper.listBySellerId(pageSize, currentPage, sellerId)
                .stream().map(vo -> {
                    QuestionDTO dto = QuestionDTO.of(vo);
                    dto.setIsAnswered(answerMapper.isAnswered(vo.getQuestionId()));
                     return dto;
                }).collect(Collectors.toList());
        int totalReviews = questionMapper.countBySellerId(QuestionType.SELLER);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListBySellerIdListPage);
    }

}
