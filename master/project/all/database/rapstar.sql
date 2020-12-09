/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50701
Source Host           : localhost:3306
Source Database       : rapstar

Target Server Type    : MYSQL
Target Server Version : 50701
File Encoding         : 65001

Date: 2020-12-09 08:12:51
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
INSERT INTO `acccollect` VALUES ('1', '1', '1');
INSERT INTO `acccollect` VALUES ('2', '1', '2');
INSERT INTO `acccollect` VALUES ('3', '1', '3');
INSERT INTO `acccollect` VALUES ('4', '1', '4');
INSERT INTO `acccollect` VALUES ('5', '1', '5');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of acclist
-- ----------------------------
INSERT INTO `acclist` VALUES ('1', '伴奏单1', '1', '1', '伴奏单1简介', '1.jpg');
INSERT INTO `acclist` VALUES ('2', '伴奏单2', '2', '1', '伴奏单2简介', '2.jpg');
INSERT INTO `acclist` VALUES ('3', '伴奏单3', '3', '1', '伴奏单3简介', '3.jpg');
INSERT INTO `acclist` VALUES ('4', '伴奏单4', '4', '1', '伴奏单4简介', '4.jpg');

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
INSERT INTO `accompaniment` VALUES ('1', 'acc1', '1', 'acc1伴奏简介', '2020-12-07 09:16:24', '1.jpg', '1', '0', '1.mp3');
INSERT INTO `accompaniment` VALUES ('2', 'acc2', '1', 'acc2伴奏简介', '2020-12-06 09:17:06', '2.jpg', '2', '0', '2.mp3');
INSERT INTO `accompaniment` VALUES ('3', 'acc3', '1', 'acc3伴奏简介', '2020-12-07 09:18:38', '3.jpg', '3', '0', '3.mp3');
INSERT INTO `accompaniment` VALUES ('4', 'acc4', '1', 'acc4伴奏简介', '2020-12-07 09:18:14', '4.jpg', '7', '0', '4.mp3');
INSERT INTO `accompaniment` VALUES ('5', 'acc5', '1', 'acc5伴奏简介', '2020-12-08 17:20:38', '5.jpg', '1', '0', '5.mp3');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of alistdetail
-- ----------------------------
INSERT INTO `alistdetail` VALUES ('1', '1', '1');
INSERT INTO `alistdetail` VALUES ('2', '1', '2');
INSERT INTO `alistdetail` VALUES ('3', '1', '3');
INSERT INTO `alistdetail` VALUES ('4', '1', '4');
INSERT INTO `alistdetail` VALUES ('5', '1', '5');
INSERT INTO `alistdetail` VALUES ('6', '2', '1');
INSERT INTO `alistdetail` VALUES ('7', '2', '2');
INSERT INTO `alistdetail` VALUES ('8', '2', '5');
INSERT INTO `alistdetail` VALUES ('9', '3', '1');
INSERT INTO `alistdetail` VALUES ('10', '3', '4');
INSERT INTO `alistdetail` VALUES ('11', '3', '5');
INSERT INTO `alistdetail` VALUES ('12', '4', '2');
INSERT INTO `alistdetail` VALUES ('13', '4', '5');
INSERT INTO `alistdetail` VALUES ('14', '4', '3');

