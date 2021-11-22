package com.triplan.mapper.cs;

import com.triplan.domain.cs.NoticeVO;
import com.triplan.enumclass.cs.NoticeTarget;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {

    void insert(NoticeVO noticeVO);

    NoticeVO select(int noticeId);

    void update(NoticeVO noticeVO);

    void delete(int noticeId);

    List<NoticeVO> noticeList(
            @Param("target") NoticeTarget noticeTarget,
            @Param("startRow") Integer startRow,
            @Param("pageSize") Integer pageSize
    );

    Integer count(NoticeTarget noticeTarget);

}