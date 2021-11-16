package com.triplan.mapper;

import com.triplan.domain.QuestionVO;
import com.triplan.enumclass.QuestionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    void insert(QuestionVO questionVO);

    QuestionVO select(Integer questionId);

    void update(QuestionVO questionVO);

    void delete(Integer questionId);

    List<QuestionVO> getQuestionList(Integer itemGroupId);

    List<QuestionVO> getQuestionBySellerId(Integer sellerId);

    List<QuestionVO> getQuestionByItemGId(Integer itemGroupId);

    List<QuestionVO> getQuestionListByMemberId(Integer memberId);

    List<QuestionVO> list(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);

    int count(String type);

}
