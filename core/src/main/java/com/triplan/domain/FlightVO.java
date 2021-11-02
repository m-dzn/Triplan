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

    public static void main(String[] args) {
        FlightVO flightVO = new FlightVO();
        flightVO.setFlightType(FlightType.ONE_WAY);
        flightVO.setPassengerType(PassengerType.ADULT);
        flightVO.setSeatClass(SeatClass.ECONOMY);

        System.out.println(flightVO.getFlightType());
        System.out.println(flightVO.getFlightType().getExplain());
        System.out.println();
        System.out.println(flightVO.getPassengerType());
        System.out.println(flightVO.getPassengerType().getPerson());
        System.out.println();
        System.out.println(flightVO.getSeatClass());
        System.out.println(flightVO.getSeatClass().getSit());

    }
}
