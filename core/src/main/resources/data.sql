INSERT INTO role (name) VALUES ('ROLE_ADMIN');
INSERT INTO role (name) VALUES ('ROLE_SELLER');
INSERT INTO role (name) VALUES ('ROLE_USER');

INSERT INTO member (email, password, nickname)
VALUES ('user@gmail.com', '1111', '사용자1');

INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, address, member_id)
VALUES ('1', 'Com. Trip', '010-1111-1111', '손명진', 'smj@gmail.com', '00-000-0000', '000-00', '부산광역시 부산진구', 1);


INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, like_count, review_count,seller_id)
VALUES ('더미1 호텔', '더미1 호텔', '더미 1', 'ROOM', '더미1',1,2, 1);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, like_count, review_count,seller_id)
VALUES ('더미2 호텔', '더미2 호텔', '더미 2', 'ROOM', '더미2',10,200, 1);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, like_count, review_count,seller_id)
VALUES ('더미3 호텔', '더미3 호텔', '더미 3', 'ROOM', '더미3',100,20000, 1);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, like_count, review_count,seller_id)
VALUES ('더미4 호텔', '더미4 호텔', '더미 4', 'ROOM', '더미4',1000,20, 1);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, like_count, review_count,seller_id)
VALUES ('더미5 호텔', '더미5 호텔', '더미 5', 'ROOM', '더미5',10000,2000, 1);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 1 객실', '더미 1 객실', 'ROOM', 1);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 1 객실-2', '더미 1 객실-2', 'ROOM', 1);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 2 객실', '더미 2 객실', 'ROOM', 2);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 2 객실-2', '더미 2 객실-2', 'ROOM', 2);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 3 객실', '더미 3 객실', 'ROOM', 3);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 3 객실-2', '더미 3 객실-2', 'ROOM', 3);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 4 객실', '더미 4 객실', 'ROOM', 4);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 4 객실-2', '더미 4 객실-2', 'ROOM', 4);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 5 객실', '더미 5 객실', 'ROOM', 5);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('더미 5 객실-2', '더미 5 객실-2', 'ROOM', 5);

INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 1);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 2);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 3);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 4);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 5);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 6);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 7);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 8);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 9);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (5, 5, 10);

INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (30000, 1, '2021-01-1T01:01:01', '2021-06-30T23:59:59', 1);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (40000, 1, '2021-02-1T01:01:01', '2021-07-31T23:59:59', 2);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (50000, 1, '2021-03-1T01:01:01', '2021-08-30T23:59:59', 3);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (60000, 1, '2021-04-1T01:01:01', '2021-09-30T23:59:59', 4);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (70000, 1, '2021-05-1T01:01:01', '2021-10-31T23:59:59', 5);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (80000, 1, '2021-06-1T01:01:01', '2021-11-30T23:59:59', 6);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (90000, 1, '2021-07-1T01:01:01', '2021-12-31T23:59:59', 7);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (100000, 1, '2021-08-1T01:01:01', '2022-01-31T23:59:59',8);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (110000, 1, '2021-09-1T01:01:01', '2022-02-28T23:59:59', 9);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (120000, 1, '2021-10-1T01:01:01', '2022-03-31T23:59:59', 10);

INSERT INTO reservation (item_category, total_price, start_date, end_date, name, phone, member_id, seller_id)
VALUES ('ROOM', 50000, '2021-11-1T01:01:01', '2021-12-31T23:59:59', '양경호', '010-9999-9999', 1, 1);

INSERT INTO reservation_item (res_id, item_schedule_id)
VALUES (1, 1);

/* Tag 그룹 */
INSERT INTO Tag (color,name,icon)
VALUES('#ffdbdb','조식','1번');
INSERT INTO Tag (color,name,icon)
VALUES('#ffeddb','주차가능','2번');
INSERT INTO Tag (color,name,icon)
VALUES('#ffffdb','객실내흡연','3번');
INSERT INTO Tag (color,name,icon)
VALUES('#edffdb','와이파이','4번');
INSERT INTO Tag (color,name,icon)
VALUES('#dbffdb','픽업','5번');
INSERT INTO Tag (color,name,icon)
VALUES('#dbffed','수영장','6번');
INSERT INTO Tag (color,name,icon)
VALUES('#dbffff','스파','7번');
INSERT INTO Tag (color,name,icon)
VALUES('#dbedff','피트니스','8번');
INSERT INTO Tag (color,name,icon)
VALUES('#dbdbff','매점','9번');
INSERT INTO Tag (color,name,icon)
VALUES('#eddbff','유아시설','10번');
INSERT INTO Tag (color,name,icon)
VALUES('#ffdbff','마감임박','11번');
INSERT INTO Tag (color,name,icon)
VALUES('#ffdbed','시즌이벤트','12번');
/* Tag_Group */
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(1,1);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(1,2);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(1,3);

INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(2,3);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(2,4);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(2,5);

INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(3,5);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(3,6);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(3,7);

INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(4,7);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(4,8);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(4,9);

INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(5,9);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(5,10);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(5,11);



/* Flight 아이템 그룹 (식별자: 2번) */
/*payment*/
INSERT INTO payment
VALUES (1, 'CELL_PHONE', 100, '2021-11-9T01:01:01', 'PAID' ,'2021-11-9T01:01:01', '2021-11-9T01:01:01', '2021-11-9T01:01:01', 1);


INSERT INTO payment
VALUES (2, 'CELL_PHONE', 100, '2021-11-9T01:01:01', 'PAID' ,'2021-11-8T01:01:01', '2021-11-9T01:01:01', '2021-11-9T01:01:01', 1);


INSERT INTO payment
VALUES (3, 'CELL_PHONE', 100, '2021-11-9T01:01:01', 'PAID' ,'2021-11-2T01:01:01', '2021-11-9T01:01:01', '2021-11-9T01:01:01', 1);

INSERT INTO payment
VALUES (4, 'CELL_PHONE', 100, '2021-11-9T01:01:01', 'PAID' ,'2021-10-8T01:01:01', '2021-11-9T01:01:01', '2021-11-9T01:01:01', 1);

INSERT INTO payment
VALUES (5, 'CELL_PHONE', 100, '2021-11-9T01:01:01', 'PAID' ,'2021-11-9T01:01:01', '2021-11-9T01:01:01', '2021-11-9T01:01:01', 1);

INSERT INTO payment
VALUES (6, 'CELL_PHONE', 100, '2021-11-9T01:01:01', 'PAID' ,'2021-11-9T01:01:01', '2021-11-9T01:01:01', '2021-11-9T05:01:01', 1);