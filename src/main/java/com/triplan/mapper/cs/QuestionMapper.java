package com.triplan.mapper.cs;

import com.triplan.domain.cs.QuestionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    void insert(QuestionVO questionVO);

    QuestionVO select(Integer questionId);

    void update(QuestionVO questionVO);

    void delete(Integer questionId);

    List<QuestionVO> listByItemGroupId(
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize,
            @Param("itemGroupId") Integer itemGroupId
    );
    int countByItemGroupId(Integer itemGroupId);

    List<QuestionVO> listBySellerId(
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize,
            @Param("sellerId") Integer sellerId
    );
    int countBySellerId(String type);

    List<QuestionVO> listByMemberId(
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize,
            @Param("memberId") Integer memberId
    );
    int countByMemberId(Integer memberId);

    List<QuestionVO> listFromCustomerToAdmin(
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize
    );

    Integer countFromCustomerToAdmin();

}
