package com.triplan.dto;

import com.triplan.domain.ReservationVO;
import com.triplan.enumclass.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ReservationDTO {

    private Long resId;
    private Long memberId;
    private Long itemId;
    private Long totalPrice;
    private Long discountPrice;
    private Long finalPrice;
    private Date resDate;
    private Long numberOfPerson;
    private String coupon;
    private String name;
    private String phone;
    private Type type;
    private boolean usage;
    private Date completeAt;
    private boolean paymentUsage;
    private Date createdAt;
    private Date updatedAt;

    public static ReservationDTO of (ReservationVO reservationVO) {
        ReservationDTO dto = new ReservationDTO();
        dto.setResId(reservationVO.getResId());
        dto.setMemberId(reservationVO.getMemberId());
        dto.setItemId(reservationVO.getItemId());
        dto.setTotalPrice(reservationVO.getTotalPrice());
        dto.setDiscountPrice(reservationVO.getDiscountPrice());
        dto.setFinalPrice(reservationVO.getFinalPrice());
        dto.setResDate(reservationVO.getResDate());
        dto.setNumberOfPerson(reservationVO.getNumberOfPerson());
        dto.setCoupon(reservationVO.getCoupon());
        dto.setName(reservationVO.getName());
        dto.setPhone(reservationVO.getPhone());
        dto.setType(reservationVO.getType());
        dto.setUsage(reservationVO.isUsage());
        dto.setCompleteAt(reservationVO.getCompleteAt());
        dto.setPaymentUsage(reservationVO.isPaymentUsage());
        dto.setCreatedAt(reservationVO.getCreatedAt());
        dto.setUpdatedAt(reservationVO.getUpdatedAt());
        return dto;
    }

    public ReservationVO toVO() {
        return ReservationVO.builder()
                .resId(resId)
                .memberId(memberId)
                .itemId(itemId)
                .totalPrice(totalPrice)
                .discountPrice(discountPrice)
                .finalPrice(finalPrice)
                .resDate(resDate)
                .numberOfPerson(numberOfPerson)
                .coupon(coupon)
                .name(name)
                .phone(phone)
                .type(type)
                .usage(usage)
                .completeAt(completeAt)
                .paymentUsage(paymentUsage)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
