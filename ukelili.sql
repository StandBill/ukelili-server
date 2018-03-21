/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : ukelili

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-05-18 01:29:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classifaction
-- ----------------------------
DROP TABLE IF EXISTS `classifaction`;
CREATE TABLE `classifaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `typeId` int(11) NOT NULL,
  `extra` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeIdd` (`typeId`),
  CONSTRAINT `typeIdd` FOREIGN KEY (`typeId`) REFERENCES `type_info` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classifaction
-- ----------------------------
INSERT INTO `classifaction` VALUES ('1', '初级教程', '4', 'dd的解放路跨世纪东方会计师对福建省地方会计师');
INSERT INTO `classifaction` VALUES ('2', '曲谱', '4', 'dd');
INSERT INTO `classifaction` VALUES ('3', '常用和弦', '4', 'dd');
INSERT INTO `classifaction` VALUES ('4', '识谱教程', '4', 'dd');
INSERT INTO `classifaction` VALUES ('5', '其他', '4', 'dd');
INSERT INTO `classifaction` VALUES ('6', '原创区', '5', 'aa');
INSERT INTO `classifaction` VALUES ('7', '新手交流', '5', 'aa');
INSERT INTO `classifaction` VALUES ('8', '教学笔记', '5', 'aa');
INSERT INTO `classifaction` VALUES ('9', '其他', '5', 'aa');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comId` int(11) NOT NULL AUTO_INCREMENT,
  `targetId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `content` text,
  `date` datetime DEFAULT NULL,
  `extra` varchar(255) DEFAULT NULL,
  `is_read` int(11) DEFAULT '0',
  `author` int(11) DEFAULT NULL,
  PRIMARY KEY (`comId`),
  KEY `dddd` (`typeId`),
  KEY `aa` (`author`),
  CONSTRAINT `aa` FOREIGN KEY (`author`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dddd` FOREIGN KEY (`typeId`) REFERENCES `type_info` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='extra???????????????id';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('99', '4', '4', '撒的发生发的', '2017-05-18 00:31:15', 'video4', '1', '15');
INSERT INTO `comment` VALUES ('101', '15', '4', '水电费', '2017-05-18 00:35:46', 'video4', '0', '20');
INSERT INTO `comment` VALUES ('102', '15', '4', '啥地方是否', '2017-05-18 00:36:28', 'video4', '0', '20');

-- ----------------------------
-- Table structure for prod_type
-- ----------------------------
DROP TABLE IF EXISTS `prod_type`;
CREATE TABLE `prod_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `exp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userId`),
  KEY `typeid` (`typeId`),
  CONSTRAINT `typeid` FOREIGN KEY (`typeId`) REFERENCES `type_info` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userid` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prod_type
-- ----------------------------
INSERT INTO `prod_type` VALUES ('1', '20', '5', '原创');
INSERT INTO `prod_type` VALUES ('3', '20', '5', '随笔');
INSERT INTO `prod_type` VALUES ('8', '20', '4', '测试');
INSERT INTO `prod_type` VALUES ('9', '7', '5', 'jj');
INSERT INTO `prod_type` VALUES ('10', '20', '4', 'ddd');
INSERT INTO `prod_type` VALUES ('11', '20', '5', '测试');

-- ----------------------------
-- Table structure for share_info
-- ----------------------------
DROP TABLE IF EXISTS `share_info`;
CREATE TABLE `share_info` (
  `shareId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `label` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `srcAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shareId`),
  KEY `uuserid` (`userId`),
  CONSTRAINT `uuserid` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_news_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_news_info`;
CREATE TABLE `sys_news_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `content` text,
  `date` datetime DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ds` (`userId`),
  KEY `ted` (`typeId`),
  CONSTRAINT `ds` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ted` FOREIGN KEY (`typeId`) REFERENCES `type_info` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_news_info
