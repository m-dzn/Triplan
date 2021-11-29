package com.triplan.service.inf;

import com.triplan.domain.cs.NoticeVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.cs.NoticeTarget;

public interface NoticeService {

    void noticeInsert(NoticeVO noticeVO);

    NoticeVO noticeSelect(Integer noticeId);

    void noticeUpdate(NoticeVO noticeVO);

    void noticeDelete(Integer noticeId);

    Pagination<NoticeVO> noticeList(NoticeTarget noticeTarget, Integer pageSize, Integer currentPage);

}
