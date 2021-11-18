package com.triplan.service;

import com.triplan.dto.seller.response.ItemScheduleDTO;
import com.triplan.mapper.ItemScheduleMapper;
import com.triplan.service.inf.ItemScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemScheduleServiceImpl implements ItemScheduleService {

    private final ItemScheduleMapper itemScheduleMapper;

    @Override
    public List<ItemScheduleDTO> getItemSchedule(Integer sellerId) {
        List<ItemScheduleDTO> res = itemScheduleMapper.getItemScheduleBySellerId(sellerId);
        return res;
    }

}
