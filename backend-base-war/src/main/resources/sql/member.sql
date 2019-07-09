/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : member

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65002

 Date: 30/06/2019 18:32:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS MEMBER DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE MEMBER;


-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `account_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账户名',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别：0-女    1-男',
  `password` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `last_modify_time` timestamp(6) NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'moon1', '1', NULL, '666', NULL, '2019-06-29 09:55:42.234201', '2019-06-29 09:55:38.000000');
INSERT INTO `t_user` VALUES (2, 'moon2', '0', NULL, '888', NULL, '2019-06-29 09:55:47.426498', '2019-06-29 09:55:43.000000');

SET FOREIGN_KEY_CHECKS = 1;
