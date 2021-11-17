package com.triplan.service.inf;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import com.triplan.dto.response.Pagination;

import java.util.List;

public interface QuestionService {

    void create(QuestionVO questionVO);

    QuestionVO getQuestion(Integer questionId);

    void update(Integer questionID, QuestionVO questionVO);
    void delete(Integer questionId);

    List<QuestionDTO> questionListByItemGroupId(Integer itemGroupId);

    List<QuestionVO> questionListBySellerId(Integer sellerId);

    List<QuestionVO> questionListByMemberId(Integer memberId);

    Pagination<QuestionVO> questionListByItemGroupIdListPage(Integer pageSize, Integer currentPage);

    Pagination<QuestionVO> questionListBySellerIdListPage(Integer pageSize, Integer currentPage);

    Pagination<QuestionVO> questionListByMemberIdListPage(Integer memberId, Integer pageSize, Integer currentPage);

}
