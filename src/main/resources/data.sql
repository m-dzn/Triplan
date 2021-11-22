INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('SELLER');
INSERT INTO role (name) VALUES ('MEMBER');

/*
    디스플레이용 데이터
*/
/* 회원 정보 */
/* [ADMIN 1명] */

INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('admin01@gmail.com', 'Itwill1234*', '맹진스쿨', 'REGISTER', 'BRONZE', 'LOCAL' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (1,1);

/* [SELLER 10명] */

INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller01@gmail.com', 'Itwill1234*', '양경호호닭발', 'REGISTER', 'BRONZE', 'LOCAL' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (1,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller02@gmail.com', 'Itwill1234*', '양경호식이두마리치킨', 'REGISTER', 'SILVER', 'GOOGLE' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (2,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller03@gmail.com', 'Itwill1234*', '윤경록녹치x', 'REGISTER', 'GOLD', 'NAVER' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (3,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller04@gmail.com', 'Itwill1234*', '양경호이짜', 'REGISTER', 'PLATINUM', 'KAKAO' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (4,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller05@gmail.com', 'Itwill1234*', '손명진진자라자라', 'UNREGISTER', 'BRONZE', 'KAKAO' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (5,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller06@gmail.com', 'Itwill1234*', '이민잼민이', 'UNREGISTER', 'SILVER', 'NAVER' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (6,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller07@gmail.com', 'Itwill1234*', '양경록', 'UNREGISTER', 'GOLD', 'GOOGLE' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (7,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller08@gmail.com', 'Itwill1234*', '양경호곡쓰', 'UNREGISTER', 'PLATINUM', 'LOCAL' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (8,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('seller09@gmail.com', 'Itwill1234*', '손명진또배기', 'PAUSE', 'BRONZE', 'LOCAL' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (9,2);


INSERT INTO `member` (email, password, nickname,state,grade,provider, profile_img)
VALUES ('seller10@gmail.com', 'Itwill1234*', '이민재첩국호로록', 'PAUSE', 'SILVER', 'GOOGLE', '/member/파일명.jpg' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (10,2);

/* [MEMER 12명]*/

INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user01@gmail.com', 'Itwill1234*', 'daoljjang96', 'REGISTER', 'BRONZE', 'LOCAL' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (1,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user02@gmail.com', 'Itwill1234*', 'haruloveforever', 'REGISTER', 'SILVER', 'GOOGLE' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (2,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user03@gmail.com', 'Itwill1234*', '하루뿌LF', 'REGISTER', 'GOLD', 'NAVER' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (3,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user04@gmail.com', 'Itwill1234*', 'harudaolmom', 'REGISTER', 'PLATINUM', 'KAKAO' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (4,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user05@gmail.com', 'Itwill1234*', 'S2하l연S2', 'UNREGISTER', 'BRONZE', 'KAKAO' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (5,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user06@gmail.com', 'Itwill1234*', '정희lalaland', 'UNREGISTER', 'SILVER', 'NAVER' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (6,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user07@gmail.com', 'Itwill1234*', '하zle', 'UNREGISTER', 'GOLD', 'GOOGLE' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (7,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user08@gmail.com', 'Itwill1234*', '터l트1zzanG', 'UNREGISTER', 'PLATINUM', 'LOCAL' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (8,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user09@gmail.com', 'Itwill1234*', 'tett1jjang', 'PAUSE', 'BRONZE', 'LOCAL' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (9,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user10@gmail.com', 'Itwill1234*', '지혀l꼰듀', 'PAUSE', 'SILVER', 'GOOGLE' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (10,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user11@gmail.com', 'Itwill1234*', 'css천자l', 'PAUSE', 'GOLD', 'NAVER' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (11,3);


INSERT INTO `member` (email, password, nickname,state,grade,provider)
VALUES ('user12@gmail.com', 'Itwill1234*', 'gwakbyeongdu', 'PAUSE', 'PLATINUM', 'KAKAO' );
--------------------------------------------------------------------
INSERT INTO member_role (member_id, role_id)
VALUES (12,3);

/* 회원 등급 정보 */
INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('BRONZE', 0,100000);

INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('SILVER', 100001,300000);

INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('GOLD', 300001, 500000);

INSERT INTO grade (grade, min_payment, max_payment)
VALUES ('PLATINUM', 500001, 2100000000);


/* 쿠폰 정보 */
INSERT INTO coupon (`name`, num, price, `condition`, expired_at)
VALUES ('가입축하 3천원 할인쿠폰', 10000001, 3000, '발급일 1달 이내 사용 가능', '2021-12-23T23:59:59');

INSERT INTO coupon (`name`, num, price, `condition`, expired_at)
VALUES ('깜짝! 오늘만 5천원 할인쿠폰', 10000002, 5000, '발급일 기준 24시 전까지 사용 가능', '2021-12-31T23:59:59');

INSERT INTO coupon (`name`, num, price, `condition`, expired_at)
VALUES ('친구 초대왕! 2만원 할인쿠폰', 10000003, 20000, '친구 10명 초대시 발급, 발급일 1년 이내 사용 가능', '2022-11-23T23:59:59');

INSERT INTO coupon (`name`, num, price, `condition`, expired_at)
VALUES ('이달의 출석왕! 1만원 할인쿠폰', 10000004, 10000, '발급된 달에만 사용 가능(11월 발급 -> 11월 내에 사용)', '2021-11-30T23:59:59');

INSERT INTO coupon (`name`, num, price,`condition`, expired_at)
VALUES ('이메일/SNS 구독 이벤트 - 5천원 할인쿠폰', 10000005, 5000, '발급일 6년 이내 사용 가능 ', '2021-05-23T23:59:59');

INSERT INTO coupon (name, num, price, condition, expired_at)
VALUES ('name', 11, 22, 'condition', '2021-12-31T23:59:59');


/* 상품 그룹 Tag 정보 */
INSERT INTO tag (color, `name`, checked)
VALUES ('#ffdbdb', '조식', '#ff9e9e');

INSERT INTO tag (color, `name`, checked)
VALUES ('#ffeddb', '주차가능', '#ffcf9e');

INSERT INTO tag (color, `name`, checked)
VALUES ('#ffffdb', '객실 내 흡연', '#ffff9e');

INSERT INTO tag (color, `name`, checked)
VALUES ('#edffdb', '와이파이', '#cfff9e');

INSERT INTO tag (color, `name`, checked)
VALUES ('#dbffdb', '픽업', '#9eff9e');

INSERT INTO tag (color, `name`, checked)
VALUES ('#dbffed', '수영장', '#9effcf');

INSERT INTO tag (color, `name`, checked)
VALUES ('#dbffff', '스파', '#9effff');

INSERT INTO tag (color, `name`, checked)
VALUES ('#dbedff', '피트니스', '#9ecfff');

INSERT INTO tag (color, `name`, checked)
VALUES ('#dbdbff', '매점', '#9e9eff');

INSERT INTO tag (color, `name`, checked)
VALUES ('#eddbff', '유아시설', '#cf9eff');


/* 결제 정보 */
INSERT INTO payment
(`TYPE`, TOTAL_PAYMENT , STATE , PAID_AT , CREATED_AT , UPDATED_AT , RES_ID )
VALUES ('CREDIT_CARD', 50000, 'PAID', '2021-11-17T12:13:33', '2021-11-17T12:13:33', '2021-11-17T12:13:33', 1);

INSERT INTO payment
(`TYPE`, TOTAL_PAYMENT , STATE , PAID_AT , CREATED_AT , UPDATED_AT, RES_ID )
VALUES ('CREDIT_CARD', 170000, 'PAID', '2021-11-25T10:00:23', '2021-11-25T10:00:23', '2021-11-25T10:00:23', 7);

INSERT INTO payment
(`TYPE`, account_bank, account_number, total_payment, payment_deadline, state, created_at, updated_at, res_id)
VALUES ('TRANSFER_WITHOUT_ACCOUNT', '케이뱅크', '70112004110417', 100000, '2021-12-17T14:59:59', 'UNPAID', '2021-11-17T12:25:33', '2021-11-17T12:25:33', 2);

INSERT INTO payment
(`TYPE`, account_bank, account_number, total_payment, payment_deadline, state, paid_at, created_at, updated_at, res_id)
VALUES ('TRANSFER_WITHOUT_ACCOUNT', '신한(조흥)은행', '56211103867610', 130000, '2021-11-30T14:59:59', 'PAID', '2021-11-20T08:17:13', '2021-11-18T07:00:33', '2021-11-20T08:17:13', 3);

INSERT INTO payment
(`TYPE`, TOTAL_PAYMENT , STATE , PAID_AT, CREATED_AT , UPDATED_AT , RES_ID )
VALUES ('CELL_PHONE', 35000, 'PAID', '2021-11-18T09:33:40', '2021-11-18T09:33:40', '2021-11-18T09:33:40', 4);

INSERT INTO payment
(`TYPE`, TOTAL_PAYMENT , STATE , PAID_AT, CREATED_AT , UPDATED_AT , RES_ID )
VALUES ('NAVER_PAY', 55000, 'PAID', '2021-11-20T18:48:23', '2021-11-20T18:48:23', '2021-11-20T18:48:23', 5);

INSERT INTO payment
(`TYPE`, TOTAL_PAYMENT , STATE , PAID_AT, CREATED_AT , UPDATED_AT , RES_ID )
VALUES ('KAKAO_PAY', 240000, 'PAID', '2021-11-20T22:10:30', '2021-11-20T22:10:30', '2021-11-20T22:10:30', 6);


/* 예약 정보 */
INSERT INTO reservation
(item_category, total_price, start_date, end_date, `name`, phone, created_at, member_id, seller_id)
VALUES
('ROOM', 50000, '2021-11-20T01:01:01', '2021-11-21T23:59:59', '오해연', '010-4320-1966', '2021-11-17T12:13:33',22, 2);

INSERT INTO reservation
(item_category, total_price, start_date, end_date, `name`, phone, created_at, member_id, seller_id)
VALUES
('ROOM', 100000, '2021-11-19T01:01:01', '2021-11-21T23:59:59', '김도연', '010-7442-9806', '2021-11-17T12:25:33', 10, 10);

INSERT INTO reservation
(item_category, total_price, start_date, end_date, `name`, phone, created_at, member_id, seller_id)
VALUES
('ROOM', 130000, '2021-11-20T01:01:01', '2021-11-21T23:59:59', '김지혜', '010-5332-4885', '2021-11-18T07:00:33', 23, 11);

INSERT INTO reservation
(item_category, total_price, start_date, end_date, `name`, phone, created_at, member_id, seller_id)
VALUES
('ROOM', 35000, '2021-12-5T01:01:01', '2021-12-6T23:59:59', '김혜빈', '010-3922-1068', '2021-11-18T09:33:40', 12, 2);

INSERT INTO reservation
(item_category, total_price, start_date, end_date, `name`, phone, created_at, member_id, seller_id)
VALUES
('ROOM', 55000, '2021-11-29T01:01:01', '2021-11-30T23:59:59', '조하린', '010-5252-8282', '2021-11-20T18:48:23', 13, 5);

INSERT INTO reservation
(item_category, total_price, start_date, end_date, `name`, phone, created_at, member_id, seller_id)
VALUES
('ROOM', 240000, '2021-12-24T01:01:01', '2021-12-25T23:59:59', '송나인', '010-5042-1433', '2021-11-20T22:10:30', 17, 8);

INSERT INTO reservation
(item_category, total_price, start_date, end_date, `name`, phone, created_at, updated_at, member_id, seller_id, cancellation)
VALUES
('ROOM', 170000, '2021-12-30T01:01:01', '2021-12-31T23:59:59', '정희라', '010-3946-5420', '2021-11-25T10:00:23', '2021-11-30T10:00:23', 20, 12, 1);


/* 리뷰 정보 */
INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '1',
	'호기심에 시작한 여행이였는데ㅠ날씨도 좋고 힐링되고 정말 좋았어요
	시간 때문에 여행하려다 포기하고 이사온뒤로 어디 놀러가질못했는데 정말 좋았어요
	또 갈거예요!!><',
	'10', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '2',
	'공기좋고 경치좋고 깨끗한 룸에서 잘먹고 잘놀다 갑니다. 종종 이용하고 싶어요!',
	'9', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '3',
	'합리적인 가격에 객실도 괜찮았어요 조식은 별로였지만... 이용 잘했어요!',
	'9', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '4',
	'서비스가 별로입니다. 가격만 싸고, 다음에는 안 올 것 같아요',
	'3', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '5', '크게 기대하지않았는데 참 좋았습니다.', '10', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '6', '이번에 엄마 환갑으로 방문했었는데 너무 좋았습니다:)', '10', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '7',
	'결제할 당시의 금액 10만원은 조금 부담스러웠지만 투어를 마치고 나서의 10만원은 결코 아깝지않은 가격이었습니다. 적극 추천해요.',
	 '10', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '8', '직원이 불친철해요. 객실도 더러워요', '1', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '9', '비가 오고 날이 흐려서 걱정했는데 사람 적고 고즈넉한 길을 찾아다녀서 좋은 경험이었습니다ㅎ',
	'9', '1', '1' );

INSERT INTO review (review_id, `content`, review_score, member_id, item_group_id )
VALUES ( '10', '혼자 보기에도 아주 좋아요!!', '10', '1', '1' );


/* 문의 정보 */
INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('전화번호 변경 어떻게해요?', '전화번호 바꼈는데 변경하고 싶어요', 0, 1, 'CUSTOMER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('이름 개명했는데 이름 어떻게 바꿔요', '이름 바꼈어요ㅜㅜ 이 계정에서도 바꾸고 싶은데 방법이 어떻게 되나요ㅠㅠ', 0, 2, 'CUSTOMER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('마일리지 관련 문의', '예약 취소했는데 마일리지 다시 들어오지 않아요 어떻게해요 ㅜㅜ', 1, 3, 'CUSTOMER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('예약 취소 하고 싶은데 어케요;', '예약 취소하고 싶어요 방법 뭐예요', 0, 4, 'SELLER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('결제 수단 변경해도 되나요?', '계좌 변경하고 싶은데 방법 없나요?ㅜㅜ', 0, 5, 'SELLER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('탈퇴하고 싶은데 어떻게 하나요?', '탈퇴경로 알려주세요', 0, 6, 'CUSTOMER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('상품 취소 하고싶은데 어떻게 해요?', '취소해주셨으면 해요', 1, 7, 'SELLER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('여행상품 환불관련 문의', '환불했는데 돈 언제 들어와요?', 1, 8, 'SELLER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('상품 관련 문의', '쿠폰 새로 생겨서 그런데 결제 취소하고 방 스위트룸으로 바꿔줄 수 있나요?', 1, 9, 'SELLER');

INSERT INTO question (`title`, `content`, `hide`, member_id, `type`)
VALUES ('계좌 관련 문의', '연결계좌 바꾸고 싶어요', 1, 10, 'CUSTOMER');


/* 공지 사항 */
/* [ SELLER전용 공지사항 10개 ] */
INSERT INTO notice (`title`, `content`, `target`)
VALUES ('접수된 문의 건 처리 방법', '[문의관리] 메뉴로 접속해 답글을 등록합니다','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('고객문의 답변 수정 방법','[문의관리]>고객문의 관리 에서 답변 수정 가능합니다.','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('문의 템플릿 안내','문의 템플릿을 이용해 구매자들이 자주 묻는 질문에 대해 미리 답변을 등록해 놓을 수 있습니다.','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('고객 문의 접수에 대한 답변의 건','구매자가 오래 기다리지 않도록 최대 2일 이내에 답변해 주세요.','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('리뷰 욕설, 비방글 삭제 요청','신고 처리 가능하니 신고해주세요.','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('베스트리뷰의 선정 제한 기준','이벤트당 동일 작성자의 리뷰는 한 건만 선정 가능','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('리뷰 블라인드 처리 조치의 건','비정상적이거나 허위로 작성된 리뷰로 의심되는 경우 사전 통보 없이 게시글을 삭제하거나 열람이 제한될 수 있음을 참고해주시기 바랍니다.','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('반품 요청 건 처리 방법','반품 승인(환불) 방법 설명, 반품 거부(철회) 방법 설명','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('정산 기준 및 정산 입금 시간','상황별 자동 구매확정 소요일 안내','SELLER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('고객혜택 등록 방법','혜택을 제공할 상품과 혜택 기간을 설정하시면 쿠폰 제공 및 포인트 적립이 가능합니다.','SELLER');

/* [ MEMBER전용 공지사항 10개 ] */
INSERT INTO notice (`title`, `content`, `target`)
VALUES ('코로나바이러스감염증-여행정보 변동사항','[충청도] 2021 금산 인삼축제 행사 취소','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('베스트 후기 이벤트 일시 중단 안내','코로나19로 인하여 잠시 쉬어가고자 합니다.','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('놀이공원 할인대전','사전이벤트 당첨여부를 확인해 보세요!','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('소멸 포인트 유효기간 연장 안내','기존 : 적립일로부터 1년, 변경 : 적립일로부터 2년','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('인스타그램 이벤트 안내','멋진 여행사진을 제보해주세요. 선정되신 3분에겐 경품을 드립니다.','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('노선별 정상 운항 항공일정 안내','노선별 항공 운항 스케줄 안내표','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('친구 추천 이벤트 안내','추천한 회원, 추천 받은 회원 모두 2,000P 적립','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('친구 추천 이벤트 당첨자 발표','이벤트 당첨자 명단과 경품 내용입니다.','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('예약 서비스 일시 중단 안내',' 2021. 11. 20 09:00 ~ 15:00 (6시간) 예약 서비스의 개편 작업으로 인해 서비스의 이용이 일시 중단될 예정입니다.','MEMBER');

INSERT INTO notice (`title`, `content`, `target`)
VALUES ('약관(이용약관, 멤버스약관) 및 개인정보 관련 변경안내','개정사유 : 회원가입 방식 변경','MEMBER');


/* 판매자 정보 */
INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, `address`, member_id)
VALUES ('1', 'Com. Trip', '010-1111-1111', '손명진', 'smj@gmail.com', '00-000-0000', '000-00', '부산광역시 부산진구', 1);

INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, `address`, member_id)
VALUES ('2', 'Triplan', '010-2222-2222', '이민재', 'lee@gmail.com', '11-111-1111', '111-11', '서울특별시 동작구', 1);

INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, `address`, member_id)
VALUES ('3', 'GOGOGO', '010-3333-3333', '김민재', 'kim@gmail.com', '22-222-2222', '222-22', '경상남도 진주시', 1);

INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, `address`, member_id)
VALUES ('4', 'KAKAO', '010-4444-4444', '박민재', 'park@gmail.com', '33-333-3333', '333-33', '부산광역시 남구', 2);

INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, `address`, member_id)
VALUES ('5', 'NAVER', '010-5555-5555', '정민재', 'jung@gmail.com', '44-444-4444', '444-44', '부산광역시 동구', 2);

/* 상품 그룹 정보 */






/*
    테스트용 데이터
*/
INSERT INTO member (email, password, nickname, point)
VALUES ('user@gmail.com', '1111', '사용자1', 9999);

INSERT INTO seller (business_license_number, business_name, tel, owner_name, email, business_account, zip_code, address, member_id)
VALUES ('1', 'Com. Trip', '010-1111-1111', '손명진', 'smj@gmail.com', '00-000-0000', '000-00', '부산광역시 부산진구', 1);

INSERT INTO wishlist (member_id, item_group_id)
VALUES (1, 1);

INSERT INTO wishlist (member_id, item_group_id)
VALUES (1, 2);

INSERT INTO wishlist (member_id, item_group_id)
VALUES (1, 3);


INSERT INTO reservation (item_category, total_price, start_date, end_date, name, phone, member_id, seller_id)
VALUES ('ROOM', 50000, '2021-11-1T01:01:01', '2021-12-31T23:59:59', '양경호', '010-9999-9999', 1, 1);

INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (50000, 1, '2021-11-25T00:00:00', '2021-11-25T23:59:59', 1);

INSERT INTO reservation_item (res_id, item_schedule_id)
VALUES (1, 1);

/* Tag 그룹 */
INSERT INTO Tag (color,name,checked)
VALUES('#ffdbdb','시즌이벤트','1번');
INSERT INTO Tag (color,name,checked)
VALUES('#ffeddb','호텔','2번');
INSERT INTO Tag (color,name,checked)
VALUES('#ffffdb','감성충만','3번');
INSERT INTO Tag (color,name,checked)
VALUES('#edffdb','4번','4번');
INSERT INTO Tag (color,name,checked)
VALUES('#dbffdb','5번','5번');
INSERT INTO Tag (color,name,checked)
VALUES('#dbffed','선착순이벤트','6번');
INSERT INTO Tag (color,name,checked)
VALUES('#dbffff','국내선','7번');
INSERT INTO Tag (color,name,checked)
VALUES('#dbedff','마감임박','8번');
INSERT INTO Tag (color,name,checked)
VALUES('#dbdbff','9번','9번');
INSERT INTO Tag (color,name,checked)
VALUES('#eddbff','10번','10번');
INSERT INTO Tag (color,name,checked)
VALUES('#ffdbff','11번','11번');
INSERT INTO Tag (color,name,checked)
VALUES('#ffdbed','12번','12번');

/* 회원 정보 */
INSERT INTO member (email, password, nickname)
VALUES ('user@gmail.com', '1111', '사용자1');

/* Test 숙박 정보 */
INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔1', '부산 해운대 하얏트 호텔1 요약 설명', '부산 해운대 하얏트 호텔1 상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test.jpg', 1, 51);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 1);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (40333, 1, '2021-11-26T00:00:00', '2021-11-26T23:59:59', 1);
VALUES (50000, 1, '2021-11-27T00:00:00', '2021-11-27T23:59:59', 1);
INSERT INTO item_group_tag (item_group_id, tag_id)
VALUES (1, 1);


INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔2', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test2.jpg', 10, 60);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 2);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (20000, 1, '2021-11-2T01:01:01', '2021-12-31T23:59:59', 2);
INSERT INTO item_group_tag (item_group_id, tag_id)
VALUES (2, 1);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔3', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test3.jpg', 20, 88);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 3);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (30000, 1, '2021-11-3T01:01:01', '2021-12-31T23:59:59', 3);
INSERT INTO item_group_tag (item_group_id, tag_id)
VALUES (3, 1);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔4', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test4.jpg', 30, 68);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 4);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (40000, 1, '2021-11-4T01:01:01', '2021-12-31T23:59:59', 4);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔5', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test5.jpg', 40, 24);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 5);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (50000, 1, '2021-11-5T01:01:01', '2021-12-31T23:59:59', 5);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔6', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test6.jpg', 50, 36);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 6);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (60000, 1, '2021-11-6T01:01:01', '2021-12-31T23:59:59', 6);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔7', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test7.jpg', 60, 77);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 7);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (70000, 1, '2021-11-7T01:01:01', '2021-12-31T23:59:59', 7);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔8', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test8.jpg', 70, 28);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 8);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (80000, 1, '2021-11-8T01:01:01', '2021-12-31T23:59:59', 8);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔9', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test9.jpg', 80, 99);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 9);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (90000, 1, '2021-11-9T01:01:01', '2021-12-31T23:59:59', 9);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔10', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test10.jpg', 90, 47);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 10);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (100000, 1, '2021-11-10T01:01:01', '2021-12-31T23:59:59', 10);

INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id, item_img, like_count, review_count)
VALUES ('부산 해운대 하얏트 호텔11', '5성급 호텔', '상세 설명', 'ROOM', '부산광역시 해운대구', 1, '/item/test11.jpg', 100, 51);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 11);
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (110000, 1, '2021-11-11T01:01:01', '2021-12-31T23:59:59', 11);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 4인실', '국내 최고의 오션뷰', 'ROOM', 1);

