package com.triplan.service.inf;

import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.RoomCardResponseDTO;
import com.triplan.enumclass.ItemCategory;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    ItemVO itemRead(Integer itemId);

    ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId);

    ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId);

    List<RoomCardResponseDTO> getItemsByItemGroupId(Integer itemGroupId, LocalDate startDate, LocalDate endDate);

}
