package com.triplan.dto;

import com.triplan.domain.SellerVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
public class SellerDTO {

    @Positive
    private Integer sellerId;
    @NotBlank
    private String businessName;
    @NotBlank
    private String ownerName;
    private Boolean privateBusiness;
    private String sellerImg;

    public SellerVO toVO() {
        return SellerVO.builder()
                .sellerId(sellerId)
                .businessName(businessName)
                .ownerName(ownerName)
                .privateBusiness(privateBusiness)
                .sellerImg(sellerImg)
                .build();
    }

}
