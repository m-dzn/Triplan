package com.triplan.service;

import com.triplan.domain.NoticeVO;
import com.triplan.mapper.NoticeMapper;
import com.triplan.service.inf.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;

    @Override
    public void noticeInsert(NoticeVO noticeVO) {
        noticeMapper.insert(noticeVO);
    }

    @Override
    public NoticeVO noticeSelect(int noticeId) {
        return noticeMapper.select(noticeId);
    }

    @Override
    public void noticeUpdate(NoticeVO noticeVO) {
        noticeMapper.update(noticeVO);
    }

    @Override
    public void noticeDelete(int noticeId) {
        noticeMapper.delete(noticeId);
    }


}
