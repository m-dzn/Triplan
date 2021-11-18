package com.triplan.service.inf;

import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.request.ItemFlightRequestDTO;
import com.triplan.dto.customer.request.ItemRoomRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.ItemCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    void itemRemove(Integer itemId);

    Integer countItem(Integer sellerId);

    List<ItemVO> itemListBySellerId(Integer sellerId);

    ItemRoomResponseDTO getDetailRoomByItemId(ItemCategory room, Integer itemId);

    ItemFlightResponseDTO getDetailFlightByItemId(ItemCategory flight, Integer itemId);

    void insertItemRoom(ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room, List<MultipartFile> files);

    void insertItemFlight(ItemFlightRequestDTO itemFlightRequestDTO, ItemCategory flight, List<MultipartFile> files);

    void updateRoomItem(Integer itemId, ItemRoomRequestDTO itemRoomRequestDTO, ItemCategory room, List<MultipartFile> files);

    void updateFlightItem(Integer itemId, ItemFlightRequestDTO itemFlightRequestDTO, ItemCategory flight, List<MultipartFile> files);

    // Seller Page 상품관리
    Pagination<ItemRoomResponseDTO> getItemRoomList(Integer sellerId, ItemCategory room, Integer pageSize, Integer currentPage);

    Pagination<ItemFlightResponseDTO> getItemFlightList(Integer sellerId,ItemCategory flight, Integer pageSize, Integer currentPage);
}