/* Test 상품 스케쥴 */
INSERT INTO item_schedule (price, stock, start_date, end_date, item_id)
VALUES (50000, 1, '2021-11-23T15:00:00', '2021-11-24T12:00:00', 1),
(50000, 1, '2021-11-24T15:00:00', '2021-11-25T12:00:00', 1),
(50000, 1, '2021-11-25T15:00:00', '2021-11-26T12:00:00', 1),
(70000, 1, '2021-11-26T15:00:00', '2021-11-27T12:00:00', 1),
(70000, 1, '2021-11-27T15:00:00', '2021-11-28T12:00:00', 1),
(50000, 1, '2021-11-28T15:00:00', '2021-11-29T12:00:00', 1);


INSERT INTO wishlist (member_id, item_group_id)
VALUES (1, 1);
INSERT INTO wishlist (member_id, item_group_id)
VALUES (1, 1);
INSERT INTO wishlist (member_id, item_group_id)
VALUES (1, 1);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('스위트룸 오션뷰 2인실', '국내 최고의 오션뷰', 'ROOM', 1);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('4인용 오션뷰 객실', '가격은 2배', 'ROOM', 1);
INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('대회의실', '가격은 4배', 'ROOM', 1);



INSERT INTO room (number_of_person, max_person, item_id)
VALUES (3, 5, 1);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (4, 4, 2);
INSERT INTO room (number_of_person, max_person, item_id)
VALUES (10, 20, 3);

