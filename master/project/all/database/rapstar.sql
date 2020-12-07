/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : rapstar

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2020-12-07 10:09:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `acccollect`
-- ----------------------------
DROP TABLE IF EXISTS `acccollect`;
CREATE TABLE `acccollect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `accid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `accid` (`accid`),
  CONSTRAINT `acccollect_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `acccollect_ibfk_2` FOREIGN KEY (`accid`) REFERENCES `accompaniment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of acccollect
-- ----------------------------
INSERT INTO `acccollect` VALUES ('1', '2', '3');
INSERT INTO `acccollect` VALUES ('2', '2', '9');
INSERT INTO `acccollect` VALUES ('3', '1', '3');
INSERT INTO `acccollect` VALUES ('4', '5', '4');
INSERT INTO `acccollect` VALUES ('5', '3', '3');

-- ----------------------------
-- Table structure for `acclist`
-- ----------------------------
DROP TABLE IF EXISTS `acclist`;
CREATE TABLE `acclist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `authorid` int(11) DEFAULT NULL,
  `priority` int(11) NOT NULL DEFAULT '1' COMMENT '0自己可见 1所有',
  `profile` varchar(200) DEFAULT '还木有简介~',
  `imgpath` varchar(20) DEFAULT NULL COMMENT '会有一个默认的图片',
  PRIMARY KEY (`id`),
  KEY `authorid` (`authorid`),
  CONSTRAINT `acclist_ibfk_1` FOREIGN KEY (`authorid`) REFERENCES `musician` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of acclist
-- ----------------------------

-- ----------------------------
-- Table structure for `accompaniment`
-- ----------------------------
DROP TABLE IF EXISTS `accompaniment`;
CREATE TABLE `accompaniment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `authorid` int(11) NOT NULL,
  `intro` varchar(100) DEFAULT '还木有介绍~',
  `time` datetime NOT NULL COMMENT '自动生成时间',
  `imgpath` varchar(20) DEFAULT NULL COMMENT '会有一个默认的图片',
  `style` int(11) NOT NULL,
  `money` double NOT NULL DEFAULT '0' COMMENT '0的时候表示免费',
  `path` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `authorid` (`authorid`),
  KEY `style` (`style`),
  CONSTRAINT `accompaniment_ibfk_1` FOREIGN KEY (`authorid`) REFERENCES `musician` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `accompaniment_ibfk_2` FOREIGN KEY (`style`) REFERENCES `style` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of accompaniment
-- ----------------------------
INSERT INTO `accompaniment` VALUES ('2', 'acc1', '2', '还木有介绍~', '2020-12-07 09:16:24', null, '1', '0', '2.mp3');
INSERT INTO `accompaniment` VALUES ('3', 'acc2', '1', '还木有介绍~', '2020-12-06 09:17:06', null, '2', '0', '3.mp3');
INSERT INTO `accompaniment` VALUES ('4', 'acc3', '3', '还木有介绍~', '2020-12-07 09:18:38', null, '3', '0', '4.mp3');
INSERT INTO `accompaniment` VALUES ('9', 'acc4', '4', '还木有介绍~', '2020-12-07 09:18:14', null, '7', '0', '9.mp3');