-- ----------------------------
INSERT INTO `sys_news_info` VALUES ('1', '7', '测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息测试系统消息', '2017-03-25 10:46:39', '3');
INSERT INTO `sys_news_info` VALUES ('4', '20', '<p>撒旦法撒旦法</p>', '2017-04-05 14:59:37', '1');
INSERT INTO `sys_news_info` VALUES ('8', '20', 'cshi ', '2017-04-05 19:17:21', '1');
INSERT INTO `sys_news_info` VALUES ('9', '20', 'kjkjlj', '2017-04-05 23:27:30', '1');
INSERT INTO `sys_news_info` VALUES ('10', '7', 'zheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshizheshi yitiaoceshi', '2017-04-05 23:28:15', '3');
INSERT INTO `sys_news_info` VALUES ('12', '20', 'XX评论了你的文章[处理]', '2017-05-01 16:05:33', '2');
INSERT INTO `sys_news_info` VALUES ('13', '7', '[张三]评论了文章[sdfsdf]', '2017-05-17 21:37:03', '2');
INSERT INTO `sys_news_info` VALUES ('14', '20', '[测试y]评论了文章[测试]', '2017-05-18 00:10:02', '2');
INSERT INTO `sys_news_info` VALUES ('15', '20', '[测试y]评论了文章[测试]', '2017-05-18 00:10:18', '2');
INSERT INTO `sys_news_info` VALUES ('16', '20', '[张三]评论了文章[等等]', '2017-05-18 00:28:47', '2');
INSERT INTO `sys_news_info` VALUES ('17', '20', '[张三]评论了文章[等等]', '2017-05-18 00:30:12', '2');
INSERT INTO `sys_news_info` VALUES ('18', '20', '[张三]评论了文章[等等]', '2017-05-18 00:31:15', '2');
INSERT INTO `sys_news_info` VALUES ('19', '20', '[张三]评论了文章[等等]', '2017-05-18 00:35:38', '2');
INSERT INTO `sys_news_info` VALUES ('20', '20', '[张三]评论了文章[等等]', '2017-05-18 00:35:46', '2');
INSERT INTO `sys_news_info` VALUES ('21', '20', '[张三]评论了文章[等等]', '2017-05-18 00:36:28', '2');
INSERT INTO `sys_news_info` VALUES ('22', '20', '[张三]评论了文章[等等]', '2017-05-18 00:39:02', '2');

-- ----------------------------
-- Table structure for text_image_info
-- ----------------------------
DROP TABLE IF EXISTS `text_image_info`;
CREATE TABLE `text_image_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `textId` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `des` text,
  `extra` text,
  PRIMARY KEY (`id`),
  KEY `textid` (`textId`),
  CONSTRAINT `textid` FOREIGN KEY (`textId`) REFERENCES `text_info` (`textId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of text_image_info
-- ----------------------------

