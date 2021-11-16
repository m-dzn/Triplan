package com.triplan.paging;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Criteria {

    // 현재 페이지 번호
    private int currentPageNo;

    // 페이지 당 출력할 데이터 개수
    private int recordsPerPage;

    // 화면 하단에 출력할 페이지 사이즈
    // 1~10까지의 페이지가 보이게 설정
    private int pageSize;

    // 검색 키워드
    private  String searchKeyword;

    // 검색 유형
    private String searchType;

    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 10;
        this.pageSize = 10;

    }
    // SQL구문에서 LIMIT구문 앞부분에 사용되는 메서드
    public int getStartPage() {
        return (currentPageNo - 1) * recordsPerPage;
    }

}
