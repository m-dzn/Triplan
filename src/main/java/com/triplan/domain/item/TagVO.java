package com.triplan.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TagVO {

    private Integer tagId;

    private String color;
    private String name;
    private String icon;

}
