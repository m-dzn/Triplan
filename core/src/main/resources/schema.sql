CREATE TABLE `Member` (
	`member_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`email`	VARCHAR(50)	NOT NULL,
	`password`	VARCHAR(255)	NOT NULL,
	`nickname`	VARCHAR(20)	NOT NULL,
	`email_confirm`	TINYINT	NOT NULL	DEFAULT 0	COMMENT 'Boolean',
	`state`	VARCHAR(20)	NOT NULL	DEFAULT 'REGISTER',
	`grade`	VARCHAR(20)	NOT NULL	DEFAULT 'BRONZE',
	`provider`	VARCHAR(100)	NOT NULL	DEFAULT 'LOCAL'	COMMENT 'sns_info -> provider로 변경',
	`profile_img`	VARCHAR(200)	NULL,
	`point`	INT	NULL	DEFAULT 0	COMMENT 'Integer',
	`account`	VARCHAR(30)	NULL,
	`deleted_at`	TIMESTAMP	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `Seller` (
	`seller_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`business_license_number`	VARCHAR(30)	NOT NULL,
	`business_name`	VARCHAR(30)	NOT NULL,
	`tel`	VARCHAR(30)	NOT NULL,
	`owner_name`	VARCHAR(30)	NOT NULL,
	`email`	VARCHAR(50)	NOT NULL,
	`business_account`	VARCHAR(30)	NOT NULL,
	`privateBusiness`	TINYINT	NOT NULL	DEFAULT 0	COMMENT '11.05 변경 : Enum인 personal_or_company -> Boolean인 privateBusiness',
	`zip_code`	VARCHAR(100)	NOT NULL,
	`address`	VARCHAR(200)	NOT NULL,
	`address_detail`	VARCHAR(200)	NULL	COMMENT '11.05 추가',
	`seller_img`	VARCHAR(30)	NULL,
	`member_id`	INT	NOT NULL
);

CREATE TABLE `Item_Group` (
	`item_group_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`name`	VARCHAR(50)	NOT NULL,
	`summary_explain`	VARCHAR(1000)	NOT NULL,
	`detail_explain`	VARCHAR(1000)	NOT NULL,
	`item_category`	VARCHAR(45)	NOT NULL	COMMENT 'item_group -> item_category',
	`address`	VARCHAR(200)	NOT NULL,
	`address_detail`	VARCHAR(200)	NULL	COMMENT '11.05 추가',
	`item_img`	VARCHAR(200)	NULL,
	`detail_img`	VARCHAR(200)	NULL,
	`location`	VARCHAR(255)	NULL,
	`lat`	INT UNSIGNED	NULL,
	`lng`	INT UNSIGNED	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL,
	`seller_id`	INT	NOT NULL
);

CREATE TABLE `Item` (
	`item_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`name`	VARCHAR(45)	NOT NULL,
	`explain`	TEXT	NOT NULL,
	`item_category`	VARCHAR(20)	NOT NULL	COMMENT 'type -> item_category',
	`base_stock`	INT UNSIGNED	NULL	DEFAULT 0,
	`sales_volume`	INT UNSIGNED	NULL	DEFAULT 0,
	`detail_img`	VARCHAR(200)	NULL,
	`created_at`	TIMESTAMP	NOT NULL    DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL,
	`item_group_id`	INT	NOT NULL
);

CREATE TABLE `Flight` (
	`flight_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`departure`	VARCHAR(45)	NOT NULL,
	`destination`	VARCHAR(45)	NOT NULL,
	`flight_type`	VARCHAR(20)	NOT NULL,
	`seat_class`	VARCHAR(20)	NOT NULL,
	`min_age`	TINYINT UNSIGNED 	NULL	DEFAULT 0	COMMENT '11.06 추가',
	`max_age`	TINYINT UNSIGNED 	NULL	DEFAULT 127	COMMENT '11.06 추가',
	`item_id`	INT	NOT NULL
);

CREATE TABLE `Room` (
	`room_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`number_of_person`	INT	NOT NULL,
	`max_person`	INT	NOT NULL,
	`img`	VARCHAR(200)	NULL,
	`item_id`	INT	NOT NULL
);

