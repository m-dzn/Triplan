package com.triplan.service;

import com.triplan.domain.FlightVO;
import com.triplan.mapper.FlightMapper;
import com.triplan.service.inf.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightMapper flightMapper;


    @Override
    public void flightInsert(FlightVO flightVO) {
        flightMapper.insert(flightVO);
    }

    @Override
    public FlightVO flightSelect(Integer flightId) {
        return flightMapper.select(flightId);
    }

    @Override
    public void flightUpdate(FlightVO flightVO) {
        flightMapper.update(flightVO);
    }

    @Override
    public void flightDelete(Integer flightId) {
        flightMapper.delete(flightId);
    }

}
