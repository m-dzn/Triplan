package com.triplan.service;

import com.triplan.domain.NoticeVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.Target;





public interface NoticeService {



    void noticeInsert(NoticeVO noticeVO);

    NoticeVO noticeSelect(Integer noticeId);

    void noticeUpdate(NoticeVO noticeVO);

    void noticeDelete(Integer noticeId);

    Pagination<NoticeVO> noticeSellerList(Target target, Integer pageSize, Integer currentPage);
    Pagination<NoticeVO> noticeMemberList(Target target, Integer pageSize, Integer currentPage);

    Pagination<NoticeVO> noticeAllList(Integer pageSize, Integer currentPage);

}
