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

 Date: 19/01/2024 02:33:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `county` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_id` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `address_ibfk_1`(`customer_id` ASC) USING BTREE,
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1021253600, '阎娟', '13522442775', '山东省', '汕头市', '华中', '@详细地址', 213412412, '1978-08-08 17:49:34', '2022-02-23 00:53:18');
INSERT INTO `address` VALUES (1047711303, '朱涛', '13211928344', '宁夏回族自治区', '承德市', '华中', '@详细地址', 213412412, '2009-01-07 04:01:53', '1976-12-02 07:31:40');
INSERT INTO `address` VALUES (1171363079, '蒋秀兰', '18954677180', '宁夏回族自治区', '龙岩市', '华中', '@详细地址', NULL, '1978-02-20 06:30:06', '1977-08-22 02:19:02');
INSERT INTO `address` VALUES (1397156867, '赵平', '13585978794', '宁夏回族自治区', '昌都地区', '华东', '@详细地址', NULL, '1970-07-31 19:13:07', '1987-12-19 22:25:03');
INSERT INTO `address` VALUES (1868020606, '易磊', '13541466119', '甘肃省', '咸宁市', '华北', '@详细地址', NULL, '2019-10-07 08:23:14', '2001-10-19 16:45:20');
INSERT INTO `address` VALUES (2276771434, '田霞', '13287895261', '黑龙江省', '临汾市', '华北', '@详细地址', NULL, '2011-10-02 19:29:22', '2012-08-23 00:47:14');
INSERT INTO `address` VALUES (2737788349, '潘涛', '18945816245', '澳门特别行政区', '乌海市', '华东', '@详细地址', NULL, '1973-10-21 02:30:45', '2008-06-09 04:59:54');
INSERT INTO `address` VALUES (2962174286, '邓明', '13511742105', '新疆维吾尔自治区', '喀什地区', '华北', '@详细地址', NULL, '1990-05-16 16:09:34', '1987-07-25 00:20:07');
INSERT INTO `address` VALUES (3203502758, '侯军', '18976765163', '台湾', '普洱市', '华南', '@详细地址', NULL, '2000-01-22 06:11:32', '2000-10-11 05:22:09');
INSERT INTO `address` VALUES (3417768116, '谭洋', '13507055115', '西藏自治区', '益阳市', '华南', '@详细地址', NULL, '2023-12-27 08:52:14', '2013-08-23 18:17:46');
INSERT INTO `address` VALUES (3430673847, '黄丽', '13296864719', '浙江省', '新界', '东北', '@详细地址', NULL, '1982-02-15 23:06:09', '1976-03-06 18:25:03');
INSERT INTO `address` VALUES (3687949627, '白秀兰', '18937482107', '澳门特别行政区', '石嘴山市', '西南', '@详细地址', NULL, '1987-06-20 23:30:45', '2007-01-04 06:40:43');
INSERT INTO `address` VALUES (4161600507, '杨霞', '13594854512', '山东省', '巴音郭楞蒙古自治州', '华中', '@详细地址', NULL, '2005-05-21 20:43:24', '1980-11-17 02:25:48');
INSERT INTO `address` VALUES (4428964468, '罗磊', '18967038464', '海外', '鹤壁市', '华北', '@详细地址', NULL, '2001-03-25 08:03:11', '2002-07-29 04:55:02');
INSERT INTO `address` VALUES (4611337591, '赵艳', '18977236001', '天津', '北京市', '华南', '@详细地址', NULL, '2023-11-10 13:33:55', '1973-05-23 10:43:29');
INSERT INTO `address` VALUES (4625679832, '易超', '18944841798', '安徽省', '重庆市', '华东', '@详细地址', NULL, '1998-04-19 22:41:58', '1995-12-23 20:05:55');
INSERT INTO `address` VALUES (4857219128, '郝桂英', '13534402134', '云南省', '嘉兴市', '西南', '@详细地址', NULL, '2005-03-07 12:48:23', '2017-12-27 16:15:30');
INSERT INTO `address` VALUES (4876820902, '黎明', '13533257732', '上海', '大兴安岭地区', '华东', '@详细地址', NULL, '1983-05-31 23:55:32', '1998-01-12 20:59:29');
INSERT INTO `address` VALUES (5159966916, '廖强', '13545363189', '广西壮族自治区', '汕尾市', '华中', '@详细地址', NULL, '1987-03-07 17:24:41', '1983-04-28 06:12:36');
INSERT INTO `address` VALUES (5609719518, '段强', '13270643456', '台湾', '中山市', '华北', '@详细地址', NULL, '1978-06-26 10:53:16', '1972-04-04 20:17:18');
INSERT INTO `address` VALUES (5623237251, '侯桂英', '13524613418', '海南省', '商洛市', '华南', '@详细地址', NULL, '1976-01-06 00:00:50', '2018-03-02 18:15:32');
INSERT INTO `address` VALUES (5972815971, '郭磊', '18925244322', '云南省', '林芝地区', '华中', '@详细地址', NULL, '1992-03-26 12:29:02', '1973-11-15 20:29:35');
INSERT INTO `address` VALUES (6025460256, '武霞', '13228189424', '四川省', '天津市', '华南', '@详细地址', NULL, '1992-08-21 10:44:26', '2006-04-15 16:16:16');
INSERT INTO `address` VALUES (6437222332, '尹明', '13549721764', '四川省', '湘潭市', '东北', '@详细地址', NULL, '1972-01-01 00:17:15', '1986-02-13 22:55:52');
INSERT INTO `address` VALUES (6551649193, '吴娟', '18975476683', '云南省', '嘉义市', '东北', '@详细地址', NULL, '2000-02-23 04:08:41', '1979-03-25 12:35:31');
INSERT INTO `address` VALUES (6564768996, '姚艳', '13589424386', '上海', '清远市', '东北', '@详细地址', NULL, '1994-12-10 20:11:12', '1974-08-26 06:08:43');
INSERT INTO `address` VALUES (6983093823, '任霞', '13560027661', '台湾', '营口市', '华中', '@详细地址', NULL, '1980-09-06 17:46:58', '2004-07-09 23:34:40');
INSERT INTO `address` VALUES (7693141344, '郭伟', '13533487752', '新疆维吾尔自治区', '鸡西市', '西南', '@详细地址', NULL, '1984-11-18 14:34:38', '1994-08-03 05:50:28');
INSERT INTO `address` VALUES (8557596929, '马杰', '13546562061', '贵州省', '巴彦淖尔市', '华东', '@详细地址', NULL, '2002-04-25 21:44:44', '1977-03-28 01:50:46');
INSERT INTO `address` VALUES (8675659995, '方明', '13233861513', '湖北省', '娄底市', '华南', '@详细地址', NULL, '1988-02-07 06:31:48', '1981-06-29 01:18:51');
INSERT INTO `address` VALUES (8774109509, '郭超', '13254549841', '贵州省', '晋城市', '西南', '@详细地址', NULL, '2011-12-07 16:39:02', '2019-10-28 16:24:34');
INSERT INTO `address` VALUES (9404526314, '何军', '13216227672', '广西壮族自治区', '昌都地区', '华南', '@详细地址', NULL, '1978-02-07 17:57:48', '1999-07-12 20:15:05');
INSERT INTO `address` VALUES (9407429003, '董刚', '18987738404', '海外', '怀化市', '华中', '@详细地址', NULL, '2001-12-30 02:24:10', '2018-07-05 21:12:51');
INSERT INTO `address` VALUES (9465414259, '梁敏', '13586328698', '北京', '辽源市', '东北', '@详细地址', NULL, '1984-09-24 01:25:15', '1979-05-23 07:36:43');
INSERT INTO `address` VALUES (9535825182, '薛桂英', '13501774759', '广东省', '广州市', '华北', '@详细地址', NULL, '2010-12-27 16:49:36', '1974-02-23 10:42:00');
INSERT INTO `address` VALUES (9699110209, '邓磊', '13295538044', '天津', '天津市', '东北', '@详细地址', NULL, '2017-09-07 23:43:15', '1989-03-20 23:27:27');
INSERT INTO `address` VALUES (9886320414, '薛娟', '18925746808', '广东省', '日照市', '西北', '@详细地址', NULL, '1991-07-21 11:12:43', '2018-11-08 00:52:52');
INSERT INTO `address` VALUES (9932240626, '沈秀兰', '13223378977', '云南省', '酒泉市', '华东', '@详细地址', NULL, '2007-05-14 14:52:44', '1998-05-13 15:15:08');
INSERT INTO `address` VALUES (9980846203, '阎刚', '13254328752', '河北省', '海外', '西南', '@详细地址', NULL, '1991-08-15 08:16:14', '2018-09-05 03:26:08');
INSERT INTO `address` VALUES (10396369216, '乔秀英', '13539316673', '山西省', '邯郸市', '西北', '@详细地址', NULL, '2009-08-04 15:23:46', '1981-11-22 04:03:09');
INSERT INTO `address` VALUES (10811819176, '曹娜', '13512767875', '安徽省', '林芝地区', '华中', '@详细地址', NULL, '2022-06-08 04:23:30', '1990-03-02 17:46:15');
INSERT INTO `address` VALUES (10945060232, '陈洋', '13588734445', '广西壮族自治区', '辽源市', '华北', '@详细地址', NULL, '2010-12-08 17:48:28', '2018-02-15 03:54:56');
INSERT INTO `address` VALUES (11029964958, '顾杰', '13536928893', '吉林省', '许昌市', '华东', '@详细地址', NULL, '2017-12-15 22:23:44', '1979-05-21 11:24:55');
INSERT INTO `address` VALUES (11097718991, '萧勇', '13501062908', '安徽省', '益阳市', '华北', '@详细地址', NULL, '1993-07-19 22:47:05', '2021-06-05 20:01:19');
INSERT INTO `address` VALUES (11289679788, '杨平', '13500355188', '西藏自治区', '重庆市', '华南', '@详细地址', NULL, '1983-08-19 16:36:55', '1986-08-15 15:21:41');
INSERT INTO `address` VALUES (11364405948, '丁杰', '13266376421', '湖北省', '新界', '西北', '@详细地址', NULL, '2001-01-06 01:44:28', '1988-08-07 07:25:11');
INSERT INTO `address` VALUES (11451223464, '锺娜', '13547805686', '海南省', '重庆市', '华中', '@详细地址', NULL, '1996-08-17 14:44:04', '1982-03-24 10:14:39');
INSERT INTO `address` VALUES (11755017221, '胡磊', '13288414213', '福建省', '临汾市', '华北', '@详细地址', NULL, '2011-07-06 18:05:24', '2013-12-02 13:06:46');
INSERT INTO `address` VALUES (11811875529, '彭平', '18967121188', '新疆维吾尔自治区', '重庆市', '西南', '@详细地址', NULL, '2003-12-07 17:02:10', '1993-03-08 00:41:45');
INSERT INTO `address` VALUES (11880619618, '范明', '18945735163', '海外', '莆田市', '西南', '@详细地址', NULL, '1984-01-16 17:46:29', '1995-11-29 03:27:41');
INSERT INTO `address` VALUES (12412513513412, '李锐', '13728920416', '广东省', '深圳市', '宝安区', '西乡桃源居', NULL, '2023-12-28 16:31:22', '2023-12-28 16:31:24');
INSERT INTO `address` VALUES (1746449299346145281, '123123', '113', '111', '111', '111,', '111', 213412412, '2024-01-14 16:28:55', '2024-01-14 16:28:55');
INSERT INTO `address` VALUES (1746450145362427906, '123', '13', '123', '123', '123', '12', 213412412, '2024-01-14 16:32:17', '2024-01-14 16:32:17');
INSERT INTO `address` VALUES (1748043575121166338, 'alex', '13765478256', '广东省', '深圳市', '宝安区', '桃源居', 213412412, '2024-01-19 02:04:00', '2024-01-19 02:04:00');
INSERT INTO `address` VALUES (1748043798954393601, '李锐', '13728920416', '湖南省', '长沙市', '岳麓区', '中南大学', 213412412, '2024-01-19 02:04:53', '2024-01-19 02:04:53');

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
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (213412412, '13728920416', '123', 'Lee', '2024-01-08 18:45:34', '2024-01-08 18:45:36');
INSERT INTO `customer` VALUES (1744311356070363137, '13932830967', '123456i', 'lee', '2024-01-08 18:53:30', '2024-01-08 18:53:30');

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`  (
  `id` bigint NOT NULL,
  `src_address_id` bigint NULL DEFAULT NULL,
  `dst_address_id` bigint NULL DEFAULT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deliveryman_id` bigint UNSIGNED NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `delivery_id`(`deliveryman_id` ASC) USING BTREE,
  INDEX `delivery_ibfk_1`(`src_address_id` ASC) USING BTREE,
  INDEX `delivery_ibfk_2`(`dst_address_id` ASC) USING BTREE,
  CONSTRAINT `delivery_ibfk_1` FOREIGN KEY (`src_address_id`) REFERENCES `address` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `delivery_ibfk_2` FOREIGN KEY (`dst_address_id`) REFERENCES `address` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `delivery_id` FOREIGN KEY (`deliveryman_id`) REFERENCES `deliveryman` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES (10887042, 12412513513412, 11451223464, '运输中', '电子产品', 104406, '2023-11-27 14:40:03', '2024-01-19 01:43:12');
INSERT INTO `delivery` VALUES (11004910, 1171363079, 11451223464, '待揽收', '电子产品', 1736218423244976130, '2023-11-27 14:40:00', '2023-12-17 10:57:06');
INSERT INTO `delivery` VALUES (11664854, 3687949627, 11451223464, '待揽收', '电子产品', 1736218423244976130, '2023-11-27 14:40:00', '2023-12-17 10:57:08');
INSERT INTO `delivery` VALUES (11726475, 11097718991, 11451223464, '运输中', '电子产品', 104406, '2023-11-27 14:40:00', '2023-12-17 10:24:58');
INSERT INTO `delivery` VALUES (12344712, 1171363079, 11029964958, '运输中', '电子产品', 939865, '2023-11-27 14:40:00', '2023-12-29 20:16:04');
INSERT INTO `delivery` VALUES (12772716, 11029964958, 11029964958, '运输中', '电子产品', 939865, '2023-11-27 14:40:00', '2024-01-19 01:57:14');
INSERT INTO `delivery` VALUES (12941000, 1171363079, 11029964958, '待取件', '电子产品', 1736218423244976130, '2023-11-27 14:40:00', '2024-01-19 02:02:14');
INSERT INTO `delivery` VALUES (12955260, 12412513513412, 11029964958, '运输中', '电子产品', 1736218423244976130, '2023-11-27 14:40:00', '2024-01-19 02:02:15');
INSERT INTO `delivery` VALUES (12993260, 3417768116, 10396369216, '待揽收', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:47');
INSERT INTO `delivery` VALUES (13767769, 12412513513412, 10396369216, '待取件', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:48');
INSERT INTO `delivery` VALUES (14856300, 1171363079, 10396369216, '已取件', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:50');
INSERT INTO `delivery` VALUES (14894091, 4611337591, 12412513513412, '待取件', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:54');
INSERT INTO `delivery` VALUES (14896520, 4611337591, 1171363079, '待取件', '生活用品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:55');
INSERT INTO `delivery` VALUES (14903816, 4611337591, 12412513513412, '待取件', '生活用品', 104406, '2023-11-27 14:40:00', '2023-12-14 20:57:58');
INSERT INTO `delivery` VALUES (15131145, 4611337591, 6564768996, '运输中', '生活用品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:57');
INSERT INTO `delivery` VALUES (15445547, 4611337591, 11289679788, '运输中', '生活用品', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (15542987, 4611337591, 12412513513412, '已取件', '文件票据', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16038760, 4611337591, 9699110209, '已取件 ', '工业生产', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16309744, 4611337591, 12412513513412, '待取件', '钟表首饰', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16352360, 4611337591, 1171363079, '运输中', '箱包', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16704555, 11289679788, 4876820902, '运输中', '文体娱乐', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16797528, 11289679788, 11289679788, '运输中', '副食干货', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17114623, 11289679788, 11289679788, '待揽收', '海鲜水产', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17322585, 11289679788, 11289679788, '待取件', '酒类', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17430756, 11289679788, 11289679788, '待取件', '医药保健', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17462903, 4611337591, 11289679788, '待揽收', '家具家电', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (18013366, 4611337591, 11289679788, '待揽收', '蔬菜', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (18736834, 11289679788, 11289679788, '待取件', '肉禽蛋品', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (1748049054119510017, 1748043798954393601, 1748043575121166338, '待揽件', '手机', NULL, '2024-01-19 02:25:46', '2024-01-19 02:25:46');

-- ----------------------------
-- Table structure for deliveryman
-- ----------------------------
DROP TABLE IF EXISTS `deliveryman`;
CREATE TABLE `deliveryman`  (
  `id` bigint UNSIGNED NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `work_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_card` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `visit_src` tinyint(1) NULL DEFAULT NULL,
  `visit_dst` tinyint(1) NULL DEFAULT NULL,
  `visit_delivery` tinyint(1) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of deliveryman
-- ----------------------------
INSERT INTO `deliveryman` VALUES (104406, '叶芳', '123', '1234', '辽宁省 辽阳市 太子河区 塔赫鲁', '530000198406213437', 1, 1, 1, '2010-07-31 19:13:04', '2024-01-19 01:48:38');
INSERT INTO `deliveryman` VALUES (106436, '萧芳', '21', '18976671756', '海南省 三沙市 中沙群岛的岛礁及其海域', '430000198507256571', 1, 1, 0, '2023-03-24 10:22:58', '2023-12-13 09:01:24');
INSERT INTO `deliveryman` VALUES (865352, '孟刚', '35', '13561313454', '江西省 上饶市 横峰县 你好', '45000020230817586X', 1, 1, 0, '2023-06-13 16:17:41', '2024-01-19 01:55:23');
INSERT INTO `deliveryman` VALUES (866315, '尹娟', '79', '13223351943', '澳门特别行政区 澳门半岛 -', '110000199210062688', 1, 1, 1, '2003-01-01 21:43:08', '2023-12-17 10:17:08');
INSERT INTO `deliveryman` VALUES (939865, '丁明', '80', '13256327237', '陕西省 延安市 延长县', '350000200006241531', 1, 1, 0, '1988-04-20 02:33:01', '1992-06-04 17:13:18');
INSERT INTO `deliveryman` VALUES (1736218423244976130, '李锐', '123456i', '13728920416', '待设置', '待设置', 0, 1, 1, '2023-12-17 10:55:04', '2024-01-19 02:01:09');
INSERT INTO `deliveryman` VALUES (1744311145759571969, 'alex', '123456i', '13632830969', '待设置', '待设置', 0, 0, 0, '2024-01-08 18:52:40', '2024-01-08 18:52:40');

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
