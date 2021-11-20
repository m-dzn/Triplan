package com.triplan.controller.api;

import com.triplan.domain.ItemGroupVO;
import com.triplan.dto.customer.response.ItemGroupResponseDTO;
import com.triplan.dto.response.AccommodationCardResponseDTO;
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
    public Pagination<AccommodationCardResponseDTO> getSearchFilterDate(
            @RequestParam(defaultValue = "2000-01-01 00:00:00") String startDate,
            @RequestParam(defaultValue = "9999-12-30 23:59:59" ) String endDate,
            @RequestParam(required = false) Integer underPrice,
            @RequestParam(defaultValue = "0") Integer overPrice,
            @RequestParam(required = false) List<Integer> tags,
            @RequestParam(required = false) String sortType,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateLDT = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateLDT = LocalDateTime.parse(endDate, formatter);

        Integer memberId = 1;
        return itemGroupService.getFilterAsDate(
                startDateLDT, endDateLDT, underPrice, overPrice, tags, sortType, pageSize, currentPage, memberId);
    }

}
