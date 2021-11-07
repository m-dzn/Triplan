package com.triplan.controller.api;


import com.triplan.domain.ItemVO;
import com.triplan.dto.customer.response.ItemFlightResponseDTO;
import com.triplan.dto.customer.response.ItemRoomResponseDTO;
import com.triplan.enumclass.ItemCategory;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ApiItemController {

    @Autowired
    private final ItemService itemService;

    @PostMapping
    public String itemSave(@RequestBody ItemVO itemVO) {
        itemService.itemSave(itemVO);
        return "create 성공";
    }

    @GetMapping("/{itemId}")
    public ItemVO itemRead(@PathVariable Integer itemId){
        return itemService.itemRead(itemId);
    }
    
    @PutMapping("/{itemId}")
    public String itemModify(@PathVariable Integer itemId, @RequestBody ItemVO itemVO){
        itemService.itemModify(itemId, itemVO);
        return "update 성공";
    }
    
    @DeleteMapping("/{itemId}")
    public String itemRemove(@PathVariable Integer itemId){
        itemService.itemRemove(itemId);
        return "delete 성공";
    }

    @GetMapping("/ROOM/{itemId}")
    public ItemRoomResponseDTO readItemDetailRoom(@PathVariable Integer itemId){
        return itemService.getDetailRoomByItemId(ItemCategory.ROOM,itemId);
    }

    @GetMapping("/FLIGHT/{itemId}")
    public ItemFlightResponseDTO readItemDetailFlight(@PathVariable Integer itemId){
        return itemService.getDetailFlightByItemId(ItemCategory.FLIGHT,itemId);
    }

}

