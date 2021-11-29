package com.triplan.dto.response.customer;

import com.triplan.enumclass.item.ItemCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WishlistResponseDTO {

    private Integer wishlistId;
    private String name;
    private ItemCategory itemCategory;
    private String location;
    private Integer likeCount;
    private Integer reviewCount;
    private String itemImg;
    private LocalDateTime createdAt; // 찜 등록일

}
