INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_SELLER');
INSERT INTO role (name) VALUES ('ROLE_USER');

INSERT INTO member (email, password, nickname)
VALUES ('user@gmail.com', '1111', '사용자1');

INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, address, member_id)
VALUES ('1', 'Com. Trip', '010-1111-1111', '손명진', 'smj@gmail.com', '00-000-0000', '000-00', '부산광역시 부산진구', 1);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id)
VALUES ('부산 해운대 하얏트 호텔', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 1);

INSERT INTO room (number_of_person, max_person, item_id)
VALUES (3, 5, 1);

INSERT INTO reservation (item_category, total_price, start_date, end_date, name, phone, member_id, seller_id)
VALUES ('ROOM', 50000, '2021-11-1T01:01:01', '2021-12-31T23:59:59', '양경호', '010-9999-9999', 1, 1);

INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (50000, 1, '2021-11-1T01:01:01', '2021-12-31T23:59:59', 1);

INSERT INTO reservation_item (res_id, item_schedule_id)
VALUES (1, 1);

INSERT INTO coupon(name, num, price, condition, expired_at)
VALUES ('쿠폰1', 1234, 1000, '숙박대전 이벤트', '2021-12-10T12:00:00');

INSERT INTO member_coupon (member_id, coupon_id)
VALUES (1, 1);

insert into notice (title, created_at, updated_at, content, target)
values ('제목', '2021-11-09T17:00:00', '2021-11-09T17:00:00', '내용', 'SELLER');

insert into notice (title, created_at, updated_at, content, target)
values ('제목', '2021-11-15T17:00:00', '2021-11-15T17:00:00', '내용', 'MEMBER');

/* Flight 아이템 그룹 (식별자: 2번) */
INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id)
VALUES ('에어 부산 김해 -> 김포', '안내사항 요약', '상세 안내사항', 'FLIGHT', '부산광역시 해운대구', 1);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('소인', '0세 ~ 12세', 'FLIGHT', 2);

INSERT INTO flight (departure, destination, flight_type, seat_class, item_id)
VALUES ('부산', '서울', 'ONE_WAY', 'ECONOMY', 2);

INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의1', '테스트 문의 내용', 0, 1, 'CUSTOMER');
INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의2', '테스트 문의 내용', 0, 1, 'CUSTOMER');
INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의3', '테스트 문의 내용', 0, 1, 'CUSTOMER');
INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의4', '테스트 문의 내용', 0, 1, 'CUSTOMER');

/*Grade 그룹*/

INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('BRONZE', 0,100000);

INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('SILVER', 100001,300000);

INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('GOLD', 300001, 500000);

INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('PLATINUM', 500001, 2100000000);