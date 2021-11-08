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
    private String businessLicenseNumber;
    private String businessName;
    private String tel;
    private String ownerName;
    private String email;
    private String businessAccount;
    private Boolean privateBusiness;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String sellerImg;
    private Integer memberId;

    public static SellerDTO of (SellerVO sellerVO) {
        SellerDTO dto = new SellerDTO();
        dto.setSellerId(sellerVO.getSellerId());
        dto.setBusinessLicenseNumber(sellerVO.getBusinessLicenseNumber());
        dto.setBusinessName(sellerVO.getBusinessName());
        dto.setTel(sellerVO.getTel());
        dto.setOwnerName(sellerVO.getOwnerName());
        dto.setEmail(sellerVO.getEmail());
        dto.setBusinessAccount(sellerVO.getBusinessAccount());
        dto.setPrivateBusiness(sellerVO.getPrivateBusiness());
        dto.setZipCode(sellerVO.getZipCode());
        dto.setAddress(sellerVO.getAddress());
        dto.setPrivateBusiness(sellerVO.getPrivateBusiness());
        dto.setSellerImg(sellerVO.getSellerImg());
        dto.setMemberId(sellerVO.getMemberId());

        return dto;
    }

    public SellerVO toVO() {
        return SellerVO.builder()
                .sellerId(sellerId)
                .businessLicenseNumber(businessLicenseNumber)
                .businessName(businessName)
                .tel(tel)
                .ownerName(ownerName)
                .email(email)
                .businessAccount(businessAccount)
                .privateBusiness(privateBusiness)
                .zipCode(zipCode)
                .address(address)
                .addressDetail(addressDetail)
                .sellerImg(sellerImg)
                .memberId(memberId)
                .build();
    }

}
