package com.triplan.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter
@Setter
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
