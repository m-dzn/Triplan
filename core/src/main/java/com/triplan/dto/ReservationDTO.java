package com.triplan.dto;

import com.triplan.domain.ReservationVO;
import com.triplan.enumclass.ItemCategory;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@ToString
public class ReservationDTO {

    private Integer resId;
    private ItemCategory itemCategory;
    private Long totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String name;
    private String phone;
    private Long totalDiscountPrice;

    private Integer memberId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    public static ReservationDTO of (ReservationVO reservationVO) {
        ReservationDTO dto = new ReservationDTO();
        dto.setResId(reservationVO.getResId());
        dto.setItemCategory(reservationVO.getItemCategory());
        dto.setTotalPrice(reservationVO.getTotalPrice());
        dto.setStartDate(reservationVO.getStartDate());
        dto.setEndDate(reservationVO.getEndDate());
        dto.setName(reservationVO.getName());
        dto.setPhone(reservationVO.getPhone());
        dto.setMemberId(reservationVO.getMemberId());
        dto.setCreatedAt(reservationVO.getCreatedAt());
        dto.setUpdatedAt(reservationVO.getUpdatedAt());

        return dto;
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
                .build();
    }

}
