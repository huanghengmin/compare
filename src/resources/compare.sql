-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        5.6.13-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 compare 的数据库结构
DROP DATABASE IF EXISTS `compare`;
CREATE DATABASE IF NOT EXISTS `compare` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `compare`;


-- 导出  表 compare.account 结构
DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `depart` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `start_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `end_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `start_hour` int(11) DEFAULT NULL,
  `end_hour` int(11) DEFAULT NULL,
  `description` text COLLATE utf8_bin,
  `remote_ip` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mac` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ip_type` int(1) NOT NULL DEFAULT '1',
  `user_type` int(1) NOT NULL DEFAULT '1' COMMENT '1代表管理员用户,2代表网点用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='账户表';

-- 正在导出表  compare.account 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
REPLACE INTO `account` (`id`, `user_name`, `password`, `sex`, `phone`, `created_time`, `modified_time`, `status`, `depart`, `title`, `name`, `email`, `start_ip`, `end_ip`, `start_hour`, `end_hour`, `description`, `remote_ip`, `mac`, `ip_type`, `user_type`) VALUES
	(1, 'admin', 'S8W2gMnH8VWiT9pXRMPQxA==', '男', '0571-88888888', '2010-07-04 13:52:36', '2014-05-22 17:16:38', '有效', '信息中心', '主任', '初始化管理员', 'xiaom@hzih.net', '0.0.0.0', '192.168.254.254', 9, 18, '这是一个默认的超级用户信息', '192.168.2.176', '5C-63-BF-1D-72-07', 1, 1),
	(2, 'authadmin', 'S8W2gMnH8VWiT9pXRMPQxA==', '男', '0571-88888888', '2012-04-12 14:22:35', '2013-05-07 18:27:30', '有效', '信息中心', '主任', '授权管理员', 'xiaom@hzih.net', '0.0.0.0', '192.168.200.254', 1, 22, '这是一个默认的授权用户信息', '', NULL, 1, 1),
	(3, 'configadmin', 'S8W2gMnH8VWiT9pXRMPQxA==', '男', '0571-88888888', '2012-06-12 18:04:01', '2013-05-07 18:27:45', '有效', '信息中心', '主任', '配置管理员', 'xiaom@hzih.net', '0.0.0.0', '192.168.200.254', 9, 21, '这是一个默认的配置用户信息', '', NULL, 1, 1),
	(4, 'auditadmin', 'S8W2gMnH8VWiT9pXRMPQxA==', '男', '0571-88888888', '2012-07-03 10:19:57', '2014-08-26 13:01:36', '有效', '信息中心', '主任', '审计管理员', 'xiaom@hzih.net', '0.0.0.0', '192.168.200.254', 7, 22, '这是一个默认的审计用户信息', NULL, NULL, 1, 1),
	(6, 'lisi', 'S8W2gMnH8VWiT9pXRMPQxA==', '男', '0571-88880571', '2016-02-24 18:18:21', NULL, '有效', '信息部', '主任', 'lisi', '**@hzih.net', '0.0.0.0', '192.255.255.255', 9, 18, '这是一个用户信息', NULL, '', 1, 2),
	(7, 'wangwu', 'S8W2gMnH8VWiT9pXRMPQxA==', '男', '0571-88880571', '2016-02-25 15:41:39', NULL, '有效', '信息部', '主任', 'wangwu', '**@hzih.net', '0.0.0.0', '192.255.255.255', 9, 18, '这是一个用户信息', NULL, '', 1, 2),
	(8, 'test', 'S8W2gMnH8VWiT9pXRMPQxA==', '男', '0571-88880571', '2016-04-05 17:11:41', NULL, '有效', '信息部', '主任', '测试', '**@hzih.net', '0.0.0.0', '255.255.255.255', 9, 18, '这是一个用户信息', NULL, '', 1, 1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


-- 导出  表 compare.account_oper_log 结构
DROP TABLE IF EXISTS `account_oper_log`;
CREATE TABLE IF NOT EXISTS `account_oper_log` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `log_time` datetime DEFAULT NULL COMMENT '审计时间',
  `level` varchar(10) DEFAULT NULL COMMENT '日志级别',
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `audit_module` varchar(255) DEFAULT NULL COMMENT '审计模块',
  `audit_info` varchar(255) DEFAULT NULL COMMENT '审计内容',
  PRIMARY KEY (`Id`),
  KEY `log_time` (`log_time`,`level`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='用户操作审计表';

-- 正在导出表  compare.account_oper_log 的数据：~18 rows (大约)
/*!40000 ALTER TABLE `account_oper_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_oper_log` ENABLE KEYS */;


-- 导出  表 compare.account_role 结构
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE IF NOT EXISTS `account_role` (
  `account_id` bigint(20) NOT NULL DEFAULT '0',
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_id`,`role_id`),
  KEY `FK410D034851BABF58` (`role_id`),
  KEY `FK410D0348BE9C187C` (`account_id`),
  KEY `FK410D034880878851` (`role_id`),
  KEY `FK410D0348E7AB80E3` (`account_id`),
  KEY `FK410D03481FCE46BD` (`role_id`),
  KEY `FK410D034811351AF7` (`account_id`),
  KEY `FK410D03488A556D64` (`role_id`),
  KEY `FK410D0348D6E01EF0` (`account_id`),
  KEY `FK410D0348D063FAAC` (`role_id`),
  KEY `FK410D03486E4B2CA8` (`account_id`),
  KEY `FK410D0348F7EB1F96` (`role_id`),
  KEY `FK410D0348562BE77E` (`account_id`),
  KEY `FK410D034869DE458B` (`role_id`),
  KEY `FK410D0348CC9A0169` (`account_id`),
  CONSTRAINT `FK410D0348CC9A0169` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK410D034811351AF7` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK410D03481FCE46BD` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK410D034851BABF58` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK410D0348562BE77E` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK410D034869DE458B` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK410D03486E4B2CA8` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK410D034880878851` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK410D03488A556D64` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK410D0348BE9C187C` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK410D0348D063FAAC` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK410D0348D6E01EF0` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK410D0348E7AB80E3` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FK410D0348F7EB1F96` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  compare.account_role 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `account_role` DISABLE KEYS */;
REPLACE INTO `account_role` (`account_id`, `role_id`) VALUES
	(1, 1),
	(2, 2),
	(4, 3),
	(3, 4),
	(6, 5),
	(7, 5),
	(8, 6);
/*!40000 ALTER TABLE `account_role` ENABLE KEYS */;


-- 导出  表 compare.identity_info 结构
DROP TABLE IF EXISTS `identity_info`;
CREATE TABLE IF NOT EXISTS `identity_info` (
  `idCard` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '身份证号码',
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '返回状态码',
  `xq` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '返回详情',
  `compare_time` datetime DEFAULT NULL COMMENT '比对时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '比对状态',
  PRIMARY KEY (`idCard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  compare.identity_info 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `identity_info` DISABLE KEYS */;
REPLACE INTO `identity_info` (`idCard`, `code`, `xq`, `compare_time`, `status`) VALUES
	('320102198204022439', '002', '【在逃人员】1.案别:在逃,入省库时间:2016-03-04 00:53:41,数据来源：七类重点人员;【在逃人员】案别：职务侵占案，立案单位：浙江省金华市公安局婺城分局，立案时间：2016-02-14;【执法办案人员】入执法办案库时间：2016-02-14 10:16:52，数据来源：执法办案-嫌疑人员;是否维族：查无记录;', '2016-04-06 00:00:00', 1),
	('411426198709180619', '000', '在指定数据库中未找到人员匹配记录;是否维族：查无记录;', '2016-04-06 00:00:00', 1),
	('430725199002093279', '000', '在指定数据库中未找到人员匹配记录;是否维族：查无记录;', '2016-04-06 00:00:00', 1);
/*!40000 ALTER TABLE `identity_info` ENABLE KEYS */;


-- 导出  表 compare.identity_query_log 结构
DROP TABLE IF EXISTS `identity_query_log`;
CREATE TABLE IF NOT EXISTS `identity_query_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `session_id` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `id_card` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `xq` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `log_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  compare.identity_query_log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `identity_query_log` DISABLE KEYS */;
REPLACE INTO `identity_query_log` (`id`, `session_id`, `id_card`, `code`, `xq`, `log_time`) VALUES
	(1, '1459923982156', '320102198204022439', '002', '【在逃人员】1.案别:在逃,入省库时间:2016-03-04 00:53:41,数据来源：七类重点人员;【在逃人员】案别：职务侵占案，立案单位：浙江省金华市公安局婺城分局，立案时间：2016-02-14;【执法办案人员】入执法办案库时间：2016-02-14 10:16:52，数据来源：执法办案-嫌疑人员;是否维族：查无记录;', '2016-04-06 14:26:28'),
	(2, '1459924335734', '320102198204022439', '002', '【在逃人员】1.案别:在逃,入省库时间:2016-03-04 00:53:41,数据来源：七类重点人员;【在逃人员】案别：职务侵占案，立案单位：浙江省金华市公安局婺城分局，立案时间：2016-02-14;【执法办案人员】入执法办案库时间：2016-02-14 10:16:52，数据来源：执法办案-嫌疑人员;是否维族：查无记录;', '2016-04-06 14:32:25'),
	(3, '1459924345156', '430725199002093279', '000', '在指定数据库中未找到人员匹配记录;是否维族：查无记录;', '2016-04-06 14:32:25'),
	(4, '1459924410609', '411426198709180619', '000', '在指定数据库中未找到人员匹配记录;是否维族：查无记录;', '2016-04-06 14:33:36');
/*!40000 ALTER TABLE `identity_query_log` ENABLE KEYS */;


-- 导出  表 compare.permission 结构
DROP TABLE IF EXISTS `permission`;
CREATE TABLE IF NOT EXISTS `permission` (
  `ID` bigint(20) NOT NULL DEFAULT '0',
  `CODE` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  compare.permission 的数据：~21 rows (大约)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
REPLACE INTO `permission` (`ID`, `CODE`, `NAME`, `DESCRIPTION`, `PARENT_ID`, `SEQ`) VALUES
	(100, 'TOP_QXGL', '权限管理', NULL, 0, 0),
	(101, 'SECOND_YHGL', '用户管理', NULL, 100, 1),
	(102, 'SECOND_JSGL', '角色管理', NULL, 100, 2),
	(103, 'SECOND_AQCL', '安全策略', NULL, 100, 3),
	(110, 'TOP_WLGL', '网络管理', NULL, 0, 0),
	(111, 'SECOND_JKGL', '接口管理', NULL, 110, 1),
	(112, 'SECOND_WLCS', '网络测试', NULL, 110, 2),
	(113, 'SECOND_LYGL', '路由管理', NULL, 110, 4),
	(114, 'SECOND_PZGL', '安全配置', NULL, 110, 5),
	(120, 'TOP_XTGL', '系统管理', NULL, 0, 0),
	(121, 'SECOND_PTSM', '平台说明', NULL, 120, 1),
	(122, 'SECOND_PTGL', '平台管理', NULL, 120, 2),
	(123, 'SECOND_ZSGL', '证书管理', NULL, 120, 3),
	(124, 'SECOND_RZXZ', '日志下载', NULL, 120, 4),
	(125, 'SECOND_BBSJ', '版本升级', NULL, 120, 5),
	(130, 'TOP_SJGL', '审计管理', NULL, 0, 0),
	(131, 'SECOND_GLRZ', '管理日志', NULL, 130, 1),
	(150, 'TOP_XTPZ', '系统配置', NULL, 0, 0),
	(151, 'SECOND_RZZJ', '日志主机', NULL, 150, 1),
	(160, 'TOP_JKGL', '监控管理', NULL, 0, 0),
	(161, 'SECOND_ZJJK', '主机监控', NULL, 160, 1);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;


-- 导出  表 compare.role 结构
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  compare.role 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`id`, `name`, `description`, `createdTime`, `modifiedTime`) VALUES
	(1, '初始化管理员', '初始化管理员', '2010-07-04 15:07:08', '2015-11-16 13:24:10'),
	(2, '授权管理员', '授权管理员', '2012-03-14 12:33:05', '2012-11-10 14:50:04'),
	(3, '审计管理员', '审计管理员', '2012-11-02 22:38:09', '2014-08-26 13:11:12'),
	(4, '配置管理员', '配置管理员', '2012-11-26 15:20:37', '2013-05-07 18:04:15'),
	(5, '网点管理员', '网点管理员', '2016-02-24 16:10:26', '2016-03-16 17:51:11'),
	(6, '测试管理员', '测试管理员', '2016-02-24 17:33:25', '2016-04-05 17:11:13');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- 导出  表 compare.role_permission 结构
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE IF NOT EXISTS `role_permission` (
  `permission_id` bigint(20) NOT NULL DEFAULT '0',
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`permission_id`,`role_id`),
  KEY `FKBD40D53851BABF58` (`role_id`),
  KEY `FKBD40D53852A81638` (`permission_id`),
  KEY `FK9C6EC93851BABF58` (`role_id`),
  KEY `FK9C6EC93852A81638` (`permission_id`),
  KEY `FKBD40D53880878851` (`role_id`),
  KEY `FKBD40D5388AAE8071` (`permission_id`),
  KEY `FKBD40D5381FCE46BD` (`role_id`),
  KEY `FKBD40D5384E8FBDDD` (`permission_id`),
  KEY `FKBD40D5388A556D64` (`role_id`),
  KEY `FKBD40D53826D30B44` (`permission_id`),
  KEY `FKBD40D538D063FAAC` (`role_id`),
  KEY `FKBD40D538D9C4828C` (`permission_id`),
  KEY `FKBD40D538F7EB1F96` (`role_id`),
  KEY `FKBD40D538BAD2CFF6` (`permission_id`),
  KEY `FKBD40D53869DE458B` (`role_id`),
  KEY `FKBD40D538916CEA2B` (`permission_id`),
  CONSTRAINT `FKBD40D538916CEA2B` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FK9C6EC93851BABF58` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK9C6EC93852A81638` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FKBD40D5381FCE46BD` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKBD40D53826D30B44` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FKBD40D5384E8FBDDD` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FKBD40D53851BABF58` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKBD40D53852A81638` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FKBD40D53869DE458B` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKBD40D53880878851` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKBD40D5388A556D64` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKBD40D5388AAE8071` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FKBD40D538BAD2CFF6` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FKBD40D538D063FAAC` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKBD40D538D9C4828C` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`ID`),
  CONSTRAINT `FKBD40D538F7EB1F96` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  compare.role_permission 的数据：~25 rows (大约)
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
REPLACE INTO `role_permission` (`permission_id`, `role_id`) VALUES
	(100, 1),
	(101, 1),
	(102, 1),
	(103, 1),
	(100, 6),
	(101, 6),
	(102, 6),
	(103, 6),
	(110, 6),
	(111, 6),
	(112, 6),
	(113, 6),
	(114, 6),
	(120, 6),
	(121, 6),
	(122, 6),
	(123, 6),
	(124, 6),
	(125, 6),
	(130, 6),
	(131, 6),
	(150, 6),
	(151, 6),
	(160, 6),
	(161, 6);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;


-- 导出  表 compare.safe_policy 结构
DROP TABLE IF EXISTS `safe_policy`;
CREATE TABLE IF NOT EXISTS `safe_policy` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `timeout` int(11) DEFAULT NULL,
  `passwordLength` int(11) DEFAULT NULL,
  `errorLimit` int(11) DEFAULT NULL,
  `remoteDisabled` tinyint(1) DEFAULT NULL,
  `macDisabled` tinyint(1) DEFAULT NULL,
  `passwordRules` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `lockTime` int(10) NOT NULL DEFAULT '24' COMMENT '锁定时间(小时)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='安全策略表';

-- 正在导出表  compare.safe_policy 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `safe_policy` DISABLE KEYS */;
REPLACE INTO `safe_policy` (`id`, `timeout`, `passwordLength`, `errorLimit`, `remoteDisabled`, `macDisabled`, `passwordRules`, `lockTime`) VALUES
	(1, 600, 0, 3, 0, 0, '^[0-9a-zA-Z!$#%@^&amp;amp;amp;amp;amp;amp;amp;*()~_+]{8,20}$', 1);
/*!40000 ALTER TABLE `safe_policy` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
