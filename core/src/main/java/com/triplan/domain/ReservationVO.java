package com.triplan.domain;

import com.triplan.enumclass.ResType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
public class ReservationVO {
    private Integer resId;
    private Integer memberId;
    private Integer itemId;
    private Integer totalPrice;
    private Integer discountPrice;
    private Integer finalPrice;
    private Timestamp resDate;
    private Integer numberOfPerson;
    private String coupon;
    private String name;
    private String phone;
    private ResType type;
    private boolean usage1;
    private Timestamp completeAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
