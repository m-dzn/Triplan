package com.triplan.domain;

import com.triplan.enumclass.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

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
    private Date resDate;
    private Integer numberOfPerson;
    private String coupon;
    private String name;
    private String phone;
    private Type type;
    private boolean usage1;
    private Date completeAt;
    private boolean paymentUsage;
    private Date createdAt;
    private Date updatedAt;
}
