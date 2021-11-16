package com.triplan.mapper;

import com.triplan.domain.AttachmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    void insert(List<AttachmentVO> attachmentList);

    int delete(@Param("aboutTableType") String aboutTableType, @Param("idInTableType") Integer idInTableType);

    void deleteByAttachmentId(Integer attachmentId);

    List<AttachmentVO> select(@Param("aboutTableType") String aboutTableType, @Param("idInTableType") Integer idInTableType);

    List<AttachmentVO> selectByAttachmentId(List<Integer> attachmentIdList);
}

