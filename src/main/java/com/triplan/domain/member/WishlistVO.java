package com.triplan.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class WishlistVO {

    // 식별자 필드
    private Integer wishlistId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드

    // Default 값이 있는 NOT NULL 필드
    private LocalDateTime createdAt;

    // Nullable 필드

    // 외래키
    @NotNull
    private Integer itemGroupId;

    @NotNull
    private Integer memberId;

    @Builder
    public WishlistVO(Integer wishlistId, Integer itemGroupId, Integer memberId) {
        this.wishlistId = wishlistId;
        this.itemGroupId = itemGroupId;
        this.memberId = memberId;
    }

}
