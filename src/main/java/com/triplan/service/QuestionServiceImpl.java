package com.triplan.service;

import com.triplan.domain.cs.QuestionVO;
import com.triplan.dto.response.Pagination;
import com.triplan.dto.response.customer.QuestionDTO;
import com.triplan.exception.AccessNotAllowedException;
import com.triplan.mapper.cs.QuestionMapper;
import com.triplan.mapper.member.MemberMapper;
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
    public void delete(Integer questionId, Integer memberId) {
        if (isMemberWhoWritten(questionId, memberId)) {
            questionMapper.delete(questionId);
        }
    }

    @Override
    public Pagination<QuestionVO> listFromCustomerToAdmin(Integer pageSize, Integer currentPage) {
        Integer startRow = (currentPage - 1) * pageSize;
        List<QuestionVO> list = questionMapper.listFromCustomerToAdmin(startRow, pageSize);
        Integer count = questionMapper.countFromCustomerToAdmin();
        return new Pagination<>(pageSize, currentPage, count, list);
    }

    @Override
    public Pagination<QuestionDTO> listByItemGroupId(Integer pageSize, Integer currentPage, Integer itemGroupId) {
        Integer startRow = (currentPage - 1) * pageSize;
        List<QuestionDTO> questionListByItemGroupIdListPage = questionMapper.listByItemGroupId(startRow, pageSize, itemGroupId)
                .stream().map(questionVO ->
                        QuestionDTO.of(questionVO, memberMapper.select(questionVO.getMemberId()))
                ).collect(Collectors.toList());

        int totalReviews = questionMapper.countByItemGroupId(itemGroupId);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByItemGroupIdListPage);
    }

    @Override
    public Pagination<QuestionVO> listByMemberId(Integer pageSize, Integer currentPage, Integer memberId) {
        Integer startRow = (currentPage - 1) * pageSize;
        List<QuestionVO> questionListByMemberIdListPage = questionMapper.listByMemberId(startRow, pageSize, memberId);

        int totalReviews = questionMapper.countByMemberId(memberId);

        return new Pagination<>(pageSize, currentPage, totalReviews, questionListByMemberIdListPage);
    }

    private boolean isMemberWhoWritten(Integer questionId, Integer memberId) {
        try {
            QuestionVO questionVO = questionMapper.select(questionId);
            if (memberId.equals(questionVO.getMemberId())) {
                return true;
            } else {
                throw new AccessNotAllowedException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
