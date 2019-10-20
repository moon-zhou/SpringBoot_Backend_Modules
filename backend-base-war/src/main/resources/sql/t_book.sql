/*
Navicat MySQL Data Transfer

Source Server         : moon-db
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : member

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-19 22:59:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(12) NOT NULL,
  `name` varchar(255) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `last_modify_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '雪中悍刀行', '2019-10-19 22:58:41', '2019-10-19 22:58:44');
INSERT INTO `t_book` VALUES ('2', 'Java编程思想', '2019-10-19 22:58:47', '2019-10-19 22:58:50');
SET FOREIGN_KEY_CHECKS=1;
