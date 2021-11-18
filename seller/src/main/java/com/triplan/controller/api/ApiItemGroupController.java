package com.triplan.controller.api;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.request.ItemGroupRequestDTO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/item-groups")
@RequiredArgsConstructor
public class ApiItemGroupController {

    private final ItemGroupService itemGroupService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public String ItemGroupAddTags(@RequestPart("itemGroup") ItemGroupRequestDTO itemGroupRequestDTO,
                                   @RequestPart("file") List<MultipartFile> files) {
        itemGroupService.ItemGroupRegisterAddTags(itemGroupRequestDTO, files);
        return "addTag";
    }

    @DeleteMapping("{itemGroupId}")
    public String deleteItemGroup(@PathVariable Integer itemGroupId){
        itemGroupService.deleteItemGroup(itemGroupId);
        return "Delete";
    }

    @GetMapping("/{itemGroupId}")
    public ItemGroupResponseDTO getItemGroupByItemGroupId(@PathVariable Integer itemGroupId){
        return itemGroupService.getItemList(itemGroupId);
    }



    @PutMapping("/{itemGroupId}")
    public String ItemGroupUpdateTags(@PathVariable Integer itemGroupId,
                                      @RequestBody ItemGroupRequestDTO itemGroupRequestDTO,
                                      @RequestParam("file") List<MultipartFile> files){
        itemGroupRequestDTO.setItemGroupId(itemGroupId);
        itemGroupService.updateItemGroupTags(itemGroupId,itemGroupRequestDTO, files);
        return "Update Tags";
    }

    @GetMapping("/list/{sellerId}")
    public Pagination<ItemGroupVO> itemGroupListBySellerId(
            @PathVariable Integer sellerId,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage) {
        return itemGroupService.itemGroupListBySellerId(sellerId, pageSize, currentPage);
    }

}
