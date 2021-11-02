package com.triplan.controller;


import com.triplan.domain.ItemVO;
import com.triplan.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/items")
@RestController
@RequiredArgsConstructor
public class itemController {

    @Autowired
    private final ItemService itemService;

    @PostMapping()
    public String itemSave(@RequestBody ItemVO itemVO) {
        itemService.itemSave(itemVO);
        return "create 성공";
    }

    @GetMapping("/{itemId}")
    public String itemRead(@PathVariable int itemId){
        itemService.itemRead(itemId);
        return "read 성공";
    }
    
    @PutMapping("/{itemId}")
    public String itemModify(@PathVariable int itemId, @RequestBody ItemVO itemVO){
        itemService.itemModify(itemId, itemVO);
        return "update 성공";
    }
    
    @DeleteMapping("/{itemId}")
    public String itemRemove(@PathVariable int itemId){
        itemService.itemRemove(itemId);
        return "delete 성공";
    }

}

