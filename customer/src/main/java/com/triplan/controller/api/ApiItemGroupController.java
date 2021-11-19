package com.triplan.controller.api;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/item-groups")
@RequiredArgsConstructor
public class ApiItemGroupController {

    private final ItemGroupService itemGroupService;

    @GetMapping("/{itemGroupId}")
    public ItemGroupVO getItemGroup(@PathVariable Integer itemGroupId) {
        ItemGroupVO itemGroupVO = itemGroupService.getItemGroup(itemGroupId);
        return itemGroupVO;
    }

    @GetMapping("/{itemGroupId}/items")
    public ItemGroupResponseDTO getItemGroupByItemGroupId(@PathVariable Integer itemGroupId) {
        return itemGroupService.getItemList(itemGroupId);
    }

    @GetMapping("/filter")
    public Pagination<ItemGroupVO> getSearchFilterDate(@RequestParam(value = "startDate", required = false, defaultValue = "2000-01-01 00:00:00") String FomstartDate,
                                                       @RequestParam(value = "endDate", required = false, defaultValue = "9999-12-30 11:59:59" ) String FomendDate,
                                                       @RequestParam(value = "underPrice", required = false) Integer underPrice,
                                                       @RequestParam(value = "overPrice", required = false,defaultValue = "0") Integer overPrice,
                                                       @RequestParam(value = "tags",required = false) List<Integer> tags,
                                                       @RequestParam(value = "sortType",required = false) String sortType,
                                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                                       @RequestParam(defaultValue = "1") Integer currentPage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(FomstartDate, formatter);
        LocalDateTime endDate = LocalDateTime.parse(FomendDate, formatter);

        return itemGroupService.getFilterAsDate(startDate,endDate,underPrice,overPrice,tags,sortType,pageSize,currentPage);
    }

}
