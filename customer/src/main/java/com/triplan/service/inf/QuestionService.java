package com.triplan.service.inf;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.response.Pagination;

public interface QuestionService {

    void create(QuestionVO questionVO);

    QuestionVO getQuestion(Integer questionId);

    void update(Integer questionID, QuestionVO questionVO);
    
    void delete(Integer questionId);

    Pagination<QuestionVO> listFromCustomerToAdmin(Integer pageSize, Integer currentPage);

    Pagination<QuestionVO> listByItemGroupId(Integer pageSize, Integer currentPage, Integer itemGroupId);

    Pagination<QuestionVO> listByMemberId(Integer pageSize, Integer currentPage, Integer memberId);

}
