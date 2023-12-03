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

 Date: 03/12/2023 18:54:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`  (
  `id` int(0) NOT NULL,
  `src_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `src_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `src_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES (10098490, 'Carl', '17817264113', 'Willow', '172356772822', 'Ap #344-5113 Pretium Rd.', 'Ap #990-2862 Orci, Road', '待揽收');
INSERT INTO `delivery` VALUES (10887042, 'Halee', '14107510872', 'Melvin', '146665765146', 'Ap #980-564 Sodales Street', 'Ap #932-9085 Sagittis Rd.', '运输中');
INSERT INTO `delivery` VALUES (11004910, 'Prescott', '19436312672', 'Amery', '152233325737', '686-9876 Ut, Avenue', 'P.O. Box 120, 3801 Convallis Av.', '待揽收');
INSERT INTO `delivery` VALUES (11664854, 'Ava', '12340326178', 'Noble', '176757543028', 'Ap #190-4225 Cursus Road', '537-9489 Mus. St.', '待揽收');
INSERT INTO `delivery` VALUES (11726475, 'Signe', '19718468776', 'Ann', '125484173171', '357-4289 Praesent Road', 'P.O. Box 450, 4993 Massa. Av.', '运输中');
INSERT INTO `delivery` VALUES (12344712, 'Phyllis', '14748547248', 'Bree', '136989698815', '992-6928 Ut St.', '1735 Molestie Road', '运输中');
INSERT INTO `delivery` VALUES (12772716, 'Reece', '17175779423', 'Rogan', '133669812616', 'Ap #679-8747 Ad Rd.', 'P.O. Box 499, 5665 Rhoncus Ave', '运输中');
INSERT INTO `delivery` VALUES (12941000, 'Hadley', '13093559515', 'Dahlia', '122778139735', '3200 Blandit Road', '112-3066 Nonummy. Ave', '待取件');
INSERT INTO `delivery` VALUES (12955260, 'Raven', '17167371186', 'Katell', '188526460513', '876-2958 Justo. St.', '552-5458 Et, Ave', '运输中');
INSERT INTO `delivery` VALUES (12993260, 'Cyrus', '16406326494', 'Xantha', '125109628221', '889-4136 Consequat Ave', 'Ap #856-5594 Vestibulum St.', '待揽收');
INSERT INTO `delivery` VALUES (13767769, 'Lucian', '12215813666', 'Uriah', '124724898518', '183-9940 Convallis Avenue', '173-659 Dolor Rd.', '待取件');
INSERT INTO `delivery` VALUES (14856300, 'Edan', '17986156367', 'Coby', '137412140541', 'P.O. Box 815, 7513 Non Avenue', 'P.O. Box 767, 3253 Risus. Road', '已取件');
INSERT INTO `delivery` VALUES (14894091, 'Alice', '12745515468', 'Forrest', '156544270417', 'Ap #861-5950 Lorem Ave', 'P.O. Box 865, 9268 Imperdiet Rd.', '待取件');
INSERT INTO `delivery` VALUES (14896520, 'Cody', '12614866860', 'Risa', '165944873485', '433-1635 Semper Rd.', 'P.O. Box 872, 8174 Nam Road', '待取件');
INSERT INTO `delivery` VALUES (14903816, 'Herrod', '15795758527', 'Ella', '161737251175', '353-2357 Magna. Road', '7536 Risus. Street', '待取件');
INSERT INTO `delivery` VALUES (15007457, 'Colton', '13122981968', 'Jennifer', '183571693714', 'Ap #394-9002 Eu, Av.', 'Ap #812-2371 Imperdiet Avenue', '待取件');
INSERT INTO `delivery` VALUES (15131145, 'Ria', '14175925072', 'Herman', '183678969631', '744-3566 Eu Road', 'Ap #736-8007 Commodo Avenue', '运输中');
INSERT INTO `delivery` VALUES (15445547, 'Angela', '13711165480', 'Wade', '169126792754', 'Ap #716-552 Dui. Ave', 'Ap #436-2170 Donec St.', '运输中');
INSERT INTO `delivery` VALUES (15542987, 'Halee', '12615446248', 'Giselle', '147522638878', '166-4288 Eu, Road', '542-8834 Magna Rd.', '已取件');
INSERT INTO `delivery` VALUES (16038760, 'Ingrid', '19067767334', 'Karina', '176246656321', 'P.O. Box 508, 2160 Erat, Ave', 'Ap #579-4495 Magna St.', '已取件 ');
INSERT INTO `delivery` VALUES (16309744, 'Hedley', '17564642378', 'Elaine', '162548706127', 'Ap #768-9186 Luctus Rd.', '391-3387 A, Rd.', '待取件');
INSERT INTO `delivery` VALUES (16352360, 'Mira', '18334913362', 'Sebastian', '121188773235', '839-9974 A, Road', '191-3769 Consectetuer Rd.', '运输中');
INSERT INTO `delivery` VALUES (16704555, 'Brody', '14253207175', 'Mikayla', '124158965974', '314-5868 Nascetur Ave', '398-9719 Orci Rd.', '运输中');
INSERT INTO `delivery` VALUES (16797528, 'Wanda', '13422845374', 'Amos', '137371486244', 'Ap #589-6629 Diam St.', '657-9743 Pede. St.', '运输中');
INSERT INTO `delivery` VALUES (17114623, 'Quyn', '16485129843', 'Olivia', '183043320795', 'Ap #104-596 Senectus St.', 'P.O. Box 891, 1116 Tempor Ave', '待揽收');
INSERT INTO `delivery` VALUES (17322585, 'Owen', '15211911186', 'Florence', '182130425140', 'Ap #326-3977 Ligula Road', 'P.O. Box 178, 9414 Nam Rd.', '待取件');
INSERT INTO `delivery` VALUES (17430756, 'Blossom', '14853726290', 'Tatiana', '132482254953', '7711 Dui. Road', 'P.O. Box 986, 8655 Libero. St.', '待取件');
INSERT INTO `delivery` VALUES (17462903, 'Armand', '16314434444', 'Kyra', '175265839751', 'Ap #128-8924 Mus. St.', '510-9222 Dapibus St.', '待揽收');
INSERT INTO `delivery` VALUES (18013366, 'Penelope', '15262623307', 'Cullen', '146581594633', '146-7507 Lacinia. Rd.', '579-7179 Iaculis Rd.', '待揽收');
INSERT INTO `delivery` VALUES (18736834, 'Jonah', '14942816129', 'Oleg', '146957614129', '726-432 Interdum. Rd.', 'Ap #412-4478 Libero Road', '待取件');