-- ----------------------------
-- Table structure for text_info
-- ----------------------------
DROP TABLE IF EXISTS `text_info`;
CREATE TABLE `text_info` (
  `textId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `downloads` int(10) unsigned zerofill DEFAULT '0000000000',
  `srcAddress` varchar(255) DEFAULT NULL,
  `transmits` int(10) unsigned zerofill DEFAULT '0000000000',
  `userId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `can_down` int(11) DEFAULT '1',
  `can_transmit` int(11) DEFAULT '1',
  `content` text,
  `coms` int(11) DEFAULT '0',
  `can_discuss` int(11) DEFAULT '1',
  `prodId` int(11) DEFAULT NULL,
  `cf_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`textId`),
  KEY `dd` (`userId`),
  KEY `ffd` (`prodId`),
  KEY `sddsf` (`cf_id`),
  CONSTRAINT `dd` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ffd` FOREIGN KEY (`prodId`) REFERENCES `prod_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sddsf` FOREIGN KEY (`cf_id`) REFERENCES `classifaction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of text_info
-- ----------------------------
INSERT INTO `text_info` VALUES ('14', '测试', '0000000000', '', '0000000000', '20', '2017-05-18 00:09:47', '0', '1', '测试啥地方是否', '1', '1', '3', '6');

-- ----------------------------
-- Table structure for type_info
-- ----------------------------
DROP TABLE IF EXISTS `type_info`;
CREATE TABLE `type_info` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_info
-- ----------------------------
INSERT INTO `type_info` VALUES ('1', 'user');
INSERT INTO `type_info` VALUES ('2', 'comment');
INSERT INTO `type_info` VALUES ('3', 'system');
INSERT INTO `type_info` VALUES ('4', 'video');
INSERT INTO `type_info` VALUES ('5', 'text');

-- ----------------------------
-- Table structure for user_comment_info
-- ----------------------------
DROP TABLE IF EXISTS `user_comment_info`;
CREATE TABLE `user_comment_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `comId` int(11) NOT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ddds` (`userId`),
  KEY `sss` (`comId`),
  CONSTRAINT `ddds` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sss` FOREIGN KEY (`comId`) REFERENCES `comment` (`comId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comment_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_download_info
-- ----------------------------
DROP TABLE IF EXISTS `user_download_info`;
CREATE TABLE `user_download_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `targetId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fffs` (`userId`),
  KEY `ff` (`typeId`),
  CONSTRAINT `ff` FOREIGN KEY (`typeId`) REFERENCES `type_info` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fffs` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_download_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rank` int(11) DEFAULT '0',
  `remark` int(11) DEFAULT '0',
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `signtime` date NOT NULL,
  `lastLogin` date DEFAULT NULL,
  `isForbit` int(11) DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('5', 'f', 'f', 'f', '0', '0', 'f', 'f', '2017-03-16', '2017-03-30', '1');
INSERT INTO `user_info` VALUES ('6', '1', 'aa', null, '0', '0', '20', null, '2017-03-16', '2017-05-14', '0');
INSERT INTO `user_info` VALUES ('7', '1', '张三', 'zhangsan', '1', '0', '1', '136@163.com', '2017-03-16', '2017-05-14', '0');
INSERT INTO `user_info` VALUES ('15', '1', 'a', null, '0', '0', 'aa', null, '2016-01-01', null, '0');
INSERT INTO `user_info` VALUES ('20', '1', '测试y', '张三', '0', '0', '13', '163@163.com', '2018-03-01', '2017-05-18', '0');
INSERT INTO `user_info` VALUES ('21', '1', 'admin', 'admin', '100', '100', '2', null, '2017-04-14', '2017-05-17', '0');

-- ----------------------------
-- Table structure for user_transmit_info
-- ----------------------------
DROP TABLE IF EXISTS `user_transmit_info`;
CREATE TABLE `user_transmit_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `targetId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ddd` (`userId`),
  KEY `aas` (`typeId`),
  CONSTRAINT `aas` FOREIGN KEY (`typeId`) REFERENCES `type_info` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ddd` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_transmit_info
-- ----------------------------

-- ----------------------------
-- Table structure for video_info
-- ----------------------------
DROP TABLE IF EXISTS `video_info`;
CREATE TABLE `video_info` (
  `videoId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `downloads` int(10) unsigned zerofill DEFAULT '0000000000',
  `transmits` int(10) unsigned zerofill DEFAULT '0000000000',
  `srcAddress` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `can_down` int(11) DEFAULT '1',
  `can_transmit` int(11) DEFAULT '1',
  `image` varchar(255) DEFAULT NULL,
  `can_discuss` int(11) DEFAULT '1',
  `coms` int(11) DEFAULT '0',
  `description` text,
  `prodId` int(11) DEFAULT NULL,
  `can_operate` int(11) DEFAULT '0',
  `cf_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`videoId`),
  KEY `useridd` (`userId`),
  KEY `sssd` (`prodId`),
  KEY `cfid` (`cf_id`),
  CONSTRAINT `cfid` FOREIGN KEY (`cf_id`) REFERENCES `classifaction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sssd` FOREIGN KEY (`prodId`) REFERENCES `prod_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `useridd` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_info
-- ----------------------------
INSERT INTO `video_info` VALUES ('3', '滴滴打车', '0000000000', '0000000000', 'http://ooqpf67rp.bkt.clouddn.com/52061894-4396-4F27-8A2D-782498AB5EF5-2017-05-09-03-15-32.mp4', '20', '2017-05-09 15:38:12', '0', '0', 'http://ooqpf67rp.bkt.clouddn.com/8CABA818-1A71-4295-9B60-4C17F5C30BFE.jpg', '0', '0', '<p>沉甸甸的多所所所所所所沉甸甸的多所所所所所所</p><br><p>沉甸甸的多所所所所所所</p><p>沉甸甸的多所所所所所所</p><p><br></p><p>沉甸甸的多所所所所所所</p><p>沉甸甸的多所所所所所所</p><p><br></p><p>沉甸甸的多所所所所所所</p><p>沉甸甸的多所所所所所所</p><p><br></p><p>沉甸甸的多所所所所所所</p><p>沉甸甸的多所所所所所所</p><p><br></p><p>沉甸甸的多所所所所所所</p><p><br></p><p><br></p>', '8', '1', '1');
INSERT INTO `video_info` VALUES ('4', '等等', '0000001990', '0000000000', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-09-17-14-42.mp4', '20', '2017-05-09 17:15:50', '1', '1', 'http://ooqpf67rp.bkt.clouddn.com/8CABA818-1A71-4295-9B60-4C17F5C30BFE.jpg', '1', '8', '撒旦法撒旦法', '8', '1', '2');
INSERT INTO `video_info` VALUES ('10', '默认标题', '0000000000', '0000000000', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-17-22-03-57.mp4', '20', '2017-05-17 22:04:06', '1', '1', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-17-22-03-57.jpg', '1', '0', 'dgfggg', '1', '1', '1');
INSERT INTO `video_info` VALUES ('11', '默认标题', '0000000000', '0000000000', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-17-23-52-55.mp4', '20', '2017-05-17 23:53:44', '1', '1', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-17-23-52-55.jpg', '1', '0', 'dd', '8', '1', '2');
INSERT INTO `video_info` VALUES ('12', '默认标题', '0000000000', '0000000000', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-17-23-52-55.mp4', '20', '2017-05-17 23:54:07', '1', '1', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-17-23-52-55.jpg', '1', '0', 'dd', '8', '1', '2');
INSERT INTO `video_info` VALUES ('13', '默认标题', '0000000000', '0000000000', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-18-01-03-36.mp4', '20', '2017-05-18 01:03:43', '1', '1', 'http://ooqpf67rp.bkt.clouddn.com/2017-05-18-01-03-36.jpg', '1', '0', 'sdfsfdsdfsdfsdf', '8', '1', '1');
