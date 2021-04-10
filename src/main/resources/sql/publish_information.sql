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

 Date: 04/05/2021 22:16:13 PM
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `publish_information`
-- ----------------------------
DROP TABLE IF EXISTS `publish_information`;
CREATE TABLE `publish_information` (
  `publish_id` varchar(255) NOT NULL,
  `location` varchar(100) NULL,
  `salary` varchar(100) NULL,
  `title` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
