package com.triplan.controller;


import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.response.ItemGroupResponseDTO;
import com.triplan.service.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller/itemGroups")
@RequiredArgsConstructor
public class ItemGroupController {

    private final ItemGroupService itemGroupService;

    @PostMapping
    public String register(@RequestBody ItemGroupVO itemGroupVO) {
        itemGroupService.ItemGroupRegister(itemGroupVO);
        return "ItemGroupRegister";
    }

    @GetMapping("/{sellerId}")
    public List<ItemGroupResponseDTO> getItemGroupBySellerId(@PathVariable Integer sellerId) {
        return itemGroupService.readSellerIG(sellerId);
    }

    @PutMapping("/{num}")
    public String updateItemGroup(@RequestBody ItemGroupVO itemGroupVO, @PathVariable Integer num) {
        itemGroupService.updateItemGroup(itemGroupVO,num);
        return "Update";
    }

    @DeleteMapping("/{num}")
    public String deleteItemGroup(@PathVariable Integer num) {
        itemGroupService.deleteItemGroup(num);
        return "Delete";
    }
}