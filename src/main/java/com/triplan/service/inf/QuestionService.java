package com.triplan.service.inf;

import com.triplan.domain.cs.QuestionVO;
import com.triplan.dto.response.customer.QuestionDTO;
import com.triplan.dto.response.Pagination;

public interface QuestionService {

    void create(QuestionVO questionVO);

    QuestionVO getQuestion(Integer questionId);

    void update(Integer questionID, QuestionVO questionVO);
    
    void delete(Integer questionId, Integer memberId);

    Pagination<QuestionDTO> listFromCustomerToAdmin(Integer pageSize, Integer currentPage);

    Pagination<QuestionDTO> listByItemGroupId(Integer pageSize, Integer currentPage, Integer itemGroupId);

    Pagination<QuestionVO> listByMemberId(Integer pageSize, Integer currentPage, Integer memberId);

}
