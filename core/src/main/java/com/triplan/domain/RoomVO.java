package com.triplan.domain;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class RoomVO {

    private Integer roomId;
    private Integer itemId;
    private Integer numberOfPerson;
    private Integer maxPerson;
    private String name;
    private String img;
    private LocalDateTime resDate;
    private Integer addPerson;

}
