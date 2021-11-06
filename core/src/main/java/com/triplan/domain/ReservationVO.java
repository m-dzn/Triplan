package com.triplan.domain;

import com.triplan.enumclass.ResType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
public class ReservationVO {
    private Integer resId;
    private Integer memberId;
    private Integer itemId;
    private Integer totalPrice;
    private Integer discountPrice;
    private Integer finalPrice;
    private LocalDateTime resDate;
    private Integer numberOfPerson;
    private String coupon;
    private String name;
    private String phone;
    private ResType type;
    private boolean used;
    private LocalDateTime completeAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
