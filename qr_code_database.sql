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

 Date: 05/12/2023 10:57:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`  (
  `id` int NOT NULL,
  `src_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `src_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `src_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dst_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

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
  `id` int NOT NULL,
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `work_address` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_card` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of deliveryman
-- ----------------------------
INSERT INTO `deliveryman` VALUES (104406, '叶芳', '16', '13531012123', '2010-07-31 19:13:04', '1986-12-06 05:56:56', '辽宁省 辽阳市 太子河区', '530000198406213437');
INSERT INTO `deliveryman` VALUES (106436, '萧芳', '21', '18976671756', '2023-03-24 10:22:58', '2006-06-04 08:19:56', '海南省 三沙市 中沙群岛的岛礁及其海域', '430000198507256571');
INSERT INTO `deliveryman` VALUES (110997, '乔娜', '50', '13581564457', '2003-07-19 14:09:59', '2009-10-30 04:52:22', '河北省 保定市 高碑店市', '210000198403146545');
INSERT INTO `deliveryman` VALUES (111148, '蒋秀兰', '13', '18921573479', '2017-11-15 19:17:56', '1970-07-03 14:47:06', '青海省 海东市 互助土族自治县', '710000198706181151');
INSERT INTO `deliveryman` VALUES (112336, '阎艳', '99', '13235481873', '2006-12-29 16:53:31', '1988-12-05 23:34:45', '黑龙江省 大兴安岭地区 塔河县', '540000197503112643');
INSERT INTO `deliveryman` VALUES (124907, '姜杰', '109', '13532454383', '2020-04-03 09:29:47', '1980-02-16 18:38:46', '海外 海外 -', '110000200408187262');
INSERT INTO `deliveryman` VALUES (129710, '常娟', '45', '13517421774', '1981-11-28 13:20:35', '2022-02-16 00:31:54', '辽宁省 阜新市 阜新蒙古族自治县', '420000200712064331');
INSERT INTO `deliveryman` VALUES (154821, '段芳', '58', '13288871002', '1999-05-19 03:20:40', '2004-02-18 20:11:48', '台湾 彰化县 大村乡', '210000200605304337');
INSERT INTO `deliveryman` VALUES (173017, '赖霞', '72', '18901703843', '2011-06-27 12:26:19', '1986-05-03 03:04:52', '广西壮族自治区 河池市 天峨县', '140000201302022152');
INSERT INTO `deliveryman` VALUES (211436, '吴勇', '55', '13254482868', '1972-03-10 13:34:52', '2003-07-08 07:21:10', '河北省 邢台市 桥西区', '450000201711041074');
INSERT INTO `deliveryman` VALUES (218899, '萧娜', '101', '13558955247', '2012-03-14 15:49:39', '1977-09-18 00:08:11', '陕西省 汉中市 南郑县', '230000201806147575');
INSERT INTO `deliveryman` VALUES (223535, '程丽', '112', '18989844182', '1988-02-10 02:44:30', '2018-10-04 07:03:02', '湖北省 荆州市 沙市区', '630000200504246906');
INSERT INTO `deliveryman` VALUES (234998, '傅杰', '2', '13255100654', '1982-08-08 21:30:16', '1981-05-22 02:39:12', '台湾 基隆市 信义区', '810000200406171713');
INSERT INTO `deliveryman` VALUES (265533, '刘磊', '61', '13536873177', '1971-11-02 20:43:19', '1991-10-04 00:22:44', '广东省 梅州市 兴宁市', '640000197304012651');
INSERT INTO `deliveryman` VALUES (265641, '林伟', '17', '13513339435', '1990-12-03 23:23:03', '2014-10-07 12:04:37', '福建省 厦门市 湖里区', '430000202207273977');
INSERT INTO `deliveryman` VALUES (310401, '黄娟', '115', '18957878353', '1991-01-14 15:50:19', '2022-01-05 15:26:10', '安徽省 铜陵市 铜陵县', '630000200607124282');
INSERT INTO `deliveryman` VALUES (315793, '薛刚', '103', '13525175719', '1976-07-19 01:50:50', '2010-06-09 08:49:09', '江苏省 泰州市 高港区', '12000020060206951X');
INSERT INTO `deliveryman` VALUES (325216, '曾超', '107', '13533514475', '2005-07-27 14:26:38', '1991-02-28 11:15:27', '贵州省 安顺市 普定县', '120000202301210654');
INSERT INTO `deliveryman` VALUES (325638, '雷秀兰', '20', '13254357442', '1989-03-26 23:52:31', '2016-04-05 01:59:58', '辽宁省 本溪市 溪湖区', '640000198310282476');
INSERT INTO `deliveryman` VALUES (336879, '曾芳', '118', '18989717543', '2017-08-22 10:37:50', '1987-07-11 05:47:51', '广东省 阳江市 其它区', '630000200104211827');
INSERT INTO `deliveryman` VALUES (357027, '郑勇', '63', '13234943022', '1993-07-27 22:51:15', '2009-04-01 01:41:48', '江西省 新余市 其它区', '810000201310060132');
INSERT INTO `deliveryman` VALUES (370797, '侯秀兰', '1', '13283622393', '2010-03-17 19:56:19', '1978-05-03 16:03:19', '广西壮族自治区 来宾市 象州县', '520000198601157651');
INSERT INTO `deliveryman` VALUES (396128, '毛丽', '80', '13546543726', '2012-12-09 03:54:12', '2013-11-05 05:58:09', '黑龙江省 双鸭山市 其它区', '460000199407081989');
INSERT INTO `deliveryman` VALUES (401436, '郑芳', '104', '13544428266', '2011-02-23 22:20:42', '1974-12-29 12:43:28', '贵州省 黔西南布依族苗族自治州 兴义市', '140000200104197168');
INSERT INTO `deliveryman` VALUES (410274, '毛秀英', '56', '13274963268', '2005-02-03 15:43:17', '1978-08-07 14:47:59', '吉林省 白山市 抚松县', '150000197308141542');
INSERT INTO `deliveryman` VALUES (433270, '叶娜', '95', '13239779423', '1982-08-29 17:46:59', '2003-12-20 01:04:08', '台湾 基隆市 其它区', '140000200702041817');
INSERT INTO `deliveryman` VALUES (454617, '唐丽', '98', '13244344212', '1998-01-10 02:40:49', '2014-03-13 23:12:28', '重庆 重庆市 沙坪坝区', '420000197302188556');
INSERT INTO `deliveryman` VALUES (460705, '阎秀英', '49', '13551858878', '2009-11-05 05:10:20', '1995-08-08 00:21:03', '甘肃省 白银市 景泰县', '330000199101301142');
INSERT INTO `deliveryman` VALUES (478407, '冯平', '100', '13216033481', '2001-08-24 22:47:12', '2012-11-19 04:34:12', '天津 天津市 西青区', '330000201312231826');
INSERT INTO `deliveryman` VALUES (478496, '杜刚', '86', '18976605133', '1982-11-28 10:26:32', '1993-05-29 20:34:55', '陕西省 宝鸡市 陇县', '130000200402294327');
INSERT INTO `deliveryman` VALUES (482889, '曾秀兰', '104', '13586593050', '1974-08-26 17:55:13', '1998-06-19 07:34:17', '香港特别行政区 香港岛 南区', '640000197504060674');
INSERT INTO `deliveryman` VALUES (523042, '程磊', '92', '13221523859', '1991-09-24 20:26:31', '2018-02-09 20:31:44', '香港特别行政区 新界 葵青区', '530000201108057485');
INSERT INTO `deliveryman` VALUES (527665, '唐勇', '101', '13580488524', '1986-03-23 06:19:34', '2006-06-23 23:50:18', '云南省 怒江傈僳族自治州 福贡县', '500000198804157279');
INSERT INTO `deliveryman` VALUES (538292, '史秀兰', '48', '13242417680', '2008-04-13 12:57:50', '2004-07-16 14:00:21', '内蒙古自治区 乌海市 海南区', '500000199602285752');
INSERT INTO `deliveryman` VALUES (541559, '林芳', '57', '13552724583', '2003-07-05 16:11:18', '2013-10-19 14:18:58', '广东省 阳江市 阳春市', '620000197105058821');
INSERT INTO `deliveryman` VALUES (553390, '邱芳', '11', '13552844876', '2012-12-17 14:57:54', '2001-11-10 22:12:40', '天津 天津市 武清区', '130000199709236783');
INSERT INTO `deliveryman` VALUES (596332, '薛霞', '61', '13598733459', '2005-04-06 06:10:55', '2015-11-07 22:15:23', '广东省 潮州市 潮安区', '630000198506241180');
INSERT INTO `deliveryman` VALUES (597488, '孙磊', '114', '13278538936', '2005-05-10 07:52:05', '2008-01-08 20:28:08', '新疆维吾尔自治区 博尔塔拉蒙古自治州 温泉县', '630000197901200333');
INSERT INTO `deliveryman` VALUES (613059, '毛艳', '93', '13512833048', '1993-10-20 17:34:44', '1993-10-24 22:38:30', '湖北省 黄石市 大冶市', '330000201202167413');
INSERT INTO `deliveryman` VALUES (614062, '姜秀兰', '35', '13212149283', '2008-12-12 09:55:53', '1974-02-05 03:02:07', '陕西省 汉中市 镇巴县', '430000199912032699');
INSERT INTO `deliveryman` VALUES (621009, '马秀英', '78', '13523421371', '1986-08-24 00:00:44', '1976-06-29 14:15:15', '江西省 景德镇市 浮梁县', '230000198312243124');
INSERT INTO `deliveryman` VALUES (623147, '郑秀兰', '25', '13508666864', '2010-05-15 23:30:59', '2009-02-04 05:26:32', '广东省 梅州市 其它区', '540000199510167262');
INSERT INTO `deliveryman` VALUES (638347, '白桂英', '38', '18952314428', '1997-10-26 22:51:20', '2013-11-28 10:39:16', '吉林省 四平市 其它区', '650000201511185548');
INSERT INTO `deliveryman` VALUES (641503, '宋杰', '79', '13254617555', '1980-07-14 12:28:43', '1985-08-29 04:44:38', '宁夏回族自治区 中卫市 中宁县', '540000199109172620');
INSERT INTO `deliveryman` VALUES (644810, '任丽', '97', '13517470775', '2017-08-18 23:08:26', '1972-05-19 03:42:02', '广东省 湛江市 霞山区', '140000198011240219');
INSERT INTO `deliveryman` VALUES (659634, '史敏', '54', '18923118591', '1980-08-16 12:49:05', '1980-02-11 15:28:51', '青海省 海北藏族自治州 刚察县', '110000200905294739');
INSERT INTO `deliveryman` VALUES (671229, '万丽', '7', '13572580500', '1975-11-29 14:30:46', '2001-07-09 15:55:32', '湖南省 娄底市 冷水江市', '440000198609217284');
INSERT INTO `deliveryman` VALUES (681324, '谢强', '21', '13551488212', '1981-06-19 16:46:11', '1982-09-11 08:55:23', '湖南省 娄底市 冷水江市', '410000200410038697');
INSERT INTO `deliveryman` VALUES (681637, '任磊', '66', '13241416797', '2004-05-25 17:19:32', '1985-05-02 01:52:00', '甘肃省 天水市 清水县', '710000201210132502');
INSERT INTO `deliveryman` VALUES (681942, '丁明', '44', '13580914742', '2017-04-27 08:21:39', '2018-05-15 07:46:16', '湖南省 岳阳市 汨罗市', '130000200504115721');
INSERT INTO `deliveryman` VALUES (685873, '金强', '94', '13264741322', '1999-04-18 05:55:04', '2006-06-08 04:02:12', '福建省 三明市 将乐县', '710000199906061116');
INSERT INTO `deliveryman` VALUES (686140, '邱涛', '39', '13238315451', '2011-04-24 20:08:09', '1990-04-17 00:58:30', '天津 天津市 河北区', '430000201802046635');
INSERT INTO `deliveryman` VALUES (691176, '孙超', '81', '13270283034', '1973-08-11 12:42:08', '2001-08-06 17:16:10', '福建省 宁德市 古田县', '820000198106244441');
INSERT INTO `deliveryman` VALUES (695142, '丁秀兰', '83', '18928556575', '1997-02-04 17:50:25', '1997-02-24 20:06:37', '云南省 保山市 昌宁县', '540000200707138583');
INSERT INTO `deliveryman` VALUES (704154, '何秀英', '12', '13240572758', '1982-04-27 23:19:23', '1996-09-21 08:31:25', '辽宁省 抚顺市 新宾满族自治县', '630000198704054036');
INSERT INTO `deliveryman` VALUES (743975, '常磊', '90', '13569367441', '1988-04-12 20:18:33', '2014-01-28 05:31:50', '浙江省 杭州市 滨江区', '710000200310023296');
INSERT INTO `deliveryman` VALUES (764077, '郝静', '105', '13282509553', '1987-03-08 09:06:37', '2010-07-02 17:08:19', '吉林省 长春市 农安县', '130000197910254693');
INSERT INTO `deliveryman` VALUES (771636, '于明', '103', '13533424577', '2000-09-27 21:47:05', '2022-06-14 18:08:14', '北京 北京市 平谷区', '220000201303255513');
INSERT INTO `deliveryman` VALUES (787190, '苏娟', '14', '13529636365', '1998-12-24 18:15:42', '1998-01-26 05:23:49', '上海 上海市 杨浦区', '32000020210625873X');
INSERT INTO `deliveryman` VALUES (788874, '田洋', '14', '13298818129', '1974-12-07 23:48:31', '2004-09-26 05:39:42', '重庆 重庆市 沙坪坝区', '120000200111123411');
INSERT INTO `deliveryman` VALUES (792219, '曾秀兰', '97', '13511451218', '1986-05-16 23:45:43', '2021-08-21 08:10:58', '澳门特别行政区 澳门半岛 -', '710000198202034537');
INSERT INTO `deliveryman` VALUES (799412, '蒋敏', '54', '13294734498', '1997-05-07 04:29:33', '1976-08-10 15:44:06', '湖南省 张家界市 桑植县', '140000198308045051');
INSERT INTO `deliveryman` VALUES (801058, '蒋静', '82', '13516440238', '1985-03-31 20:41:04', '1999-03-06 07:06:16', '广西壮族自治区 北海市 其它区', '64000019941016827X');
INSERT INTO `deliveryman` VALUES (805362, '张桂英', '71', '13574321111', '2019-08-17 08:34:54', '1999-07-25 22:27:45', '青海省 海南藏族自治州 贵南县', '990000199706126423');
INSERT INTO `deliveryman` VALUES (807868, '杨平', '9', '13537911312', '1993-11-17 11:41:19', '2017-07-21 05:46:46', '青海省 海东市 乐都区', '630000199811165377');
INSERT INTO `deliveryman` VALUES (825235, '何明', '42', '13278627542', '1977-01-10 00:58:09', '1975-09-01 13:06:18', '江苏省 连云港市 赣榆县', '820000200804154283');
INSERT INTO `deliveryman` VALUES (833108, '金勇', '98', '13567625471', '2003-10-31 19:59:17', '1974-04-23 12:55:45', '甘肃省 嘉峪关市 -', '220000201811026426');
INSERT INTO `deliveryman` VALUES (865352, '孟刚', '35', '13561313454', '2023-06-13 16:17:41', '2020-01-19 19:54:39', '江西省 上饶市 横峰县', '45000020230817586X');
INSERT INTO `deliveryman` VALUES (866315, '尹娟', '79', '13223351943', '2003-01-01 21:43:08', '1983-10-05 15:05:31', '澳门特别行政区 澳门半岛 -', '110000199210062688');
INSERT INTO `deliveryman` VALUES (872911, '武霞', '13', '13566558241', '2022-01-03 09:36:46', '2008-01-14 13:48:59', '西藏自治区 那曲地区 申扎县', '650000201405158474');
INSERT INTO `deliveryman` VALUES (886084, '胡丽', '33', '13567526748', '1992-02-18 23:46:46', '2000-09-18 05:09:53', '新疆维吾尔自治区 吐鲁番地区 托克逊县', '510000198904046113');
INSERT INTO `deliveryman` VALUES (891410, '汪敏', '39', '13247747428', '2014-08-28 18:09:36', '2002-12-02 05:36:27', '贵州省 铜仁市 江口县', '450000198506206306');
INSERT INTO `deliveryman` VALUES (899409, '郭静', '43', '13521637774', '2020-09-03 12:29:03', '1996-03-03 04:12:53', '台湾 南投县 名间乡', '120000198706226575');
INSERT INTO `deliveryman` VALUES (915024, '黄明', '34', '18948542315', '1974-11-01 20:17:27', '2014-04-03 13:56:49', '黑龙江省 鹤岗市 其它区', '420000201506131411');
INSERT INTO `deliveryman` VALUES (936784, '谢秀英', '98', '13572689373', '2017-07-16 10:18:09', '2004-01-23 18:39:20', '香港特别行政区 九龙 黄大仙区', '150000199011210382');
INSERT INTO `deliveryman` VALUES (937005, '江刚', '6', '13524216845', '2011-01-05 09:20:19', '2023-04-12 11:49:42', '广西壮族自治区 河池市 凤山县', '320000197404235743');
INSERT INTO `deliveryman` VALUES (939865, '丁明', '80', '13256327237', '1988-04-20 02:33:01', '1992-06-04 17:13:18', '陕西省 延安市 延长县', '350000200006241531');
INSERT INTO `deliveryman` VALUES (944711, '田艳', '47', '13545693756', '1973-05-01 15:08:50', '1982-05-10 03:57:29', '福建省 莆田市 仙游县', '820000201201316882');
INSERT INTO `deliveryman` VALUES (955071, '丁磊', '80', '13560943228', '1990-04-05 00:14:18', '1984-12-08 08:09:41', '北京 北京市 海淀区', '650000201604157714');
INSERT INTO `deliveryman` VALUES (973381, '郑磊', '118', '13587592883', '1978-03-28 22:18:06', '1982-03-07 00:12:38', '上海 上海市 浦东新区', '410000201404146565');
INSERT INTO `deliveryman` VALUES (975326, '余明', '52', '18957044432', '2018-12-26 19:55:16', '2018-02-10 06:44:08', '贵州省 黔西南布依族苗族自治州 其它区', '45000020230516388X');
INSERT INTO `deliveryman` VALUES (975695, '许勇', '31', '13235620326', '2008-07-29 05:41:16', '2009-11-21 13:53:34', '贵州省 安顺市 普定县', '650000198704032674');
INSERT INTO `deliveryman` VALUES (976703, '姚明', '26', '18931146573', '2011-10-13 21:18:08', '1980-01-15 21:45:09', '河北省 衡水市 阜城县', '990000201607024763');
INSERT INTO `deliveryman` VALUES (993308, '万静', '28', '13556835526', '1978-02-23 19:05:29', '1993-03-26 12:56:49', '陕西省 汉中市 宁强县', '640000201002275519');
INSERT INTO `deliveryman` VALUES (993943, '冯艳', '38', '13586222616', '1977-12-21 14:00:21', '2015-01-16 16:45:19', '安徽省 蚌埠市 怀远县', '330000199005261646');
INSERT INTO `deliveryman` VALUES (1011859, '余洋', '95', '13543425186', '1984-03-01 08:06:59', '2015-03-04 10:31:32', '黑龙江省 牡丹江市 爱民区', '340000200502136384');
INSERT INTO `deliveryman` VALUES (1029627, '石丽', '66', '13578462744', '1980-02-09 02:45:53', '1992-04-22 00:28:35', '宁夏回族自治区 石嘴山市 惠农区', '510000200609194674');
INSERT INTO `deliveryman` VALUES (1051752, '龚霞', '111', '13285323463', '1988-07-12 23:12:42', '2009-07-11 19:56:02', '黑龙江省 佳木斯市 桦川县', '510000197611245253');
INSERT INTO `deliveryman` VALUES (1079037, '彭磊', '51', '13285856611', '1980-12-03 04:32:40', '2012-09-08 04:28:38', '黑龙江省 双鸭山市 饶河县', '520000197505273260');
INSERT INTO `deliveryman` VALUES (1086245, '石洋', '5', '13221823546', '2008-04-18 07:57:06', '1987-07-30 17:38:15', '安徽省 黄山市 黟县', '650000200605189772');
INSERT INTO `deliveryman` VALUES (1088056, '罗秀兰', '11', '18947477258', '1980-02-24 14:29:46', '1972-10-09 06:08:25', '北京 北京市 怀柔区', '990000197809029563');
INSERT INTO `deliveryman` VALUES (1091355, '薛丽', '101', '13538615388', '1974-07-03 05:38:49', '1998-07-16 10:00:04', '福建省 漳州市 华安县', '630000200709287576');
INSERT INTO `deliveryman` VALUES (1097087, '夏洋', '17', '18918244273', '2015-10-09 02:46:31', '2002-11-24 07:50:30', '澳门特别行政区 离岛 -', '810000199705278785');
INSERT INTO `deliveryman` VALUES (1100835, '许超', '16', '18919858584', '2003-07-09 21:05:03', '1989-10-01 13:20:28', '江西省 赣州市 全南县', '540000198911162484');
INSERT INTO `deliveryman` VALUES (1131789, '于磊', '115', '13235157687', '1995-01-09 07:32:15', '1999-02-28 04:58:00', '台湾 嘉义市 其它区', '210000198707102349');
INSERT INTO `deliveryman` VALUES (1142205, '周静', '53', '18982770486', '2008-04-30 21:52:43', '2012-02-08 21:04:45', '宁夏回族自治区 石嘴山市 惠农区', '530000201112064485');
INSERT INTO `deliveryman` VALUES (1156187, '常强', '47', '13206320112', '1988-10-28 06:07:40', '1990-11-22 10:29:39', '福建省 福州市 晋安区', '620000197608013334');
INSERT INTO `deliveryman` VALUES (1173196, '黄超', '116', '13515757042', '2007-10-18 18:30:29', '2016-07-27 04:31:34', '内蒙古自治区 乌兰察布市 凉城县', '340000197902233568');
INSERT INTO `deliveryman` VALUES (1175326, '周敏', '39', '18928775168', '2005-03-02 18:42:19', '1981-02-10 05:48:25', '福建省 三明市 宁化县', '330000201803224188');
INSERT INTO `deliveryman` VALUES (10110232, 'Brenna', '7', '+86-19655466515', '2023-12-04 00:00:00', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (10446861, 'Winifred', '7', '+86-13292365133', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (11582005, 'William', '8', '+86-14345008776', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (11710063, 'Jacqueline', '4', '+86-15766795518', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (11726475, 'Signe', '6', '+86-18434322895', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (11954195, 'Oscar', '5', '+86-12801043730', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (12414140, 'Hashim', '9', '+86-19041871515', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (12993260, 'Cyrus', '5', '+86-18589436744', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (15253086, 'Brody', '9', '+86-12985588794', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (15318744, 'Nomlanga', '7', '+86-11032425451', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (15563713, 'Fritz', '2', '+86-19980664613', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (16038760, 'Ingrid', '8', '+86-16564562568', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (16963544, 'Chaney', '9', '+86-16555444483', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);
INSERT INTO `deliveryman` VALUES (17430756, 'Blossom', '4', '+86-16751881620', '2023-12-04 12:33:54', '2023-12-04 12:33:54', NULL, NULL);

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
