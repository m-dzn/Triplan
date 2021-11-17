package com.triplan.controller.api;


import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.request.ItemFlightRequestDTO;
import com.triplan.dto.customer.request.ItemRoomRequestDTO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.enumclass.ItemCategory;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ApiItemController {

    private final ItemService itemService;

    @DeleteMapping("/delete/{itemId}")
    public String itemRemove(@PathVariable Integer itemId){
        itemService.itemRemove(itemId);
        return "delete 성공";
    }

    // Seller 메인 페이지
    // sellerId 상품별 판매량
    @GetMapping("/sellers/{sellerId}")
    public List<ItemVO> itemListBySellerId(@PathVariable Integer sellerId) {
        return itemService.itemListBySellerId(sellerId);
    }

    @GetMapping("/count/sellers/{sellerId}")
    public Integer countItem(@PathVariable Integer sellerId) {
        return itemService.countItem(sellerId);
    }

    // 상품 관리
        // 판매자 상품관리 리스트

        // room + flight
    @GetMapping("/room/{itemId}")
    public ItemRoomResponseDTO readItemDetailRoom(@PathVariable Integer itemId){
        return itemService.getDetailRoomByItemId(ItemCategory.ROOM,itemId);
    }

    @GetMapping("/flight/{itemId}")
    public ItemFlightResponseDTO readItemDetailFlight(@PathVariable Integer itemId){
        return itemService.getDetailFlightByItemId(ItemCategory.FLIGHT,itemId);
    }

    @PostMapping("/room")
    public String insertItemRoom(@RequestBody ItemRoomRequestDTO itemRoomRequestDTO){
        return itemService.insertItemRoom(itemRoomRequestDTO,ItemCategory.ROOM);
    }

    @PostMapping("/flight")
    public String insertItemFlight(@RequestBody ItemFlightRequestDTO itemFlightRequestDTO){
        return itemService.insertItemFlight(itemFlightRequestDTO, ItemCategory.FLIGHT);

    }

    @PutMapping("/room/{itemId}")
    public String updateRoomItem(@PathVariable Integer itemId, @RequestBody ItemRoomRequestDTO itemRoomRequestDTO){
        return itemService.updateRoomItem(itemId, itemRoomRequestDTO, ItemCategory.ROOM);

    }

    @PutMapping("/flight/{itemId}")
    public String updateFlightItem(@PathVariable Integer itemId, @RequestBody ItemFlightRequestDTO itemFlightRequestDTO){
        return itemService.updateFlightItem(itemId, itemFlightRequestDTO, ItemCategory.FLIGHT);
    }

    // Seller Page 상품관리
    @GetMapping("/{sellerId}/rooms")
    public Pagination<ItemRoomResponseDTO> getItemRoomList(
            @PathVariable Integer sellerId,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage) {
        return itemService.getItemRoomList(sellerId,ItemCategory.ROOM, pageSize, currentPage);
    }

    @GetMapping("/{sellerId}/flights")
    public Pagination<ItemFlightResponseDTO> getItemFlightList(
            @PathVariable Integer sellerId,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage) {
        return itemService.getItemFlightList(sellerId, ItemCategory.FLIGHT, pageSize, currentPage);
    }
}

