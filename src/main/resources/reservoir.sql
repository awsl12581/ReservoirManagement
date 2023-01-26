/*
 Navicat Premium Data Transfer

 Source Server         : localhost.mysql
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : reservoir

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 24/05/2022 19:40:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reservoir_coordinates
-- ----------------------------
DROP TABLE IF EXISTS `reservoir_coordinates`;
CREATE TABLE `reservoir_coordinates`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `reservoir_id` int NOT NULL,
  `lat` double(12, 6) NOT NULL,
  `lng` double(12, 6) NOT NULL,
  `record` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservoir_coordinates
-- ----------------------------
INSERT INTO `reservoir_coordinates` VALUES (2, 15, 112.249842, 34.945723, '270');
INSERT INTO `reservoir_coordinates` VALUES (3, 16, 111.126934, 32.711372, '170');
INSERT INTO `reservoir_coordinates` VALUES (4, 17, 116.913914, 40.517502, '157.5');
INSERT INTO `reservoir_coordinates` VALUES (5, 18, 115.798830, 40.398723, '483.07');
INSERT INTO `reservoir_coordinates` VALUES (6, 19, 114.171204, 36.292220, '145');
INSERT INTO `reservoir_coordinates` VALUES (7, 20, 116.593035, 40.309519, '155');
INSERT INTO `reservoir_coordinates` VALUES (8, 21, 118.772982, 29.699056, '112');
INSERT INTO `reservoir_coordinates` VALUES (9, 22, 109.501800, 109.550300, '99');
INSERT INTO `reservoir_coordinates` VALUES (10, 23, 115.194353, 29.272233, '159');
INSERT INTO `reservoir_coordinates` VALUES (11, 24, 114.629071, 23.778596, '155');
INSERT INTO `reservoir_coordinates` VALUES (12, 25, 103.254745, 35.861568, '156');

-- ----------------------------
-- Table structure for reservoir_info
-- ----------------------------
DROP TABLE IF EXISTS `reservoir_info`;
CREATE TABLE `reservoir_info`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `reservoir_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `completion_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservoir_info
-- ----------------------------
INSERT INTO `reservoir_info` VALUES (15, '小浪底水库', '河南省洛阳市孟津县小浪底村', '1997-10-28', '工程地处黄河中游最后一段峡谷的出口，控制流域面积69.4万平方公里，占黄河流域面积的92.3%，主要功能为治沙防洪，辅助功能为发电，是治理黄河的关键水利工程，被世界银行誉为该行与发展中国家合作项目的典范。');
INSERT INTO `reservoir_info` VALUES (16, '丹江口水库', '湖北省十堰市丹江口市和河南省南阳市淅川县境内', '2009-06', '丹江口水库的水源分别由发源自陕西省宁强县蟠冢山的汉江、发源于陕西省秦岭地区商洛市西北部凤凰山南麓的丹江和发源自河南省栾川县小庙岭的淅水组成。丹江口水库最开阔处位于湖北省丹江口市和河南省淅川县交界处，形成长30余公里、宽20余公里的水面，被誉为“小太平洋”。');
INSERT INTO `reservoir_info` VALUES (17, '密云水库', '北京市密云区城区北16千米处', '1960-09', '1985年被列为一级水源保护区。按千年一遇洪水设计、万年一遇洪水校核，设计水位157.5米。挡水建筑物的两座主坝，五座副坝，总长4,559.8米。输水建筑物有：白河发电输水隧洞，潮河输水隧洞，水九引水隧洞。泄水建筑物有：第一、二、三溢洪道，走马庄隧洞（不参加泄洪），白河泄空隧洞，潮河泄空隧洞，潮河人防洞。');
INSERT INTO `reservoir_info` VALUES (18, '官厅水库', '河北省怀来县官厅镇、北京市延庆县', '1954-05-13', '官厅水库因大坝修建在官厅镇附近而得名，是1949年后中华人民共和国建设的第一座大型水库。');
INSERT INTO `reservoir_info` VALUES (19, '岳城水库', '河北省邯郸市磁县与河南省安阳市殷都区交界处', '1970', '水库总库容13亿立方米，控制流域面积18100平方千米，占漳河流域面积的99.4%，主要功能为防洪，兼有灌溉、发电、城市供水等综合效益，为不完全年调节的大型水利枢纽工程。');
INSERT INTO `reservoir_info` VALUES (20, '怀柔水库', '北京市怀柔区', '1958', '该水库水质常年保持在Ⅱ类，是北京市饮用水的重要水源地之一，也是京密引水渠和南水北调工程的重要组成部分。可与密云水库一起向北京城区输水。');
INSERT INTO `reservoir_info` VALUES (21, '新安江水库', '浙江省杭州市淳安县境内', '1957-10', '1984年12月，千岛湖为新安江水库的风景区名。从此，千岛湖就以“天下第一秀水”的优美自然景观和丰富的人文景观而成为天下游人“宠爱”之一。');
INSERT INTO `reservoir_info` VALUES (22, '江口水库', '玉林市福绵区成均镇，距福绵城区12千米', '1957', '江口水库有年调节功能，灌溉为主，兼顾发电、防洪、养鱼、造林。控制流域面积36平方千米，正常水位相应水面面积1平方千米，水库回水长度5千米，原设计坝高29米，总库容1 902万立方米。工程于1956年动工兴建，1957年竣工蓄水。1976年曾进行加固改造，大坝加高1米，防浪墙也相应加高1米。1998年再次进行水库除险加固，完成了主坝灌浆、溢洪道加固延伸、封堵旧涵管等项目。');
INSERT INTO `reservoir_info` VALUES (23, '柘林水库', '江西省九江市永修县、武宁县之间', '1975-12', '是在永修县柘林镇筑坝拦截修水而形成的以防洪、发电、灌溉、养殖为主要功能的大（一）型水库。以柘林湖之名和云居山佛教圣地联合列为：“中国国家重点风景名胜区”、“中国最美的湖光山色”。');
INSERT INTO `reservoir_info` VALUES (24, '新丰江水库', '广东省河源市区仅6公里的新丰江下游', '1969', '在广东省河源市西部。属东江水系。汇水面积5140平方公里。库区周围为低山丘陵，水面宽阔 [1]  。大坝筑在河源市城郊。坝址以上控制集水面积5740平方公里。1958年7月破土动工，1969年建成。混凝土大坝，最大坝高105米，设计库容量140亿立方米。灌溉河源、龙门、新丰等县农田近百万亩。是兼有养殖、发电和航运等综合效益大型水利工程 [2]  。坝下水电站装机容量29.25万千瓦。因水坝建于新丰江下游得名。');
INSERT INTO `reservoir_info` VALUES (25, '刘家峡水库', '甘肃临夏永靖县/城西南1公里处', '1974', '为黄河上游开发规划中的第七个梯阶电站，兼有发电、防洪、灌溉、养殖、航运、旅游等多种功能。 水库地处高原峡谷，被誉为“高原明珠”，景色壮观。');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', 'admin', '123@qq.com', 'admin');
INSERT INTO `user_info` VALUES (2, 'acc', '2222', '12345@qq.com', 'user');
INSERT INTO `user_info` VALUES (3, 'aqws', '12345', '123@qq.com', 'user');
INSERT INTO `user_info` VALUES (4, 'nongchatea', 'admin', '869399522@qq.com', 'user');
INSERT INTO `user_info` VALUES (5, 'nongchatea1111', '123456', '869399522@qq.com', 'user');
INSERT INTO `user_info` VALUES (6, '123', '123456', '123456', 'user');

SET FOREIGN_KEY_CHECKS = 1;
