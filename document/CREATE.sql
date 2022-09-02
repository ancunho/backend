
-- ma_city table
CREATE TABLE `ma_city` (
                           `CITY_ID` int NOT NULL AUTO_INCREMENT,
                           `CITY_NAME` varchar(45) DEFAULT NULL,
                           `PROVINCE_ID` int DEFAULT NULL,
                           `CITY_NAME_PINYIN` varchar(45) DEFAULT NULL,
                           `CITY_GRADE_ID` varchar(10) DEFAULT NULL,
                           `CITY_ENAME` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`CITY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='城市表';


-- ma_province table
CREATE TABLE `ma_province` (
                               `PROVINCE_ID` int NOT NULL AUTO_INCREMENT,
                               `PROVINCE_NAME` varchar(45) DEFAULT NULL,
                               `PROVINCE_NAME_PINYIN` varchar(45) DEFAULT NULL,
                               `PROVINCE_FULL_NAME` varchar(45) DEFAULT NULL,
                               `PROVINCE_ENAME` varchar(45) DEFAULT NULL,
                               PRIMARY KEY (`PROVINCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='省份表';

-- sys_menu table
CREATE TABLE `sys_menu` (
                            `ID` bigint NOT NULL AUTO_INCREMENT,
                            `PARENT_ID` bigint DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
                            `NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `PATH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单URL',
                            `PERMS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
                            `COMPONENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `TYPE` int NOT NULL COMMENT '类型     0：目录   1：菜单   2：按钮',
                            `ICON` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单图标',
                            `ORDER_NUM` int DEFAULT NULL COMMENT '排序',
                            `OPTION01` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION02` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION03` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION04` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION05` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `CREATETIME` datetime NOT NULL,
                            `UPDATETIME` datetime DEFAULT NULL,
                            `STATUS` int NOT NULL,
                            PRIMARY KEY (`ID`),
                            UNIQUE KEY `NAME` (`NAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sys_role table
CREATE TABLE `sys_role` (
                            `ID` bigint NOT NULL AUTO_INCREMENT,
                            `NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `CODE` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `REMARK` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
                            `CREATETIME` datetime DEFAULT NULL,
                            `UPDATETIME` datetime DEFAULT NULL,
                            `STATUS` int NOT NULL,
                            PRIMARY KEY (`ID`),
                            UNIQUE KEY `NAME` (`NAME`) USING BTREE,
                            UNIQUE KEY `CODE` (`CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- sys_role_menu table
CREATE TABLE `sys_role_menu` (
                                 `ID` bigint NOT NULL AUTO_INCREMENT,
                                 `ROLE_ID` bigint NOT NULL,
                                 `MENU_ID` bigint NOT NULL,
                                 PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- sys_user table
CREATE TABLE `sys_user` (
                            `USER_SEQ` int NOT NULL AUTO_INCREMENT,
                            `OPENID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `UNIONID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `USERNAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `PASSWORD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `ROLE_NO` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `ROLE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `STATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `USER_TYPE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `REALNAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `COMPANY` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `COMPANY_TYPE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `MOBILE_NO` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `EMAIL` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `SEX` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `BIRTHDAY` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `WECHAT` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `PROVINCE_CODE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `CITY_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `DISTRICT_CODE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `QUESTION` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `ANSWER` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `IMAGE_PHOTO` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION01` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION02` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION03` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION04` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `OPTION05` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                            `CREATETIME` datetime DEFAULT CURRENT_TIMESTAMP,
                            `UPDATETIME` datetime DEFAULT NULL,
                            PRIMARY KEY (`USER_SEQ`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='회원정보테이블';


-- sys_user_role
CREATE TABLE `sys_user_role` (
                                 `ID` bigint NOT NULL AUTO_INCREMENT,
                                 `USER_SEQ` bigint NOT NULL,
                                 `ROLE_ID` bigint NOT NULL,
                                 PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- tb_post
CREATE TABLE `tb_post` (
                           `POST_ID` int NOT NULL AUTO_INCREMENT,
                           `POST_TYPE` varchar(10) NOT NULL,
                           `POST_CATEGORY_ID` int DEFAULT NULL,
                           `POST_TITLE` varchar(100) DEFAULT NULL,
                           `POST_CONTENT` mediumtext,
                           `EVENT_START_TIME` varchar(45) DEFAULT NULL,
                           `EVENT_END_TIME` varchar(45) DEFAULT NULL,
                           `POST_THUMBNAIL_SMALL` varchar(100) DEFAULT NULL,
                           `POST_THUMBNAIL_BIG` varchar(100) DEFAULT NULL,
                           `POST_AUTHOR` varchar(45) DEFAULT NULL,
                           `IS_JOIN` varchar(10) DEFAULT NULL COMMENT '참여여부(0:불필요, 1: 필요), 회원이 참여하는 포스트 , 예: 레슨',
                           `IS_NEED_PAY` varchar(10) DEFAULT NULL COMMENT '지불이 필요한 포스트인가?',
                           `POST_PRICE` decimal(20,2) DEFAULT NULL,
                           `STATUS` varchar(10) DEFAULT NULL,
                           `OPTION01` varchar(1000) DEFAULT NULL,
                           `OPTION02` varchar(45) DEFAULT NULL,
                           `OPTION03` varchar(45) DEFAULT NULL,
                           `OPTION04` varchar(45) DEFAULT NULL,
                           `OPTION05` varchar(45) DEFAULT NULL,
                           `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
                           `UPDATE_TIME` datetime DEFAULT NULL,
                           PRIMARY KEY (`POST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- tb_classification
CREATE TABLE `tb_classification` (
                                     `CLASSIFICATION_ID` int NOT NULL AUTO_INCREMENT,
                                     `PARENT_CLASSIFICATION_ID` int DEFAULT NULL,
                                     `CLASSIFICATION_NAME` varchar(100) DEFAULT NULL,
                                     `CLASSIFICATION_TYPE` varchar(45) DEFAULT NULL,
                                     `CLASSIFICATION_IMAGE` varchar(100) DEFAULT NULL,
                                     `SORT_ORDER` int DEFAULT NULL,
                                     `DEPTH_NUM` int DEFAULT NULL,
                                     `STATUS` varchar(10) DEFAULT NULL,
                                     `OPTION01` varchar(45) DEFAULT NULL,
                                     `OPTION02` varchar(45) DEFAULT NULL,
                                     `OPTION03` varchar(45) DEFAULT NULL,
                                     `OPTION04` varchar(45) DEFAULT NULL,
                                     `OPTION05` varchar(45) DEFAULT NULL,
                                     `CREATE_TIME` datetime DEFAULT NULL,
                                     `UPDATE_TIME` datetime DEFAULT NULL,
                                     PRIMARY KEY (`CLASSIFICATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- tb_common_code
CREATE TABLE `tb_common_code` (
                                  `CODE_ID` int NOT NULL AUTO_INCREMENT COMMENT '번호',
                                  `CODE_TYPE` varchar(45) DEFAULT NULL,
                                  `CODE_CD` varchar(45) DEFAULT NULL,
                                  `CODE_NAME` varchar(45) DEFAULT NULL,
                                  `USE_YN` varchar(2) DEFAULT NULL,
                                  `REMARK` varchar(100) DEFAULT NULL,
                                  `SORT_ORDER` int DEFAULT NULL,
                                  `OPTION01` varchar(45) DEFAULT NULL,
                                  `OPTION02` varchar(45) DEFAULT NULL,
                                  `OPTION03` varchar(45) DEFAULT NULL,
                                  `OPTION04` varchar(45) DEFAULT NULL,
                                  `OPTION05` varchar(45) DEFAULT NULL,
                                  `CREATE_TIME` datetime DEFAULT NULL,
                                  `UPDATE_TIME` datetime DEFAULT NULL,
                                  PRIMARY KEY (`CODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='공통코드테이블';


-- tb_file_list
CREATE TABLE `tb_file_list` (
                                `FILE_ID` int NOT NULL AUTO_INCREMENT,
                                `FILE_TYPE` varchar(45) DEFAULT NULL,
                                `FILE_PURPOSE` varchar(45) DEFAULT NULL,
                                `FILE_ORIGIN_NAME` varchar(100) DEFAULT NULL,
                                `FILE_NAME` varchar(100) DEFAULT NULL,
                                `FILE_PATH` varchar(45) DEFAULT NULL,
                                `FILE_BUCKET_NAME` varchar(45) DEFAULT NULL,
                                `FILE_BUCKET_OBJECT` varchar(45) DEFAULT NULL,
                                `FILE_SIZE` varchar(45) DEFAULT NULL,
                                `FILE_EXTENTION` varchar(20) DEFAULT NULL,
                                `FILE_URL` varchar(100) DEFAULT NULL,
                                `FILE_SORT` int DEFAULT NULL,
                                `FILE_IS_MAIN` varchar(2) DEFAULT NULL,
                                `FILE_REMARK` varchar(45) DEFAULT NULL,
                                `STATUS` varchar(2) DEFAULT NULL,
                                `OPTION01` varchar(45) DEFAULT NULL,
                                `OPTION02` varchar(45) DEFAULT NULL,
                                `OPTION03` varchar(45) DEFAULT NULL,
                                `OPTION04` varchar(45) DEFAULT NULL,
                                `OPTION05` varchar(45) DEFAULT NULL,
                                `CREATE_TIME` datetime DEFAULT NULL,
                                `UPDATE_TIME` datetime DEFAULT NULL,
                                PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- tb_blog_category
CREATE TABLE `tb_blog_category` (
                                    `CATEGORY_ID` int NOT NULL AUTO_INCREMENT,
                                    `PARENT_CATEGORY_ID` int DEFAULT NULL,
                                    `CATEGORY_NAME` varchar(100) DEFAULT NULL,
                                    `CATEGORY_TYPE` varchar(45) DEFAULT NULL,
                                    `SORT_ORDER` int DEFAULT NULL,
                                    `STATUS` varchar(10) DEFAULT NULL,
                                    `OPTION01` varchar(45) DEFAULT NULL,
                                    `OPTION02` varchar(45) DEFAULT NULL,
                                    `OPTION03` varchar(45) DEFAULT NULL,
                                    `OPTION04` varchar(45) DEFAULT NULL,
                                    `OPTION05` varchar(45) DEFAULT NULL,
                                    `CREATE_TIME` datetime DEFAULT NULL,
                                    `UPDATE_TIME` datetime DEFAULT NULL,
                                    PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



--포스트 태그 테이블
CREATE TABLE `tb_post_tag` (
                               `TAG_ID` int NOT NULL AUTO_INCREMENT,
                               `POST_ID` int NOT NULL,
                               `TAG_NAME` varchar(100) DEFAULT NULL,
                               PRIMARY KEY (`TAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='포스트 태그 테이블';


--포스트 - 참여고객 테이블
CREATE TABLE `tb_post_customer` (
                                    `POST_CUSTOMER_ID` int NOT NULL AUTO_INCREMENT,
                                    `POST_ID` int DEFAULT NULL,
                                    `CUSTOMER_ID` int DEFAULT NULL,
                                    `PAID_YN` varchar(10) DEFAULT NULL COMMENT '포스트테이블',
                                    `JOINED_YN` varchar(10) DEFAULT NULL,
                                    `JOINED_TIME` datetime DEFAULT NULL,
                                    `PC_ORDER_NO` varchar(50) DEFAULT NULL,
                                    `OPTION01` varchar(45) DEFAULT NULL,
                                    `OPTION02` varchar(45) DEFAULT NULL,
                                    `OPTION03` varchar(45) DEFAULT NULL,
                                    `OPTION04` varchar(45) DEFAULT NULL,
                                    `OPTION05` varchar(45) DEFAULT NULL,
                                    `CREATE_TIME` datetime DEFAULT NULL,
                                    `UPDATE_TIME` datetime DEFAULT NULL,
                                    PRIMARY KEY (`POST_CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- TB_BASE_DATE
CREATE TABLE `tb_base_date` (
                                `BASE_YMD` varchar(10) NOT NULL,
                                `BASE_YYYY` varchar(10) DEFAULT NULL,
                                `BASE_MM` varchar(45) DEFAULT NULL,
                                `BASE_DD` varchar(45) DEFAULT NULL,
                                `BASE_WEEKDAY` varchar(45) DEFAULT NULL,
                                `BASE_WEEKDAY_NAME` varchar(45) DEFAULT NULL,
                                `BASE_WW` varchar(45) DEFAULT NULL,
                                `LUNAR_YMD` varchar(45) DEFAULT NULL,
                                `HOLIDAY_YN` varchar(45) DEFAULT NULL,
                                `HOLIDAY_NAME` varchar(45) DEFAULT NULL,
                                `USE_YN` varchar(45) DEFAULT NULL,
                                `MEMO` varchar(45) DEFAULT NULL,
                                `OPTION01` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'TB_BASE_DATE',
                                `OPTION02` varchar(45) DEFAULT NULL,
                                `OPTION03` varchar(45) DEFAULT NULL,
                                `OPTION04` varchar(45) DEFAULT NULL,
                                `OPTION05` varchar(45) DEFAULT NULL,
                                PRIMARY KEY (`BASE_YMD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TB_SPU
CREATE TABLE `tb_spu` (
                          `SPU_ID` int NOT NULL AUTO_INCREMENT,
                          `CLASSIFICATION_ID` int DEFAULT NULL,
                          `DEPTH01_ID` int DEFAULT NULL,
                          `DEPTH01_NAME` varchar(45) DEFAULT NULL,
                          `DEPTH02_ID` int DEFAULT NULL,
                          `DEPTH02_NAME` varchar(45) DEFAULT NULL,
                          `DEPTH03_ID` int DEFAULT NULL,
                          `DEPTH03_NAME` varchar(45) DEFAULT NULL,
                          `BRAND_ID` int DEFAULT NULL,
                          `SPU_NAME` varchar(100) DEFAULT NULL,
                          `SPU_TYPE` varchar(45) DEFAULT NULL,
                          `STATUS` varchar(2) DEFAULT NULL,
                          `MAIN_IMAGE_01` varchar(100) DEFAULT NULL,
                          `MAIN_IMAGE_02` varchar(100) DEFAULT NULL,
                          `MAIN_IMAGE_03` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_01` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_02` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_03` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_04` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_05` varchar(100) DEFAULT NULL,
                          `OPTION01` varchar(45) DEFAULT NULL,
                          `OPTION02` varchar(45) DEFAULT NULL,
                          `OPTION03` varchar(45) DEFAULT NULL,
                          `OPTION04` varchar(45) DEFAULT NULL,
                          `OPTION05` varchar(45) DEFAULT NULL,
                          `CREATE_TIME` datetime DEFAULT NULL,
                          `UPDATE_TIME` datetime DEFAULT NULL,
                          PRIMARY KEY (`SPU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--TB_SPU_ATTRIBUTE
CREATE TABLE `tb_spu_attribute` (
                                    `SPU_ATTR_ID` int NOT NULL AUTO_INCREMENT,
                                    `SPU_ID` int NOT NULL,
                                    `ATTR_ID` int NOT NULL,
                                    `STATUS` varchar(2) DEFAULT NULL,
                                    `OPTION01` varchar(45) DEFAULT NULL,
                                    `OPTION02` varchar(45) DEFAULT NULL,
                                    `OPTION03` varchar(45) DEFAULT NULL,
                                    `OPTION04` varchar(45) DEFAULT NULL,
                                    `OPTION05` varchar(45) DEFAULT NULL,
                                    `CREATE_TIME` datetime DEFAULT NULL,
                                    `UPDATE_TIME` datetime DEFAULT NULL,
                                    PRIMARY KEY (`SPU_ATTR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--TB_SKU
CREATE TABLE `tb_sku` (
                          `SKU_ID` int NOT NULL AUTO_INCREMENT,
                          `SPU_ID` int NOT NULL,
                          `SKU_NAME` varchar(100) DEFAULT NULL,
                          `SKU_INTRO` varchar(1000) DEFAULT NULL,
                          `SKU_PRICE` decimal(20,2) DEFAULT NULL,
                          `SKU_CODE` varchar(50) DEFAULT NULL COMMENT 'SKU 编码',
                          `SKU_BARCODE` varchar(100) DEFAULT NULL,
                          `SKU_STOCK` int DEFAULT NULL,
                          `SKU_UNIT` int DEFAULT NULL,
                          `SKU_UNIT_NAME` varchar(10) DEFAULT NULL,
                          `PRICE` decimal(20,2) DEFAULT NULL,
                          `VIP_PRICE` decimal(20,2) DEFAULT NULL,
                          `STATUS` varchar(10) DEFAULT NULL,
                          `MAIN_IMAGE_01` varchar(100) DEFAULT NULL,
                          `MAIN_IMAGE_02` varchar(100) DEFAULT NULL,
                          `MAIN_IMAGE_03` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_01` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_02` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_03` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_04` varchar(100) DEFAULT NULL,
                          `SUB_IMAGE_05` varchar(100) DEFAULT NULL,
                          `OPTION01` varchar(45) DEFAULT NULL,
                          `OPTION02` varchar(45) DEFAULT NULL,
                          `OPTION03` varchar(45) DEFAULT NULL,
                          `OPTION04` varchar(45) DEFAULT NULL,
                          `OPTION05` varchar(45) DEFAULT NULL,
                          `CREATE_TIME` datetime DEFAULT NULL,
                          `UPDATE_TIME` datetime DEFAULT NULL,
                          PRIMARY KEY (`SKU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



--TB_SKU_ATTRIBUTE

CREATE TABLE `tb_sku_attribute` (
                                    `SKU_ATTR_ID` int NOT NULL AUTO_INCREMENT,
                                    `SKU_ID` int NOT NULL,
                                    `ATTR_ID` int DEFAULT NULL,
                                    `ATTR_VALUE_ID` int NOT NULL,
                                    `IS_MUST` varchar(2) DEFAULT NULL,
                                    `IS_DEFAULT` varchar(2) DEFAULT NULL,
                                    `PRICE_PLUS` decimal(20,2) DEFAULT NULL,
                                    `STATUS` varchar(10) DEFAULT NULL,
                                    `OPTION01` varchar(45) DEFAULT NULL,
                                    `OPTION02` varchar(45) DEFAULT NULL,
                                    `OPTION03` varchar(45) DEFAULT NULL,
                                    `OPTION04` varchar(45) DEFAULT NULL,
                                    `OPTION05` varchar(45) DEFAULT NULL,
                                    `CREATE_TIME` datetime DEFAULT NULL,
                                    `UPDATE_TIME` datetime DEFAULT NULL,
                                    PRIMARY KEY (`SKU_ATTR_ID`),
                                    KEY `tb_sku_attribute_attr_id` (`ATTR_ID` ASC),
                                    KEY `tb_sku_attribute_attr_value_id` (`ATTR_VALUE_ID` ASC)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--TB_ATTRIBUTE
CREATE TABLE `tb_attribute` (
                                `ATTR_ID` int NOT NULL AUTO_INCREMENT,
                                `ATTR_NAME` varchar(45) DEFAULT NULL,
                                `ATTR_TYPE` varchar(45) DEFAULT NULL,
                                `STATUS` varchar(2) DEFAULT NULL,
                                `ATTR_IMAGE` varchar(100) DEFAULT NULL,
                                `OPTION01` varchar(45) DEFAULT NULL,
                                `OPTION02` varchar(45) DEFAULT NULL,
                                `OPTION03` varchar(45) DEFAULT NULL,
                                `OPTION04` varchar(45) DEFAULT NULL,
                                `OPTION05` varchar(45) DEFAULT NULL,
                                `CREATE_TIME` datetime DEFAULT NULL,
                                `UPDATE_TIME` datetime DEFAULT NULL,
                                PRIMARY KEY (`ATTR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--TB_ATTRIBUTE_VALUE
CREATE TABLE `tb_attribute_value` (
                                      `ATTR_VALUE_ID` int NOT NULL AUTO_INCREMENT,
                                      `ATTR_ID` int NOT NULL,
                                      `ATTR_VALUE` varchar(45) DEFAULT NULL,
                                      `PRICE` decimal(20,2) DEFAULT NULL,
                                      `VIP_PRICE` decimal(20,2) DEFAULT NULL,
                                      `DELIVERY_PRICE` decimal(20,2) DEFAULT NULL,
                                      `DELIVERY_TYPE` varchar(45) DEFAULT NULL,
                                      `STATUS` varchar(10) DEFAULT NULL,
                                      `ATTR_VALUE_IMAGE` varchar(100) DEFAULT NULL,
                                      `OPTION01` varchar(45) DEFAULT NULL,
                                      `OPTION02` varchar(45) DEFAULT NULL,
                                      `OPTION03` varchar(45) DEFAULT NULL,
                                      `OPTION04` varchar(45) DEFAULT NULL,
                                      `OPTION05` varchar(45) DEFAULT NULL,
                                      `CREATE_TIME` datetime DEFAULT NULL,
                                      `UPDATE_TIME` datetime DEFAULT NULL,
                                      PRIMARY KEY (`ATTR_VALUE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



--고객테이블 - 클라이언트정보
CREATE TABLE `tb_customer` (
                               `CUSTOMER_ID` int NOT NULL AUTO_INCREMENT COMMENT '고객번호',
                               `WEIXIN_OPEN_ID` varchar(100) DEFAULT NULL COMMENT '위챗오픈아이디',
                               `WEIXIN_UNION_ID` varchar(100) DEFAULT NULL COMMENT '위챗UNION아이디',
                               `USERNAME` varchar(45) DEFAULT NULL COMMENT '아이디(로그인용)',
                               `PASSWORD` varchar(100) DEFAULT NULL COMMENT '비밀번호',
                               `MOBILE_NO` varchar(45) DEFAULT NULL COMMENT '전화번호',
                               `NICKNAME` varchar(45) DEFAULT NULL,
                               `GRADE` varchar(45) DEFAULT NULL,
                               `CUSTOMER_TYPE` varchar(10) DEFAULT NULL,
                               `REALNAME` varchar(45) DEFAULT NULL,
                               `BIRTHDAY` varchar(45) DEFAULT NULL,
                               `SEX` varchar(2) DEFAULT NULL,
                               `EMAIL` varchar(100) DEFAULT NULL,
                               `COUNTRY` varchar(45) DEFAULT NULL,
                               `PROVINCE` varchar(45) DEFAULT NULL,
                               `CITY` varchar(45) DEFAULT NULL,
                               `ADDRESS` varchar(100) DEFAULT NULL,
                               `STATUS` varchar(10) DEFAULT NULL,
                               `WECHAT_ID` varchar(45) DEFAULT NULL,
                               `OPTION01` varchar(45) DEFAULT NULL,
                               `OPTION02` varchar(45) DEFAULT NULL,
                               `OPTION03` varchar(45) DEFAULT NULL,
                               `OPTION04` varchar(45) DEFAULT NULL,
                               `OPTION05` varchar(45) DEFAULT NULL,
                               `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
                               `UPDATE_TIME` datetime DEFAULT NULL,
                               PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='고객테이블 - 클라이언트 고객정보  ';

-- 매장정보테이블
CREATE TABLE `tb_shop` (
                           `SHOP_ID` int NOT NULL AUTO_INCREMENT,
                           `SHOP_NAME` varchar(45) DEFAULT NULL,
                           `SHOP_INTRO` varchar(200) DEFAULT NULL,
                           `MANAGER_NAME` varchar(45) DEFAULT NULL,
                           `MANAGER_MOBILE` varchar(45) DEFAULT NULL,
                           `SHOP_MOBILE` varchar(45) DEFAULT NULL,
                           `SHOP_STATUS` varchar(2) DEFAULT NULL,
                           `SHOP_PROVINCE` varchar(45) DEFAULT NULL,
                           `SHOP_CITY` varchar(45) DEFAULT NULL,
                           `SHOP_DISTRICT` varchar(45) DEFAULT NULL,
                           `SHOP_ADDRESS` varchar(100) DEFAULT NULL,
                           `SHOP_IMAGE` varchar(45) DEFAULT NULL,
                           `OPTION01` varchar(45) DEFAULT NULL,
                           `OPTION02` varchar(45) DEFAULT NULL,
                           `OPTION03` varchar(45) DEFAULT NULL,
                           `OPTION04` varchar(45) DEFAULT NULL,
                           `OPTION05` varchar(45) DEFAULT NULL,
                           `CREATE_TIME` datetime DEFAULT NULL,
                           `UPDATE_TIME` datetime DEFAULT NULL,
                           PRIMARY KEY (`SHOP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='매장정보테이블';

--방/타석정보
CREATE TABLE `tb_room` (
                           `ROOM_ID` int NOT NULL AUTO_INCREMENT,
                           `SHOP_ID` int NOT NULL,
                           `ROOM_TYPE` varchar(2) DEFAULT NULL,
                           `ROOM_NAME` varchar(45) DEFAULT NULL,
                           `ROOM_THUMBNAIL` varchar(200) DEFAULT NULL,
                           `ROOM_INTRO` varchar(1000) DEFAULT NULL,
                           `ROOM_CODE` varchar(45) DEFAULT NULL,
                           `ROOM_CAPACITY` varchar(45) DEFAULT NULL,
                           `ROOM_STATUS` varchar(2) DEFAULT NULL,
                           `OPTION01` varchar(45) DEFAULT NULL,
                           `OPTION02` varchar(45) DEFAULT NULL,
                           `OPTION03` varchar(45) DEFAULT NULL,
                           `OPTION04` varchar(45) DEFAULT NULL,
                           `OPTION05` varchar(45) DEFAULT NULL,
                           `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
                           `UPDATE_TIME` datetime DEFAULT NULL,
                           PRIMARY KEY (`ROOM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='방/타석정보';

--예약정보

CREATE TABLE `tb_booking` (
                              `BOOKING_ID` bigint NOT NULL AUTO_INCREMENT,
                              `BOOKING_ORDER_NO` varchar(50) DEFAULT NULL,
                              `BOOKING_ORDER_STATUS` varchar(20) DEFAULT NULL,
                              `BOOKING_TYPE` varchar(2) DEFAULT NULL,
                              `SHOP_ID` int DEFAULT NULL,
                              `ROOM_ID` int DEFAULT NULL,
                              `CUSTOMER_ID` int DEFAULT NULL,
                              `BOOKING_PERSON_COUNT` varchar(45) DEFAULT NULL,
                              `BOOKING_STARTDAY` varchar(10) DEFAULT NULL,
                              `BOOKING_ENDDAY` varchar(10) DEFAULT NULL,
                              `BOOKING_STARTTIME` varchar(45) DEFAULT NULL,
                              `BOOKING_ENDTIME` varchar(45) DEFAULT NULL,
                              `BOOKING_STATUS` varchar(2) DEFAULT NULL,
                              `BOOKING_MOBILE` varchar(45) DEFAULT NULL,
                              `BOOKING_PERSON_NAME` varchar(45) DEFAULT NULL,
                              `PAY_STATUS` varchar(2) DEFAULT NULL,
                              `REMARK` varchar(100) DEFAULT NULL,
                              `COMMENT` varchar(100) DEFAULT NULL,
                              `CHANGE_USER_ID` int DEFAULT NULL,
                              `CHANGE_TIME` datetime DEFAULT NULL,
                              `CUSTOMER_CHANGE_TIME` datetime DEFAULT NULL,
                              `BOOKING_TIME` datetime DEFAULT NULL,
                              `OPTION01` varchar(45) DEFAULT NULL,
                              `OPTION02` varchar(45) DEFAULT NULL,
                              `OPTION03` varchar(45) DEFAULT NULL,
                              `OPTION04` varchar(45) DEFAULT NULL,
                              `OPTION05` varchar(45) DEFAULT NULL,
                              `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP,
                              `UPDATE_TIME` datetime DEFAULT NULL,
                              PRIMARY KEY (`BOOKING_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='예약정보(메인)';
