package com.triplan.dto.response;

import com.triplan.enumclass.ItemCategory;
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
    private LocalDateTime createdAt; // 찜 등록일

}
