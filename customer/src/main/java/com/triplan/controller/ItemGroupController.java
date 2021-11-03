package com.triplan.controller;


import com.triplan.domain.ItemGroupVO;
import com.triplan.service.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-groups")
@RequiredArgsConstructor
public class ItemGroupController {

    private final ItemGroupService itemGroupService;

    //POST GET PUT DELETE

    @PostMapping
    public String register(@RequestBody ItemGroupVO itemGroupVO){
        itemGroupService.ItemGroupRegister(itemGroupVO);
        return "ItemGroupRegister";
    }

    @GetMapping("/{num}")
    public ItemGroupVO getItemGroup(@PathVariable int num){
        ItemGroupVO itemGroupVO = itemGroupService.getItemGroup(num);
        return itemGroupVO;
    }

    @GetMapping("/join/{num}")
    public ItemGroupVO joinItem(@PathVariable int num){
        ItemGroupVO ig = itemGroupService.getjoin(num);
        return ig;
    }


    @PutMapping("/{num}")
    public String updateItemGroup(@RequestBody ItemGroupVO itemGroupVO, @PathVariable int num){
        itemGroupService.updateItemGroup(itemGroupVO,num);
        return "Update";
    }

    @DeleteMapping("{num}")
    public String deleteItemGroup(@PathVariable int num){
        itemGroupService.deleteItemGroup(num);
        return "Delete";
    }
}
