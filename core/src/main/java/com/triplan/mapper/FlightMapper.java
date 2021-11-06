package com.triplan.mapper;

import com.triplan.domain.FlightVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FlightMapper {

    void insert(FlightVO flightVO);

    FlightVO select(Integer flightId);

    void update(FlightVO flightVO);

    void delete(Integer flightId);

}
