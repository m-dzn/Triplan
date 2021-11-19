CREATE TABLE `Member` (
	`member_id`	INT AUTO_INCREMENT	NOT NULL,
	`email`	VARCHAR(50)	NOT NULL,
	`password`	VARCHAR(255)	NULL,
	`nickname`	VARCHAR(20)	NOT NULL,
	`email_confirm`	TINYINT	NOT NULL	DEFAULT 0	COMMENT 'Boolean',
	`state`	VARCHAR(20)	NOT NULL	DEFAULT 'REGISTER',
	`grade`	VARCHAR(20)	NOT NULL	DEFAULT 'BRONZE'	COMMENT 'grade_id로 바꿀지 생각해보기',
	`profile_img`	VARCHAR(255)	NULL,
	`point`	INT	NULL	DEFAULT 0	COMMENT 'Integer',
	`provider`	VARCHAR(100)	NOT NULL	DEFAULT 'LOCAL'	COMMENT 'sns_info -> provider로 변경',
	`account`	VARCHAR(30)	NULL,
	`deleted_at`	TIMESTAMP	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `Seller` (
	`seller_id`	INT AUTO_INCREMENT	NOT NULL,
	`business_license_number`	VARCHAR(30)	NOT NULL,
	`business_name`	VARCHAR(30)	NOT NULL,
	`tel`	VARCHAR(30)	NOT NULL,
	`owner_name`	VARCHAR(30)	NOT NULL,
	`email`	VARCHAR(50)	NOT NULL,
	`business_account`	VARCHAR(30)	NOT NULL,
	`private_business`	TINYINT	NOT NULL	DEFAULT 0	COMMENT '11.05 변경 : Enum인 personal_or_company -> Boolean인 privateBusiness',
	`zip_code`	VARCHAR(100)	NOT NULL,
	`address`	VARCHAR(200)	NOT NULL,
	`address_detail`	VARCHAR(200)	NULL	COMMENT '11.05 추가',
	`seller_img`	VARCHAR(255)	NULL	COMMENT '/seller/img/UUID.jpg <img src="/seller/img/UUID.jpg"/>',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`member_id`	INT	NOT NULL
);

CREATE TABLE `Item_Group` (
	`item_group_id`	INT AUTO_INCREMENT	NOT NULL,
	`name`	VARCHAR(50)	NOT NULL,
	`summary_explain`	VARCHAR(1000)	NOT NULL,
	`detail_explain`	VARCHAR(1000)	NOT NULL,
	`item_category`	VARCHAR(45)	NOT NULL	COMMENT 'item_group -> item_category',
	`address`	VARCHAR(200)	NOT NULL,
	`address_detail`	VARCHAR(200)	NULL	COMMENT '11.05 추가',
	`item_img`	VARCHAR(255)	NULL,
	`detail_img`	VARCHAR(255)	NULL,
	`location`	VARCHAR(255)	NULL,
	`lat`	INT UNSIGNED	NULL,
	`lng`	INT UNSIGNED	NULL,
	`like_count`	INT UNSIGNED	NULL	DEFAULT 0	COMMENT '11.08 추가',
	`review_count`	INT UNSIGNED	NULL	DEFAULT 0	COMMENT '11.17 추가',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`seller_id`	INT	NOT NULL
);

CREATE TABLE `Item` (
	`item_id`	INT AUTO_INCREMENT	NOT NULL,
	`name`	VARCHAR(45)	NOT NULL,
	`explain`	TEXT	NOT NULL,
	`item_category`	VARCHAR(20)	NOT NULL	COMMENT 'type -> item_category',
	`base_stock`	INT UNSIGNED	NULL	DEFAULT 0,
	`sales_volume`	INT UNSIGNED	NULL	DEFAULT 0,
	`detail_img`	VARCHAR(255)	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`item_group_id`	INT	NOT NULL
);

CREATE TABLE `Flight` (
	`flight_id`	INT AUTO_INCREMENT	NOT NULL,
	`departure`	VARCHAR(45)	NOT NULL,
	`destination`	VARCHAR(45)	NOT NULL,
	`flight_type`	VARCHAR(20)	NOT NULL,
	`seat_class`	VARCHAR(20)	NOT NULL,
	`min_age`	TINYINT UNSIGNED	NULL	DEFAULT 0	COMMENT '11.06 추가',
	`max_age`	TINYINT UNSIGNED	NULL	DEFAULT 127	COMMENT '11.06 추가 : h2는 127, MySQL은 255로 적용',
	`item_id`	INT	NOT NULL
);

CREATE TABLE `Room` (
	`room_id`	INT AUTO_INCREMENT	NOT NULL,
	`number_of_person`	INT	NOT NULL,
	`max_person`	INT	NOT NULL,
	`img`	VARCHAR(200)	NULL,
	`item_id`	INT	NOT NULL
);

CREATE TABLE `Payment` (
	`payment_id`	INT AUTO_INCREMENT	NOT NULL,
	`state`	VARCHAR(20)	NOT NULL	DEFAULT 'UNPAID',
	`type`	VARCHAR(30)	NOT NULL,
	`total_payment`	INT UNSIGNED	NOT NULL,
	`account_bank`	VARCHAR(20)	NULL,
	`account_number`	VARCHAR(20)	NULL,
	`payment_deadline`	TIMESTAMP	NULL,
	`paid_at`	TIMESTAMP	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`res_id`	INT	NOT NULL
);

CREATE TABLE `Question` (
	`question_id`	INT AUTO_INCREMENT	NOT NULL,
	`title`	VARCHAR(45)	NOT NULL,
	`content`	TEXT	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`hide`	TINYINT	NOT NULL	DEFAULT 0	COMMENT 'Boolean',
	`member_id`	INT	NOT NULL	COMMENT 'Integer',
	`qna_category_id`	INT	NULL	COMMENT 'Integer',
	`item_group_id`	INT	NULL	COMMENT 'Integer',
	`type`	VARCHAR(45)	NOT NULL
);

CREATE TABLE `Review` (
	`review_id`	INT AUTO_INCREMENT	NOT NULL,
	`content`	VARCHAR(1000)	NOT NULL,
	`review_score`	INT	NOT NULL	DEFAULT 0	COMMENT 'Boolean -> Enum으로 수정',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`member_id`	INT	NOT NULL,
	`item_id`	INT	NOT NULL,
	`review_img`	VARCHAR(200)	NULL
);

CREATE TABLE `Member_Role` (
	`member_id`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`role_id`	INT	NOT NULL
);

CREATE TABLE `Role` (
	`role_id`	INT AUTO_INCREMENT	NOT NULL,
	`name`	VARCHAR(20)	NOT NULL
);

CREATE TABLE `Answer` (
	`question_id`	INT	NOT NULL,
	`content`	text	NOT NULL
);

CREATE TABLE `QNA_Category` (
	`qna_category_id`	INT AUTO_INCREMENT	NOT NULL,
	`name`	VARCHAR(255)	NOT NULL
);

CREATE TABLE `Notice` (
	`notice_id`	INT AUTO_INCREMENT	NOT NULL,
	`title`	VARCHAR(60)	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`content`	VARCHAR(1000)	NOT NULL	COMMENT 'contents -> content로 수정',
	`target`	VARCHAR(20)	NOT NULL	COMMENT '11.05 추가'
);

CREATE TABLE `Reservation` (
	`res_id`	INT AUTO_INCREMENT	NOT NULL,
	`item_category`	VARCHAR(30)	NOT NULL,
	`total_price`	INT UNSIGNED	NOT NULL,
	`start_date`	TIMESTAMP	NOT NULL,
	`end_date`	TIMESTAMP	NOT NULL,
	`name`	VARCHAR(45)	NOT NULL,
	`phone`	VARCHAR(45)	NOT NULL,
	`total_discount_price`	INT UNSIGNED	NULL	DEFAULT 0,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`member_id`	INT	NOT NULL,
	`seller_id`	INT	NULL,
	`cancellation`	INT	NULL	DEFAULT 0	COMMENT '0(예약) / 1(취소)'
);

CREATE TABLE `Tag` (
	`tag_id`	INT AUTO_INCREMENT	NOT NULL,
	`color`	VARCHAR(20)	NULL,
	`name`	VARCHAR(255)	NULL,
	`icon`	VARCHAR(255)	NULL
);

CREATE TABLE `Item_Group_Tag` (
	`item_group_id`	INT	NOT NULL,
	`tag_id`	INT	NOT NULL
);

CREATE TABLE `Wishlist` (
	`wishlist_id`	INT AUTO_INCREMENT	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`item_group_id`	INT	NOT NULL	COMMENT 'Integer',
	`member_id`	INT	NOT NULL	COMMENT 'Integer'
);

CREATE TABLE `Attachment` (
	`attachment_id`	INT AUTO_INCREMENT	NOT NULL,
	`about_table_type`	VARCHAR(20)	NOT NULL,
	`id_in_table_type`	INT	NOT NULL,
	`origin_file_name`	VARCHAR(200)	NOT NULL,
	`server_file_name`	VARCHAR(40)	NOT NULL,
	`file_extension`	VARCHAR(10)	NOT NULL,
	`upload_path`	VARCHAR(45)	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`file_size`	INT UNSIGNED	NULL
);

CREATE TABLE `Reservation_Item` (
	`res_id`	INT	NOT NULL,
	`item_schedule_id`	INT	NOT NULL
);

CREATE TABLE `Item_Schedule` (
	`item_schedule_id`	INT AUTO_INCREMENT	NOT NULL,
	`price`	INT UNSIGNED	NOT NULL,
	`discount_price`	INT UNSIGNED	NULL	DEFAULT 0,
	`stock`	INT UNSIGNED	NOT NULL	DEFAULT 0	COMMENT '남은 재고수량',
	`start_date`	TIMESTAMP	NOT NULL,
	`end_date`	TIMESTAMP	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`item_id`	INT	NOT NULL
);

CREATE TABLE `Member_Coupon` (
	`member_coupon_id`	INT AUTO_INCREMENT	NOT NULL,
	`member_id`	INT	NOT NULL,
	`coupon_id`	INT	NOT NULL,
	`usage1`	TINYINT	NOT NULL	DEFAULT 0	COMMENT '0(미사용) / 1(사용 or 기한지남)',
	`used_at`	TIMESTAMP	NULL,
	`res_id`	INT	NULL	COMMENT 'Foreign Key(Reservation)'
);

CREATE TABLE `Coupon` (
	`coupon_id`	INT AUTO_INCREMENT	NOT NULL,
	`name`	VARCHAR(45)	NOT NULL,
	`num`	INT UNIQUE	NULL	COMMENT '쿠폰 등록시 입력하면 쿠폰 등록',
	`price`	INT UNSIGNED	NOT NULL,
	`condition`	VARCHAR(200)	NULL,
	`expired_at`	TIMESTAMP	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `Grade` (
	`grade`	VARCHAR(20)	NOT NULL,
	`min_payment`	INT	NULL,
	`max_payment`	INT	NULL
);

ALTER TABLE `Member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`member_id`
);

ALTER TABLE `Seller` ADD CONSTRAINT `PK_SELLER` PRIMARY KEY (
	`seller_id`
);

ALTER TABLE `Item_Group` ADD CONSTRAINT `PK_ITEM_GROUP` PRIMARY KEY (
	`item_group_id`
);

ALTER TABLE `Item` ADD CONSTRAINT `PK_ITEM` PRIMARY KEY (
	`item_id`
);

ALTER TABLE `Flight` ADD CONSTRAINT `PK_FLIGHT` PRIMARY KEY (
	`flight_id`
);

ALTER TABLE `Room` ADD CONSTRAINT `PK_ROOM` PRIMARY KEY (
	`room_id`
);

ALTER TABLE `Payment` ADD CONSTRAINT `PK_PAYMENT` PRIMARY KEY (
	`payment_id`
);

ALTER TABLE `Question` ADD CONSTRAINT `PK_QUESTION` PRIMARY KEY (
	`question_id`
);

ALTER TABLE `Review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`review_id`
);

ALTER TABLE `Member_Role` ADD CONSTRAINT `PK_MEMBER_ROLE` PRIMARY KEY (
	`member_id`,
	`role_id`
);

ALTER TABLE `Role` ADD CONSTRAINT `PK_ROLE` PRIMARY KEY (
	`role_id`
);

ALTER TABLE `Answer` ADD CONSTRAINT `PK_ANSWER` PRIMARY KEY (
	`question_id`
);

ALTER TABLE `QNA_Category` ADD CONSTRAINT `PK_QNA_CATEGORY` PRIMARY KEY (
	`qna_category_id`
);

ALTER TABLE `Notice` ADD CONSTRAINT `PK_NOTICE` PRIMARY KEY (
	`notice_id`
);

ALTER TABLE `Reservation` ADD CONSTRAINT `PK_RESERVATION` PRIMARY KEY (
	`res_id`
);

ALTER TABLE `Tag` ADD CONSTRAINT `PK_TAG` PRIMARY KEY (
	`tag_id`
);

ALTER TABLE `Item_Group_Tag` ADD CONSTRAINT `PK_ITEM_GROUP_TAG` PRIMARY KEY (
	`item_group_id`,
	`tag_id`
);

ALTER TABLE `Wishlist` ADD CONSTRAINT `PK_WISHLIST` PRIMARY KEY (
	`wishlist_id`
);

ALTER TABLE `Attachment` ADD CONSTRAINT `PK_ATTACHMENT` PRIMARY KEY (
	`attachment_id`
);

ALTER TABLE `Reservation_Item` ADD CONSTRAINT `PK_RESERVATION_ITEM` PRIMARY KEY (
	`res_id`,
	`item_schedule_id`
);

ALTER TABLE `Item_Schedule` ADD CONSTRAINT `PK_ITEM_SCHEDULE` PRIMARY KEY (
	`item_schedule_id`
);

ALTER TABLE `Member_Coupon` ADD CONSTRAINT `PK_MEMBER_COUPON` PRIMARY KEY (
	`member_coupon_id`,
	`member_id`,
	`coupon_id`
);

ALTER TABLE `Coupon` ADD CONSTRAINT `PK_COUPON` PRIMARY KEY (
	`coupon_id`
);

ALTER TABLE `Grade` ADD CONSTRAINT `PK_GRADE` PRIMARY KEY (
	`grade`
);

ALTER TABLE `Member_Role` ADD CONSTRAINT `FK_Member_TO_Member_Role_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `Member` (
	`member_id`
);

ALTER TABLE `Member_Role` ADD CONSTRAINT `FK_Role_TO_Member_Role_1` FOREIGN KEY (
	`role_id`
)
REFERENCES `Role` (
	`role_id`
);

ALTER TABLE `Answer` ADD CONSTRAINT `FK_Question_TO_Answer_1` FOREIGN KEY (
	`question_id`
)
REFERENCES `Question` (
	`question_id`
);

ALTER TABLE `Item_Group_Tag` ADD CONSTRAINT `FK_Item_Group_TO_Item_Group_Tag_1` FOREIGN KEY (
	`item_group_id`
)
REFERENCES `Item_Group` (
	`item_group_id`
);

ALTER TABLE `Item_Group_Tag` ADD CONSTRAINT `FK_Tag_TO_Item_Group_Tag_1` FOREIGN KEY (
	`tag_id`
)
REFERENCES `Tag` (
	`tag_id`
);

ALTER TABLE `Reservation_Item` ADD CONSTRAINT `FK_Reservation_TO_Reservation_Item_1` FOREIGN KEY (
	`res_id`
)
REFERENCES `Reservation` (
	`res_id`
);

ALTER TABLE `Reservation_Item` ADD CONSTRAINT `FK_Item_Schedule_TO_Reservation_Item_1` FOREIGN KEY (
	`item_schedule_id`
)
REFERENCES `Item_Schedule` (
	`item_schedule_id`
);

ALTER TABLE `Member_Coupon` ADD CONSTRAINT `FK_Member_TO_Member_Coupon_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `Member` (
	`member_id`
);

ALTER TABLE `Member_Coupon` ADD CONSTRAINT `FK_Coupon_TO_Member_Coupon_1` FOREIGN KEY (
	`coupon_id`
)
REFERENCES `Coupon` (
	`coupon_id`
);
