package com.triplan.controller.api;

import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item-groups")
@RequiredArgsConstructor
public class ApiItemGroupController {

    private final ItemGroupService itemGroupService;

    @DeleteMapping("{itemGroupId}")
    public String deleteItemGroup(@PathVariable Integer itemGroupId){
        itemGroupService.deleteItemGroup(itemGroupId);
        return "Delete";
    }

    @GetMapping("/{itemGroupId}")
    public ItemGroupResponseDTO getItemGroupByItemGroupId(@PathVariable Integer itemGroupId){
        return itemGroupService.getItemList(itemGroupId);
    }

    @PostMapping
    public String ItemGroupAddTags(@RequestBody ItemGroupRequestDTO itemGroupRequestDTO){
        itemGroupService.ItemGroupRegisterAddTags(itemGroupRequestDTO);
        return "addTag";
    }

    @PutMapping("/{itemGroupId}")
    public String ItemGroupUpdateTags(@PathVariable Integer itemGroupId,
                                      @RequestBody ItemGroupRequestDTO itemGroupRequestDTO){
        itemGroupService.updateItemGroupTags(itemGroupId,itemGroupRequestDTO);
        return "Update Tags";
    }
}
