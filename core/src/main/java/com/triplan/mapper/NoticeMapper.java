package com.triplan.mapper;

import com.triplan.domain.NoticeVO;
import com.triplan.enumclass.Target;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    void insert(NoticeVO noticeVO);

    NoticeVO select(int noticeId);

    void update(NoticeVO noticeVO);

    void delete(int noticeId);

    List<NoticeVO> noticeList(Target target);

    Integer count(Target target);

}