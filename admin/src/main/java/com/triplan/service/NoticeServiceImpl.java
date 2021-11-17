package com.triplan.service;

import com.triplan.domain.NoticeVO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.Target;
import com.triplan.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper noticeMapper;

    @Override
    public void noticeInsert(NoticeVO noticeVO) {
        noticeMapper.noticeInsert(noticeVO);
    }

    @Override
    public NoticeVO noticeSelect(Integer noticeId) {
        return noticeMapper.noticeSelect(noticeId);
    }


    @Override
    public void noticeUpdate(NoticeVO noticeVO) {
        noticeMapper.noticeUpdate(noticeVO);
    }

    @Override
    public void noticeDelete(Integer noticeId) {
        noticeMapper.noticeDelete(noticeId);
    }


    @Override
    public Pagination<NoticeVO> noticeList(Target target, Integer pageSize, Integer currentPage) {
        List<NoticeVO> noticeList = noticeMapper.noticeList(target);
        Integer count = noticeMapper.count(target);
        Pagination<NoticeVO> noticePagination = new Pagination<>(pageSize,currentPage, count,noticeList);
        return noticePagination;
    }




}