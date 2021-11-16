package com.triplan.mapper;

import com.triplan.domain.NoticeVO;
import com.triplan.enumclass.Target;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    void noticeInsert(NoticeVO noticeVO);

    NoticeVO noticeSelect(int noticeId);

    void noticeUpdate(NoticeVO noticeVO);

    void noticeDelete(int noticeId);

    List<NoticeVO> noticeList(Target target);

    Integer count(Target target);

}