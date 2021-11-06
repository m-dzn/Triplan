package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemPrice {
    adult(0,"성인"),
    teenager(1,"청소년"),
    child(2,"소인");

    private Integer code;
    private String explain;
}
