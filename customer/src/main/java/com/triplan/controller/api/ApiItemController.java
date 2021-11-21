package com.triplan.controller.api;


import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.dto.response.RoomCardResponseDTO;
import com.triplan.dto.seller.response.ItemResponseDTO;
import com.triplan.enumclass.ItemCategory;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ApiItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    public ItemResponseDTO itemRead(
            @PathVariable Integer itemId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startDateLDT = LocalDate.parse(startDate, formatter).atStartOfDay();
        LocalDateTime endDateLDT = LocalDate.parse(endDate, formatter).atTime(23,59,59);

        return itemService.itemRead(itemId, startDateLDT, endDateLDT);
    }

    @GetMapping("/room/{itemId}")
    public ItemRoomResponseDTO readItemDetailRoom(@PathVariable Integer itemId){
        return itemService.getDetailRoomByItemId(ItemCategory.ROOM, itemId);
    }

    @GetMapping("/flight/{itemId}")
    public ItemFlightResponseDTO readItemDetailFlight(@PathVariable Integer itemId){
        return itemService.getDetailFlightByItemId(ItemCategory.FLIGHT, itemId);
    }

    @GetMapping("/item-groups/{itemGroupId}")
    public List<RoomCardResponseDTO> getItemsByItemGroupId(
            @PathVariable Integer itemGroupId,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDateLDT = startDate == null ? LocalDate.now() : LocalDate.parse(startDate, formatter);
        LocalDate endDateLDT = endDate == null ? LocalDate.now().plus(1, ChronoUnit.DAYS) : LocalDate.parse(endDate, formatter);

        return itemService.getItemsByItemGroupId(itemGroupId, startDateLDT, endDateLDT);
    }

}

