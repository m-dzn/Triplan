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

    private  final AnswerMapper answerMapper;
    private final QuestionMapper questionMapper;

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
    public Pagination<QuestionDTO> listFromCustomerToAdmin(Integer pageSize, Integer currentPage) {
        List<QuestionDTO> list = questionMapper.listFromCustomerToAdmin(pageSize, currentPage)
                .stream().map(vo -> {
                    QuestionDTO dto = QuestionDTO.of(vo);
                    dto.setIsAnswered(answerMapper.isAnswered(vo.getQuestionId()));
                    return dto;
                }).collect(Collectors.toList());
        Integer count = questionMapper.countFromCustomerToAdmin();
        return new Pagination<>(pageSize, currentPage, count, list);
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
    public Pagination<QuestionDTO> listByMemberId(Integer pageSize, Integer currentPage, Integer memberId) {
        List<QuestionDTO> questionListByMemberIdListPage = questionMapper.listByMemberId(pageSize, currentPage, memberId)
                .stream().map(vo -> {
                    QuestionDTO dto = QuestionDTO.of(vo);
                    dto.setIsAnswered(answerMapper.isAnswered(vo.getQuestionId()));
                    return dto;
                }).collect(Collectors.toList());

        int totalReviews = questionMapper.countByMemberId(memberId);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByMemberIdListPage);
    }

}