-- ----------------------------
-- Table structure for `alistdetail`
-- ----------------------------
DROP TABLE IF EXISTS `alistdetail`;
CREATE TABLE `alistdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `listid` int(11) NOT NULL,
  `accid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `listid` (`listid`),
  KEY `accid` (`accid`),
  CONSTRAINT `alistdetail_ibfk_1` FOREIGN KEY (`listid`) REFERENCES `acclist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `alistdetail_ibfk_2` FOREIGN KEY (`accid`) REFERENCES `accompaniment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of alistdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `demo`
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `authorid` int(11) NOT NULL,
  `accid` int(11) NOT NULL,
  `lyricpath` varchar(20) DEFAULT NULL COMMENT 'txt+id.txt',
  `time` datetime NOT NULL,
  `path` varchar(20) NOT NULL COMMENT 'demo+id.mp3/wav',
  `imgpath` varchar(20) DEFAULT NULL COMMENT 'demoimg+id.png/jpg',
  `priority` int(11) NOT NULL DEFAULT '1' COMMENT '0表示自己，1表示所有',
  `statu` int(11) NOT NULL DEFAULT '0' COMMENT '0已完成 1已上传',
  PRIMARY KEY (`id`),
  KEY `authorid` (`authorid`),
  KEY `accid` (`accid`),
  CONSTRAINT `demo_ibfk_1` FOREIGN KEY (`authorid`) REFERENCES `musician` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `demo_ibfk_2` FOREIGN KEY (`accid`) REFERENCES `accompaniment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of demo
-- ----------------------------

-- ----------------------------
-- Table structure for `democollect`
-- ----------------------------
DROP TABLE IF EXISTS `democollect`;
CREATE TABLE `democollect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `demoid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `demoid` (`demoid`),
  CONSTRAINT `democollect_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `democollect_ibfk_2` FOREIGN KEY (`demoid`) REFERENCES `demo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of democollect
-- ----------------------------

-- ----------------------------
-- Table structure for `demolist`
-- ----------------------------
DROP TABLE IF EXISTS `demolist`;
CREATE TABLE `demolist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `authorid` int(11) DEFAULT NULL,
  `priority` int(11) NOT NULL DEFAULT '1' COMMENT '0表示自己 1表示所有',
  `imgpath` varchar(20) DEFAULT NULL COMMENT '会有一个默认的图片',
  PRIMARY KEY (`id`),
  KEY `authorid` (`authorid`),
  CONSTRAINT `demolist_ibfk_1` FOREIGN KEY (`authorid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of demolist
-- ----------------------------

-- ----------------------------
-- Table structure for `dlistdetail`
-- ----------------------------
DROP TABLE IF EXISTS `dlistdetail`;
CREATE TABLE `dlistdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `listid` int(11) NOT NULL,
  `demoid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `listid` (`listid`),
  KEY `demoid` (`demoid`),
  CONSTRAINT `dlistdetail_ibfk_1` FOREIGN KEY (`listid`) REFERENCES `demolist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dlistdetail_ibfk_2` FOREIGN KEY (`demoid`) REFERENCES `demo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dlistdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `following`
-- ----------------------------
DROP TABLE IF EXISTS `following`;
CREATE TABLE `following` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `star` int(11) NOT NULL,
  `follower` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `star` (`star`),
  KEY `follower` (`follower`),
  CONSTRAINT `following_ibfk_1` FOREIGN KEY (`star`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `following_ibfk_2` FOREIGN KEY (`follower`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of following
-- ----------------------------
INSERT INTO `following` VALUES ('1', '2', '3');
INSERT INTO `following` VALUES ('2', '2', '4');
INSERT INTO `following` VALUES ('4', '6', '1');
INSERT INTO `following` VALUES ('5', '2', '6');
INSERT INTO `following` VALUES ('6', '8', '2');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'qian', '钱', 'qian');
INSERT INTO `manager` VALUES ('2', 'zhang', '张', 'zhang');
INSERT INTO `manager` VALUES ('3', 'zheng', '郑', 'zheng');
INSERT INTO `manager` VALUES ('4', 'guan', '关', 'guan');
INSERT INTO `manager` VALUES ('5', 'liu', '刘', 'liu');
INSERT INTO `manager` VALUES ('6', 'li', '李', 'li');

-- ----------------------------
-- Table structure for `musician`
-- ----------------------------
DROP TABLE IF EXISTS `musician`;
CREATE TABLE `musician` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '还木有写昵称~',
  `shortpro` varchar(100) NOT NULL DEFAULT '还木有短介绍~',
  `longpro` varchar(400) NOT NULL DEFAULT '还木有长介绍~',
  `sex` char(2) NOT NULL DEFAULT '男',
  `userid` int(11) DEFAULT NULL,
  `photopath` varchar(20) DEFAULT NULL COMMENT '会有一个默认的头像',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `musician_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of musician
-- ----------------------------
INSERT INTO `musician` VALUES ('1', '缠山藏风', '还木有短介绍~', '还木有长介绍~', '男', null, null);
INSERT INTO `musician` VALUES ('2', '解在关锁', '还木有短介绍~', '还木有长介绍~', '女', '8', null);
INSERT INTO `musician` VALUES ('3', '第三个歌手', '还木有短介绍~', '还木有长介绍~', '男', null, null);
INSERT INTO `musician` VALUES ('4', '第四个歌手', '还木有短介绍~', '还木有长介绍~', '女', '4', null);

-- ----------------------------
-- Table structure for `slistcollect`
-- ----------------------------
DROP TABLE IF EXISTS `slistcollect`;
CREATE TABLE `slistcollect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `songlistid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `songlistid` (`songlistid`),
  CONSTRAINT `slistcollect_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `slistcollect_ibfk_2` FOREIGN KEY (`songlistid`) REFERENCES `songlist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of slistcollect
-- ----------------------------

-- ----------------------------
-- Table structure for `slistdetail`
-- ----------------------------
DROP TABLE IF EXISTS `slistdetail`;
CREATE TABLE `slistdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `listid` int(11) NOT NULL,
  `songid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `listid` (`listid`),
  KEY `songid` (`songid`),
  CONSTRAINT `slistdetail_ibfk_1` FOREIGN KEY (`listid`) REFERENCES `songlist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `slistdetail_ibfk_2` FOREIGN KEY (`songid`) REFERENCES `song` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of slistdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `song`
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `authorid` int(11) NOT NULL,
  `lyricpath` varchar(20) DEFAULT NULL COMMENT 'lrc+id.lrc',
  `acc` int(11) DEFAULT NULL,
  `style` int(11) DEFAULT NULL,
  `path` varchar(20) NOT NULL COMMENT 'song+id.mp3/wav',
  `money` double NOT NULL DEFAULT '0' COMMENT '0表示免费',
  `imgpath` varchar(20) DEFAULT NULL COMMENT 'songimg+id.png/jpg会有一个默认的',
  PRIMARY KEY (`id`),
  KEY `authorid` (`authorid`),
  KEY `style` (`style`),
  CONSTRAINT `song_ibfk_1` FOREIGN KEY (`authorid`) REFERENCES `musician` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `song_ibfk_2` FOREIGN KEY (`style`) REFERENCES `style` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of song
-- ----------------------------

-- ----------------------------
-- Table structure for `songcollect`
-- ----------------------------
DROP TABLE IF EXISTS `songcollect`;
CREATE TABLE `songcollect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `songid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `songid` (`songid`),
  CONSTRAINT `songcollect_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `songcollect_ibfk_2` FOREIGN KEY (`songid`) REFERENCES `song` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of songcollect
-- ----------------------------

-- ----------------------------
-- Table structure for `songlist`
-- ----------------------------
DROP TABLE IF EXISTS `songlist`;
CREATE TABLE `songlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `authorid` int(11) NOT NULL,
  `priority` int(11) NOT NULL DEFAULT '1' COMMENT '0表示自己 1表示所有',
  `profile` varchar(200) DEFAULT '还木有简介~',
  `imgpath` varchar(20) DEFAULT NULL COMMENT '会有一个默认的',
  PRIMARY KEY (`id`),
  KEY `authorid` (`authorid`),
  CONSTRAINT `songlist_ibfk_1` FOREIGN KEY (`authorid`) REFERENCES `musician` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of songlist
-- ----------------------------

-- ----------------------------
-- Table structure for `style`
-- ----------------------------
DROP TABLE IF EXISTS `style`;
CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of style
-- ----------------------------
INSERT INTO `style` VALUES ('1', '流行说唱');
INSERT INTO `style` VALUES ('2', '另类说唱');
INSERT INTO `style` VALUES ('3', '地下说唱');
INSERT INTO `style` VALUES ('4', '重低音贝斯说唱');
INSERT INTO `style` VALUES ('5', '西海岸说唱乐');
INSERT INTO `style` VALUES ('6', '硬核说唱');
INSERT INTO `style` VALUES ('7', '老派说唱乐');
INSERT INTO `style` VALUES ('8', '中西部说唱乐');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` char(11) NOT NULL,
  `name` varchar(50) DEFAULT '还没有填昵称~' COMMENT '昵称',
  `pwd` varchar(20) NOT NULL COMMENT '是否加密？？',
  `photopath` varchar(20) DEFAULT NULL COMMENT '会有一个默认头像',
  `sex` char(2) NOT NULL DEFAULT '男' COMMENT '默认为男',
  `intro` varchar(100) DEFAULT '还木有简介哦~',
  `stars` int(11) NOT NULL DEFAULT '0',
  `followers` int(11) NOT NULL DEFAULT '0',
  `isvip` char(2) NOT NULL DEFAULT '0' COMMENT '只有0和1两个值',
  `certification` char(2) NOT NULL DEFAULT '0' COMMENT '0是普通用户，1是音乐人认证(发了歌/伴奏的都是音乐人，demo的不算)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '12345678901', '还没有填昵称~', '000111', '1.jpg', '男', '还木有简介哦~', '1', '0', '0', '0');
INSERT INTO `user` VALUES ('2', '12345678902', '还没有填昵称~', '000222', '2.jpg', '女', '还木有简介哦~', '1', '3', '0', '0');
INSERT INTO `user` VALUES ('3', '12345678903', '还没有填昵称~', '000333', '3.jpg', '男', '还木有简介哦~', '1', '0', '0', '0');
INSERT INTO `user` VALUES ('4', '12345678904', '还没有填昵称~', '000444', '4.jpg', '男', '还木有简介哦~', '1', '0', '0', '0');
INSERT INTO `user` VALUES ('5', '12345678905', '还没有填昵称~', '000555', '5.jpg', '女', '还木有简介哦~', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('6', '12345678906', '还没有填昵称~', '000666', '0.jpg', '男', '还木有简介哦~', '1', '1', '0', '0');
INSERT INTO `user` VALUES ('7', '12345678907', '还没有填昵称~', '000777', '0.jpg', '男', '还木有简介哦~', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('8', '12345678908', '还没有填昵称~', '000888', '0.jpg', '女', '还木有简介哦~', '0', '1', '0', '0');
