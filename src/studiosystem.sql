/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : studiosystem

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-09-10 12:21:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(32) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '4QrcOUm6Wau+VuBX8g+IPg==');

-- ----------------------------
-- Table structure for `classinfo`
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `c_id` int(10) NOT NULL AUTO_INCREMENT,
  `c_status` int(1) NOT NULL,
  `c_name` varchar(20) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES ('1', '1', '测试课程1');
INSERT INTO `classinfo` VALUES ('2', '0', '测试2');
INSERT INTO `classinfo` VALUES ('3', '1', '测试3');

-- ----------------------------
-- Table structure for `learngoal`
-- ----------------------------
DROP TABLE IF EXISTS `learngoal`;
CREATE TABLE `learngoal` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sc_id` int(10) NOT NULL,
  `imagepath_1` varchar(255) DEFAULT NULL,
  `imagepath_2` varchar(255) DEFAULT NULL,
  `imagepath_3` varchar(255) DEFAULT NULL,
  `t_comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of learngoal
-- ----------------------------

-- ----------------------------
-- Table structure for `parentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `parentinfo`;
CREATE TABLE `parentinfo` (
  `p_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) DEFAULT NULL,
  `relation` varchar(20) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `s_id` int(10) NOT NULL,
  PRIMARY KEY (`p_id`),
  KEY `FK_student_sid` (`s_id`),
  CONSTRAINT `FK_student_sid` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parentinfo
-- ----------------------------
INSERT INTO `parentinfo` VALUES ('1', 'p1', 'm2', 'm3', 'm3', 'm4', 'm5', '1');
INSERT INTO `parentinfo` VALUES ('3', 'liudj', '父亲', '集·', '啊的空间', '1536885', '打卡', '8');
INSERT INTO `parentinfo` VALUES ('6', 'asdas', '', '', '', 'sda', '', '6');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(10) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) NOT NULL,
  `sex` varchar(4) NOT NULL,
  `school` varchar(100) DEFAULT NULL,
  `classroom` varchar(100) DEFAULT NULL,
  `brithday` date NOT NULL,
  `age` int(4) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'aaa', 'aa', 'cc', ' ccc', '2017-06-07', '123');
INSERT INTO `student` VALUES ('6', 'eee', 'aa', 'eee', 'eeee', '2017-06-07', '123');
INSERT INTO `student` VALUES ('8', '流进', '男', '哈哈', '一般大声', '2019-02-06', '10');
INSERT INTO `student` VALUES ('9', '六级2', '男', '', '', '2017-04-07', '11');
INSERT INTO `student` VALUES ('10', '多萨达斯', '女', '', '', '2017-04-07', null);

-- ----------------------------
-- Table structure for `studentclass`
-- ----------------------------
DROP TABLE IF EXISTS `studentclass`;
CREATE TABLE `studentclass` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `c_id` int(10) NOT NULL,
  `s_id` int(10) NOT NULL,
  `classhours` int(5) NOT NULL,
  `lasthours` int(5) NOT NULL,
  `signupdate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_studentclass_cid` (`c_id`),
  KEY `FK_studentclass_sid` (`s_id`),
  CONSTRAINT `FK_studentclass_cid` FOREIGN KEY (`c_id`) REFERENCES `classinfo` (`c_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_studentclass_sid` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentclass
-- ----------------------------
INSERT INTO `studentclass` VALUES ('1', '1', '1', '30', '13', '2017-07-17');
INSERT INTO `studentclass` VALUES ('3', '1', '8', '11', '10', '2017-06-29');
INSERT INTO `studentclass` VALUES ('6', '2', '8', '11', '11', '2017-07-04');
INSERT INTO `studentclass` VALUES ('8', '2', '6', '231', '229', '2017-07-04');
INSERT INTO `studentclass` VALUES ('11', '1', '8', '15', '15', '2017-06-29');
INSERT INTO `studentclass` VALUES ('13', '1', '8', '11', '11', '2017-06-29');
INSERT INTO `studentclass` VALUES ('14', '1', '1', '15', '11', '2017-06-27');
INSERT INTO `studentclass` VALUES ('15', '3', '8', '123', '54', '2017-06-28');
INSERT INTO `studentclass` VALUES ('16', '2', '10', '11', '11', '2017-07-06');

-- ----------------------------
-- Table structure for `works`
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works` (
  `w_id` int(10) NOT NULL AUTO_INCREMENT,
  `s_id` int(10) NOT NULL,
  `w_name` varchar(50) NOT NULL,
  `pubtime` datetime NOT NULL,
  `w_comment` varchar(255) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`w_id`),
  KEY `FK_works_sid` (`s_id`),
  CONSTRAINT `FK_works_sid` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of works
-- ----------------------------
INSERT INTO `works` VALUES ('3', '6', '哈哈', '2017-06-27 00:00:00', '说你们', '20170719221441230.jpg');
INSERT INTO `works` VALUES ('4', '6', '送到', '2017-07-06 00:00:00', '大大', '20170719221816936.jpg');
INSERT INTO `works` VALUES ('6', '8', '哈哈', '2017-07-06 00:00:00', '搜索', '20170720121021378.jpg');
INSERT INTO `works` VALUES ('7', '8', '哈哈', '2017-06-30 00:00:00', '测试1', '20170720122131099.jpg');
INSERT INTO `works` VALUES ('8', '8', 'admin', '2017-02-08 00:00:00', '西嘎', '20170720125952347.jpg');
INSERT INTO `works` VALUES ('9', '8', '过虚空', '2017-06-28 00:00:00', '', '20170720130010306.jpg');
INSERT INTO `works` VALUES ('10', '8', '实打实', '2017-07-18 00:00:00', '', '20170720130024900.jpg');
INSERT INTO `works` VALUES ('11', '8', '大苏打', '2017-06-29 00:00:00', '', '20170720130125021.jpg');
INSERT INTO `works` VALUES ('16', '8', 'dasda', '2017-06-25 00:00:00', '', '20170726174010812.jpg');
INSERT INTO `works` VALUES ('17', '6', 'dsad', '2017-07-04 00:00:00', 'dsad', '20170726174727270.jpg');
INSERT INTO `works` VALUES ('18', '8', 'ddsa', '2017-01-01 00:00:00', 'dsadasdas', '20170729172618899.jpg');
INSERT INTO `works` VALUES ('19', '8', 'dsaj', '2017-01-07 00:00:00', '这个要考试打开就卡仕达酱阿卡丽即将开始打架啊', '20170729172747133.jpg');
INSERT INTO `works` VALUES ('21', '8', 'dasdasd', '2017-06-29 00:00:00', 'dsadas bdsgsa vf a ssda vasd sdg fsd ', '20170729185702845.jpg');
INSERT INTO `works` VALUES ('22', '8', 'dasd asda sczx czx czxf', '2017-07-08 00:00:00', 'we radsfas das das das casdsaczxcz ', '20170729185718335.jpg');
