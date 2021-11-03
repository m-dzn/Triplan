package com.triplan.service;

import com.triplan.domain.FlightVO;
import com.triplan.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{

    private final FlightMapper flightMapper;


    @Override
    public void flightInsert(FlightVO flightVO) {
        flightMapper.flightInsert(flightVO);
    }

    @Override
    public FlightVO flightSelect(int flightId) {
        return flightMapper.flightSelect(flightId);
    }

    @Override
    public void flightUpdate(FlightVO flightVO) {
        flightMapper.flightUpdate(flightVO);
    }

    @Override
    public void flightDelete(int flightId) {
        flightMapper.flightDelete(flightId);
    }
}
