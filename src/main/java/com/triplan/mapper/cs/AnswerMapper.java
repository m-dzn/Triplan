package com.triplan.mapper.cs;

import com.triplan.domain.cs.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnswerMapper {

    void insert(AnswerVO answerVO);

    AnswerVO select(Integer questionId);

    void update(@Param("questionId") Integer questionId, @Param("answerVO") AnswerVO answerVO);

    void delete(Integer questionId);

}
