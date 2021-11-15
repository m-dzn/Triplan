package com.triplan.controller.api;


import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemScheduleVO;
import com.triplan.service.inf.ItemSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/item-searchs")
@RequiredArgsConstructor
public class ApiItemSearchController {

    private final ItemSearchService itemSearchService;

    @GetMapping("/list")
    public List<ItemScheduleVO> getListItemSchedule(){
        return itemSearchService.getListAll();
    }

    @GetMapping("/list/filter")
    public List<ItemGroupVO> getSearchFilterDate(@RequestParam(value = "startDate", required = false, defaultValue = "2000-01-01 00:00:00") String FomstartDate,
                                                 @RequestParam(value = "endDate", required = false, defaultValue = "9999-12-30 11:59:59" ) String FomendDate,
                                                 @RequestParam(value = "underPrice", required = false) Integer underPrice,
                                                 @RequestParam(value = "overPrice", required = false,defaultValue = "0") Integer overPrice){

        System.out.println("getSearchFilterDate");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.parse(FomstartDate, formatter);
        LocalDateTime endDate = LocalDateTime.parse(FomendDate, formatter);

        return itemSearchService.getFilterAsDate(startDate,endDate,underPrice,overPrice);

    }
}
