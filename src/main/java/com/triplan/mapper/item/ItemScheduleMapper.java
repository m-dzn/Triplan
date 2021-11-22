package com.triplan.mapper.item;

import com.triplan.domain.item.ItemScheduleVO;
import com.triplan.dto.response.seller.ItemScheduleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ItemScheduleMapper {
    List<ItemScheduleDTO> getItemScheduleBySellerId(Integer sellerId);

    List<ItemScheduleVO> selectByDate(
            @Param("itemId") Integer itemId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
