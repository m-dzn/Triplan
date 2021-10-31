package com.triplan.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ItemVO {
    private int itemId;
    private int itemGroupId;
    private int location;
    private Timestamp startDay;
    private Timestamp endDay;
    private int price;
    private String type;
    private int totalStock;
    private int totalSalesCount;
    private String introduce;
    private String detailImg;
    private int discountPrice;
    private String itemName;
}
