package com.triplan.service.inf;

import com.triplan.domain.QuestionVO;
import com.triplan.dto.customer.reponse.QuestionDTO;
import com.triplan.dto.response.Pagination;

public interface QuestionService {

    void create(QuestionVO questionVO);

    QuestionDTO getQuestion(Integer questionId);

    void update(Integer questionID, QuestionVO questionVO);

    void delete(Integer questionId);

    Pagination<QuestionDTO> listByItemGroupId(Integer pageSize, Integer currentPage, Integer itemGroupId);

    Pagination<QuestionDTO> listBySellerId(Integer pageSize, Integer currentPage, Integer sellerId);

}
