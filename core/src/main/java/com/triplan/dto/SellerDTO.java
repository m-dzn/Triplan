package com.triplan.dto;

import com.triplan.domain.SellerVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SellerDTO {

    private Integer sellerId;
    private String businessName;
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
