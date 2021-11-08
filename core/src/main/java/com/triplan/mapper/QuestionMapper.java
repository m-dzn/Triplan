package com.triplan.mapper;

import com.triplan.domain.QuestionVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    void insert(QuestionVO questionVO);

    QuestionVO select(int questionId);

    void update(QuestionVO questionVO);

    void delete(int questionId);

}
