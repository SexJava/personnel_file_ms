/*
Navicat MySQL Data Transfer

Source Server         : pfms
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pfms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-23 20:26:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adminfo`
-- ----------------------------
DROP TABLE IF EXISTS `adminfo`;
CREATE TABLE `adminfo` (
  `admId` int(11) NOT NULL AUTO_INCREMENT,
  `admName` varchar(255) NOT NULL,
  `admPwd` varchar(255) NOT NULL,
  `admRole` int(11) NOT NULL,
  PRIMARY KEY (`admId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminfo
-- ----------------------------
INSERT INTO `adminfo` VALUES ('1', '张三', '123', '1');
INSERT INTO `adminfo` VALUES ('2', '李四', '123', '1');
INSERT INTO `adminfo` VALUES ('3', '李四', '123', '1');
INSERT INTO `adminfo` VALUES ('4', '李四', '123', '1');
INSERT INTO `adminfo` VALUES ('5', '李四', '1234', '1');
INSERT INTO `adminfo` VALUES ('6', '李四', '1234', '1');
INSERT INTO `adminfo` VALUES ('7', '李四', '1234', '1');
INSERT INTO `adminfo` VALUES ('8', '李四', '1234', '1');
INSERT INTO `adminfo` VALUES ('9', '李雪', '123', '1');

-- ----------------------------
-- Table structure for `cominfo`
-- ----------------------------
DROP TABLE IF EXISTS `cominfo`;
CREATE TABLE `cominfo` (
  `comId` int(11) NOT NULL AUTO_INCREMENT,
  `comName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cominfo
-- ----------------------------
INSERT INTO `cominfo` VALUES ('1', 'tencent');
INSERT INTO `cominfo` VALUES ('2', 'baidu');
INSERT INTO `cominfo` VALUES ('3', 'baidu');
INSERT INTO `cominfo` VALUES ('4', 'alibaba');
INSERT INTO `cominfo` VALUES ('5', '字节跳动');

-- ----------------------------
-- Table structure for `fileinfo`
-- ----------------------------
DROP TABLE IF EXISTS `fileinfo`;
CREATE TABLE `fileinfo` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `laodongFile` varchar(255) DEFAULT NULL,
  `peixunFile` varchar(255) DEFAULT NULL,
  `baomiFile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fileId`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileinfo
-- ----------------------------
INSERT INTO `fileinfo` VALUES ('1', '1', '15713843828041.PNG', '1571384382804', '1571384382804');
INSERT INTO `fileinfo` VALUES ('2', '2', '15713842720891.PNG', '1571384272089', '1571384272089');
INSERT INTO `fileinfo` VALUES ('3', '3', '15713842461291.PNG', '15713842461291.PNG', '15713842461291.PNG');

-- ----------------------------
-- Table structure for `insinfo`
-- ----------------------------
DROP TABLE IF EXISTS `insinfo`;
CREATE TABLE `insinfo` (
  `insId` int(11) NOT NULL AUTO_INCREMENT,
  `insName` varchar(255) DEFAULT NULL,
  `insPrice` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`insId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insinfo
-- ----------------------------
INSERT INTO `insinfo` VALUES ('1', '医疗保险', '100', null);
INSERT INTO `insinfo` VALUES ('2', '死亡险', '1500', null);
INSERT INTO `insinfo` VALUES ('3', '意外险', '900', null);

-- ----------------------------
-- Table structure for `rencaiinfo`
-- ----------------------------
DROP TABLE IF EXISTS `rencaiinfo`;
CREATE TABLE `rencaiinfo` (
  `userId` int(11) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `comId` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rencaiinfo
-- ----------------------------
INSERT INTO `rencaiinfo` VALUES ('4', '张三', '1');

-- ----------------------------
-- Table structure for `traininfo`
-- ----------------------------
DROP TABLE IF EXISTS `traininfo`;
CREATE TABLE `traininfo` (
  `trainId` int(11) NOT NULL AUTO_INCREMENT,
  `trainName` varchar(255) NOT NULL,
  PRIMARY KEY (`trainId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traininfo
-- ----------------------------
INSERT INTO `traininfo` VALUES ('1', '网络培训');
INSERT INTO `traininfo` VALUES ('2', '技术培训');
INSERT INTO `traininfo` VALUES ('3', '职业素养培训');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `userPwd` varchar(255) NOT NULL,
  `userRole` int(11) NOT NULL,
  `userSal` double DEFAULT NULL,
  `insId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('2', '狗子', '123456', '0', '900', '3');
INSERT INTO `userinfo` VALUES ('4', '张三', '123', '0', '500', '2');
INSERT INTO `userinfo` VALUES ('5', '王五', '123', '0', '600', '1');
INSERT INTO `userinfo` VALUES ('6', '赵六', '123', '0', '4000', '1');
