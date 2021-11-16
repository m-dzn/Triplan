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
    public Pagination<NoticeVO> noticeSellerList(Target target, Integer pageSize, Integer currentPage) {
        List<NoticeVO> noticeSellerList = noticeMapper.noticeSellerList(target,pageSize, currentPage);

        Integer countSeller = noticeMapper.countSeller(target);
         Pagination<NoticeVO> noticePagination = new Pagination<>(pageSize, currentPage, countSeller, noticeSellerList);
        return noticePagination;
    }

    @Override
    public Pagination<NoticeVO> noticeMemberList(Target target, Integer pageSize, Integer currentPage) {
        List<NoticeVO> noticeMemberList = noticeMapper.noticeMemberList(target,pageSize, currentPage);

        Integer countMember = noticeMapper.countMember(target);
        Pagination<NoticeVO> noticePagination = new Pagination<>(pageSize, currentPage, countMember, noticeMemberList);
        return noticePagination;
    }
    @Override
    public Pagination<NoticeVO> noticeAllList(Integer pageSize, Integer currentPage) {
        List<NoticeVO> noticeAllList = noticeMapper.noticeAllList(pageSize, currentPage);

        int totalNotices = noticeMapper.count();

        return new Pagination<>(pageSize,currentPage,totalNotices, noticeAllList);
    }
}