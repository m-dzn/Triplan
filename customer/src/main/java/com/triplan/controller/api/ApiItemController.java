package com.triplan.controller.api;


import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ApiItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    public ItemVO itemRead(@PathVariable Integer itemId){
        return itemService.itemRead(itemId);
    }

    @GetMapping("/room/{itemId}")
    public ItemRoomResponseDTO readItemDetailRoom(@PathVariable Integer itemId){
        return itemService.getDetailRoomByItemId(ItemCategory.ROOM,itemId);
    }

    @GetMapping("/flight/{itemId}")
    public ItemFlightResponseDTO readItemDetailFlight(@PathVariable Integer itemId){
        return itemService.getDetailFlightByItemId(ItemCategory.FLIGHT,itemId);
    }

    @GetMapping("/rooms")
    public List<ItemRoomResponseDTO> getItemRoomList(){
        return itemService.getItemRoomList(ItemCategory.ROOM);
    }

    @GetMapping("/flights")
    public List<ItemFlightResponseDTO> getItemFlightList(){
        return itemService.getItemFlightList(ItemCategory.FLIGHT);
    }
}

