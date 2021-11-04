package com.triplan.dto;

import com.triplan.domain.ReservationVO;
import com.triplan.enumclass.ResType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class ReservationDTO {

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
        dto.setUsage1(reservationVO.isUsage1());
        dto.setCompleteAt(reservationVO.getCompleteAt());
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
                .usage1(usage1)
                .completeAt(completeAt)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
