/*
 Navicat Premium Data Transfer

 Source Server         : MacMySQL
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost
 Source Database       : FPO

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 04/05/2021 22:16:18 PM
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `publisher_info`
-- ----------------------------
DROP TABLE IF EXISTS `publisher_info`;
CREATE TABLE `publisher_info` (
  `user_id` varchar(255) DEFAULT NULL,
  `publish_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
