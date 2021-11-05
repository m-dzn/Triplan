package com.triplan.domain;

import com.triplan.enumclass.FlightType;
import com.triplan.enumclass.PassengerType;
import com.triplan.enumclass.SeatClass;
import lombok.Data;


@Data
public class FlightVO {

    private Integer flightId;
    private Integer itemId;
    private String departure;
    private String destination;
    private FlightType flightType;
    private Integer numberOfPerson;
    private SeatClass seatClass;
    private PassengerType passengerType;
    private String airline;
    private String baggage;
    private String seatNumber;
    
}
