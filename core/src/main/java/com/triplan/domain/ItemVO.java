package com.triplan.domain;

import com.triplan.enumclass.ItemPrice;
import com.triplan.enumclass.ItemType;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.sql.Timestamp;

@Data
@Log4j2
public class ItemVO {
    private int itemId;
    private int itemGroupId;
    private int location;
    private Timestamp startDay;
    private Timestamp endDay;
    private ItemPrice price; // 성인, 청소년, 소인
    private ItemType type; // 객실, 패키지, 항공권
    private int totalStock;
    private int totalSalesCount;
    private String introduce;
    private String detailImg;
    private int discountPrice;
    private String itemName;
}
