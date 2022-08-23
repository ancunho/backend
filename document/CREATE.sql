
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