INSERT INTO coupon(name, num, price, condition, expired_at)
VALUES ('쿠폰1', 1234, 1000, '숙박대전 이벤트', '2021-12-10T12:00:00');

INSERT INTO member_coupon (member_id, coupon_id)
VALUES (1, 1);

insert into notice (title, created_at, updated_at, content, target)
values ('제목', '2021-11-09T17:00:00', '2021-11-09T17:00:00', '내용', 'SELLER');

insert into notice (title, created_at, updated_at, content, target)
values ('제목', '2021-11-15T17:00:00', '2021-11-15T17:00:00', '내용', 'MEMBER');

/* Test Flight 아이템 그룹 (식별자: 2번) */
INSERT INTO item_group (name, summary_explain, detail_explain, item_category, address, seller_id)
VALUES ('에어 부산 김해 -> 김포', '안내사항 요약', '상세 안내사항', 'FLIGHT', '부산광역시 해운대구', 1);

INSERT INTO item (name, `explain`, item_category, item_group_id)
VALUES ('소인', '0세 ~ 12세', 'FLIGHT', 2);

INSERT INTO flight (departure, destination, flight_type, seat_class, item_id)
VALUES ('부산', '서울', 'ONE_WAY', 'ECONOMY', 4);

INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(2,6);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(2,7);
INSERT INTO Item_Group_Tag (item_group_id,tag_id)
VALUES(2,8);

