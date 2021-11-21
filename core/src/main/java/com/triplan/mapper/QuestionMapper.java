package com.triplan.mapper;

import com.triplan.domain.QuestionVO;
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
    int countByItemGroupId(Integer itemGroupId);

    List<QuestionVO> listBySellerId(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage, @Param("sellerId") Integer sellerId);
    int countBySellerId(String type);

    List<QuestionVO> listByMemberId(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage, @Param("memberId") Integer memberId);
    int countByMemberId(Integer memberId);

    List<QuestionVO> listFromCustomerToAdmin(Integer pageSize, Integer currentPage);

    Integer countFromCustomerToAdmin();

}
