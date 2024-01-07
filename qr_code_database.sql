/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : qr_code_database

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 08/01/2024 03:24:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` bigint(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `county` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `customer_id` bigint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `address_ibfk_1`(`customer_id`) USING BTREE,
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (12412513513412, '李锐', '13728920416', '广东省', '深圳市', '宝安区', '西乡桃源居', NULL, '2023-12-28 16:31:22', '2023-12-28 16:31:24');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` bigint(0) NOT NULL,
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`  (
  `id` bigint(0) NOT NULL,
  `src_address_id` bigint(0) NULL DEFAULT NULL,
  `dst_address_id` bigint(0) NULL DEFAULT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deliveryman_id` bigint(0) UNSIGNED NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `delivery_id`(`deliveryman_id`) USING BTREE,
  INDEX `delivery_ibfk_1`(`src_address_id`) USING BTREE,
  INDEX `delivery_ibfk_2`(`dst_address_id`) USING BTREE,
  CONSTRAINT `delivery_ibfk_1` FOREIGN KEY (`src_address_id`) REFERENCES `address` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `delivery_ibfk_2` FOREIGN KEY (`dst_address_id`) REFERENCES `address` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `delivery_id` FOREIGN KEY (`deliveryman_id`) REFERENCES `deliveryman` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES (10887042, 12412513513412, 12412513513412, '运输中', '电子产品', 1736218423244976130, '2023-11-27 14:40:03', '2023-12-17 10:56:11');
INSERT INTO `delivery` VALUES (11004910, 12412513513412, 12412513513412, '待揽收', '电子产品', 1736218423244976130, '2023-11-27 14:40:00', '2023-12-17 10:57:06');
INSERT INTO `delivery` VALUES (11664854, 12412513513412, 12412513513412, '待揽收', '电子产品', 1736218423244976130, '2023-11-27 14:40:00', '2023-12-17 10:57:08');
INSERT INTO `delivery` VALUES (11726475, 12412513513412, 12412513513412, '运输中', '电子产品', 104406, '2023-11-27 14:40:00', '2023-12-17 10:24:58');
INSERT INTO `delivery` VALUES (12344712, 12412513513412, 12412513513412, '运输中', '电子产品', 939865, '2023-11-27 14:40:00', '2023-12-29 20:16:04');
INSERT INTO `delivery` VALUES (12772716, 12412513513412, 12412513513412, '运输中', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 21:05:08');
INSERT INTO `delivery` VALUES (12941000, 12412513513412, 12412513513412, '待取件', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 21:05:09');
INSERT INTO `delivery` VALUES (12955260, 12412513513412, 12412513513412, '运输中', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 21:05:10');
INSERT INTO `delivery` VALUES (12993260, 12412513513412, 12412513513412, '待揽收', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:47');
INSERT INTO `delivery` VALUES (13767769, 12412513513412, 12412513513412, '待取件', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:48');
INSERT INTO `delivery` VALUES (14856300, 12412513513412, 12412513513412, '已取件', '电子产品', 872911, '2023-11-27 14:40:00', '2023-12-14 20:57:50');
INSERT INTO `delivery` VALUES (14894091, 12412513513412, 12412513513412, '待取件', '电子产品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:54');
INSERT INTO `delivery` VALUES (14896520, 12412513513412, 12412513513412, '待取件', '生活用品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:55');
INSERT INTO `delivery` VALUES (14903816, 12412513513412, 12412513513412, '待取件', '生活用品', 104406, '2023-11-27 14:40:00', '2023-12-14 20:57:58');
INSERT INTO `delivery` VALUES (15131145, 12412513513412, 12412513513412, '运输中', '生活用品', NULL, '2023-11-27 14:40:00', '2023-12-14 20:57:57');
INSERT INTO `delivery` VALUES (15445547, 12412513513412, 12412513513412, '运输中', '生活用品', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (15542987, 12412513513412, 12412513513412, '已取件', '文件票据', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16038760, 12412513513412, 12412513513412, '已取件 ', '工业生产', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16309744, 12412513513412, 12412513513412, '待取件', '钟表首饰', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16352360, 12412513513412, 12412513513412, '运输中', '箱包', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16704555, 12412513513412, 12412513513412, '运输中', '文体娱乐', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (16797528, 12412513513412, 12412513513412, '运输中', '副食干货', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17114623, 12412513513412, 12412513513412, '待揽收', '海鲜水产', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17322585, 12412513513412, 12412513513412, '待取件', '酒类', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17430756, 12412513513412, 12412513513412, '待取件', '医药保健', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (17462903, 12412513513412, 12412513513412, '待揽收', '家具家电', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (18013366, 12412513513412, 12412513513412, '待揽收', '蔬菜', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');
INSERT INTO `delivery` VALUES (18736834, 12412513513412, 12412513513412, '待取件', '肉禽蛋品', NULL, '2023-11-27 14:40:00', '2023-12-05 14:40:13');

-- ----------------------------
-- Table structure for deliveryman
-- ----------------------------
DROP TABLE IF EXISTS `deliveryman`;
CREATE TABLE `deliveryman`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `work_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_card` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `visit_src` tinyint(1) NULL DEFAULT NULL,
  `visit_dst` tinyint(1) NULL DEFAULT NULL,
  `visit_delivery` tinyint(1) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deliveryman
-- ----------------------------
INSERT INTO `deliveryman` VALUES (104406, '叶芳', '123', '123', '辽宁省 辽阳市 太子河区', '530000198406213437', 1, 1, 1, '2010-07-31 19:13:04', '2023-12-11 23:23:48');
INSERT INTO `deliveryman` VALUES (106436, '萧芳', '21', '18976671756', '海南省 三沙市 中沙群岛的岛礁及其海域', '430000198507256571', 1, 1, 0, '2023-03-24 10:22:58', '2023-12-13 09:01:24');
INSERT INTO `deliveryman` VALUES (865352, '孟刚', '35', '13561313454', '江西省 上饶市 横峰县', '45000020230817586X', 1, 1, 0, '2023-06-13 16:17:41', '2023-12-17 10:17:09');
INSERT INTO `deliveryman` VALUES (866315, '尹娟', '79', '13223351943', '澳门特别行政区 澳门半岛 -', '110000199210062688', 1, 1, 1, '2003-01-01 21:43:08', '2023-12-17 10:17:08');
INSERT INTO `deliveryman` VALUES (872911, '武霞', '13', '13566558241', '西藏自治区 那曲地区 申扎县', '650000201405158474', 1, 0, 0, '2022-01-03 09:36:46', '2008-01-14 13:48:59');
INSERT INTO `deliveryman` VALUES (939865, '丁明', '80', '13256327237', '陕西省 延安市 延长县', '350000200006241531', 1, 1, 0, '1988-04-20 02:33:01', '1992-06-04 17:13:18');
INSERT INTO `deliveryman` VALUES (1736218423244976130, '李锐', '123456i', '13728920416', '待设置', '待设置', 1, 1, 1, '2023-12-17 10:55:04', '2023-12-17 10:57:12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (123, 'admin', '123');

SET FOREIGN_KEY_CHECKS = 1;
