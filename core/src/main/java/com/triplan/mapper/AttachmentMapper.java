package com.triplan.mapper;

import com.triplan.domain.AttachmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttachmentMapper {

    void insert(List<AttachmentVO> attachmentList);

    void delete(@Param("tableType") String tableType, @Param("id") int id);

    List<AttachmentVO> select(@Param("tableType") String tableType, @Param("id") int id);

}