package com.triplan.service.inf;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.response.Pagination;

public interface QuestionService {

    void create(QuestionVO questionVO);

    QuestionVO getQuestion(Integer questionId);

    void update(Integer questionID, QuestionVO questionVO);

    void delete(Integer questionId);

    Pagination<QuestionVO> listByItemGroupId(Integer pageSize, Integer currentPage, Integer itemGroupId);

    Pagination<QuestionVO> listBySellerId(Integer pageSize, Integer currentPage, Integer sellerId);

}
