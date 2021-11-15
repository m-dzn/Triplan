package com.triplan.mapper;

import com.triplan.domain.NoticeVO;
import com.triplan.enumclass.Target;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {


    void noticeInsert(NoticeVO noticeVO);

    NoticeVO noticeSelect(Integer noticeId);

    void noticeUpdate(NoticeVO noticeVO);

    void noticeDelete(Integer noticeId);

    List<NoticeVO> noticeList(Target target);



}
