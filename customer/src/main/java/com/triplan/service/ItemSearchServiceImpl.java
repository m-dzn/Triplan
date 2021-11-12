package com.triplan.service;


import com.triplan.domain.ItemGroupVO;
import com.triplan.domain.ItemScheduleVO;
import com.triplan.domain.ItemVO;
import com.triplan.mapper.ItemGroupMapper;
import com.triplan.mapper.ItemSearchMapper;
import com.triplan.service.inf.ItemSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemSearchServiceImpl implements ItemSearchService {

    private final ItemSearchMapper itemSearchMapper;
    private final ItemGroupMapper itemGroupMapper;

    @Override
    public List<ItemScheduleVO> getListAll() {
        return itemSearchMapper.getList();
    }

    @Override
    public List<ItemGroupVO> getFilterAsDate(LocalDateTime startDate, LocalDateTime endDate, Integer underPrice, Integer overPrice) {

        Integer Data = null;

        if(startDate != null) Data = 1;
        else if(endDate != null) Data = 1;
       // else if (tag != null) Data = 1;
        else if (underPrice != null) Data = 1;
        else if (overPrice != null) Data = 1;
        else Data = null;

        List<ItemGroupVO> resultItemGroupId = itemSearchMapper.getFilterAsDateDistinct(startDate,endDate,underPrice,overPrice,Data);
        List<ItemGroupVO> itemGroupVOS = itemGroupMapper.selectAll(resultItemGroupId);
        //[1,2]

//        for(int i=0; i<resultItemGroupId.size(); i++){
//            Integer itemGroupId = (resultItemGroupId.get(i).getItemGroupId());
//            itemGroupVOS.add(itemGroupMapper.select(itemGroupId));
//        }

        return itemGroupVOS;
    }
}
