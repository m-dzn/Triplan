package com.triplan.mapper;

import com.triplan.domain.AttachmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    void insert(List<AttachmentVO> attachmentList);


    int delete(@Param("tableType") String tableType, @Param("id") int id);

    List<AttachmentVO> select(@Param("aboutTableType") String aboutTableType, @Param("idInTableType") int idInTableType);

    List<AttachmentVO> selectAll();

    void deleteByAttachmentId(Integer attachmentId);

    List<AttachmentVO> selectByAttachmentId(List<Integer> attachmentIdList);
}

