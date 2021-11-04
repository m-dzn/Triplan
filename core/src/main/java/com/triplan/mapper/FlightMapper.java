package com.triplan.mapper;

import com.triplan.domain.FlightVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FlightMapper {

    void flightInsert(FlightVO flightVO);
    FlightVO flightSelect(int flightId);
    void flightUpdate(FlightVO flightVO);
    void flightDelete(int flightId);

}
