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

    List<QuestionVO> listByItemGroupId(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage, @Param("itemGroupId") Integer itemGroupId);
    int countByItemGroupId(QuestionType type);

    List<QuestionVO> listBySellerId(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage, @Param("sellerId") Integer sellerId);
    int countBySellerId(QuestionType type);

    List<QuestionVO> listByMemberId(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage, @Param("memberId") Integer memberId);
    int countByMemberId(Integer memberId);

}
