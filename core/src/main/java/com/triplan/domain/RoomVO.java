package com.triplan.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
public class RoomVO {

    private Integer roomId;
    private Integer itemId;
    private Integer numberOfPerson;
    private Integer maxPerson;
    private String name;
    private String img;
    private Timestamp resDate;
    private Integer addPerson;
}
