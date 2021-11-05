package com.triplan.domain;

import com.triplan.enumclass.ItemType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
public class ItemGroupVO {

    private Integer itemGroupId;
    private Integer sellerId;
    private String summaryExplain;
    private String detailExplain;
    private String detailImg;
    private String itemImg;
    private String itemGroup;
    private ItemType type;
    private String address;
    private String time;
    private String selectOption;
    private Integer minPurchaseQuantity;
    private Integer starScore;
    private String thumbnailImg;
    private String companyForeignkey;
    private Integer lat;
    private Integer lng;
    private Integer location;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private List<ItemVO> itemvo;
}
