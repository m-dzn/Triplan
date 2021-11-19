package com.triplan.controller.api;

import com.triplan.dto.seller.response.ItemScheduleDTO;
import com.triplan.service.inf.ItemScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/item-schedules")
@RequiredArgsConstructor
public class ApiItemScheduleController {

    public final ItemScheduleService itemScheduleService;

    @GetMapping("/sellers/{sellerId}")
    public List<ItemScheduleDTO> getItemSchedule(@PathVariable Integer sellerId){
        return itemScheduleService.getItemSchedule(sellerId);
    }

}