CREATE TABLE `Payment` (
	`payment_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`type`	VARCHAR(20)	NOT NULL,
	`total_payment`	INT UNSIGNED	NOT NULL,
	`payment_deadline`	TIMESTAMP	NOT NULL,
	`state`	VARCHAR(20)	NOT NULL	DEFAULT 'UNPAID',
	`created_at`	TIMESTAMP	NOT NULL    DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL,
	`res_id`	INT	NOT NULL
);

CREATE TABLE `Question` (
	`question_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`title`	varchar(45)	NULL,
	`content`	text	NULL,
	`created_at`	TIMESTAMP	NOT NULL     DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL,
	`hide`	tinyint	NOT NULL	COMMENT 'Boolean',
	`member_id`	INT	NOT NULL	COMMENT 'Integer',
	`qna_category_id`	INT	NOT NULL	COMMENT 'Integer',
	`item_group_id`	INT	NOT NULL	COMMENT 'Integer'
);

CREATE TABLE `Review` (
	`review_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`content`	VARCHAR(1000)	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL,
	`updated_at`	TIMESTAMP	NULL,
	`review_score`	INT	NOT NULL	DEFAULT 0	COMMENT 'Boolean -> Enum으로 수정',
	`member_id`	VARCHAR(255)	NOT NULL,
	`item_id`	INT	NOT NULL
);

CREATE TABLE `Member_Role` (
	`member_id`	INT	NOT NULL	COMMENT 'AUTO_INCREMENT',
	`role_id`	INT	NOT NULL
);

CREATE TABLE `Role` (
	`role_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL
);

CREATE TABLE `Answer` (
	`question_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`content`	text	NULL
);

CREATE TABLE `QNA_Category` (
	`qna_category_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`inquirer`	varchar(45)	NOT NULL,
	`category_name`	VARCHAR(255)	NOT NULL
);

CREATE TABLE `Notice` (
	`notice_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`title`	VARCHAR(60)	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL,
	`content`	VARCHAR(1000)	NULL	COMMENT 'contents -> content로 수정',
	`target`	VARCHAR(20)	NOT NULL	COMMENT '11.05 추가'
);

CREATE TABLE `Reservation` (
	`res_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`item_category`	VARCHAR(30)	NOT NULL,
	`total_price`	INT UNSIGNED	NOT NULL,
	`start_date`	TIMESTAMP	NOT NULL,
	`end_date`	TIMESTAMP	NOT NULL,
	`name`	VARCHAR(45)	NOT NULL,
	`phone`	VARCHAR(45)	NOT NULL,
	`total_discount_price`	INT UNSIGNED	NULL	DEFAULT 0,
	`created_at`	TIMESTAMP	NOT NULL    DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL,
	`member_id`	INT	NOT NULL
);

CREATE TABLE `Tag` (
	`tag_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`color`	VARCHAR(20)	NULL,
	`name`	VARCHAR(255)	NULL,
	`icon`	VARCHAR(255)	NULL
);

CREATE TABLE `Item_Group_Tag` (
	`item_group_id`	INT	NOT NULL,
	`tag_id`	INT	NOT NULL
);

CREATE TABLE `Coupon` (
	`coupon_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`name`	VARCHAR(45)	NOT NULL,
	`num`	INT	NULL	COMMENT '쿠폰 등록시 입력하면 쿠폰 등록',
	`price`	INT UNSIGNED	NOT NULL,
	`condition`	VARCHAR(200)	NULL,
	`usage1`	TINYINT	NULL	COMMENT 'default 0(미사용) / 1(사용)',
	`item_id`	INT	NULL	COMMENT '예약 id Foreign key로 들고와서 조인해서 사용',
	`deadline`	TIMESTAMP	NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL	COMMENT 'ON UPDATE CURRENT_TIMESTAMP'
);

CREATE TABLE `Wishlist` (
	`wishlist_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`created_at`	TIMESTAMP	NOT NULL    DEFAULT CURRENT_TIMESTAMP,
	`item_id`	INT	NOT NULL	COMMENT 'Integer',
	`member_id`	INT	NOT NULL	COMMENT 'Integer'
);

CREATE TABLE `Attachment` (
	`attachment_id`	INT PRIMARY KEY AUTO_INCREMENT,
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
	`item_schedule_id`	INT PRIMARY KEY AUTO_INCREMENT,
	`price`	INT UNSIGNED	NOT NULL,
	`discount_price`	INT UNSIGNED	NULL	DEFAULT 0,
	`stock`	INT UNSIGNED	NOT NULL	DEFAULT 0	COMMENT '남은 재고수량',
	`start_date`	TIMESTAMP	NOT NULL,
	`end_date`	TIMESTAMP	NOT NULL,
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	TIMESTAMP	NULL,
	`item_id`	INT	NOT NULL
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

