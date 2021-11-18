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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ApiItemController {

    private final ItemService itemService;

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

    @PostMapping(value = "/room", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public void insertItemRoom(@RequestPart ItemRoomRequestDTO itemRoomRequestDTO,
                               @RequestPart("file") List<MultipartFile> files){
        itemService.insertItemRoom(itemRoomRequestDTO,ItemCategory.ROOM, files);
    }

    @PostMapping(value = "/flight", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public void insertItemFlight(@RequestPart ItemFlightRequestDTO itemFlightRequestDTO,
                                 @RequestPart("file") List<MultipartFile> files){
        itemService.insertItemFlight(itemFlightRequestDTO, ItemCategory.FLIGHT, files);
    }

    @PutMapping("/room/{itemId}")
    public String updateRoomItem(@PathVariable Integer itemId,
                                 @RequestBody ItemRoomRequestDTO itemRoomRequestDTO,
                                 @RequestParam("file") List<MultipartFile> files){
        itemService.updateRoomItem(itemId, itemRoomRequestDTO, ItemCategory.ROOM, files);
        return "Update";
    }

    @PutMapping("/flight/{itemId}")
    public String updateFlightItem(@PathVariable Integer itemId,
                                   @RequestBody ItemFlightRequestDTO itemFlightRequestDTO,
                                   @RequestParam("file") List<MultipartFile> files){
        itemService.updateFlightItem(itemId, itemFlightRequestDTO, ItemCategory.FLIGHT, files);
        return "Update";
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

    @DeleteMapping("/delete/{itemId}")
    public String itemRemove(@PathVariable Integer itemId){
        itemService.itemRemove(itemId);
        return "delete 성공";
    }
}