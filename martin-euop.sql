/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : martin-euop

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-03-08 17:24:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('admin', 'ROLE_USER');
INSERT INTO `authorities` VALUES ('guanxc', 'ROLE_USER');

-- ----------------------------
-- Table structure for clientdetails
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId` varchar(48) NOT NULL,
  `resourceIds` varchar(256) DEFAULT NULL,
  `appSecret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `grantTypes` varchar(256) DEFAULT NULL,
  `redirectUrl` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additionalInformation` varchar(4096) DEFAULT NULL,
  `autoApproveScopes` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientdetails
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('acme', 'oauth2-resource', 'acmesecret', 'app', 'authorization_code', '', null, null, null, null, 'app');
INSERT INTO `oauth_client_details` VALUES ('app', null, 'app', 'app', 'password,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('client', 'oauth2-resource', 'secret', 'app', 'authorization_code', '', null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('my-trusted-client', 'oauth2-resource', null, 'read', 'authorization_code', null, null, null, null, null, '');
INSERT INTO `oauth_client_details` VALUES ('webApp', null, 'webApp', 'app', 'authorization_code,password,refresh_token,client_credentials', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------
INSERT INTO `oauth_refresh_token` VALUES ('b96e057b4e1c4920428e833db48d4c15', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002462303132643438372D613930382D343361662D613865662D3533633533393963386264367372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001613B74C98E78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000009770400000009737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000A524F4C455F61646D696E7371007E000D740006617069646F637371007E000D74000C64617461626173652F6C6F677371007E000D74000673797374656D7371007E000D740008757365722F6164647371007E000D74000B757365722F64656C6574657371007E000D740009757365722F656469747371007E000D740009757365722F766965777371007E000D740008757365724C6973747871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0024787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00224C000573636F706571007E00247870740006776562417070737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00227870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F7479706574000870617373776F7264740008757365726E616D6574000561646D696E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000174000361707078017371007E0033770C000000103F40000000000000787371007E002A3F40000000000000770800000010000000007870707371007E0033770C000000103F40000000000000787371007E0033770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000977040000000971007E000F71007E001171007E001371007E001571007E001771007E001971007E001B71007E001D71007E001F7871007E003D737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E002A3F400000000000067708000000080000000271007E002C71007E002D71007E002E71007E002F780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00244C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0030737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000971007E000F71007E001171007E001371007E001571007E001771007E001971007E001B71007E001D71007E001F787074000561646D696E);

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES ('2', 'wyf', '2018-02-28 15:36:13', null, '2018-02-28 15:36:16', '查看demo', 'query-demo');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('3', 'wyf', '2018-02-28 15:37:05', null, '2018-02-28 15:37:08', '管理员', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('4', 'wyf', '2018-02-28 15:37:33', null, '2018-02-28 15:37:36', '普通用户', 'ROLE_USER');

-- ----------------------------
-- Table structure for sys_role_authorities
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_authorities`;
CREATE TABLE `sys_role_authorities` (
  `sys_role_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sys_role_id`,`authorities_id`),
  KEY `FK9oc88v6ini6fjy2spcb8d63no` (`authorities_id`),
  CONSTRAINT `FK9oc88v6ini6fjy2spcb8d63no` FOREIGN KEY (`authorities_id`) REFERENCES `sys_authority` (`id`),
  CONSTRAINT `FKscivyriuji1w3sgrcpeqo5jdd` FOREIGN KEY (`sys_role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_authorities
-- ----------------------------
INSERT INTO `sys_role_authorities` VALUES ('3', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_51bvuyvihefoh4kp5syh2jpi4` (`username`),
  UNIQUE KEY `UK_ahtq5ew3v0kt1n7hf1sgp7p8l` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('5', 'wyf', '2018-02-28 15:38:26', null, '2018-02-28 15:38:29', null, null, null, null, '$2a$10$XOVs4Z1YtPKqKwQVywG9j.xLAqXYRQLGZMGMrZDNbtl6pUC0Weteq', 'admin');
INSERT INTO `sys_user` VALUES ('6', 'wyf', '2018-02-28 15:39:04', null, '2018-02-28 15:39:06', null, null, null, null, '$2a$10$WjApX3bMw1KfzckGCCOB.eXRNY61ZcwsqpNzc2yiHtjsqnS3LmXAS', 'wyf');

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles` (
  `sys_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sys_user_id`,`roles_id`),
  KEY `FKdpvc6d7xqpqr43dfuk1s27cqh` (`roles_id`),
  CONSTRAINT `FKd0ut7sloes191bygyf7a3pk52` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKdpvc6d7xqpqr43dfuk1s27cqh` FOREIGN KEY (`roles_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES ('5', '3');
INSERT INTO `sys_user_roles` VALUES ('6', '4');

-- ----------------------------
-- Table structure for t_menus
-- ----------------------------
DROP TABLE IF EXISTS `t_menus`;
CREATE TABLE `t_menus` (
  `f_id` varchar(64) NOT NULL,
  `f_code` varchar(255) DEFAULT NULL COMMENT '菜单编码',
  `f_parent_code` varchar(255) DEFAULT NULL COMMENT '菜单父编码',
  `f_parent_id` varchar(255) DEFAULT NULL COMMENT '父菜单ID',
  `f_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `f_url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `f_is_menu` int(11) DEFAULT NULL COMMENT '是否是菜单',
  `f_level` int(11) DEFAULT NULL COMMENT '菜单层级',
  `f_sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `f_status` int(11) DEFAULT NULL,
  `f_icon` varchar(255) DEFAULT NULL,
  `f_create_time` datetime DEFAULT NULL,
  `f_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `FK_CODE` (`f_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menus
-- ----------------------------
INSERT INTO `t_menus` VALUES ('000000000000000000', 'root', '0', '0', '系统根目录', '', '1', '0', '1', '1', null, '2017-08-03 18:31:54', null);
INSERT INTO `t_menus` VALUES ('121323213213213213', '/users', 'userList', '893288715881807872', '获取用户', '/users', '0', '3', '3', '1', null, '2018-02-28 16:55:56', null);
INSERT INTO `t_menus` VALUES ('893287144657780736', 'system', 'root', '000000000000000000', '系统设置', 'system', '1', '1', '10', '1', '', '2017-08-04 09:47:06', null);
INSERT INTO `t_menus` VALUES ('893288715881807872', 'userList', 'system', '893287144657780736', '用户管理', 'user/list', '1', '2', '1', '1', '', '2017-08-04 09:53:21', '2017-08-07 18:18:39');
INSERT INTO `t_menus` VALUES ('893304960282787840', 'user/add', 'userList', '893288715881807872', '用户添加', 'user/add', '0', '3', '1', '1', '', '2017-08-04 10:57:54', '2017-08-08 11:02:55');
INSERT INTO `t_menus` VALUES ('894396523532517376', 'user/edit', 'userList', '893288715881807872', '用户修改', 'user/edit', '0', '3', '1', '1', '', '2017-08-07 11:15:23', '2017-08-07 16:57:52');
INSERT INTO `t_menus` VALUES ('894473486712438784', 'user/view', 'userList', '893288715881807872', '用户查看', 'user/View', '0', '3', '2', '1', '', '2017-08-07 16:21:12', null);
INSERT INTO `t_menus` VALUES ('894473651837992960', 'user/delete', 'userList', '893288715881807872', '用户删除', 'user/delete', '0', '3', '4', '1', '', '2017-08-07 16:21:52', null);
INSERT INTO `t_menus` VALUES ('894475142061621248', 'roleList', 'system', '893287144657780736', '角色管理', 'role/list', '1', '2', '2', '1', '', '2017-08-07 16:27:47', '2017-08-08 10:34:56');
INSERT INTO `t_menus` VALUES ('894475827880656896', 'role/add', 'roleList', '894475142061621248', '角色添加', 'role/add', '0', '3', '1', '1', '', '2017-08-07 16:30:31', null);
INSERT INTO `t_menus` VALUES ('894475985452269568', 'role/edit', 'roleList', '894475142061621248', '角色编辑', 'role/edit', '0', '3', '2', '1', '', '2017-08-07 16:31:08', null);
INSERT INTO `t_menus` VALUES ('894476118730473472', 'role/delete', 'roleList', '894475142061621248', '角色删除', 'role/delete', '0', '3', '2', '1', '', '2017-08-07 16:31:40', '2017-08-07 16:37:24');
INSERT INTO `t_menus` VALUES ('894476276402749440', 'role/permission', 'roleList', '894475142061621248', '角色配权', 'role/permission', '0', '3', '3', '1', '', '2017-08-07 16:32:18', null);
INSERT INTO `t_menus` VALUES ('894476950951690240', 'menu/list', 'system', '893287144657780736', '菜单管理', 'menu/list', '1', '2', '2', '1', '', '2017-08-07 16:34:58', null);
INSERT INTO `t_menus` VALUES ('894477107919323136', 'menu/add', 'menu/list', '894476950951690240', '菜单添加', 'menu/add', '0', '3', '1', '1', '', '2017-08-07 16:35:36', null);
INSERT INTO `t_menus` VALUES ('894477244926263296', 'menu/edit', 'menu/list', '894476950951690240', '菜单编辑', 'menu/edit', '0', '3', '2', '1', '', '2017-08-07 16:36:08', null);
INSERT INTO `t_menus` VALUES ('894477420512411648', 'menu/delete', 'menu/list', '894476950951690240', '菜单删除', 'menu/delete', '0', '3', '2', '1', '', '2017-08-07 16:36:50', null);
INSERT INTO `t_menus` VALUES ('894477851082883072', 'apidoc', 'system', '893287144657780736', 'Api文档', 'swagger-ui.html', '1', '2', '9', '1', '', '2017-08-07 16:38:33', '2017-09-13 11:20:26');
INSERT INTO `t_menus` VALUES ('894477995903811584', 'database/log', 'system', '893287144657780736', '数据库日志', 'druid', '1', '2', '10', '1', '', '2017-08-07 16:39:07', '2017-08-08 09:56:29');
INSERT INTO `t_menus` VALUES ('894752734459199488', 'companyList', 'root', '000000000000000000', '公司管理', '/companyList', '1', '1', '1', '1', '', '2017-08-08 10:50:50', null);
INSERT INTO `t_menus` VALUES ('903459378655395840', '/user/modify', 'userList', '893288715881807872', '密码重置', '/user/modify', '1', '3', '2', '1', '', '2017-09-01 11:27:56', null);

-- ----------------------------
-- Table structure for t_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `f_role_id` int(11) NOT NULL,
  `f_menu_id` varchar(255) NOT NULL,
  `f_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`f_role_id`,`f_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_privilege
-- ----------------------------
INSERT INTO `t_privilege` VALUES ('1', '893287144657780736', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('1', '893288715881807872', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('1', '893304960282787840', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('1', '894396523532517376', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('1', '894473486712438784', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('1', '894473651837992960', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('1', '894477851082883072', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('1', '894477995903811584', '2017-08-08 11:31:39');
INSERT INTO `t_privilege` VALUES ('2', '893287144657780736', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '893288715881807872', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '893304960282787840', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '894396523532517376', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '894473486712438784', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '894473651837992960', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '894475142061621248', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '894475827880656896', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '894475985452269568', '2017-08-08 11:56:44');
INSERT INTO `t_privilege` VALUES ('2', '894476118730473472', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894476276402749440', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894476950951690240', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894477107919323136', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894477244926263296', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894477420512411648', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894477851082883072', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894477995903811584', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894752734459199488', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('2', '894769217763540992', '2017-08-08 11:56:45');
INSERT INTO `t_privilege` VALUES ('3', '121323213213213213', '2018-03-08 16:43:50');
INSERT INTO `t_privilege` VALUES ('3', '893287144657780736', '2017-09-14 18:40:48');
INSERT INTO `t_privilege` VALUES ('3', '894477851082883072', '2017-09-14 18:40:51');
INSERT INTO `t_privilege` VALUES ('3', '894477995903811584', '2017-09-14 18:40:53');
INSERT INTO `t_privilege` VALUES ('3', '894752734459199488', '2017-09-14 18:40:54');

-- ----------------------------
-- Table structure for t_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE `t_roles` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `f_name` varchar(11) NOT NULL COMMENT '角色名',
  `f_description` varchar(11) DEFAULT NULL COMMENT '描述信息',
  `f_status` int(11) NOT NULL COMMENT '主键ID',
  `f_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `f_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`f_id`),
  UNIQUE KEY `index_role_name` (`f_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_roles
-- ----------------------------
INSERT INTO `t_roles` VALUES ('1', 'super', '超级管理员', '1', '2017-06-20 15:08:45', null);
INSERT INTO `t_roles` VALUES ('2', 'admin', '管理员', '1', '2017-06-20 15:07:13', '2017-06-26 12:46:09');
INSERT INTO `t_roles` VALUES ('3', 'user', '用户', '1', '2017-06-28 18:50:39', '2017-07-21 09:41:28');

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `f_user_id` varchar(128) NOT NULL,
  `f_user_name` varchar(128) DEFAULT NULL,
  `f_password` varchar(255) DEFAULT NULL,
  `f_user_type` int(11) DEFAULT NULL,
  `f_description` varchar(255) DEFAULT NULL,
  `f_phone` varchar(64) DEFAULT NULL,
  `f_address` varchar(255) DEFAULT NULL,
  `f_age` int(11) DEFAULT NULL,
  `f_create_time` datetime DEFAULT NULL,
  `f_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`f_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('a5e16bba-fcf1-11e7-a783-dc4a3e46fef3', 'super', '*2F491374500E3D85FB71B1E29D4A327C31E3C24A', '1', '超级管理员', null, null, '26', '2017-06-20 15:12:16', '2017-09-12 14:39:48');
INSERT INTO `t_users` VALUES ('a5f289a7-fcf1-11e7-a783-dc4a3e46fef3', 'admin', '*2F491374500E3D85FB71B1E29D4A327C31E3C24A', '2', '管理员', null, null, '35', '2017-06-26 17:31:41', null);
INSERT INTO `t_users` VALUES ('a5ff210e-fcf1-11e7-a783-dc4a3e46fef3', 'guanxianchun', '$2a$10$g/5Ha2sbplYrzyPFp8U5A.EmaWCfo2menysGzqQP5zGLKId3vu3uK', '3', '管贤春', '', '湖南长沙', '35', '2017-08-30 10:34:59', '2017-09-18 16:10:22');
INSERT INTO `t_users` VALUES ('a616ed3d-fcf1-11e7-a783-dc4a3e46fef3', 'test1', '*2F491374500E3D85FB71B1E29D4A327C31E3C24A', '3', 'test1', null, null, '35', '2017-09-18 16:11:15', null);
INSERT INTO `t_users` VALUES ('a628932a-fcf1-11e7-a783-dc4a3e46fef3', 'test2', '*2F491374500E3D85FB71B1E29D4A327C31E3C24A', '3', 'test2', null, null, '35', '2017-09-21 17:09:51', null);

-- ----------------------------
-- Table structure for t_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_user_roles`;
CREATE TABLE `t_user_roles` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `f_user_id` varchar(128) NOT NULL COMMENT '用户ID',
  `f_role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `f_creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_roles
-- ----------------------------
INSERT INTO `t_user_roles` VALUES ('1', 'a5e16bba-fcf1-11e7-a783-dc4a3e46fef3', '1', '2018-01-19 16:25:54');
INSERT INTO `t_user_roles` VALUES ('19', 'a5f289a7-fcf1-11e7-a783-dc4a3e46fef3', '2', '2018-01-19 16:26:21');
INSERT INTO `t_user_roles` VALUES ('20', 'a5ff210e-fcf1-11e7-a783-dc4a3e46fef3', '3', '2018-01-19 16:26:35');
INSERT INTO `t_user_roles` VALUES ('21', 'a616ed3d-fcf1-11e7-a783-dc4a3e46fef3', '3', '2018-01-19 16:26:50');
INSERT INTO `t_user_roles` VALUES ('22', 'a628932a-fcf1-11e7-a783-dc4a3e46fef3', '3', '2018-01-19 16:27:08');

-- ----------------------------
-- View structure for users
-- ----------------------------
DROP VIEW IF EXISTS `users`;
CREATE ALGORITHM=UNDEFINED DEFINER=`martin-euop`@`%` SQL SECURITY DEFINER VIEW `users` AS select `t_users`.`f_user_name` AS `username`,`t_users`.`f_password` AS `password`,1 AS `enabled` from `t_users` ;
