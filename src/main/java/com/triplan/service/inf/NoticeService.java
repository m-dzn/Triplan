package com.triplan.service.inf;

import com.triplan.domain.cs.NoticeVO;

public interface NoticeService {
    void noticeInsert(NoticeVO noticeVO);

    NoticeVO noticeSelect(int noticeId);

    void noticeUpdate(NoticeVO noticeVO);

    void noticeDelete(int noticeId);
}
