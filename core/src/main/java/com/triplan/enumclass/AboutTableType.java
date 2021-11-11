package com.triplan.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AboutTableType {

    ITEM("/item"),
    BLOG("/blog"),
    ROOM("/room"),
    REVIEW("/review"),
    SELLER("/seller"),
    MEMBER("/member");

    private final String filePath;
}