package com.triplan.mapper.item;

import com.triplan.domain.item.TagVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {

    void RegisterAddTagIdList(@Param("itemGroupId") Integer itemGroupId,
                              @Param("idList") List<Integer> tagIdList);

    void updateTagListByGroupId(@Param("itemGroupId") Integer itemGroupId,
                                @Param("idList") List<Integer> tagIdList);

    List<Integer> getIdList(Integer itemGroupId);

    void delete(Integer itemGroupId);

    List<TagVO> list(Integer itemGroupId);

}
