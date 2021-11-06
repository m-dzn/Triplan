package com.triplan.service.inf;

import com.triplan.domain.FlightVO;

public interface FlightService {

    void flightInsert(FlightVO flightVO);

    FlightVO flightSelect(Integer flightId);

    void flightUpdate(FlightVO flightVO);

    void flightDelete(Integer flightId);

}
