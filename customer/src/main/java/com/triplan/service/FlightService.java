package com.triplan.service;

import com.triplan.domain.FlightVO;

public interface FlightService {
    void flightInsert(FlightVO flightVO);

    FlightVO flightSelect(int flightId);

    void flightUpdate(FlightVO flightVO);

    void flightDelete(int flightId);
}
