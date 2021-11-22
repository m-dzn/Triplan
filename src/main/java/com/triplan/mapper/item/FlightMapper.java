package com.triplan.mapper.item;

import com.triplan.domain.item.FlightVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FlightMapper {

    void insert(FlightVO flightVO);

    FlightVO select(Integer flightId);

    void update(FlightVO flightVO);

    void delete(Integer flightId);

    FlightVO getFlightByItemId(Integer itemId);

    void updateByItemId(FlightVO flightVO);
}
