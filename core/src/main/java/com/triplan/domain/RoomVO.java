package com.triplan.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class RoomVO {

    private int roomId;
    private int itemId;
    private int numberOfPerson;
    private int maxPerson;
    private String name;
    private String img;
    private Timestamp resDate;
    private int addPerson;

}
