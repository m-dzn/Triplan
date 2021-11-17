package com.triplan.mapper;

import com.triplan.domain.NoticeVO;
import com.triplan.enumclass.NoticeTarget;
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
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage
    );

    Integer count(NoticeTarget noticeTarget);

}