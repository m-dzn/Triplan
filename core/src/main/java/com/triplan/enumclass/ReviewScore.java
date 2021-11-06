package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ReviewScore {

    Zero(0),
    Zero_point_five(0.5),
    One(1),
    One_point_five(1.5),
    Two(2),
    Two_point_five(2.5),
    Three(3),
    Three_point_five(3.5),
    Four(4),
    Four_point_five(4.5),
    Five(5);

    private double code;


}
