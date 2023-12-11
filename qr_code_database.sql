/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : qr_code_database

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 12/12/2023 00:11:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` bigint NOT NULL,
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (123, '123', '123', '123', '2023-12-09 13:04:35');

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`  (
  `id` bigint NOT NULL,
  `src_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `src_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `src_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deliveryman_id` bigint UNSIGNED NULL DEFAULT NULL,
  INDEX `id`(`id` ASC) USING BTREE,
  INDEX `manID`(`deliveryman_id` ASC) USING BTREE,
  CONSTRAINT `manID` FOREIGN KEY (`deliveryman_id`) REFERENCES `deliveryman` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES (10887042, 'Halee', '14107510872', 'Melvin', '146665765146', 'Ap #980-564 Sodales Street', 'Ap #932-9085 Sagittis Rd.', '运输中', '2023-11-27 14:40:03', '2023-12-11 15:52:10', '电子产品', '手机', 104406);
INSERT INTO `delivery` VALUES (11004910, 'Prescott', '19436312672', 'Amery', '152233325737', '686-9876 Ut, Avenue', 'P.O. Box 120, 3801 Convallis Av.', '待揽收', '2023-11-27 14:40:00', '2023-12-11 15:52:12', '电子产品', '手机', 104406);
INSERT INTO `delivery` VALUES (11664854, 'Ava', '12340326178', 'Noble', '176757543028', 'Ap #190-4225 Cursus Road', '537-9489 Mus. St.', '待揽收', '2023-11-27 14:40:00', '2023-12-11 15:52:13', '电子产品', '手机', 104406);
INSERT INTO `delivery` VALUES (11726475, 'Signe', '19718468776', 'Ann', '125484173171', '357-4289 Praesent Road', 'P.O. Box 450, 4993 Massa. Av.', '运输中', '2023-11-27 14:40:00', '2023-12-09 20:42:45', '电子产品', '手机', 899409);
INSERT INTO `delivery` VALUES (12344712, 'Phyllis', '14748547248', 'Bree', '136989698815', '992-6928 Ut St.', '1735 Molestie Road', '运输中', '2023-11-27 14:40:00', '2023-12-09 20:42:46', '电子产品', '手机', 944711);
INSERT INTO `delivery` VALUES (12772716, 'Reece', '17175779423', 'Rogan', '133669812616', 'Ap #679-8747 Ad Rd.', 'P.O. Box 499, 5665 Rhoncus Ave', '运输中', '2023-11-27 14:40:00', '2023-12-09 20:41:58', '电子产品', '手机', 899409);
INSERT INTO `delivery` VALUES (12941000, 'Hadley', '13093559515', 'Dahlia', '122778139735', '3200 Blandit Road', '112-3066 Nonummy. Ave', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '电子产品', '手机', NULL);
INSERT INTO `delivery` VALUES (12955260, 'Raven', '17167371186', 'Katell', '188526460513', '876-2958 Justo. St.', '552-5458 Et, Ave', '运输中', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '电子产品', '手机', NULL);
INSERT INTO `delivery` VALUES (12993260, 'Cyrus', '16406326494', 'Xantha', '125109628221', '889-4136 Consequat Ave', 'Ap #856-5594 Vestibulum St.', '待揽收', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '电子产品', '手机', NULL);
INSERT INTO `delivery` VALUES (13767769, 'Lucian', '12215813666', 'Uriah', '124724898518', '183-9940 Convallis Avenue', '173-659 Dolor Rd.', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '电子产品', '手机', NULL);
INSERT INTO `delivery` VALUES (14856300, 'Edan', '17986156367', 'Coby', '137412140541', 'P.O. Box 815, 7513 Non Avenue', 'P.O. Box 767, 3253 Risus. Road', '已取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '电子产品', '手机', NULL);
INSERT INTO `delivery` VALUES (14894091, 'Alice', '12745515468', 'Forrest', '156544270417', 'Ap #861-5950 Lorem Ave', 'P.O. Box 865, 9268 Imperdiet Rd.', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '电子产品', '手机', NULL);
INSERT INTO `delivery` VALUES (14896520, 'Cody', '12614866860', 'Risa', '165944873485', '433-1635 Semper Rd.', 'P.O. Box 872, 8174 Nam Road', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '生活用品', '手机', NULL);
INSERT INTO `delivery` VALUES (14903816, 'Herrod', '15795758527', 'Ella', '161737251175', '353-2357 Magna. Road', '7536 Risus. Street', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '生活用品', '手机', NULL);
INSERT INTO `delivery` VALUES (15007457, 'Colton', '13122981968', 'Jennifer', '183571693714', 'Ap #394-9002 Eu, Av.', 'Ap #812-2371 Imperdiet Avenue', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '生活用品', '手机', NULL);
INSERT INTO `delivery` VALUES (15131145, 'Ria', '14175925072', 'Herman', '183678969631', '744-3566 Eu Road', 'Ap #736-8007 Commodo Avenue', '运输中', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '生活用品', '手机', NULL);
INSERT INTO `delivery` VALUES (15445547, 'Angela', '13711165480', 'Wade', '169126792754', 'Ap #716-552 Dui. Ave', 'Ap #436-2170 Donec St.', '运输中', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '生活用品', '手机', NULL);
INSERT INTO `delivery` VALUES (15542987, 'Halee', '12615446248', 'Giselle', '147522638878', '166-4288 Eu, Road', '542-8834 Magna Rd.', '已取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '文件票据', '手机', NULL);
INSERT INTO `delivery` VALUES (16038760, 'Ingrid', '19067767334', 'Karina', '176246656321', 'P.O. Box 508, 2160 Erat, Ave', 'Ap #579-4495 Magna St.', '已取件 ', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '工业生产', '手机', NULL);
INSERT INTO `delivery` VALUES (16309744, 'Hedley', '17564642378', 'Elaine', '162548706127', 'Ap #768-9186 Luctus Rd.', '391-3387 A, Rd.', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '钟表首饰', '手机', NULL);
INSERT INTO `delivery` VALUES (16352360, 'Mira', '18334913362', 'Sebastian', '121188773235', '839-9974 A, Road', '191-3769 Consectetuer Rd.', '运输中', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '箱包', '手机', NULL);
INSERT INTO `delivery` VALUES (16704555, 'Brody', '14253207175', 'Mikayla', '124158965974', '314-5868 Nascetur Ave', '398-9719 Orci Rd.', '运输中', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '文体娱乐', '手机', NULL);
INSERT INTO `delivery` VALUES (16797528, 'Wanda', '13422845374', 'Amos', '137371486244', 'Ap #589-6629 Diam St.', '657-9743 Pede. St.', '运输中', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '副食干货', '手机', NULL);
INSERT INTO `delivery` VALUES (17114623, 'Quyn', '16485129843', 'Olivia', '183043320795', 'Ap #104-596 Senectus St.', 'P.O. Box 891, 1116 Tempor Ave', '待揽收', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '海鲜水产', '手机', NULL);
INSERT INTO `delivery` VALUES (17322585, 'Owen', '15211911186', 'Florence', '182130425140', 'Ap #326-3977 Ligula Road', 'P.O. Box 178, 9414 Nam Rd.', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '酒类', '手机', NULL);
INSERT INTO `delivery` VALUES (17430756, 'Blossom', '14853726290', 'Tatiana', '132482254953', '7711 Dui. Road', 'P.O. Box 986, 8655 Libero. St.', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '医药保健', '手机', NULL);
INSERT INTO `delivery` VALUES (17462903, 'Armand', '16314434444', 'Kyra', '175265839751', 'Ap #128-8924 Mus. St.', '510-9222 Dapibus St.', '待揽收', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '家具家电', '手机', NULL);
INSERT INTO `delivery` VALUES (18013366, 'Penelope', '15262623307', 'Cullen', '146581594633', '146-7507 Lacinia. Rd.', '579-7179 Iaculis Rd.', '待揽收', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '蔬菜', '手机', NULL);
INSERT INTO `delivery` VALUES (18736834, 'Jonah', '14942816129', 'Oleg', '146957614129', '726-432 Interdum. Rd.', 'Ap #412-4478 Libero Road', '待取件', '2023-11-27 14:40:00', '2023-12-05 14:40:13', '肉禽蛋品', '手机', NULL);

-- ----------------------------
-- Table structure for deliveryman
-- ----------------------------
DROP TABLE IF EXISTS `deliveryman`;
CREATE TABLE `deliveryman`  (
  `id` bigint UNSIGNED NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `work_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_card` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `visit_src` tinyint(1) NULL DEFAULT NULL,
  `visit_dst` tinyint(1) NULL DEFAULT NULL,
  `visit_delivery` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of deliveryman
-- ----------------------------
INSERT INTO `deliveryman` VALUES (104406, '叶芳', '123', '123', '2010-07-31 19:13:04', '2023-12-11 23:23:48', '辽宁省 辽阳市 太子河区', '530000198406213437', 1, 1, 1);
INSERT INTO `deliveryman` VALUES (106436, '萧芳', '21', '18976671756', '2023-03-24 10:22:58', '2023-12-09 19:56:09', '海南省 三沙市 中沙群岛的岛礁及其海域', '430000198507256571', 0, 0, 0);
INSERT INTO `deliveryman` VALUES (865352, '孟刚', '35', '13561313454', '2023-06-13 16:17:41', '2023-12-09 11:39:58', '江西省 上饶市 横峰县', '45000020230817586X', 0, 0, 0);
INSERT INTO `deliveryman` VALUES (866315, '尹娟', '79', '13223351943', '2003-01-01 21:43:08', '2023-12-09 11:39:58', '澳门特别行政区 澳门半岛 -', '110000199210062688', 0, 0, 0);
INSERT INTO `deliveryman` VALUES (872911, '武霞', '13', '13566558241', '2022-01-03 09:36:46', '2008-01-14 13:48:59', '西藏自治区 那曲地区 申扎县', '650000201405158474', 1, 0, 0);
INSERT INTO `deliveryman` VALUES (886084, '胡丽', '33', '13567526748', '1992-02-18 23:46:46', '2000-09-18 05:09:53', '新疆维吾尔自治区 吐鲁番地区 托克逊县', '510000198904046113', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (891410, '汪敏', '39', '13247747428', '2014-08-28 18:09:36', '2002-12-02 05:36:27', '贵州省 铜仁市 江口县', '450000198506206306', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (899409, '郭静', '43', '13521637774', '2020-09-03 12:29:03', '1996-03-03 04:12:53', '台湾 南投县 名间乡', '120000198706226575', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (915024, '黄明', '34', '18948542315', '1974-11-01 20:17:27', '2014-04-03 13:56:49', '黑龙江省 鹤岗市 其它区', '420000201506131411', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (936784, '谢秀英', '98', '13572689373', '2017-07-16 10:18:09', '2004-01-23 18:39:20', '香港特别行政区 九龙 黄大仙区', '150000199011210382', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (937005, '江刚', '6', '13524216845', '2011-01-05 09:20:19', '2023-04-12 11:49:42', '广西壮族自治区 河池市 凤山县', '320000197404235743', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (939865, '丁明', '80', '13256327237', '1988-04-20 02:33:01', '1992-06-04 17:13:18', '陕西省 延安市 延长县', '350000200006241531', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (944711, '田艳', '47', '13545693756', '1973-05-01 15:08:50', '1982-05-10 03:57:29', '福建省 莆田市 仙游县', '820000201201316882', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (955071, '丁磊', '80', '13560943228', '1990-04-05 00:14:18', '1984-12-08 08:09:41', '北京 北京市 海淀区', '650000201604157714', 1, 1, 0);
INSERT INTO `deliveryman` VALUES (1733295625367285761, '123', '123', '123456', NULL, NULL, NULL, '123', NULL, NULL, NULL);
INSERT INTO `deliveryman` VALUES (1733296061726167041, '123', '858655', '123855', '2023-12-09 09:22:39', '2023-12-09 09:22:39', NULL, '5685', NULL, NULL, NULL);
INSERT INTO `deliveryman` VALUES (1734093059391545345, '24564', 'gjknggy', 'fgjm', '2023-12-11 14:09:38', '2023-12-11 14:09:38', NULL, 'hjkgdf', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (123, 'admin', '123');

SET FOREIGN_KEY_CHECKS = 1;
