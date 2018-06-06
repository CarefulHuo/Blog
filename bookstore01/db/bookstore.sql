/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2018-06-06 12:36:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buyteritem
-- ----------------------------
DROP TABLE IF EXISTS `buyteritem`;
CREATE TABLE `buyteritem` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `num` int(255) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `buyitem_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buyteritem
-- ----------------------------
INSERT INTO `buyteritem` VALUES ('2f3c875d-e009-41f1-a948-2fc0b9115911', 'java web', '32', '14', '7', 'f14e73e1-6377-4600-8b43-f312a03185a3', '1', '2018-06-01 10:40:00');
INSERT INTO `buyteritem` VALUES ('2f6258cb-de62-4959-8f36-cfde6d1a4b11', 'java web', '32', '1', '7', '1ac73e9f-ad3f-46d6-beef-0de222a03289', '1', '2018-06-04 08:21:28');
INSERT INTO `buyteritem` VALUES ('498776d1-6626-424c-ac98-5ca83977a594', 'java web', '32', '20', '7', 'a0abfdb8-cf15-421b-a2ad-6f2df2a61e1d', '1', '2018-06-01 10:18:25');
INSERT INTO `buyteritem` VALUES ('b5fd16b4-5637-4640-a979-297cae374905', 'java web', '32', '1', '7', 'a83fdc0b-32c5-4f5f-a773-69ae37c78ca9', '1', '2018-06-01 12:31:06');
INSERT INTO `buyteritem` VALUES ('c7004086-221d-41ac-94ff-773eb2003deb', '时空穿行', '28', '1', '16', 'a5dbde82-7751-4efa-98f1-db24a4977419', '2', '2018-05-30 10:42:19');
INSERT INTO `buyteritem` VALUES ('c814632f-320a-49fd-82f9-c931ce4b9adb', 'Java入门经典', '98', '6', '7', '9f60dc92-fa18-4b38-b187-7775583c579f', '801541b4-2418-4133-96e6-a9d0e24fce5b', '2018-06-01 10:09:09');
INSERT INTO `buyteritem` VALUES ('e9e9290e-d8e0-46d2-93a5-f5d0edd18b17', 'Java入门经典', '98', '4', '7', '54792a72-1d37-4fa5-9f86-a6519ccdb3c7', '801541b4-2418-4133-96e6-a9d0e24fce5b', '2018-05-31 21:11:26');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `n_time` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('3', '年前大促', '年前大促，回馈新老客户，欢迎各位新老客户', '2018-06-01');
INSERT INTO `notice` VALUES ('4', '6.18大减价', '各种优惠，各种实惠', '2018-05-31');
INSERT INTO `notice` VALUES ('5', '双11', '双11震撼来袭，各种优惠不容错过', '2018-05-31');
INSERT INTO `notice` VALUES ('8', '6.18大减价', '翻炒太过分的传统风格统一', null);
INSERT INTO `notice` VALUES ('9', 'dfgdsf ', 'afsdf', null);

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `order_id` varchar(100) NOT NULL DEFAULT '',
  `product_id` varchar(100) NOT NULL DEFAULT '',
  `buynum` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1ac73e9f-ad3f-46d6-beef-0de222a03289', '1', '1');
INSERT INTO `orderitem` VALUES ('21c7c59c-b920-48d5-b4f3-1d170047313b', '1', '1');
INSERT INTO `orderitem` VALUES ('54792a72-1d37-4fa5-9f86-a6519ccdb3c7', '801541b4-2418-4133-96e6-a9d0e24fce5b', '4');
INSERT INTO `orderitem` VALUES ('5972ce09-77e6-46b8-836c-81fe4ee654a8', '1', '1');
INSERT INTO `orderitem` VALUES ('834c16c3-ee79-4c4f-b8a4-ddf29562b06d', '1', '4');
INSERT INTO `orderitem` VALUES ('9f60dc92-fa18-4b38-b187-7775583c579f', '801541b4-2418-4133-96e6-a9d0e24fce5b', '6');
INSERT INTO `orderitem` VALUES ('a0abfdb8-cf15-421b-a2ad-6f2df2a61e1d', '1', '20');
INSERT INTO `orderitem` VALUES ('a5c2cf5b-168c-4a92-a971-e01632625c71', 'abed33fc-c9ff-46a8-b4bb-3c86873fd4d4', '9');
INSERT INTO `orderitem` VALUES ('a5dbde82-7751-4efa-98f1-db24a4977419', '2', '1');
INSERT INTO `orderitem` VALUES ('a83fdc0b-32c5-4f5f-a773-69ae37c78ca9', '1', '1');
INSERT INTO `orderitem` VALUES ('f14e73e1-6377-4600-8b43-f312a03185a3', '1', '14');
INSERT INTO `orderitem` VALUES ('f7489a81-259d-4f2b-99cd-1300070b2b12', 'abed33fc-c9ff-46a8-b4bb-3c86873fd4d4', '6');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(100) NOT NULL,
  `money` double DEFAULT NULL,
  `receiverAddress` varchar(255) DEFAULT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` varchar(20) DEFAULT NULL,
  `paystate` int(11) DEFAULT '0',
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1ac73e9f-ad3f-46d6-beef-0de222a03289', '32', '22222', 'abc', '1591733908', '0', '2018-06-04 08:21:28', '7');
INSERT INTO `orders` VALUES ('21c7c59c-b920-48d5-b4f3-1d170047313b', '32', '', '', '', '0', '2018-06-06 11:53:10', '7');
INSERT INTO `orders` VALUES ('54792a72-1d37-4fa5-9f86-a6519ccdb3c7', '392', '河南省安阳市文峰区', 'jian', '1591733908', '1', '2018-05-31 21:23:14', '7');
INSERT INTO `orders` VALUES ('5972ce09-77e6-46b8-836c-81fe4ee654a8', '32', 'hehefswee', 'abc', '1591733908', '0', '2018-06-05 18:31:46', '7');
INSERT INTO `orders` VALUES ('834c16c3-ee79-4c4f-b8a4-ddf29562b06d', '128', '', '', '', '0', '2018-06-06 12:30:25', '7');
INSERT INTO `orders` VALUES ('9f60dc92-fa18-4b38-b187-7775583c579f', '588', '河南省安阳市文峰区', 'hwy', '1591733908', '1', '2018-06-01 10:10:53', '7');
INSERT INTO `orders` VALUES ('a0abfdb8-cf15-421b-a2ad-6f2df2a61e1d', '640', '河南省驻马店', 'hlb', '1591733908', '1', '2018-06-01 10:19:30', '7');
INSERT INTO `orders` VALUES ('a5c2cf5b-168c-4a92-a971-e01632625c71', '405', 'sdfsdf', 'sdfs', '12312321', '0', '2018-06-06 12:28:35', '7');
INSERT INTO `orders` VALUES ('a5dbde82-7751-4efa-98f1-db24a4977419', '28', 'rgeergergreg', 'admin', '234234242', '1', '2018-05-30 10:42:19', '16');
INSERT INTO `orders` VALUES ('a83fdc0b-32c5-4f5f-a773-69ae37c78ca9', '32', '伸缩缝', '陈帅帅', '1591733908', '1', '2018-06-01 12:32:16', '7');
INSERT INTO `orders` VALUES ('f14e73e1-6377-4600-8b43-f312a03185a3', '448', '安阳师范学院', 'java web', '1591733908', '1', '2018-06-01 10:42:02', '7');
INSERT INTO `orders` VALUES ('f7489a81-259d-4f2b-99cd-1300070b2b12', '270', '河南省驻马店', '霍伟烨', '1591733908', '0', '2018-06-05 18:30:35', '7');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(40) DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'java web', '32', '计算机', '294', '36ee63bc-c251-49ce-9b9a-b5e1e2e75ec0.jpg', '1111');
INSERT INTO `products` VALUES ('2', '时空穿行', '28', '科技', '100', 'd79dc124-de69-4b77-847e-bc461bfdb857.jpg', '11121654');
INSERT INTO `products` VALUES ('3', 'Java基础入门', '30', '计算机', '200', '524b7c65-2f94-49ac-8824-a444ff61ac9eTS14.jpg', '156465');
INSERT INTO `products` VALUES ('801541b4-2418-4133-96e6-a9d0e24fce5b', 'Java入门经典', '98', '计算机', '90', 'e470b9d9-d5c0-40c0-a0ee-e2bcbe9c8d14java2.jpg', 'Java入门经典');
INSERT INTO `products` VALUES ('839378e1-d156-458a-88ae-9ce94324f18c', '影响力', '45', '励志', '100', '04b89ce9-3f77-468a-8761-1db34e4c13ff103.jpg', '影响力');
INSERT INTO `products` VALUES ('abed33fc-c9ff-46a8-b4bb-3c86873fd4d4', '培育男孩', '45', '生活', '285', '013ab83c-e7ba-4fcf-b271-3d4499e45581105.jpg', '培育男孩');
INSERT INTO `products` VALUES ('d9aae4d3-0c22-4723-8b01-9a47dcc1bcf2', 'haocha', '454', '计算机', '34', 'a571b036-1ae0-4c23-aab5-e7ad0a3b8fcffish.jpg', 'sfsfsdfsdf');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `activeCode` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `role` varchar(10) DEFAULT '普通用户',
  `registTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('7', 'abc', '123456', '女', '906779930@qq.com', '1591733908', '', 'cd682eda-4a7b-4cf3-8a1e-18e800f97d64', '1', '普通用户', '2018-06-05 18:23:04');
INSERT INTO `user` VALUES ('16', 'admin', '123456', '女', '1591733908@qq.com', '234234242', '24234233', 'a546574b-2bad-4933-8b73-1be7af2cf560', '1', '普通用户', '2018-05-29 21:16:25');
INSERT INTO `user` VALUES ('24', '管理员', '1111', '女', '3198311340@qq.com', '12313213', '真是够够的', 'f60b9997-d6b1-4060-af3b-dd79cf1213eb', '0', '超级用户', '2018-05-30 13:43:30');
INSERT INTO `user` VALUES ('25', '小布丁', '1111', '男', 'hnzmdhwy@163.com', '2342342342', '受到各方的观点', '52179a42-dec5-420a-975e-f8ace27606f3', '1', '超级用户', '2018-05-30 13:06:33');
