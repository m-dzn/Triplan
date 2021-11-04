package com.triplan.service;

import com.triplan.domain.NoticeVO;
import com.triplan.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    @Override
    public void noticeInsert(NoticeVO noticeVO) {
        noticeMapper.noticeInsert(noticeVO);
    }

    @Override
    public NoticeVO noticeSelect(int noticeId) {
        return noticeMapper.noticeSelect(noticeId);
    }


    @Override
    public void noticeUpdate(NoticeVO noticeVO) {
        noticeMapper.noticeUpdate(noticeVO);
    }

    @Override
    public void noticeDelete(int noticeId) {
        noticeMapper.noticeDelete(noticeId);
    }


}
