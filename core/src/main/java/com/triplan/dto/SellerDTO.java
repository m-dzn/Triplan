package com.triplan.dto;

import com.triplan.domain.SellerVO;
import com.triplan.enumclass.ProductGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SellerDTO {

    private Long sellerId;
    private Long memberId;
    private ProductGroup productGroup;
    private String businessLicenseNumber;
    private String businessName;
    private String tel;
    private String ownerName;
    private String address;
    private String zipCode;
    private String email;
    private String sellerImg;
    private String businessAccount;
    private boolean personalOrCompany;

    public static SellerDTO of (SellerVO sellerVO) {
        SellerDTO dto = new SellerDTO();
        dto.setSellerId(sellerVO.getSellerId());
        dto.setMemberId(sellerVO.getMemberId());
        dto.setProductGroup(sellerVO.getProductGroup());
        dto.setBusinessLicenseNumber(sellerVO.getBusinessLicenseNumber());
        dto.setBusinessName(sellerVO.getBusinessName());
        dto.setTel(sellerVO.getTel());
        dto.setOwnerName(sellerVO.getOwnerName());
        dto.setAddress(sellerVO.getAddress());
        dto.setZipCode(sellerVO.getZipCode());
        dto.setEmail(sellerVO.getEmail());
        dto.setSellerImg(sellerVO.getSellerImg());
        dto.setBusinessAccount(sellerVO.getBusinessAccount());
        dto.setPersonalOrCompany(sellerVO.isPersonalOrCompany());
        return dto;
    }

    public SellerVO toVO() {
        return SellerVO.builder()
                .sellerId(sellerId)
                .memberId(memberId)
                .productGroup(productGroup)
                .businessLicenseNumber(businessLicenseNumber)
                .businessName(businessName)
                .tel(tel)
                .ownerName(ownerName)
                .address(address)
                .zipCode(zipCode)
                .email(email)
                .sellerImg(sellerImg)
                .businessAccount(businessAccount)
                .personalOrCompany(personalOrCompany)
                .build();
    }
}