/* Test payment */
// 카드결제
INSERT INTO payment
(TYPE, TOTAL_PAYMENT , STATE , CREATED_AT , RES_ID )
VALUES ('CREDIT_CARD', 50000, 'PAID', '2021-11-17T12:13:33', 1);

// 무통장입금(미결제)
INSERT INTO payment
(type, account_bank, account_number, total_payment, payment_deadline, state, created_at, res_id)
VALUES ('TRANSFER_WITHOUT_ACCOUNT', '케이뱅크', '70112004110417', 100000, '2021-12-17T14:59:59', 'UNPAID', '2021-11-17T12:25:33', 2);


// 무통장입금(결제)
INSERT INTO payment
(type, account_bank, account_number, total_payment, payment_deadline, state, created_at, updated_at, res_id)
VALUES ('TRANSFER_WITHOUT_ACCOUNT', '신한(조흥)은행', '56211103867610', 130000, '2021-11-30T14:59:59', 'PAID', '2021-11-17T12:25:33', '2021-11-20T08:17:13', 3);

// 폰결제
INSERT INTO payment
(TYPE, TOTAL_PAYMENT , STATE , CREATED_AT , RES_ID )
VALUES ('CELL_PHONE', 35000, 'PAID', '2021-11-18T09:33:40', 4);

