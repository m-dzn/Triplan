package com.triplan.mapper;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    void insert(List<AttachmentVO> attachmentList);


    int delete(@Param("aboutTableType") String aboutTableType, @Param("idInTableType") Integer idInTableType);

    void deleteAllByAttachmentId(@Param("attachmentIdList") List<Integer> attachmentIdList);

    List<AttachmentVO> select(@Param("aboutTableType") AboutTableType aboutTableType, @Param("idInTableType") Integer idInTableType);

    List<AttachmentVO> selectAllByAttachmentId(List<Integer> attachmentIdList);

}

