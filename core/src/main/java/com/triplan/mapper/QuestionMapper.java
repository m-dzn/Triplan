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

    List<QuestionVO> getQuestionListByItemGroupId(Integer itemGroupId);

    List<QuestionVO> getQuestionBySellerId(Integer sellerId);

    List<QuestionVO> getQuestionListByMemberId(Integer memberId);

    List<QuestionVO> questionListByItemGroupIdListPage(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);
    int questionListByItemGroupIdCountPage(String type);

    List<QuestionVO> questionListBySellerIdListPage(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);
    int questionBySellerIdCountPage(String type);

    List<QuestionVO> questionListByMemberIdListPage(@Param("memberId") Integer memberId, @Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);
    int questionListByMemberIdCountPage(Integer memberId);
}
