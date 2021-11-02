package com.triplan.domain;

import com.triplan.enumclass.PersonalOrCompany;
import com.triplan.enumclass.ProductGroup;
import lombok.Data;

@Data
public class SellerVO {

    private Integer sellerId;
    private Integer memberId;
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
    private PersonalOrCompany personalOrCompany;

    public static void main(String[] args){
        SellerVO sellerVO = new SellerVO();

        sellerVO.setProductGroup(ProductGroup.Flight);
        sellerVO.setProductGroup(ProductGroup.Room);
        sellerVO.setProductGroup(ProductGroup.Package);

        sellerVO.setPersonalOrCompany(PersonalOrCompany.Personal);
        sellerVO.setPersonalOrCompany(PersonalOrCompany.Company);

        System.out.println(sellerVO.getProductGroup());
        System.out.println(sellerVO.getProductGroup().getCode());
        System.out.println(sellerVO.getProductGroup().getExplain());
        System.out.println();
        System.out.println(sellerVO.getPersonalOrCompany());
        System.out.println(sellerVO.getPersonalOrCompany().getExplain());


    }


}
