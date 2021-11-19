package com.triplan.service.inf;

import com.triplan.dto.seller.response.ItemScheduleDTO;

import java.util.List;

public interface ItemScheduleService {

    List<ItemScheduleDTO> getItemSchedule(Integer sellerId);

}
