package com.triplan.mapper;

import com.triplan.domain.NoticeVO;
import com.triplan.enumclass.Target;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface NoticeMapper {


    void noticeInsert(NoticeVO noticeVO);

    NoticeVO noticeSelect(Integer noticeId);

    void noticeUpdate(NoticeVO noticeVO);

    void noticeDelete(Integer noticeId);

    List<NoticeVO> noticeSellerList(@Param("target") Target target,@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);

    List<NoticeVO> noticeMemberList(@Param("target") Target target,@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);

    Integer countSeller(Target target);
    Integer countMember(Target target);

    Integer count();

    List<NoticeVO> noticeAllList(@Param("pageSize") Integer pageSize, @Param("currentPage") Integer currentPage);
}
