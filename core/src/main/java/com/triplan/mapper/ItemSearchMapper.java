package com.triplan.mapper;

import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemScheduleVO;
import com.triplan.domain.ItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ItemSearchMapper {
    List<ItemScheduleVO> getList();

    List<ItemGroupVO> getFilterAsDateDistinct(@Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate,
                                              @Param("underPrice") Integer underPrice,
                                              @Param("overPrice") Integer overPrice,
                                              @Param("Data") Integer Data);
}