// 네이버페이
INSERT INTO payment
(TYPE, TOTAL_PAYMENT , STATE , CREATED_AT , RES_ID )
VALUES ('NAVER_PAY', 55000, 'PAID', '2021-11-20T18:48:23', 5);

// 카카오페이
INSERT INTO payment
(TYPE, TOTAL_PAYMENT , STATE , CREATED_AT , RES_ID )
VALUES ('KAKAO_PAY', 240000, 'PAID', '2021-11-20T22:10:30', 6);
INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의1', '테스트 문의 내용', 0, 1, 'CUSTOMER');
INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의2', '테스트 문의 내용', 0, 1, 'CUSTOMER');
INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의3', '테스트 문의 내용', 0, 1, 'CUSTOMER');
INSERT INTO question (title, content, hide, member_id, type)
VALUES ('테스트 문의4', '테스트 문의 내용', 0, 1, 'CUSTOMER');
INSERT INTO question (title, content, hide, member_id, type, item_group_id)
VALUES ('테스트 문의5', '테스트 문의 내용', 0, 1, 'CUSTOMER', 1);
INSERT INTO question (title, content, hide, member_id, type, item_group_id)
VALUES ('테스트 문의6', '테스트 문의 내용', 0, 1, 'CUSTOMER', 1);
INSERT INTO question (title, content, hide, member_id, type, item_group_id)
VALUES ('테스트 문의7', '테스트 문의 내용', 0, 1, 'CUSTOMER', 1);

