/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : empdemo_ssm

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-13 10:34:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for e_dept
-- ----------------------------
DROP TABLE IF EXISTS `e_dept`;
CREATE TABLE `e_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for e_emp
-- ----------------------------
DROP TABLE IF EXISTS `e_emp`;
CREATE TABLE `e_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `sex` enum('男','女') DEFAULT '男',
  `salary` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
