package com.triplan.controller.api;


import com.triplan.domain.ItemVO;
import com.triplan.dto.seller.response.ItemDTO;
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

    @GetMapping("/list/{itemId}")
    public List<ItemDTO> itemList(@PathVariable Integer itemId){
        return itemService.itemList(itemId);
    }

    // 메인 페이지
    // sellerId 상품별 판매량
    @GetMapping("/sellers/{sellerId}")
    public List<ItemVO> itemListBySellerId(@PathVariable Integer sellerId) {
        return itemService.itemListBySellerId(sellerId);
    }


    @GetMapping("/count/sellers/{sellerId}")
    public Integer countItem(@PathVariable Integer sellerId) {
        return itemService.countItem(sellerId);
    }

}