-- ----------------------------
-- Table structure for `banzou`
-- ----------------------------
DROP TABLE IF EXISTS `banzou`;
CREATE TABLE `banzou` (
  `collector` varchar(40) DEFAULT NULL,
  `banzou` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banzou
-- ----------------------------
INSERT INTO `banzou` VALUES ('user1', '哥斯拉伴奏');
INSERT INTO `banzou` VALUES ('user1', '个耶夫斯基');

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `goalid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `type` (`type`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`type`) REFERENCES `type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of collection
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES ('1', 'demo1', '1', '1', '1.txt', '2020-12-11 15:49:20', '1.mp3', '1.png', '1', '0');
INSERT INTO `demo` VALUES ('2', 'demo2', '2', '1', '2.txt', '2020-12-23 15:23:23', '2.mp3', '2.png', '1', '0');
INSERT INTO `demo` VALUES ('3', 'demo3', '3', '3', '3.txt', '2020-12-22 18:51:12', '3.mp3', '3.png', '1', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of democollect
-- ----------------------------
INSERT INTO `democollect` VALUES ('1', '1', '1');
INSERT INTO `democollect` VALUES ('2', '1', '2');
INSERT INTO `democollect` VALUES ('3', '1', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of demolist
-- ----------------------------
INSERT INTO `demolist` VALUES ('1', 'demo单1', '1', '1', 'Alistimg1.jpg');
INSERT INTO `demolist` VALUES ('2', 'demo单2', '1', '1', 'Alistimg2.jpg');
INSERT INTO `demolist` VALUES ('3', 'demo单3', '1', '1', 'Alistimg3.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dlistdetail
-- ----------------------------
INSERT INTO `dlistdetail` VALUES ('1', '1', '1');
INSERT INTO `dlistdetail` VALUES ('2', '1', '2');
INSERT INTO `dlistdetail` VALUES ('3', '1', '3');
INSERT INTO `dlistdetail` VALUES ('4', '2', '1');
INSERT INTO `dlistdetail` VALUES ('5', '2', '2');
INSERT INTO `dlistdetail` VALUES ('6', '2', '3');
INSERT INTO `dlistdetail` VALUES ('7', '3', '2');
INSERT INTO `dlistdetail` VALUES ('8', '3', '3');

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of following
-- ----------------------------
INSERT INTO `following` VALUES ('1', '2', '3');
INSERT INTO `following` VALUES ('2', '2', '4');
INSERT INTO `following` VALUES ('3', '4', '5');
INSERT INTO `following` VALUES ('4', '2', '1');
INSERT INTO `following` VALUES ('5', '2', '6');
INSERT INTO `following` VALUES ('6', '1', '2');
INSERT INTO `following` VALUES ('7', '1', '8');
INSERT INTO `following` VALUES ('8', '1', '3');
INSERT INTO `following` VALUES ('9', '4', '13');
INSERT INTO `following` VALUES ('10', '4', '9');
INSERT INTO `following` VALUES ('11', '8', '5');
INSERT INTO `following` VALUES ('12', '8', '9');
INSERT INTO `following` VALUES ('13', '10', '1');
INSERT INTO `following` VALUES ('14', '10', '2');
INSERT INTO `following` VALUES ('15', '10', '5');
INSERT INTO `following` VALUES ('16', '12', '4');
INSERT INTO `following` VALUES ('17', '12', '6');
INSERT INTO `following` VALUES ('18', '12', '8');
INSERT INTO `following` VALUES ('19', '12', '10');
INSERT INTO `following` VALUES ('20', '12', '13');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of musician
-- ----------------------------
INSERT INTO `musician` VALUES ('1', '潘玮柏', '潘玮柏（Wilber Pan），1980年8月6日出生于美国西弗吉尼亚州，祖籍中国上海市普陀区，华语流行乐男歌手、影视演员、主持人，毕业于加州州立理工大学。', '2001年3月担任Channel[V]音乐台的主持人，从而正式进入演艺圈 [1]  ；同年出演个人首部电视剧《麻辣鲜师》。2002年12月，推出首张个人音乐专辑《壁虎漫步》，从而正式进军歌坛 [1]  。2003年9月，推出第二张个人音乐专辑《我的麦克风》 [2]  。2004年，凭借专辑《Wu Ha》获得中国音乐榜最佳新人奖。2005年11月，获得\"中国风尚大典\"港台风尚男歌手奖 [3]  。2006年，凭借专辑《反转地球》获得“东南音乐劲爆榜”港台地区劲爆最受欢迎男歌手奖 [4]  。2008年，在台湾偶像剧《不良笑花》中饰演男主角唐门 [5]  。2009年，凭借专辑《零零七》获得新城国语力颁奖礼亚洲跳唱歌手奖 [6]  。2010年，在台湾偶像剧 《爱无限》中饰演男主角梁景晧 [7]  ，并获得第46届台湾电视金钟奖戏剧节目男主角奖 [8]  。2011年，推出第八张个人音乐专辑《', '男', '1', '1.jpg');
INSERT INTO `musician` VALUES ('2', '埃米纳姆', '十分优秀的说唱歌手，演员，目前已售出3亿张唱片', '埃米纳姆（Eminem，原名马歇尔·布鲁斯·马瑟斯三世，1972年10月17日-），出生于美国密苏里州堪萨斯城，美国说唱男歌手。[1]1997年埃米纳姆首次以个人身份推出专辑《Infinite》[2]。2000年2月，埃米纳姆凭借专辑《The Slim Shady LP》获第42届格莱美最佳Rap歌手和最佳Rap专辑。[3]2001年2月21日，凭借专辑《The Marshall Mathers LP》获第43届格莱美最佳Rap歌手、最佳Rap组合和最佳Rap专辑[4][5][6]。2002年出演了电影《8英里》，并在影片中演唱了《Lose Yourself》，获奥斯卡最佳原创歌曲奖[7][8]。2004年2月，凭借歌曲《Lose Yourself》获第46届格莱美最佳Rap歌手和最佳Rap歌曲[9]。2011年8月，《滚石》将其评选为“嘻哈之王”[1]。2011年12月，获得第53届格莱', '男', '2', '2.jpg');
INSERT INTO `musician` VALUES ('3', '欧阳靖', '曾在说唱的天堂美国击败黑人，获得“Freestyle Friday”的冠军。他还和陈奕迅合作过《爱是怀疑》，在台上完全不输气场，而且说了一段粤语的rap', '他虽然是个华裔但唱的rap基本都是英文。但是技巧和能力不能因为语种而降分！比起很多Rapper新人，可能他们还没出生，欧阳靖已经开始写词了。 本回答被提问者和网友采纳', '男', '4', '3.jpg');
INSERT INTO `musician` VALUES ('4', 'Ghostface Killah', '鬼脸煞星比较擅长的是俚语编码韵律，并且使用特殊的技艺将其串联起来。他一直以一直放松的姿态开始自己的创作和演唱，并且获得了更多人的喜欢。', 'Ghostface Killah是出生于1970年5月9日。 原名Dennis Coles，并曾用Tony Starks,Iron Man等名发表作品的Ghostface Killah在1993年参加Wu-Tang Clan乐团专辑「Enter the Wu-Tang」录制工作，由于突出表现而成功跻身Wu-Tang Clan成员。', '男', '5', '4.jpg');
INSERT INTO `musician` VALUES ('5', '法老', '法老，本名孙权，1992年10月11日出生于浙江省海宁市 [1]  ，中国内地说唱歌手，说唱厂牌“活死人”创始人。', '2016年，创立“活死人”说唱厂牌。2018年10月23日，发布个人原创专辑《生于未来》。2017年3月14日，发布单曲《亲密爱人2017》。2019年3月31日，发布个人原创mixtape《上学嗨mixtape》；11月8日，发布个人原创单曲《悲伤的大象》。2020年6月，作为制作人参加芒果TV说唱音乐综艺《说唱听我的》 [2]  。', '男', '6', '5.jpg');
INSERT INTO `musician` VALUES ('6', '艾热', '艾热（AIR），出生于新疆喀什 [1]  ，中国内地流行说唱男歌手 [1]  ', '2016年，推出个人单曲《UUG abiz》。2017年，为吴莫愁创作并制作的单曲《旅程》正式上线 [2]  。2018年，参加爱奇艺歌唱选秀节目《中国新说唱》 [3]  ，最终获得全国总决赛冠军，从而正式进入演艺圈 [4]  ；11月29日，获得亚洲音乐盛典年度最佳说唱歌手奖 [5]  ；12月18日，推出首张个人同名专辑《AIR·艾热》 [6]  。2019年1月5日，推出与GAI合唱的歌曲《永不独行》 [7]  ；3月25日，获得第26届东方风云榜音乐盛典最受欢迎说唱歌手奖 [8]  ；8月30日，获得华人歌曲音乐盛典乐坛新势力奖 [9]  ；10月17日，入围2019福布斯中国30岁以下精英榜（30 Under 30） [10]  。2020年4月，以奇袭歌手身份参加湖南卫视音乐竞技节目《歌手·当打之年》 [11]  。', '男', '7', '6.jpg');
INSERT INTO `musician` VALUES ('7', '胡彦斌', '胡彦斌（Tiger Hu），1983年7月4日生于上海市，中国内地男歌手、音乐制作人，牛班音乐学校创始人。', '1999年参加“上海亚洲音乐节新人歌手大赛”出道 [3]  。2002年发行首张个人专辑《文武双全》，成为首位在内地、香港、台湾推出个人专辑的国内歌手 [4]  。2003年发行专辑《文武双全升级版》。2004年发行专辑《MuSiC混合体》，一人包办了专辑中所有的作曲、编曲以及制作工作。2005年组建“一极录音工作室”。2007年创建个人厂牌“风风火火”。2008年在台湾举行“胡彦斌2008男人歌演唱会”，成为第一位在台湾举行售票演唱会的内地艺人 [5]  。2011年，赴美留学，进修音乐制作人与电影，从唱作人成长为全能音乐制作人。2013年12月27日，在江苏卫视“全能星战”节目总决赛上获得冠军 [6]  。2014年发行专辑《太歌》。2015年1月，参加《我是歌手第三季》并进入总决赛 [7]  。\r\n2018年4月，担任中国首部女团青春成长节目《创造101》唱作导师及音乐总监 [8] ', '男', '8', '7.jpg');
INSERT INTO `musician` VALUES ('8', '某幻君', '某幻君，B站人气UP主，绝地求生娱乐主播。', 'B站“阴阳怪气”男团成员之一，早期因恐怖游戏视频走红，后转型绝地求生主播，凭借良好的素质涵养，以及一口流利的英语走红。 [1]', '男', '9', '8.jpg');
INSERT INTO `musician` VALUES ('9', '刘聪', 'KEY.L刘聪，说唱歌手 [1]  ，是来自湖南长沙的说唱组合C-BLOCK的成员 [2]  。', '在《中国新说唱》中，KEY.L刘聪以一首给自己的歌《Hey Kong》成功晋级半决赛，走心歌词不仅直击观众内心，更在节目开播当晚登至微博热搜TOP3 [3]  。', '男', '10', '9.jpg');
INSERT INTO `musician` VALUES ('10', '谢帝', '谢帝（Boss Shady [1]  ），原名蔡镇鸿，1989年11月6日出生于四川省成都市，中国内地嘻哈说唱男歌手', '2013年，推出Mixtape混音专辑《随便听起耍嘛》；同年，与5ter凭借歌曲《在场》获得“第二届中国嘻哈颁奖典礼”最佳原创国语歌曲奖 [2]  。2014年，参加CCTV-3《中国好歌曲》的比赛，获得全国总决赛四强；同年3月29日，凭借歌曲《明天不上班》获得“第三届中国嘻哈颁奖典礼”最佳原创方言歌曲奖 [3]  。2015年8月，推出首张个人音乐专辑《人，社会，钱》 [4]  ；同年10月1日，在成都举办“谢帝之好耍巡回演唱会” [5-6]  。2016年4月，推出个人说唱单曲《绝世武神》 [7]  ；同年8月，推出个人说唱单曲《堵起》 [8-9]  。2017年，出演个人首部电影 《火锅侠》 [10]  ；同年，推出第二张个人音乐专辑《这张专辑太Diao了》 [11]  ；7月20日，获得首届唱工委CMA音乐颁奖盛典最佳说唱表演奖', '男', '11', '10.jpg');
INSERT INTO `musician` VALUES ('11', '周杰伦', '周杰伦（Jay Chou），1979年1月18日出生于台湾省新北市，祖籍福建省泉州市永春县，中国台湾流行乐男歌手、原创音乐人、演员、导演、编剧，毕业于淡江中学。', '2000年发行首张个人专辑《Jay》。2001年发行的专辑《范特西》奠定其融合中西方音乐的风格 [1]  。2002年举行“The One”世界巡回演唱会 [2]  。2003年成为美国《时代周刊》封面人物 [3-4]  。2004年获得世界音乐大奖中国区最畅销艺人奖 [5]  。2005年凭借动作片《头文字D》获得台湾电影金马奖、香港电影金像奖最佳新人奖 [6]  。2006年起连续三年获得世界音乐大奖中国区最畅销艺人奖 [7]  。2007年自编自导的文艺片《不能说的秘密》获得台湾电影金马奖年度台湾杰出电影奖 [8]  。\r\n2008年凭借歌曲《青花瓷》获得第19届金曲奖最佳作曲人奖。2009年入选美国CNN评出的“25位亚洲最具影响力的人物” [9]  ，同年获得第20届金曲奖最佳国语男歌手奖 [10]  。2010年入选美国《Fast Company》评出的“全球百大创意人物” [', '男', '12', '11.jpg');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of slistcollect
-- ----------------------------
INSERT INTO `slistcollect` VALUES ('1', '1', '1');
INSERT INTO `slistcollect` VALUES ('2', '1', '2');
INSERT INTO `slistcollect` VALUES ('3', '1', '3');
INSERT INTO `slistcollect` VALUES ('4', '2', '4');
INSERT INTO `slistcollect` VALUES ('5', '2', '5');
INSERT INTO `slistcollect` VALUES ('6', '2', '3');
INSERT INTO `slistcollect` VALUES ('7', '3', '1');
INSERT INTO `slistcollect` VALUES ('8', '4', '1');
INSERT INTO `slistcollect` VALUES ('9', '4', '2');
INSERT INTO `slistcollect` VALUES ('10', '4', '3');
INSERT INTO `slistcollect` VALUES ('11', '5', '4');
INSERT INTO `slistcollect` VALUES ('12', '5', '5');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of slistdetail
-- ----------------------------
INSERT INTO `slistdetail` VALUES ('1', '1', '1');
INSERT INTO `slistdetail` VALUES ('2', '1', '2');
INSERT INTO `slistdetail` VALUES ('3', '1', '3');
INSERT INTO `slistdetail` VALUES ('4', '1', '4');
INSERT INTO `slistdetail` VALUES ('5', '2', '3');
INSERT INTO `slistdetail` VALUES ('6', '2', '5');
INSERT INTO `slistdetail` VALUES ('7', '2', '7');
INSERT INTO `slistdetail` VALUES ('8', '2', '9');
INSERT INTO `slistdetail` VALUES ('9', '3', '1');
INSERT INTO `slistdetail` VALUES ('10', '3', '6');
INSERT INTO `slistdetail` VALUES ('11', '3', '10');
INSERT INTO `slistdetail` VALUES ('12', '3', '14');
INSERT INTO `slistdetail` VALUES ('13', '4', '1');
INSERT INTO `slistdetail` VALUES ('14', '4', '12');
INSERT INTO `slistdetail` VALUES ('15', '5', '8');
INSERT INTO `slistdetail` VALUES ('16', '5', '11');
INSERT INTO `slistdetail` VALUES ('17', '5', '14');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('1', '不得不爱', '1', 'lrc1.lrc', null, '2', '1.mp3', '0', '1.png');
INSERT INTO `song` VALUES ('2', 'The Slim Shady LP', '2', 'lrc2.lrc', null, '6', '2.mp3', '0', '2.png');
INSERT INTO `song` VALUES ('3', 'ABC', '3', 'lrc3.lrc', null, '1', '3.mp3', '0', '3.png');
INSERT INTO `song` VALUES ('4', 'Ice Cream', '4', 'lrc4.lrc', null, '1', '4.mp3', '0', '4.png');
INSERT INTO `song` VALUES ('5', '上学威龙', '5', 'lrc5.lrc', null, '6', '5.mp3', '0', '5.png');
INSERT INTO `song` VALUES ('6', '巨人', '6', 'lrc6.lrc', null, '9', '6.mp3', '0', '6.png');
INSERT INTO `song` VALUES ('7', '返老还童', '7', 'lrc7.lrc', null, '1', '7.mp3', '0', '7.png');
INSERT INTO `song` VALUES ('8', '电子羊', '8', 'lrc8.lrc', null, '1', '8.mp3', '0', '8.png');
INSERT INTO `song` VALUES ('9', '斗士', '8', 'lrc9.lrc', null, '1', '9.mp3', '0', '9.png');
INSERT INTO `song` VALUES ('10', '经济舱', '9', 'lrc10.lrc', null, '1', '10.mp3', '0', '10.png');
INSERT INTO `song` VALUES ('11', '老子明天不上班', '10', 'lrc11.lrc', null, '2', '11.mp3', '0', '11.png');
INSERT INTO `song` VALUES ('12', '闹啥子嘛闹', '10', 'lrc12.lrc', null, '2', '12.mp3', '0', '12.png');
INSERT INTO `song` VALUES ('13', '双截棍', '11', 'lrc13.lrc', null, '9', '13.mp3', '0', '13.png');
INSERT INTO `song` VALUES ('14', '止战之殇', '11', 'lrc14.lrc', null, '1', '14.mp3', '0', '14.png');

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of songcollect
-- ----------------------------
INSERT INTO `songcollect` VALUES ('1', '1', '1');
INSERT INTO `songcollect` VALUES ('2', '1', '2');
INSERT INTO `songcollect` VALUES ('3', '1', '3');
INSERT INTO `songcollect` VALUES ('4', '1', '4');
INSERT INTO `songcollect` VALUES ('5', '1', '5');
INSERT INTO `songcollect` VALUES ('6', '1', '6');
INSERT INTO `songcollect` VALUES ('7', '2', '2');
INSERT INTO `songcollect` VALUES ('8', '2', '5');
INSERT INTO `songcollect` VALUES ('9', '2', '8');
INSERT INTO `songcollect` VALUES ('10', '2', '9');
INSERT INTO `songcollect` VALUES ('11', '3', '1');
INSERT INTO `songcollect` VALUES ('12', '3', '4');
INSERT INTO `songcollect` VALUES ('13', '3', '8');
INSERT INTO `songcollect` VALUES ('14', '6', '8');
INSERT INTO `songcollect` VALUES ('15', '6', '9');
INSERT INTO `songcollect` VALUES ('16', '6', '12');
INSERT INTO `songcollect` VALUES ('17', '9', '2');
INSERT INTO `songcollect` VALUES ('18', '9', '13');
INSERT INTO `songcollect` VALUES ('19', '12', '14');
INSERT INTO `songcollect` VALUES ('20', '13', '4');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of songlist
-- ----------------------------
INSERT INTO `songlist` VALUES ('1', '歌单1', '1', '1', '歌单1简介', 'Slistimg1.jpg');
INSERT INTO `songlist` VALUES ('2', '歌单2', '1', '1', '歌单2简介', 'Slistimg2.jpg');
INSERT INTO `songlist` VALUES ('3', '歌单3', '1', '1', '歌单3简介', 'Slistimg3.jpg');
INSERT INTO `songlist` VALUES ('4', '歌单4', '1', '1', '歌单4简介', 'Slistimg4.jpg');
INSERT INTO `songlist` VALUES ('5', '歌单5', '1', '1', '歌单5简介', 'Slistimg5.jpg');

-- ----------------------------
-- Table structure for `style`
-- ----------------------------
DROP TABLE IF EXISTS `style`;
CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

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
INSERT INTO `style` VALUES ('9', '前卫摇滚');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', 'song');
INSERT INTO `type` VALUES ('2', 'accompaniment');
INSERT INTO `type` VALUES ('3', 'sheet');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '12345678901', '如果等不及', '000111', '123456789011.jpg', '男', '如果等不及，不如没有开始', '2', '3', '0', '0');
INSERT INTO `user` VALUES ('2', '12345678902', '为战而来', '000222', '123456789022.jpg', '女', '肖战最帅哈哈哈', '2', '4', '0', '0');
INSERT INTO `user` VALUES ('3', '12345678903', '爱我中华', '000333', '123456789033.jpg', '男', '丰富的过每一天，快乐的看每一天', '1', '0', '0', '0');
INSERT INTO `user` VALUES ('4', '12345678904', '中华小曲库', '000444', '123456789044.jpg', '男', '我从小就特别喜欢听音乐', '2', '3', '0', '0');
INSERT INTO `user` VALUES ('5', '12345678905', '阖家欢乐', '000555', '123456789055.jpg', '女', '家和万事兴', '3', '0', '0', '0');
INSERT INTO `user` VALUES ('6', '12345678906', '硝烟四起', '000666', '123456789066.jpg', '女', '为战而来', '2', '0', '0', '0');
INSERT INTO `user` VALUES ('7', '12345678907', '一鹿有晗', '000777', '123456789077.jpg', '女', '女孩的可爱程度,　与能吃程度成正比', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('8', '12345678908', '为什么我还是学渣', '000888', '123456789088.jpg', '男', '小时候总是在作文上写自己扶过老人 现在想想自己胆子太大', '2', '2', '0', '0');
INSERT INTO `user` VALUES ('9', '12345678909', '偷吃薯片', '000999', '123456789099.jpg', '男', '	所谓猪一样的室友就是 我感冒让他带一盒白加黑 他给我带了一包奥利奥 。', '2', '0', '0', '0');
INSERT INTO `user` VALUES ('10', '12345678910', '人醉梦未醒', '001010', '1234567891010.jpg', '女', '咎由自取的东西最后也不用谁可怜', '1', '3', '0', '0');
INSERT INTO `user` VALUES ('11', '12345678911', '睫毛微卷', '001111', '1234567891111.jpg', '女', '时光带走的只会是各种品种的狗', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('12', '12345678912', '老衲已成佛', '001212', '1234567891212.jpg', '男', '放学到家，扔下书包，狂奔到这个房间，插上插销，开机。用时7秒堪称完美~~~', '0', '5', '0', '0');
INSERT INTO `user` VALUES ('13', '12345678913', '等你到星期八', '001313', '1234567891313', '女', '	没动力的时候我就会想到你的笑', '2', '0', '0', '0');

-- ----------------------------
-- Table structure for `user_login`
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `phone` char(11) NOT NULL,
  `pwd` varchar(18) NOT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_login
-- ----------------------------
