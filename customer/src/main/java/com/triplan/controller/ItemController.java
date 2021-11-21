package com.triplan.controller;

import com.triplan.domain.ItemVO;
import com.triplan.dto.seller.response.ItemResponseDTO;
import com.triplan.service.inf.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/test")
    public String itemRead(@PathVariable Integer itemId, Model model){
        ItemResponseDTO itemDTO = itemService.itemRead(itemId);
        model.addAttribute("item", itemDTO);

        return "item"; // View Resolver의 동작이 숨겨져있음 -> "/templates/" (prefix) + "item" + ".html" (suffix) => "/templates/item.html"
    }

    // @Controller의 구성
    // 1. 메서드 반환 값이 다 String -> 어떤 뷰 템플릿이랑 Model에 담긴 데이터를 결합할지 템플릿 정보를 가지고 있어야 하기 때문
    // 2. Model 객체에 @RestController에서는 return으로 돌려줬던 데이터를 이름을 지정해 (ex: "item") 담아서 보내기만 하면 끝

}