-- ----------------------------
-- Table structure for deliveryman
-- ----------------------------
DROP TABLE IF EXISTS `deliveryman`;
CREATE TABLE `deliveryman`  (
  `id` int(0) NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deliveryman
-- ----------------------------
INSERT INTO `deliveryman` VALUES (10110232, 'Brenna', '7', '+86-19655466515');
INSERT INTO `deliveryman` VALUES (10446861, 'Winifred', '7', '+86-13292365133');
INSERT INTO `deliveryman` VALUES (11582005, 'William', '8', '+86-14345008776');
INSERT INTO `deliveryman` VALUES (11710063, 'Jacqueline', '4', '+86-15766795518');
INSERT INTO `deliveryman` VALUES (11726475, 'Signe', '6', '+86-18434322895');
INSERT INTO `deliveryman` VALUES (11954195, 'Oscar', '5', '+86-12801043730');
INSERT INTO `deliveryman` VALUES (12414140, 'Hashim', '9', '+86-19041871515');
INSERT INTO `deliveryman` VALUES (12993260, 'Cyrus', '5', '+86-18589436744');
INSERT INTO `deliveryman` VALUES (15253086, 'Brody', '9', '+86-12985588794');
INSERT INTO `deliveryman` VALUES (15318744, 'Nomlanga', '7', '+86-11032425451');
INSERT INTO `deliveryman` VALUES (15563713, 'Fritz', '2', '+86-19980664613');
INSERT INTO `deliveryman` VALUES (16038760, 'Ingrid', '8', '+86-16564562568');
INSERT INTO `deliveryman` VALUES (16963544, 'Chaney', '9', '+86-16555444483');
INSERT INTO `deliveryman` VALUES (17430756, 'Blossom', '4', '+86-16751881620');
INSERT INTO `deliveryman` VALUES (18013366, 'Penelope', '9', '+86-19266291744');

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
