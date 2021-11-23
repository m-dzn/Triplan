package com.triplan.controller.api;

import com.triplan.domain.item.ItemGroupVO;
import com.triplan.dto.response.customer.ItemGroupResponseDTO;
import com.triplan.dto.response.customer.AccommodationCardResponseDTO;
import com.triplan.dto.response.Pagination;
import com.triplan.security.CurrentMember;
import com.triplan.security.MemberPrincipal;
import com.triplan.service.inf.ItemGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ItemGroupResponseDTO getItemGroupByItemGroupId(
            @PathVariable Integer itemGroupId,
            @CurrentMember MemberPrincipal currentMember
    ) {
        Integer memberId = currentMember != null ? currentMember.getMemberId() : null;
        return itemGroupService.getItemList(itemGroupId, memberId);
    }

    @GetMapping("/filter")
    public Pagination<AccommodationCardResponseDTO> getSearchFilterDate(
            @RequestParam(defaultValue = "2000-01-01") String startDate,
            @RequestParam(defaultValue = "9999-12-30" ) String endDate,
            @RequestParam(required = false) Integer underPrice,
            @RequestParam(defaultValue = "0") Integer overPrice,
            @RequestParam(required = false) List<Integer> tags,
            @RequestParam(required = false) String sortType,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer currentPage,
            @CurrentMember MemberPrincipal currentMember) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startDateLDT = LocalDate.parse(startDate, formatter).atStartOfDay();
        LocalDateTime endDateLDT = LocalDate.parse(endDate, formatter).atTime(23,59,59);

        Integer memberId = currentMember != null ? currentMember.getMemberId() : null;
        return itemGroupService.getFilterAsDate(
                startDateLDT, endDateLDT, underPrice, overPrice, tags, sortType, pageSize, currentPage, memberId);
    }

}
