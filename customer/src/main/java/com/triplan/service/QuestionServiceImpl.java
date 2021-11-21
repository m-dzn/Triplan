package com.triplan.service;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.QuestionType;
import com.triplan.mapper.MemberMapper;
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
    private final MemberMapper memberMapper;

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
    public Pagination<QuestionVO> listFromCustomerToAdmin(Integer pageSize, Integer currentPage) {
        List<QuestionVO> list = questionMapper.listFromCustomerToAdmin(pageSize, currentPage);
        Integer count = questionMapper.countFromCustomerToAdmin();
        return new Pagination<>(pageSize, currentPage, count, list);
    }

    @Override
    public Pagination<QuestionDTO> listByItemGroupId(Integer pageSize, Integer currentPage, Integer itemGroupId) {
        List<QuestionDTO> questionListByItemGroupIdListPage = questionMapper.listByItemGroupId(pageSize, currentPage, itemGroupId)
                .stream().map(questionVO ->
                        QuestionDTO.of(questionVO, memberMapper.select(questionVO.getMemberId()))
                ).collect(Collectors.toList());

        int totalReviews = questionMapper.countByItemGroupId(itemGroupId);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByItemGroupIdListPage);
    }

    @Override
    public Pagination<QuestionVO> listByMemberId(Integer pageSize, Integer currentPage, Integer memberId) {
        List<QuestionVO> questionListByMemberIdListPage = questionMapper.listByMemberId(pageSize, currentPage, memberId);

        int totalReviews = questionMapper.countByMemberId(memberId);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByMemberIdListPage);
    }

}
