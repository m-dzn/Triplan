package com.triplan.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PageVO {

    private Integer cnt;
    private Integer pageSize;
    private String pageNum;
    private Integer currentPage;
    private Integer startRow;
    private Integer endRow;
    private Integer pageBlock;
    private Integer startPage;
    private Integer endPage;
    private Integer pageCount;

}
