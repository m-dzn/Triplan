package com.triplan.service;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.QuestionType;
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
    private Integer memberId;

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
    public List<QuestionDTO> questionListByItemGroupId(Integer itemGroupId) {
        List<QuestionVO> listVO = questionMapper.getQuestionListByItemGroupId(itemGroupId);
        List<QuestionDTO> res = listVO.stream().map(QuestionDTO::of).collect(Collectors.toList());
        return res;
    }

    @Override
    public List<QuestionVO> questionListBySellerId(Integer sellerId) {
        List<QuestionVO> questionVO = questionMapper.getQuestionBySellerId(sellerId);
        return questionVO;
    }

    @Override
    public List<QuestionVO> questionListByMemberId(Integer memberId) {
        List<QuestionVO> listVO = questionMapper.getQuestionListByMemberId(memberId);
        return listVO;
    }

    @Override
    public Pagination<QuestionVO> questionListByItemGroupIdListPage(Integer pageSize, Integer currentPage) {
        List<QuestionVO> questionListByItemGroupIdListPage = questionMapper.questionListByItemGroupIdListPage(pageSize, currentPage);

        int totalReviews = questionMapper.questionListByItemGroupIdCountPage("CUSTOMER");

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByItemGroupIdListPage);
    }

    @Override
    public Pagination<QuestionVO> questionListBySellerIdListPage(Integer pageSize, Integer currentPage) {
        List<QuestionVO> questionListBySellerIdListPage = questionMapper.questionListByItemGroupIdListPage(pageSize, currentPage);

        int totalReviews = questionMapper.questionBySellerIdCountPage("SELLER");

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListBySellerIdListPage);
    }

    @Override
    public Pagination<QuestionVO> questionListByMemberIdListPage(Integer memberId, Integer pageSize, Integer currentPage) {
        List<QuestionVO> questionListByMemberIdListPage = questionMapper.questionListByMemberIdListPage(memberId, pageSize, currentPage);

        int totalReviews = questionMapper.questionListByMemberIdCountPage(memberId);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByMemberIdListPage);
    }


}
