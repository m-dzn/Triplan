package com.triplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }

}

1. core모듈에서 mappper vo 작업,,
2. 테이블 하나씩 맡으면 파일 안겹침,, 브랜치 하나로 가능?
서로 겹치지않는 다섯개의 파일 만들고 진행,,?
패키지명 패키지구조 안겹치게 정해야함
하



coer] vo mapper mapper.xml


짜야할거
회원 ㅇ
여행상품 ㅇ
객실 ㅇ
객실옵션 ㅇ
항공권
예약
결제
상품그룹
스토어
첨부파일

패키지명 만들고
패키지명이 어디 들어갈지
컨트롤러에서 crud구현

