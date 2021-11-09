package com.triplan.dto;

import com.triplan.domain.ReservationVO;
import com.triplan.enumclass.ItemCategory;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Integer resId;
    private ItemCategory itemCategory;
    private Long totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String name;
    private String phone;
    private Long totalDiscountPrice;

    private Boolean cancellation;

    private Integer memberId;
    private Integer sellerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;


    public static ReservationDTO of(ReservationVO reservationVO){
        return ReservationDTO.builder()
                .resId(reservationVO.getResId())
                .itemCategory(reservationVO.getItemCategory())
                .totalPrice(reservationVO.getTotalPrice())
                .startDate(reservationVO.getStartDate())
                .endDate(reservationVO.getEndDate())
                .name(reservationVO.getName())
                .phone(reservationVO.getPhone())
                .totalDiscountPrice(reservationVO.getTotalDiscountPrice())
                .memberId(reservationVO.getMemberId())
                .sellerId(reservationVO.getSellerId())
                .cancellation(reservationVO.getCancellation())
                .createdAt(reservationVO.getCreatedAt())
                .updatedAt(reservationVO.getUpdatedAt())
                .build();
    }

    public ReservationVO toVO() {
        return ReservationVO.builder()
                .resId(resId)
                .itemCategory(itemCategory)
                .totalPrice(totalPrice)
                .startDate(startDate)
                .endDate(endDate)
                .name(name)
                .phone(phone)
                .totalDiscountPrice(totalDiscountPrice)
                .memberId(memberId)
                .sellerId(sellerId)
                .cancellation(cancellation)
                .build();
    }

}
