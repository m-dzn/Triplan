package com.triplan.domain.item;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemGroupTagVO {

    private Integer itemGroupId;
    private Integer tagId;

}
