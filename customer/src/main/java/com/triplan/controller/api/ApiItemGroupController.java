package com.triplan.controller.api;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-groups")
@RequiredArgsConstructor
public class ApiItemGroupController {

    private final ItemGroupService itemGroupService;

    @PostMapping
    public String register(@RequestBody ItemGroupVO itemGroupVO){
        itemGroupService.ItemGroupRegister(itemGroupVO);
        return "ItemGroupRegister";
    }

    @GetMapping("/{itemGroupId}")
    public ItemGroupVO getItemGroup(@PathVariable Integer itemGroupId){
        ItemGroupVO itemGroupVO = itemGroupService.getItemGroup(itemGroupId);
        return itemGroupVO;
    }

    @PutMapping("/{itemGroupId}")
    public String updateItemGroup(@RequestBody ItemGroupVO itemGroupVO, @PathVariable Integer itemGroupId){
        itemGroupService.updateItemGroup(itemGroupVO,itemGroupId);
        return "Update";
    }

    @DeleteMapping("{itemGroupId}")
    public String deleteItemGroup(@PathVariable Integer itemGroupId){
        itemGroupService.deleteItemGroup(itemGroupId);
        return "Delete";
    }

    @GetMapping("/item-list/{itemGroupId}")
    public ItemGroupResponseDTO getItemGroupByItemGroupId(@PathVariable Integer itemGroupId){
        return itemGroupService.getItemList(itemGroupId);
    }

    @PostMapping("/plus-tags")
    public String ItemGroupAddTags(@RequestBody ItemGroupRequestDTO itemGroupRequestDTO){
        itemGroupService.ItemGroupRegisterAddTags(itemGroupRequestDTO);
        return "addTag";
    }

    @PostMapping("/plus-tags/{itemGroupId}")
    public String ItemGroupUpdateTags(@PathVariable Integer itemGroupId,
                                      @RequestBody ItemGroupRequestDTO itemGroupRequestDTO){
        itemGroupService.updateItemGroupTags(itemGroupId,itemGroupRequestDTO);
        return "Update Tags";
    }
}
