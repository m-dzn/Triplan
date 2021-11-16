package com.triplan.controller.api;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item-groups")
@RequiredArgsConstructor
public class ApiItemGroupController {

    private final ItemGroupService itemGroupService;

    @GetMapping("/{itemGroupId}")
    public ItemGroupVO getItemGroup(@PathVariable Integer itemGroupId){
        ItemGroupVO itemGroupVO = itemGroupService.getItemGroup(itemGroupId);
        return itemGroupVO;
    }

    @GetMapping("/{itemGroupId}/items")
    public ItemGroupResponseDTO getItemGroupByItemGroupId(@PathVariable Integer itemGroupId){
        return itemGroupService.getItemList(itemGroupId);
    }
}
