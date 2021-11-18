package com.triplan.mapper;

import com.triplan.dto.seller.response.ItemScheduleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemScheduleMapper {
    List<ItemScheduleDTO> getItemScheduleBySellerId(Integer sellerId);
}
