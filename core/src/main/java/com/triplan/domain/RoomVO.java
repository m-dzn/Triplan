package com.triplan.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class RoomVO {

    private int room_id;
    private int item_id;
    private int number_of_person;
    private int max_person;
    private String name;
    private String img;
    private Timestamp res_date;
    private int add_person;

}
