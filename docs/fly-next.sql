/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 127.0.0.1:3306
 Source Schema         : fly-next

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 01/07/2023 15:11:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_api_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_api_log`;
CREATE TABLE `sys_api_log`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户id',
  `service_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务ID',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端id: PC端, 微程序, APP等 ',
  `request_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'http 请求id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志标题: 用户管理, 菜单管理等',
  `type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志类型: button, uri',
  `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志类型: 按钮, 链接',
  `remote_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作类型: SAVE,UPDATE,JUMP,REMOVE',
  `remote_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作类型: 新增, 修改, 删除, 查看',
  `remote_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作IP地址',
  `remote_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作地址',
  `remote_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作状态: 成功, 失败, 异常',
  `user_agent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URI',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作方式',
  `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '操作提交的数据',
  `json_result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '返回数据',
  `del_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标记',
  `ex_info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '异常信息',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `execute_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务端处理耗时',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回消息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_api_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_app_client
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_client`;
CREATE TABLE `sys_app_client`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `app_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '应用标识码',
  `app_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '应用类型',
  `app_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '应用名称',
  `ask_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '互联网访问地址',
  `lan_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内网访问地址',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否启用1-是;0-否',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `can_del` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否可删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '应用管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_app_client
-- ----------------------------
INSERT INTO `sys_app_client` VALUES ('1562101700737765376', 'web_app', 'vocational_work', 'Fly Next', '1', '1', 'http://127.0.0.1:8080/upload/2023/4/2146ffef796342b5b04ce91d322ae54f.jpg', '1', '', '0', '2022-08-23 23:37:23', NULL, NULL, '2023-04-28 15:07:56', '王大宸', '1541230113952239617');
INSERT INTO `sys_app_client` VALUES ('1674450910060875776', 'NEXT_APP', 'vocational_work', 'VUE 项目', '11', NULL, 'http://127.0.0.1:8080/upload/2023/06/30/ab52f44ac6534b8a88d19e9982f16e1a.jpg', '1', '', '1', '2023-06-30 00:13:01', '王大宸', '1541230113952239617', '2023-06-30 00:13:01', '王大宸', '1541230113952239617');

-- ----------------------------
-- Table structure for sys_authorized_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_authorized_refresh_token`;
CREATE TABLE `sys_authorized_refresh_token`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `app_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第三方平台id(服务提供商)',
  `authorizer_appid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权方appid(userId, openId)',
  `authorizer_access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权方令牌',
  `expires_in` int NULL DEFAULT NULL COMMENT '有效期，单位：秒',
  `expire_time` datetime NULL DEFAULT NULL COMMENT 'token过期时间',
  `authorizer_refresh_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权方的刷新令牌',
  `secret_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '秘钥',
  `func_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限集(希望重新建一张表存储)',
  `is_cancel` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否停止授权 1是 0否',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '授权方的刷新令牌' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_authorized_refresh_token
-- ----------------------------
INSERT INTO `sys_authorized_refresh_token` VALUES ('wx1aa3965a223a1632', 'wxd749fa1109b97118', 'wx1aa3965a223a1632', '67_wIECyHw6H3Z4KG9almq_89kl3eVFqxyK99dVRGPMTvf76JLc4y1UKCZkhbRQCCEWLTFmmpG9KoGF7qfyWcAfgHM1Bwed2nhtqfgLj0PovE82h0CNSuBQUEiPFb-QunqZH3ApVoBZNGJeXY9TTISaAMDZOY', 7200, '2023-03-25 15:56:56', 'refreshtoken@@@bv4a6JJKpjM7iepLaCcu2GyO6ri8ToldDjCbXQi0NQA', NULL, NULL, '0', '2023-02-04 18:25:04', '2023-03-25 14:01:56');
INSERT INTO `sys_authorized_refresh_token` VALUES ('wx8b88f9d0c3ea5b23', 'wxd749fa1109b97118', 'wx8b88f9d0c3ea5b23', '65_y7ps3rS4GN7YkHUKVOFLRCER4_nH0ETshnpbxPHB37B2uPgeh5GeDWrZcq5SBLhpsuXQo6FQ1don1pc8Pz4rZUkQaCoE9UCbne_9UbsNpP1fh6WtFR3caTdQBDj6-ia8R5gtuwtkx7PEirzXUTBdAFDCBJ', NULL, NULL, 'refreshtoken@@@IWGvXU7_ndv9qDho-H9Uiod7aWEtGKfQ04lcCsjXA3Q', NULL, NULL, '1', '2023-02-04 15:43:40', '2023-02-04 18:23:54');
INSERT INTO `sys_authorized_refresh_token` VALUES ('wxc62aff128a4f968b', 'wxd749fa1109b97118', 'wxc62aff128a4f968b', '67_nVJi_YT1dbjxjVG1VViSw6P0AMXsbMRHofQkZ6yMwVqUfg0F8yEqDiiaBR3hqQ9-ZDimfnGjj2rR9kJ2f5x8I0OcaGmyVDPs5uYnPU4EtQDBlvLLoMJGeypp-pnuCrhqqfbDrzlhUMaLd_ZhJSLeAIDCLE', 7200, '2023-03-25 15:57:08', 'refreshtoken@@@ogbVZ5dQb_P9S7pm3I-INfllmTz2vlZ1jkpB5pB24uI', NULL, NULL, '0', '2023-02-02 23:06:47', '2023-03-25 14:02:08');

-- ----------------------------
-- Table structure for sys_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_info`;
CREATE TABLE `sys_dept_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户标识',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上级id',
  `dept_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门类型',
  `dept_level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门级次',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_can_del` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否可删除: 1-可删除;0-不可删',
  `person_charge` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dept_info
-- ----------------------------
INSERT INTO `sys_dept_info` VALUES ('1563188903018631168', NULL, '人事一部', '693505675909021696', NULL, NULL, '人事一部', '1', NULL, '2022-08-26 23:37:32', NULL, NULL, '2023-05-07 13:39:49', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('1643284935135596544', NULL, '231', '693505675909021696', NULL, NULL, '3123123', NULL, NULL, '2023-04-05 00:10:34', '1541230113952239617', '王大宸', '2023-04-05 00:10:34', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('1655084597760888832', NULL, '12312', '693505675909021696', NULL, NULL, '12312', '1', NULL, '2023-05-07 13:38:13', '1541230113952239617', '王大宸', '2023-05-07 13:38:13', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('1657764763582730240', NULL, '1111112222', '693505675909021696', '', NULL, '111111111111111', '1', '', '2023-05-14 23:08:14', '1541230113952239617', '王大宸', '2023-05-14 23:42:54', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('1657765569010733056', NULL, '2222222', '1657764763582730240', '', NULL, '22222222222222', '1', '', '2023-05-14 23:11:26', '1541230113952239617', '王大宸', '2023-05-14 23:42:46', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('693505675909021696', NULL, '人事部', 'root', NULL, NULL, '', '1', NULL, '2022-02-22 14:25:03', '636009158973734912', '王大宸', '2023-05-07 13:39:55', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('693511254211706880', NULL, '研发部', 'root', 'YF_DEPT', NULL, '12012', '1', NULL, '2022-02-22 14:47:13', '636009158973734912', '王大宸', '2023-05-07 13:46:22', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('693511335077888000', NULL, '研发一部', '693511254211706880', NULL, NULL, NULL, '1', NULL, '2022-02-22 14:47:33', '636009158973734912', '王大宸', '2022-02-22 14:47:33', '636009158973734912', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('693511454263230464', NULL, '研发二部', '693511254211706880', NULL, NULL, '000', '1', NULL, '2022-02-22 14:48:01', '636009158973734912', '王大宸', '2023-05-14 23:01:41', '1541230113952239617', '王大宸');
INSERT INTO `sys_dept_info` VALUES ('root', NULL, '总平台', '0', NULL, NULL, '', '0', NULL, '2022-02-22 11:29:02', '636009158973734912', '王大宸', '2023-05-07 13:40:13', '1541230113952239617', '王大宸');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典id',
  `dict_sort` int NULL DEFAULT NULL COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典标签',
  `dict_value` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否默认（Y是 N否）',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态,数据字典:dict_data_status',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dict_type`(`dict_type` ASC) USING BTREE COMMENT '数据字典类型'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1562089659041976320', 1, '是', '1', 'yes_or_no', NULL, NULL, '1', '1', '', '', NULL, '2022-08-23 22:49:32', '', '2022-08-23 22:52:19', NULL);
INSERT INTO `sys_dict_data` VALUES ('1562089715228872704', 2, '否', '0', 'yes_or_no', NULL, NULL, '0', '1', '', '', NULL, '2022-08-23 22:49:45', '', '2022-08-23 22:52:14', NULL);
INSERT INTO `sys_dict_data` VALUES ('1562435975647465472', 1, '按钮', 'button', 'element_type', NULL, NULL, '1', '1', '', '', NULL, '2022-08-24 21:45:40', '', '2022-08-24 21:45:40', NULL);
INSERT INTO `sys_dict_data` VALUES ('1562436050264133632', 2, '链接', 'uri', 'element_type', NULL, NULL, '0', '1', '', '', NULL, '2022-08-24 21:45:58', '', '2022-08-24 21:45:58', NULL);
INSERT INTO `sys_dict_data` VALUES ('1643270191876018176', 1, '是', '1', 'is_default', NULL, NULL, '0', '1', '', '王大宸', '1541230113952239617', '2023-04-04 23:11:59', '王大宸', '2023-04-04 23:13:12', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1643270269801992192', 2, '否', '0', 'is_default', NULL, NULL, '1', '1', '', '王大宸', '1541230113952239617', '2023-04-04 23:12:17', '王大宸', '2023-04-04 23:13:17', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1643522458105548800', 1, 'iframe(内嵌)', 'iframe', 'menu_iframe', NULL, NULL, '1', '1', '', '王大宸', '1541230113952239617', '2023-04-05 15:54:24', '王大宸', '2023-04-14 22:44:49', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1643522494356918272', 2, '_parent(父窗口打开)', '_parent', 'menu_iframe', NULL, NULL, '0', '1', '', '王大宸', '1541230113952239617', '2023-04-05 15:54:32', '王大宸', '2023-04-14 22:44:40', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1643522533724655616', 3, '_blank(新窗口打开)', '_blank', 'menu_iframe', NULL, NULL, '0', '1', '', '王大宸', '1541230113952239617', '2023-04-05 15:54:42', '王大宸', '2023-04-27 21:37:49', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1653798862797803520', 1, '人事部', 'RS_DEPT', 'dept_type', NULL, NULL, '1', '1', '', '王大宸', '1541230113952239617', '2023-05-04 00:29:10', '王大宸', '2023-05-04 00:29:10', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1653798954380431360', 4, '研发部', 'YF_DEPT', 'dept_type', NULL, NULL, '0', '1', '', '王大宸', '1541230113952239617', '2023-05-04 00:29:31', '王大宸', '2023-05-07 13:20:32', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1653799043282898944', 3, '销售部', 'XS_DEPT', 'dept_type', NULL, NULL, '0', '1', '', '王大宸', '1541230113952239617', '2023-05-04 00:29:53', '王大宸', '2023-05-04 00:29:53', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('1655080082437443584', 2, '分公司', 'OFFICE', 'dept_type', NULL, NULL, '0', '1', 'office', '王大宸', '1541230113952239617', '2023-05-07 13:20:16', '王大宸', '2023-05-07 13:20:16', '1541230113952239617');
INSERT INTO `sys_dict_data` VALUES ('424949604766072832', 99, '其他操作', '99', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:39:07', '王大宸', '2022-02-16 16:54:52', '476373339368472576');
INSERT INTO `sys_dict_data` VALUES ('424949710579974144', 2, '新增', '1', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:39:32', '王大宸', '2020-02-12 12:39:32', NULL);
INSERT INTO `sys_dict_data` VALUES ('424949780440301568', 3, '更新', '2', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:39:48', '王大宸', '2020-02-12 12:39:48', NULL);
INSERT INTO `sys_dict_data` VALUES ('424949852204843008', 4, '删除', '3', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:40:06', '王大宸', '2020-02-12 12:40:06', NULL);
INSERT INTO `sys_dict_data` VALUES ('424949922224553984', 5, '查询', '4', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:40:22', '王大宸', '2020-03-15 23:39:58', NULL);
INSERT INTO `sys_dict_data` VALUES ('424949996648284160', 6, '页面跳转', '5', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:40:40', '王大宸', '2020-02-12 12:40:40', NULL);
INSERT INTO `sys_dict_data` VALUES ('424950982943064064', 1, '操作成功', '1', 'operation_status', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:44:35', '王大宸', '2020-02-12 12:44:35', NULL);
INSERT INTO `sys_dict_data` VALUES ('424951054778908672', 2, '操作失败', '0', 'operation_status', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-12 12:44:52', '王大宸', '2020-02-23 18:37:40', NULL);
INSERT INTO `sys_dict_data` VALUES ('429026229052915711', 3, '操作异常', '2', 'operation_status', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-23 18:38:10', '王大宸', '2020-02-23 18:38:10', NULL);
INSERT INTO `sys_dict_data` VALUES ('429026283541118976', 4, '其他异常', '3', 'operation_status', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-23 18:38:23', '王大宸', '2020-02-23 18:38:23', NULL);
INSERT INTO `sys_dict_data` VALUES ('429026324150370304', 5, '分页异常', '4', 'operation_status', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-02-23 18:38:32', '王大宸', '2020-02-23 18:38:32', NULL);
INSERT INTO `sys_dict_data` VALUES ('433066218715758592', 7, '授权', '6', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-03-05 22:11:38', '王大宸', '2020-03-05 22:11:38', NULL);
INSERT INTO `sys_dict_data` VALUES ('433066294997565440', 8, '导入', '7', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-03-05 22:11:56', '王大宸', '2020-03-05 22:11:56', NULL);
INSERT INTO `sys_dict_data` VALUES ('433066357941485568', 12, '导出', '11', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-03-05 22:12:11', '王大宸', '2020-03-15 23:40:39', NULL);
INSERT INTO `sys_dict_data` VALUES ('433066430540693504', 9, '强退', '8', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-03-05 22:12:29', '王大宸', '2020-03-15 23:41:09', NULL);
INSERT INTO `sys_dict_data` VALUES ('433066494768070656', 10, '生成代码', '9', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-03-05 22:12:44', '王大宸', '2020-03-15 23:41:22', NULL);
INSERT INTO `sys_dict_data` VALUES ('433066571364450304', 11, '清空', '10', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', NULL, '2020-03-05 22:13:02', '王大宸', '2020-03-15 23:41:39', NULL);
INSERT INTO `sys_dict_data` VALUES ('659839750957842432', 1, '可用', '1', 'dict_data_status', NULL, NULL, '1', '1', '1111', '', NULL, '2021-11-21 16:48:41', '', '2021-11-21 16:51:19', NULL);
INSERT INTO `sys_dict_data` VALUES ('659839821900300288', 2, '不可用', '0', 'dict_data_status', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-21 16:48:58', '', '2021-11-21 17:06:00', NULL);
INSERT INTO `sys_dict_data` VALUES ('659857431975051264', 1, '可用', '1', 'can_usable', NULL, NULL, '1', '1', '', '', NULL, '2021-11-21 17:58:57', '', '2021-11-21 18:25:03', NULL);
INSERT INTO `sys_dict_data` VALUES ('659857484584206336', 2, '不可用', '0', 'can_usable', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-21 17:59:10', '', '2021-11-21 17:59:10', NULL);
INSERT INTO `sys_dict_data` VALUES ('659928602120699904', 1, '男', '1', 'sys_sex', NULL, NULL, '1', '1', '', '', NULL, '2021-11-21 22:41:45', '', '2022-08-25 22:46:14', NULL);
INSERT INTO `sys_dict_data` VALUES ('659928646408355840', 2, '女', '2', 'sys_sex', NULL, NULL, '0', '1', '', '', NULL, '2021-11-21 22:41:56', '', '2021-11-21 22:41:56', NULL);
INSERT INTO `sys_dict_data` VALUES ('659928691765559296', 3, '未知', '3', 'sys_sex', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-21 22:42:07', '', '2021-11-21 22:42:07', NULL);
INSERT INTO `sys_dict_data` VALUES ('659933025542750208', 1, '正常', '1', 'user_status', NULL, NULL, '1', '1', '', '', NULL, '2021-11-21 22:59:20', '', '2022-08-25 22:46:02', NULL);
INSERT INTO `sys_dict_data` VALUES ('659933078219014144', 2, '冻结', '0', 'user_status', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-21 22:59:32', '', '2021-11-21 22:59:32', NULL);
INSERT INTO `sys_dict_data` VALUES ('660301699646636032', 1, '显示', '1', 'menu_visible', NULL, NULL, '1', '1', '', '', NULL, '2021-11-22 23:24:19', '', '2021-11-22 23:24:19', NULL);
INSERT INTO `sys_dict_data` VALUES ('660301762745745408', 2, '不显示', '0', 'menu_visible', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-22 23:24:34', '', '2021-11-22 23:24:34', NULL);
INSERT INTO `sys_dict_data` VALUES ('660302105705594880', 1, '目录', 'dirt', 'menu_type', NULL, NULL, '1', '1', '', '', NULL, '2021-11-22 23:25:55', '', '2022-08-24 22:10:08', NULL);
INSERT INTO `sys_dict_data` VALUES ('660302147581526016', 2, '菜单', 'menu', 'menu_type', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-22 23:26:05', '', '2021-11-26 20:58:08', NULL);
INSERT INTO `sys_dict_data` VALUES ('660302147581526017', 3, '链接', 'uri', 'menu_type', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-22 23:26:05', '', '2021-11-26 20:58:08', NULL);
INSERT INTO `sys_dict_data` VALUES ('660647833028149248', 1, 'GET', 'GET', 'http_method', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-23 22:19:43', '', '2021-11-23 22:19:43', NULL);
INSERT INTO `sys_dict_data` VALUES ('660647902016061440', 2, 'POST', 'POST', 'http_method', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-23 22:20:00', '', '2021-11-23 22:20:00', NULL);
INSERT INTO `sys_dict_data` VALUES ('660647971972857856', 3, 'PUT', 'PUT', 'http_method', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-23 22:20:16', '', '2021-11-23 22:20:16', NULL);
INSERT INTO `sys_dict_data` VALUES ('660648014524071936', 4, 'DELETE', 'DELETE', 'http_method', NULL, NULL, NULL, '1', '', '', NULL, '2021-11-23 22:20:27', '', '2021-11-23 22:20:27', NULL);
INSERT INTO `sys_dict_data` VALUES ('662795133489922048', 1, '统一登录', 'sign_on', 'system_type', NULL, NULL, NULL, '1', '', '王大宸', '636009158973734912', '2021-11-29 20:32:20', '王大宸', '2021-11-29 20:32:20', '636009158973734912');
INSERT INTO `sys_dict_data` VALUES ('662795297155858432', 2, '业务系统', 'vocational_work', 'system_type', NULL, NULL, '1', '1', '', '王大宸', '636009158973734912', '2021-11-29 20:32:59', '王大宸', '2021-11-29 20:32:59', '636009158973734912');
INSERT INTO `sys_dict_data` VALUES ('662795626794598400', 3, '小程序', 'app_applet', 'system_type', NULL, NULL, NULL, '1', '', '王大宸', '636009158973734912', '2021-11-29 20:34:17', '王大宸', '2021-11-29 20:34:17', '636009158973734912');
INSERT INTO `sys_dict_data` VALUES ('662795706100498432', 4, '文件上传', 'app_oss', 'system_type', NULL, NULL, NULL, '1', '', '王大宸', '636009158973734912', '2021-11-29 20:34:36', '王大宸', '2021-11-29 20:34:36', '636009158973734912');
INSERT INTO `sys_dict_data` VALUES ('662795951043657728', 5, '大屏展示', 'large_screen_display', 'system_type', NULL, NULL, NULL, '1', '', '王大宸', '636009158973734912', '2021-11-29 20:35:35', '王大宸', '2021-11-29 20:35:35', '636009158973734912');
INSERT INTO `sys_dict_data` VALUES ('691369184210599936', 13, '重置密码', '13', 'log_business_type', NULL, NULL, NULL, '1', '', '王大宸', '476373339368472576', '2022-02-16 16:55:24', '王大宸', '2022-02-16 16:58:27', '476373339368472576');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态,数据字典: dict_data_status',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1324949371625684992', '操作类型', 'log_business_type', '1', '', '王大宸', '476373339368472576', '2020-03-07 23:06:50', '王大宸', '2020-03-07 23:06:50', '476373339368472576');
INSERT INTO `sys_dict_type` VALUES ('134950903045767168', '操作状态', 'operation_status', '1', '', '王大宸', '476373339368472576', '2020-03-07 23:06:50', '王大宸', '2020-03-07 23:06:50', '476373339368472576');
INSERT INTO `sys_dict_type` VALUES ('1359835017048244224', '数据字典状态(是否可用)', 'dict_data_status', '1', '仅针对数据字典使用: 1-可用;0-不可用', '', NULL, '2021-11-21 16:29:53', '', '2021-11-21 17:54:19', NULL);
INSERT INTO `sys_dict_type` VALUES ('1359856189370548224', '是否可用', 'can_usable', '1', '1-可用;0-不可用', '', NULL, '2021-11-21 17:54:01', '', '2021-11-21 22:40:45', NULL);
INSERT INTO `sys_dict_type` VALUES ('1359928329750986752', '性别', 'sys_sex', '1', '男,女,未知', '', NULL, '2021-11-21 22:40:40', '', '2021-11-21 22:40:59', NULL);
INSERT INTO `sys_dict_type` VALUES ('1359932975852830720', '用户状态', 'user_status', '1', '冻结,正常', '', NULL, '2021-11-21 22:59:08', '', '2021-11-21 22:59:08', NULL);
INSERT INTO `sys_dict_type` VALUES ('1360301654943744000', '菜单状态(是否显示)', 'menu_visible', '1', '1-显示;0-不显示', '', NULL, '2021-11-22 23:24:08', '', '2021-11-22 23:24:08', NULL);
INSERT INTO `sys_dict_type` VALUES ('1360302055545913344', '菜单类型', 'menu_type', '1', '1-目录;2-菜单;3-按钮', '', NULL, '2021-11-22 23:25:43', '', '2021-11-22 23:55:56', NULL);
INSERT INTO `sys_dict_type` VALUES ('1360647725486194688', '请求类型', 'http_method', '1', 'GET,POST,PUT,DELETE', '', NULL, '2021-11-23 22:19:18', '王大宸', '2022-09-25 17:06:19', '1541230113952239617');
INSERT INTO `sys_dict_type` VALUES ('1362794717003923456', '系统类型', 'system_type', '1', '统一登录,基础系统,业务系统', '王大宸', '636009158973734912', '2021-11-29 20:30:40', '王大宸', '2023-04-16 22:49:47', '1541230113952239617');
INSERT INTO `sys_dict_type` VALUES ('1562089580075814912', '是与否', 'yes_or_no', '1', '1-是;0-否', '', NULL, '2022-08-23 22:49:13', '王大宸', '2023-04-14 21:42:47', '1541230113952239617');
INSERT INTO `sys_dict_type` VALUES ('1562435897033625600', '按钮资源类型', 'element_type', '1', '按钮类型', '', NULL, '2022-08-24 21:45:21', '王大宸', '2022-09-25 17:06:24', '1541230113952239617');
INSERT INTO `sys_dict_type` VALUES ('1643269515825516544', '是否默认', 'is_default', '1', '认为二位', '王大宸', '1541230113952239617', '2023-04-04 23:09:18', '王大宸', '2023-04-05 21:40:23', '1541230113952239617');
INSERT INTO `sys_dict_type` VALUES ('1643522359333883904', '菜单打开形式', 'menu_iframe', '1', '_blank;_parent;iframe', '王大宸', '1541230113952239617', '2023-04-05 15:54:00', '王大宸', '2023-05-04 00:30:48', '1541230113952239617');
INSERT INTO `sys_dict_type` VALUES ('1653798441328971776', '部门类型', 'dept_type', '1', '人事部,研发部,销售部等', '王大宸', '1541230113952239617', '2023-05-04 00:27:29', '王大宸', '2023-05-04 00:30:51', '1541230113952239617');

-- ----------------------------
-- Table structure for sys_element_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_element_info`;
CREATE TABLE `sys_element_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  `menu_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源关联菜单',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名称: 新增,编辑,删除 ... 等',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源编码: 权限编码',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源类型: button,uri',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源路径, 路径动态参数使用{*}: /admin/user/{*}',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视图路径, 路径动态参数使用{*}: /admin/user/{*}',
  `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源请求类型:GET,POST,PUT,DELETE',
  `order_num` int NULL DEFAULT NULL COMMENT '排序',
  `visible` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态:1-可用,0-禁用',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '按钮资源' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_element_info
-- ----------------------------
INSERT INTO `sys_element_info` VALUES ('1563491791578206208', NULL, '1556461808062173184', '按钮资源查询', 'admin:element:info:query', 'button', '/admin/element/page', '/', 'GET', 7, '1', '', '2022-08-27 19:41:06', '王大宸', '1541230113952239617', '2022-08-27 19:51:47', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563491976005947392', NULL, '1556461808062173184', '菜单查询', 'admin:menu:info:query', 'button', '/admin/menu/page', '/', 'GET', 1, '1', '', '2022-08-27 19:41:50', '王大宸', '1541230113952239617', '2022-08-27 19:41:50', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563492307016224768', NULL, '1556461808062173184', '新增菜单', 'admin:menu:info:save', 'button', '/admin/menu', '/admin/menu/{*}/add', 'POST', 2, '1', '', '2022-08-27 19:43:09', '王大宸', '1541230113952239617', '2022-08-27 19:43:09', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563492549476356096', NULL, '1556461808062173184', '编辑菜单', 'admin:menu:info:update', 'button', '/admin/menu/{*}', '/admin/menu/edit/{*}', 'PUT', 4, '1', '', '2022-08-27 19:44:07', '王大宸', '1541230113952239617', '2022-08-27 19:44:07', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563492724638879744', NULL, '1556461808062173184', '删除菜单', 'admin:menu:info:delete', 'button', '/admin/menu/{*}', '/', 'DELETE', 5, '1', '', '2022-08-27 19:44:49', '王大宸', '1541230113952239617', '2022-08-27 19:44:49', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563492994114523136', NULL, '1556461808062173184', '查看菜单', 'admin:menu:info:view', 'button', '/admin/menu/{*}', '/admin/menu/view/{*}', 'GET', 6, '1', '', '2022-08-27 19:45:53', '王大宸', '1541230113952239617', '2022-08-27 19:45:53', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563493310667034624', NULL, '1556461808062173184', '新增按钮', 'admin:element:info:save', 'button', '/admin/element', '/admin/element/{*}/add', 'POST', 8, '1', '', '2022-08-27 19:47:08', '王大宸', '1541230113952239617', '2022-08-27 19:47:08', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563493532361166848', NULL, '1556461808062173184', '编辑按钮', 'admin:element:info:update', 'button', '/admin/element/{*}', '/admin/element/edit/{*}', 'PUT', 9, '1', '', '2022-08-27 19:48:01', '王大宸', '1541230113952239617', '2022-08-27 19:48:01', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563493702217895936', NULL, '1556461808062173184', '删除按钮', 'admin:element:info:delete', 'button', '/admin/element/{*}', '/', 'DELETE', 10, '1', '', '2022-08-27 19:48:42', '王大宸', '1541230113952239617', '2022-08-27 19:48:42', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563494130162733056', NULL, '1556461808062173184', '查询按钮', 'admin:element:info:view', 'button', '/admin/element/{*}', '/admin/element/view/{*}', 'GET', 11, '1', '', '2022-08-27 19:50:24', '王大宸', '1541230113952239617', '2022-08-27 19:52:07', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563495341288984576', NULL, '1539506450076930048', '导入', 'tools:table:info:import', 'button', '/tools/table/info/import/db', '/tools/table/info/import/index', 'POST', 1, '1', '', '2022-08-27 19:55:12', '王大宸', '1541230113952239617', '2022-08-27 19:55:12', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563495702405976064', NULL, '1539506450076930048', '生成代码', 'tools:table:info:download', 'button', '/tools/table/info/code', '/', 'PUT', 2, '1', '', '2022-08-27 19:56:38', '王大宸', '1541230113952239617', '2022-08-27 19:56:38', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563496093470298112', NULL, '1539506450076930048', '预览', 'tools:table:info:preview', 'button', '/tools/table/info/preview/{*}', '/tools/table/info/view/{*}', 'GET', 3, '1', '', '2022-08-27 19:58:12', '王大宸', '1541230113952239617', '2022-08-27 19:58:12', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563496409666293760', NULL, '1539506450076930048', '编辑', 'tools:table:info:update', 'button', '/tools/table/info/{*}', '/tools/table/info/edit/{*}', 'PUT', 4, '1', '', '2022-08-27 19:59:27', '王大宸', '1541230113952239617', '2022-08-27 19:59:27', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563496638331359232', NULL, '1539506450076930048', '删除', 'tools:table:info:delete', 'button', '/tools/table/info/{*}', '/', 'DELETE', 5, '1', '', '2022-08-27 20:00:22', '王大宸', '1541230113952239617', '2022-08-27 20:00:22', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563497996870619137', NULL, '1563139490028064768', '查询', 'admin:dept:query', 'uri', '/admin/dept/page', '/', 'GET', 1, '1', '查询部门管理', '2022-08-27 20:05:45', '王大宸', NULL, '2023-04-05 22:40:37', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563498751786618882', NULL, '1563139490028064768', '新增', 'admin:dept:save', 'button', '/admin/dept', '/admin/dept/add', 'POST', 2, '1', '新增部门管理', '2022-08-27 20:08:45', '王大宸', NULL, '2022-08-27 20:08:45', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563498751786618883', NULL, '1563139490028064768', '修改', 'admin:dept:update', 'button', '/admin/dept/{*}', '/admin/dept/edit/{*}', 'PUT', 3, '1', '修改部门管理', '2022-08-27 20:08:45', '王大宸', NULL, '2022-08-27 20:08:45', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563498751786618884', NULL, '1563139490028064768', '查看', 'admin:dept:view', 'button', '/admin/dept/{*}', '/admin/dept/view/{*}', 'GET', 4, '1', '查看部门管理', '2022-08-27 20:08:45', '王大宸', NULL, '2022-08-27 20:08:45', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563498751786618885', NULL, '1563139490028064768', '删除', 'admin:dept:delete', 'button', '/admin/dept/{*}', '/', 'DELETE', 5, '1', '删除部门管理', '2022-08-27 20:08:45', '王大宸', NULL, '2022-08-27 20:08:45', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563499282768728065', NULL, '1556461808573878272', '查询', 'admin:app:client:query', 'button', '/admin/app/client/page', '/', 'GET', 1, '1', '查询应用管理', '2022-08-27 20:10:52', '王大宸', NULL, '2022-08-27 20:10:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563499282768728066', NULL, '1556461808573878272', '新增', 'admin:app:client:save', 'button', '/admin/app/client', '/admin/app/client/add', 'POST', 2, '1', '新增应用管理', '2022-08-27 20:10:52', '王大宸', NULL, '2022-08-27 20:10:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563499282768728067', NULL, '1556461808573878272', '修改', 'admin:app:client:update', 'button', '/admin/app/client/{*}', '/admin/app/client/edit/{*}', 'PUT', 3, '1', '修改应用管理', '2022-08-27 20:10:52', '王大宸', NULL, '2022-08-27 20:10:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563499282768728068', NULL, '1556461808573878272', '查看', 'admin:app:client:view', 'button', '/admin/app/client/{*}', '/admin/app/client/view/{*}', 'GET', 4, '1', '查看应用管理', '2022-08-27 20:10:52', '王大宸', NULL, '2022-08-27 20:10:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563499282768728069', NULL, '1556461808573878272', '删除', 'admin:app:client:delete', 'button', '/admin/app/client/{*}', '/', 'DELETE', 5, '1', '删除应用管理', '2022-08-27 20:10:52', '王大宸', NULL, '2022-08-27 20:10:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563500219818184705', NULL, '1563500219818184704', '查询', 'admin:role:query', 'button', '/admin/role/page', '/', 'GET', 1, '1', '查询角色', '2022-08-27 20:14:35', '王大宸', NULL, '2022-08-27 20:14:35', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563500219818184706', NULL, '1563500219818184704', '新增', 'admin:role:save', 'button', '/admin/role', '/admin/role/add', 'POST', 2, '1', '新增角色', '2022-08-27 20:14:35', '王大宸', NULL, '2022-08-27 20:14:35', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563500219818184707', NULL, '1563500219818184704', '修改', 'admin:role:update', 'button', '/admin/role/{*}', '/admin/role/edit/{*}', 'PUT', 3, '1', '修改角色', '2022-08-27 20:14:35', '王大宸', NULL, '2022-08-27 20:14:35', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563500219818184708', NULL, '1563500219818184704', '查看', 'admin:role:view', 'button', '/admin/role/{*}', '/admin/role/view/{*}', 'GET', 4, '1', '查看角色', '2022-08-27 20:14:35', '王大宸', NULL, '2022-08-27 20:14:35', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563500219818184709', NULL, '1563500219818184704', '删除', 'admin:role:delete', 'button', '/admin/role/{*}', '/', 'DELETE', 5, '1', '删除角色', '2022-08-27 20:14:35', '王大宸', NULL, '2022-08-27 20:14:35', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563501492080611328', NULL, '1563500219818184704', '角色权限', 'admin:role:power', 'button', '/admin/role/menu', '/admin/role/power/{*}', 'POST', 6, '1', '', '2022-08-27 20:19:39', '王大宸', '1541230113952239617', '2022-08-27 20:19:39', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563502008068083713', NULL, '1563502008068083712', '查询字典类型', 'admin:dict:type:query', 'button', '/admin/dict/type/page', '/', 'GET', 1, '1', '查询字典类型表', '2022-08-27 20:21:41', '王大宸', NULL, '2022-08-27 20:21:41', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563502008068083714', NULL, '1563502008068083712', '新增字典类型', 'admin:dict:type:save', 'button', '/admin/dict/type', '/admin/dict/type/add', 'POST', 2, '1', '新增字典类型表', '2022-08-27 20:21:41', '王大宸', NULL, '2022-08-27 20:21:41', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563502008068083715', NULL, '1563502008068083712', '修改字典类型', 'admin:dict:type:update', 'button', '/admin/dict/type/{*}', '/admin/dict/type/edit/{*}', 'PUT', 3, '1', '修改字典类型表', '2022-08-27 20:21:41', '王大宸', NULL, '2022-08-27 20:21:41', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563502008068083716', NULL, '1563502008068083712', '数据字典', 'admin:dict:data:index', 'button', '/admin/dict/type/{*}', '/', 'GET', 5, '1', '跳转到数据字典列表页面', '2022-08-27 20:21:41', '王大宸', NULL, '2022-08-27 20:24:38', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563502008068083717', NULL, '1563502008068083712', '删除字典类型', 'admin:dict:type:delete', 'button', '/admin/dict/type/{*}', '/', 'DELETE', 4, '1', '删除字典类型表', '2022-08-27 20:21:41', '王大宸', NULL, '2022-08-27 20:24:32', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563503046821023744', NULL, '1563502008068083712', '数据字典查询', 'admin:dict:data:query', 'uri', '/admin/dict/data/page', '/', 'GET', 6, '1', '', '2022-08-27 20:25:50', '王大宸', '1541230113952239617', '2022-08-27 20:25:50', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563503346768285696', NULL, '1563502008068083712', '数据字典新增', 'admin:dict:data:save', 'button', '/admin/dict/data', '/admin/dict/data/{*}/add', 'POST', 7, '1', '', '2022-08-27 20:27:01', '王大宸', '1541230113952239617', '2022-08-27 20:27:01', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563503592151846912', NULL, '1563502008068083712', '数据字典编辑', 'admin:dict:data:update', 'button', '/admin/dict/data/{*}', '/admin/dict/data/edit/{*}', 'PUT', 8, '1', '', '2022-08-27 20:28:00', '王大宸', '1541230113952239617', '2022-08-27 20:28:00', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563503771064078336', NULL, '1563502008068083712', '数据字典删除', 'admin:dict:data:delete', 'button', '/admin/dict/data/{*}', '/', 'DELETE', 8, '1', '', '2022-08-27 20:28:42', '王大宸', '1541230113952239617', '2022-08-27 20:28:42', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563504032054644736', NULL, '1563502008068083712', '数据字典查看', 'admin:dict:data:view', 'uri', '/', '/admin/dict/data/view{*}', 'GET', 9, '1', '', '2022-08-27 20:29:44', '王大宸', '1541230113952239617', '2022-08-27 20:29:52', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563504365816385537', NULL, '1563504365816385536', '查询', 'admin:user:info:query', 'button', '/admin/user/page', '/', 'GET', 1, '1', '查询用户信息', '2022-08-27 20:31:03', '王大宸', NULL, '2022-08-27 20:31:03', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563504365816385538', NULL, '1563504365816385536', '新增', 'admin:user:info:save', 'button', '/admin/user', '/admin/user/add', 'POST', 2, '1', '新增用户信息', '2022-08-27 20:31:03', '王大宸', NULL, '2022-08-27 20:31:03', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563504365816385539', NULL, '1563504365816385536', '修改', 'admin:user:info:update', 'button', '/admin/user/{*}', '/admin/user/edit/{*}', 'PUT', 3, '1', '修改用户信息', '2022-08-27 20:31:03', '王大宸', NULL, '2022-08-27 20:31:03', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563504365816385540', NULL, '1563504365816385536', '查看', 'admin:user:info:view', 'button', '/admin/user/{*}', '/admin/user/view/{*}', 'GET', 4, '1', '查看用户信息', '2022-08-27 20:31:03', '王大宸', NULL, '2022-08-27 20:31:03', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563504365816385541', NULL, '1563504365816385536', '删除', 'admin:user:info:delete', 'button', '/admin/user/{*}', '/', 'DELETE', 7, '1', '删除用户信息', '2022-08-27 20:31:03', '王大宸', NULL, '2022-08-27 20:40:20', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563506132595642368', NULL, '1563504365816385536', '用户角色', 'admin:user:role:index', 'uri', '/admin/role/user', '/admin/role/user/{*}/index', 'POST', 5, '1', '', '2022-08-27 20:38:05', '王大宸', '1541230113952239617', '2022-08-27 20:40:05', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563506517972488192', NULL, '1563504365816385536', '权限下发', 'admin:perms:auth:index', 'button', '/admin/perms/auth', '/admin/perms/auth/{*}/index', 'POST', 6, '1', '', '2022-08-27 20:39:37', '王大宸', '1541230113952239617', '2022-08-27 20:40:11', '王大宸', '1541230113952239617');
INSERT INTO `sys_element_info` VALUES ('1563523443859787777', NULL, '1563523443859787776', '查询', 'admin:make:use:log:query', 'button', '/control/api/log/page', '/', 'GET', 1, '1', '查询日志表', '2022-08-27 21:46:52', '王大宸', NULL, '2022-08-27 21:46:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563523443859787780', NULL, '1563523443859787776', '查看', 'admin:make:use:log:view', 'button', '/control/api/log/{*}', '/control/api/log/view/{*}', 'GET', 4, '1', '查看日志表', '2022-08-27 21:46:52', '王大宸', NULL, '2022-08-27 21:46:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1563523443859787781', NULL, '1563523443859787776', '删除', 'admin:make:use:log:delete', 'button', '/control/api/log/{*}', '/', 'DELETE', 5, '1', '删除日志表', '2022-08-27 21:46:52', '王大宸', NULL, '2022-08-27 21:46:52', '王大宸', NULL);
INSERT INTO `sys_element_info` VALUES ('1655942121091371008', NULL, '1655924762725191680', '查询', 'query', 'uri', '/page', '', 'POST', 1, '1', '', '2023-05-09 22:25:42', '王大宸', '1541230113952239617', '2023-05-09 22:37:05', '王大宸', '1541230113952239617');

-- ----------------------------
-- Table structure for sys_gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `sys_gen_table_column`;
CREATE TABLE `sys_gen_table_column`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `ts_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前端TS类型',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_dto_vo` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否Dto/Vo类字段',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_form` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否为表单字段（1是）',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典类型',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_gen_table_column
-- ----------------------------

-- ----------------------------
-- Table structure for sys_gen_table_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_gen_table_info`;
CREATE TABLE `sys_gen_table_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表名称',
  `ui_style` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'UI类型',
  `client_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属客户端',
  `iframe` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器打开方式',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表描述',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `context_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务上下文',
  `module_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成业务名(controller访问名, 例如: 模块名为 admin, 业务名为 user, controller 访问路径为: /admin/user)',
  `function_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上级菜单目录id',
  `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成代码方式（0 zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_gen_table_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_login_error_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_error_record`;
CREATE TABLE `sys_login_error_record`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `error_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '错误类型',
  `session_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会话ID(sessionId)',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '错误密码',
  `verification_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问IP',
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '错误消息',
  `request_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求ID',
  `os` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `access_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问地址',
  `browser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `client_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  `create_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录错误日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_login_error_record
-- ----------------------------

-- ----------------------------
-- Table structure for sys_login_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_record`;
CREATE TABLE `sys_login_record`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '访问ID',
  `session_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会话id',
  `client_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  `sign_method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录方式',
  `nickname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登陆者姓名',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录IP地址',
  `access_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录状态（1成功 0失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提示消息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_login_record
-- ----------------------------

-- ----------------------------
-- Table structure for sys_make_use_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_make_use_log`;
CREATE TABLE `sys_make_use_log`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户id',
  `service_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务ID',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端id: PC端, 微程序, APP等 ',
  `request_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'http 请求id',
  `menu_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '日志标题: 用户管理, 菜单管理等',
  `make_use_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作类型: 新增, 修改, 删除, 查看',
  `log_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '日志类型: button-按钮, uri-链接, view-页面访问',
  `make_use_ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作IP地址',
  `make_use_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作地址',
  `make_use_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作状态: 成功, 失败, 异常',
  `user_agent` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URI',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作方式',
  `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '操作提交的数据',
  `json_result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '返回数据',
  `del_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标记',
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '异常信息',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `execute_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务端处理耗时',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回消息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tenant_id`(`tenant_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_make_use_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_info`;
CREATE TABLE `sys_menu_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路径编码,权限编码',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级节点',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源路径,浏览器访问地址',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '重定向路径',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Layui图标(JQ)',
  `element_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ElementUI图标',
  `layui_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'LayuiUIVue图标',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型:dirt-目录;menu-菜单;uri-外链',
  `order_num` int NULL DEFAULT NULL COMMENT '排序',
  `visible` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否显示:1-显示,0-不显示',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件名称(路由中的 name 值)',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件地址(vue中组件的地址)',
  `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '外链地址',
  `affix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单是否固定（固定在 tagsView 中，不可进行关闭），右键菜单无 `关闭` 项',
  `iframe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否内嵌, 开启条件，`1、isIframe: true 2、链接地址不为空（meta.isLink）`',
  `keep_alive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单是否缓存',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu_info
-- ----------------------------
INSERT INTO `sys_menu_info` VALUES ('1539506077102641152', 'tool', '系统工具', 'web_app', 'web_app', '/tool', NULL, 'layui-icon-util', NULL, NULL, 'dirt', 99, '1', 'ToolManagement', 'admin/role/index', NULL, '0', 'iframe', '1', '', '2022-06-22 15:10:26', '王大宸', '636009158973734912', '2023-04-28 14:46:27', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1539506077102641153', 'admin', '系统管理', 'web_app', 'web_app', '/admin', NULL, 'layui-icon-set-sm', NULL, NULL, 'dirt', 2, '1', 'ToolManagement', 'admin/role/index', NULL, '0', 'iframe', '1', '', '2022-06-22 15:10:26', '王大宸', '636009158973734912', '2023-04-28 14:46:24', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1539506450076930048', 'tool:generator:code', '代码生成器', 'web_app', '1539506077102641152', '/tools/table/info/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 1, '1', 'CodeManagement', 'tools/code/index', NULL, '0', 'iframe', '1', '', '2022-06-22 15:11:55', '王大宸', '636009158973734912', '2022-08-27 13:42:16', '王大宸', '636009158973734912');
INSERT INTO `sys_menu_info` VALUES ('1540926019261829120', 'index', '控制台', 'web_app', 'web_app', '/dashboard/console', NULL, 'layui-icon-console', NULL, NULL, 'menu', 1, '1', 'C4fZ2ojBaComponent', 'home/index', NULL, '1', 'iframe', '1', '', '2022-06-26 13:12:47', '王大宸', '636009158973734912', '2023-05-11 14:22:23', 'test002', '1650042355497177088');
INSERT INTO `sys_menu_info` VALUES ('1556461808062173184', 'admin:menu:info:index', '菜单管理', 'web_app', '1539506077102641153', '/admin/menu/info/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 4, '1', 'MenuManagement', 'admin/menu/index', NULL, NULL, 'iframe', '1', '菜单管理', '2022-08-08 10:06:27', '王大宸', NULL, '2022-08-27 20:42:40', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1556461808573878272', 'admin:app:client:index', '应用管理', 'web_app', '1539506077102641153', '/admin/app/client/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 6, '1', 'AppClientManagement', 'admin/appclient/index', NULL, NULL, 'iframe', '1', '微服务客户端(应用管理)', '2022-08-08 10:06:27', '王大宸', NULL, '2022-08-27 20:42:50', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1563139490028064768', 'admin:dept:index', '部门管理', 'web_app', '1539506077102641153', '/admin/dept/info/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 1, '1', 'CbjXesobNComponent', NULL, NULL, NULL, 'iframe', '1', '', '2022-08-26 20:21:11', NULL, NULL, '2023-04-11 17:06:10', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1563500219818184704', 'admin:role:index', '角色管理', 'web_app', '1539506077102641153', '/admin/role/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 3, '1', 'RoleManagement', 'admin/role/index', NULL, NULL, 'iframe', '1', '角色', '2022-08-27 20:14:35', '王大宸', NULL, '2022-08-27 20:42:33', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1563502008068083712', 'admin:dict:type:index', '字典类型', 'web_app', '1539506077102641153', '/admin/dict/type/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 5, '1', 'DictTypeManagement', 'admin/dict/type/index', NULL, NULL, 'iframe', '1', '字典类型', '2022-08-27 20:21:41', '王大宸', NULL, '2022-08-27 20:43:29', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1563504365816385536', 'admin:user:info:index', '用户信息', 'web_app', '1539506077102641153', '/admin/user/info/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 2, '1', 'UserManagement', 'admin/user/index', NULL, NULL, 'iframe', '1', '用户信息', '2022-08-27 20:31:03', '王大宸', NULL, '2022-08-27 20:42:26', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1563523443859787776', 'admin:make:use:log:index', '操作日志', 'web_app', '1675023327518920704', '/admin/make/use/log/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 999, '1', 'CylCnFR9sComponent', 'control/api/log/index', NULL, NULL, 'iframe', '1', '日志表', '2022-08-27 21:46:52', '王大宸', NULL, '2023-07-01 14:07:58', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1567149300868321280', 'control:server:index', '系统监控', 'web_app', '1675023327518920704', '/admin/server/use/index', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 998, '1', 'CFCCyUISeComponent', NULL, NULL, NULL, 'iframe', '1', '', '2022-09-06 21:54:44', '王大宸', '1541230113952239617', '2023-07-01 14:07:50', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1567182432116019200', 'error', '错误页面', 'web_app', 'web_app', '/error', NULL, 'layui-icon-404', NULL, NULL, 'dirt', 90, '1', NULL, NULL, NULL, NULL, 'iframe', '1', '', '2022-09-07 00:06:23', '王大宸', '1541230113952239617', '2023-04-28 14:46:26', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1567182596612427776', 'error:401', '401', 'web_app', '1567182432116019200', '/error/401', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 1, '1', NULL, NULL, NULL, NULL, 'iframe', '1', '', '2022-09-07 00:07:03', '王大宸', '1541230113952239617', '2022-09-07 00:07:03', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1567182683187056640', 'error:403', '403', 'web_app', '1567182432116019200', '/error/403', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 3, '1', NULL, NULL, NULL, NULL, 'iframe', '1', '', '2022-09-07 00:07:23', '王大宸', '1541230113952239617', '2022-09-07 00:12:36', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1567182766066503680', 'error:404', '404', 'web_app', '1567182432116019200', '/error/404', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 4, '1', NULL, NULL, NULL, NULL, 'iframe', '1', '', '2022-09-07 00:07:43', '王大宸', '1541230113952239617', '2022-09-07 00:08:23', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1567182885012770816', 'error:500', '500', 'web_app', '1567182432116019200', '/error/500', NULL, 'layui-icon-tree', NULL, NULL, 'menu', 5, '1', NULL, NULL, NULL, NULL, 'iframe', '1', '', '2022-09-07 00:08:11', '王大宸', '1541230113952239617', '2022-09-07 00:08:11', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1655904181543899136', 'next:dashboard', '首页', 'NEXT_APP', 'NEXT_APP', '/home/index', NULL, '', 'iconfont icon-shouye', '', 'menu', 1, '1', 'home', '/home/index', NULL, '1', '0', '1', '', '2023-05-09 19:54:57', '王大宸', '1541230113952239617', '2023-05-09 19:55:15', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1655904525380358144', 'next:admin', '系统管理', 'NEXT_APP', 'NEXT_APP', '/admin', NULL, '', 'iconfont icon-quanjushezhi_o', '', 'dirt', 98, '1', 'AdminComponent', 'layout/routerView/parent', NULL, '0', '0', '1', '', '2023-05-09 19:56:19', '王大宸', '1541230113952239617', '2023-05-13 23:27:49', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1655924762725191680', 'admin:menu:info', '菜单管理', 'NEXT_APP', '1655904525380358144', '/admin/menu', NULL, '', 'iconfont icon-diannao1', '', 'menu', 99, '1', 'MenuComponent', '/admin/menu/index', NULL, '0', '0', '1', '', '2023-05-09 21:16:44', '王大宸', '1541230113952239617', '2023-05-09 21:16:44', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1655931800020717568', 'admin:app:info', '应用管理', 'NEXT_APP', '1655904525380358144', '/admin/app', NULL, '', 'iconfont icon-caidan', '', 'menu', 99, '1', 'AppClientComponent', '/admin/app/index', NULL, '0', '0', '1', '', '2023-05-09 21:44:42', '王大宸', '1541230113952239617', '2023-05-12 23:19:18', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1657266958112002048', 'next:tools', '系统工具', 'NEXT_APP', 'NEXT_APP', '/tools', '', '', 'iconfont icon-zujian', '', 'dirt', 99, '1', 'C9yhvBMaQComponent', '', '', '0', '0', '1', '', '2023-05-13 14:10:08', '王大宸', '1541230113952239617', '2023-05-13 14:37:35', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1657267205756293120', 'next:tools:code', '代码生成器', 'NEXT_APP', '1657266958112002048', '/tools/tableinfo/index', '', '', 'iconfont icon-shouye_dongtaihui', '', 'menu', 99, '1', 'TableInfoComponent', '/tools/tableinfo/index', '', '0', '0', '1', '', '2023-05-13 14:11:07', '王大宸', '1541230113952239617', '2023-05-13 15:10:56', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1657748572298416128', 'admin:dept:info:index', '部门管理', 'NEXT_APP', '1655904525380358144', '/api/admin/dept/index', '', 'layui-icon-tree', 'iconfont icon-shuxingtu', 'layui-icon-tree', 'menu', 99, '1', 'DeptInfoComponent', '/admin/dept/index', '', '0', '0', '1', '部门管理', '2023-05-13 14:11:07', '王大宸', NULL, '2023-05-14 22:10:38', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1658083203468103680', 'admin:position:info:index', '岗位信息', 'NEXT_APP', '1655904525380358144', '/api/admin/position/index', '', 'layui-icon-tree', 'iconfont icon-crew_feature', 'layui-icon-tree', 'menu', 99, '1', 'PositionInfoComponent', '/admin/position/index', '', '0', '0', '1', '岗位信息', '2023-05-13 14:11:07', '王大宸', NULL, '2023-05-15 22:19:20', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1658436483918467072', 'admin:worker:info:index', '员工信息', 'NEXT_APP', '1655904525380358144', '/api/admin/worker/index', '', 'layui-icon-tree', 'iconfont icon-icon-', 'layui-icon-tree', 'menu', 99, '1', 'WorkerInfoComponent', '/admin/worker/index', '', '0', '0', '1', '员工信息', '2023-05-13 14:11:07', '王大宸', NULL, '2023-05-16 21:08:51', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1675023327518920704', 'monitor', '系统监控', 'web_app', 'web_app', '/', NULL, 'layui-icon-chart', NULL, NULL, 'dirt', 89, '1', 'CPwyqhe8zComponent', NULL, NULL, NULL, 'iframe', NULL, '', '2023-07-01 14:07:36', '王大宸', '1541230113952239617', '2023-07-01 14:07:36', '王大宸', '1541230113952239617');
INSERT INTO `sys_menu_info` VALUES ('1675028791598125056', 'record:login:index', '登录日志', 'web_app', '1675023327518920704', '/record/login/index', NULL, 'layui-icon-log', NULL, NULL, 'menu', 1, '1', 'CVphYYoxpComponent', NULL, NULL, NULL, 'iframe', NULL, '', '2023-07-01 14:29:19', '王大宸', '1541230113952239617', '2023-07-01 14:29:19', '王大宸', '1541230113952239617');

-- ----------------------------
-- Table structure for sys_net_disk_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_net_disk_info`;
CREATE TABLE `sys_net_disk_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租房标识',
  `biz_md5` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件MD5',
  `real_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实路径',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网络路径',
  `file_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `file_size` bigint NULL DEFAULT NULL COMMENT '文件大小',
  `file_format` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件格式',
  `biz_type` int NULL DEFAULT NULL COMMENT '文件类型：1-通用文件;2-头像',
  `download_count` int NULL DEFAULT NULL COMMENT '下载量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者ID',
  `create_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者ID',
  `update_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_net_disk_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_net_disk_md5
-- ----------------------------
DROP TABLE IF EXISTS `sys_net_disk_md5`;
CREATE TABLE `sys_net_disk_md5`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `md5` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件MD5编码',
  `real_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件网络路径',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件URL',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `file_size` bigint NULL DEFAULT NULL COMMENT '文件大小',
  `file_format` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件格式',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者ID',
  `create_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者ID',
  `update_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人姓名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_md5`(`md5` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件MD5' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_net_disk_md5
-- ----------------------------

-- ----------------------------
-- Table structure for sys_perms_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_perms_auth`;
CREATE TABLE `sys_perms_auth`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单id',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限下发' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_perms_auth
-- ----------------------------
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665536', '1563170150960730112', 'web_app', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665537', '1563170150960730112', '1540926019261829120', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665538', '1563170150960730112', '1539506077102641153', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665539', '1563170150960730112', '1563139490028064768', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665540', '1563170150960730112', '1556461808062173184', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665541', '1563170150960730112', '1556461808062173185', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665542', '1563170150960730112', '1556461808062173186', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665543', '1563170150960730112', '1556461808062173187', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665544', '1563170150960730112', '1556461808062173188', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665545', '1563170150960730112', '1556461808062173189', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665546', '1563170150960730112', '1556473472358682626', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665547', '1563170150960730112', '1556473472358682627', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665548', '1563170150960730112', '1556473472358682629', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665549', '1563170150960730112', '1556461808573878272', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665550', '1563170150960730112', '1556461808573878274', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665551', '1563170150960730112', '1556461808573878275', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665552', '1563170150960730112', '1556461808573878276', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665553', '1563170150960730112', '1539506077102641152', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665554', '1563170150960730112', '1539506450076930048', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1563187923929665555', '1563170150960730112', '1540926789453484032', NULL);
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637952', '1567426872327933952', 'web_app', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637953', '1567426872327933952', '1540926019261829120', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637954', '1567426872327933952', '1539506077102641153', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637955', '1567426872327933952', '1563139490028064768', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637956', '1567426872327933952', '1563497996870619137', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637957', '1567426872327933952', '1563498751786618882', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637958', '1567426872327933952', '1563498751786618883', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637959', '1567426872327933952', '1563498751786618884', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637960', '1567426872327933952', '1563498751786618885', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637961', '1567426872327933952', '1563504365816385536', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637962', '1567426872327933952', '1563504365816385537', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637963', '1567426872327933952', '1563504365816385538', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637964', '1567426872327933952', '1563504365816385539', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637965', '1567426872327933952', '1563504365816385540', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637966', '1567426872327933952', '1563506132595642368', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637967', '1567426872327933952', '1563506517972488192', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637968', '1567426872327933952', '1563504365816385541', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637969', '1567426872327933952', '1563500219818184704', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637970', '1567426872327933952', '1563500219818184705', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637971', '1567426872327933952', '1563500219818184706', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637972', '1567426872327933952', '1563500219818184707', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637973', '1567426872327933952', '1563500219818184708', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637974', '1567426872327933952', '1563500219818184709', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637975', '1567426872327933952', '1563501492080611328', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637976', '1567426872327933952', '1556461808062173184', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637977', '1567426872327933952', '1563491976005947392', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637978', '1567426872327933952', '1563492307016224768', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637979', '1567426872327933952', '1563492549476356096', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637980', '1567426872327933952', '1563492724638879744', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637981', '1567426872327933952', '1563492994114523136', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637982', '1567426872327933952', '1563491791578206208', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637983', '1567426872327933952', '1563493310667034624', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637984', '1567426872327933952', '1563493532361166848', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637985', '1567426872327933952', '1563493702217895936', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637986', '1567426872327933952', '1563494130162733056', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637987', '1567426872327933952', '1563502008068083712', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637988', '1567426872327933952', '1563502008068083713', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637989', '1567426872327933952', '1563502008068083714', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637990', '1567426872327933952', '1563502008068083715', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637991', '1567426872327933952', '1563502008068083717', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637992', '1567426872327933952', '1563502008068083716', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637993', '1567426872327933952', '1563503046821023744', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637994', '1567426872327933952', '1563503346768285696', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637995', '1567426872327933952', '1563503592151846912', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637996', '1567426872327933952', '1563503771064078336', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637997', '1567426872327933952', '1563504032054644736', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637998', '1567426872327933952', '1567182432116019200', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112637999', '1567426872327933952', '1567182596612427776', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112638000', '1567426872327933952', '1567182683187056640', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112638001', '1567426872327933952', '1567182766066503680', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1646688828112638002', '1567426872327933952', '1567182885012770816', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035840', '1650042355497177088', 'web_app', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035841', '1650042355497177088', '1539506077102641153', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035842', '1650042355497177088', '1563139490028064768', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035843', '1650042355497177088', '1563497996870619137', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035844', '1650042355497177088', '1563498751786618882', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035845', '1650042355497177088', '1563498751786618883', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035846', '1650042355497177088', '1563498751786618884', 'WEB_APP');
INSERT INTO `sys_perms_auth` VALUES ('1650042694032035847', '1650042355497177088', '1563498751786618885', 'WEB_APP');

-- ----------------------------
-- Table structure for sys_persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `sys_persistent_logins`;
CREATE TABLE `sys_persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `series` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `last_used` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录-记住我' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_persistent_logins
-- ----------------------------
INSERT INTO `sys_persistent_logins` VALUES ('admin', '/Yr6dGFAtY/KnomkomUd2A==', 'BCgngHuliwxXCK48+KvxuQ==', '2023-07-01 14:56:59');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '2vDcrJeSo8DmQjFceeFLig==', 'UqzupkoSxdC6f/ymK8vQrw==', '2023-07-01 13:55:28');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '5IkyVOGZlDow1eRQXOlPvw==', 'TQ3i2RD6tm/3Vv+sFA5+Mg==', '2023-07-01 13:57:46');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '5NfTdIQu4G+691g/aN6n2Q==', 'zUa4Yd88MEZKLlmBG7e1VA==', '2023-05-09 09:31:44');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '5v/31ivXHLUDNsA6qtNgdQ==', 'lzWvh2zkrl9ctBGtGftVAg==', '2023-05-13 20:30:43');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '7wCl0k1IBjrVohqWut8P3Q==', 'DxCNkfkKifttPJnZfCj2Hw==', '2023-07-01 14:00:10');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '9QzXFKkjAXJrjqZFdzmE8A==', 'hR+JaGRYb8c/y//ANZ0Lgw==', '2023-07-01 13:56:38');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'bFzFyR42xBZ6Pdmx47hq+Q==', 'XROPlY8qMaMnMzVWGKbnAw==', '2023-07-01 14:06:00');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'BRXNXEjWYIx0woEGYZDVQw==', 'RsRPWU4g1Q2l8MMmnWGJ0Q==', '2023-05-13 19:28:00');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'crdanaTXnRmTRHjtqhCjrw==', 'df0dNPuFq/Eu0E6k17ILxw==', '2023-07-01 13:53:05');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'eJAVBMlgQOrcS2Dg/D7YgA==', 'MX7WQhpvEOHqmeEESi2mBg==', '2023-07-01 14:58:03');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'eKpdo5p6eqMouLXonwHzog==', 'MWRqvHFu+VzzmOyLGqRvAw==', '2023-06-02 21:22:39');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'fdAMPp4OpfJY7UQzQ2/8rA==', 'OXYQ2zQWbpL+EfrJvds4lw==', '2023-07-01 14:29:57');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'FEga1hdYlmF0NIo9+jdaUQ==', 'oTGBwytLnrawvZ1FVEFFtw==', '2023-07-01 13:52:36');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'g0LPRcHdvzOZAkUpavaAQQ==', 'PtP3m2JF/L2CCrAcATGE5Q==', '2023-07-01 14:56:04');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'H1ev20K4OO0sYUMcinfT5g==', 'eQ+VpyDxw9ZNz/icNJOQyA==', '2023-06-09 22:25:18');
INSERT INTO `sys_persistent_logins` VALUES ('test002', 'h5Aaessz9aRLr4mxeFxSbw==', '/lMlauqk0UgLI+ThNlZv6Q==', '2023-05-09 10:02:49');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'hzn9i8dwj+hnF76K+tAppQ==', 'XVWkTN4us96uDJahCQ2YRA==', '2023-05-09 09:36:16');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'jLvGiaF7E4pdGSK4yiLmLw==', 'hgYAHK4649LHqaFlXt53wA==', '2023-06-30 21:54:14');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'KiV0sQImDhj0El97JJQr+g==', 'dAL1KNE72N0lSs/SEM/YkQ==', '2023-07-01 14:02:12');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'KMP1pvcXDckW6NM9FHW1rA==', 'Jmcu8gKL9Kdwc1sn21TDfA==', '2023-06-02 21:35:54');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'qyEFKI0u5XscBEmlhQrr7Q==', 'j1JYi5nxjf8LDFFFJEQvNw==', '2023-05-17 21:39:10');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'rumE6DdsnbhHw6ahETNFTw==', 'SICQxDmflKhqjZSJA09sTQ==', '2023-06-30 22:35:38');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'S7OGg22yl219YvciwDqKOw==', 'OzYZa/AjN83ys47jsmYCQA==', '2023-07-01 13:58:50');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'SM3kHA+gY28B//+K8TvuSA==', 'BeSRqgMW+QF8gxYG4rUXfA==', '2023-06-30 23:20:00');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'Tu+aZa/rbkVPM84AGle5Ng==', 'iTHL/6Ave7vmiBcoCr7wOA==', '2023-05-09 20:22:52');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'u6sBZtnudz5OpzPXDcdg7w==', 'U4VniztUbixLgI333Ffv+Q==', '2023-07-01 14:48:58');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'Ue85plNGjjJvdcTpOdfhIw==', 'H3qiwIAD7KdBISGk7tnsZg==', '2023-07-01 14:04:27');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'v1TGZgGrvKuXpMWnO7MHzA==', 'kBin9wxR7B/VGRr1iae3iw==', '2023-06-12 23:00:49');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'vOQ6vRQxlf5fnRBWbi+4lg==', 'OCE10eHcU8yBYIu3K9RIeg==', '2023-07-01 13:49:47');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'vR9lrRLj8zztvd5Fn0Ln0g==', 'Q/sFN4mcfTEX6w3Uaj4vLQ==', '2023-07-01 13:54:48');
INSERT INTO `sys_persistent_logins` VALUES ('test002', 'wbU3NHwtStlClPqvS502JA==', 'DK/10YptxXfGfy2O/PCUMQ==', '2023-05-09 09:36:00');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'XukAaYPzYeZzjVbBnTYCyQ==', 'ElGiGSNT13S4LCRSzCAG3Q==', '2023-06-30 22:05:46');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'YcONh6518v6uIliXJxbfBQ==', 'PXiSF9XAXtOlabj8tow/vQ==', '2023-06-30 23:28:14');
INSERT INTO `sys_persistent_logins` VALUES ('test002', 'YfidgXyWFbifSaS5IDQ3iA==', 'ZkoHpi3zduwUt911TPJ2VA==', '2023-05-11 10:41:04');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'Zif3ETRzkJPIZClrt6AfkA==', 'Czzhacm8dkD+EqgVfCa98Q==', '2023-07-01 13:49:07');

-- ----------------------------
-- Table structure for sys_position_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_position_info`;
CREATE TABLE `sys_position_info`  (
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户标识',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位名称',
  `position_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位标识',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_position_info
-- ----------------------------
INSERT INTO `sys_position_info` VALUES ('1658090160996356096', NULL, '123413123', '123', '693511254211706880', '1', '123123', '2023-05-15 20:41:15', '1541230113952239617', '王大宸', '2023-05-15 20:41:29', '1541230113952239617', '王大宸');
INSERT INTO `sys_position_info` VALUES ('1658091090085023744', NULL, '董事长', '1', 'root', '1', '', '2023-05-15 20:44:56', '1541230113952239617', '王大宸', '2023-05-15 20:44:56', '1541230113952239617', '王大宸');

-- ----------------------------
-- Table structure for sys_role_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门id',
  `role_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_info
-- ----------------------------
INSERT INTO `sys_role_info` VALUES ('1593488950146764800', '660312611032023041', 'ROLE_USER', '4444444', NULL, '4444444444444444444444444444444', '2022-11-18 14:19:06', '王大宸', '1541230113952239617', '王大宸', '2023-04-23 21:26:36', '1541230113952239617');
INSERT INTO `sys_role_info` VALUES ('1643274063357022208', '660312611032023041', 'ROLE_USER', '11423', NULL, '11111423423', '2023-04-04 23:27:22', '王大宸', '1541230113952239617', '王大宸', '2023-04-23 21:26:32', '1541230113952239617');
INSERT INTO `sys_role_info` VALUES ('1650128731618021376', '660312611032023041', 'ROLE_USER', '111111111111111111111', NULL, '123', '2023-04-23 21:25:22', '王大宸', '1541230113952239617', '王大宸', '2023-04-27 21:37:30', '1541230113952239617');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据唯一标识',
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单id',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单角色' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1562804494251724800', '1562460559193018368', '1539506077102641153', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724801', '1562460559193018368', '1556461808062173184', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724802', '1562460559193018368', '1556461808062173186', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724803', '1562460559193018368', '1556461808062173187', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724804', '1562460559193018368', '1556461808062173189', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724805', '1562460559193018368', '1556473472358682626', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724806', '1562460559193018368', '1556473472358682627', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724807', '1562460559193018368', '1556473472358682629', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724808', '1562460559193018368', '1556461808573878272', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724809', '1562460559193018368', '1556461808573878273', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724810', '1562460559193018368', '1556461808573878274', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724811', '1562460559193018368', '1556461808573878275', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724812', '1562460559193018368', '1556461808573878276', NULL);
INSERT INTO `sys_role_menu` VALUES ('1562804494251724813', '1562460559193018368', '1556461808573878277', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757952', '1567440041481998336', '1539506077102641153', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757953', '1567440041481998336', '1563139490028064768', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757954', '1567440041481998336', '1563497996870619137', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757955', '1567440041481998336', '1563498751786618882', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757956', '1567440041481998336', '1563498751786618883', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757957', '1567440041481998336', '1563498751786618884', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757958', '1567440041481998336', '1563498751786618885', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757959', '1567440041481998336', '1556461808062173184', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757960', '1567440041481998336', '1563491976005947392', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757961', '1567440041481998336', '1563492307016224768', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757962', '1567440041481998336', '1563492549476356096', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757963', '1567440041481998336', '1563492724638879744', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757964', '1567440041481998336', '1563492994114523136', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757965', '1567440041481998336', '1563491791578206208', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757966', '1567440041481998336', '1563493310667034624', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757967', '1567440041481998336', '1563493532361166848', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757968', '1567440041481998336', '1563493702217895936', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757969', '1567440041481998336', '1563494130162733056', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757970', '1567440041481998336', '1563502008068083712', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757971', '1567440041481998336', '1563502008068083713', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757972', '1567440041481998336', '1563502008068083714', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757973', '1567440041481998336', '1563502008068083715', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757974', '1567440041481998336', '1563502008068083717', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757975', '1567440041481998336', '1563502008068083716', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757976', '1567440041481998336', '1563503046821023744', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757977', '1567440041481998336', '1563503346768285696', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757978', '1567440041481998336', '1563503592151846912', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757979', '1567440041481998336', '1563503771064078336', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757980', '1567440041481998336', '1563504032054644736', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757981', '1567440041481998336', '1556461808573878272', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757982', '1567440041481998336', '1563499282768728065', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757983', '1567440041481998336', '1563499282768728066', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757984', '1567440041481998336', '1563499282768728067', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757985', '1567440041481998336', '1563499282768728068', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757986', '1567440041481998336', '1563499282768728069', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757987', '1567440041481998336', '1567182432116019200', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757988', '1567440041481998336', '1567182596612427776', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757989', '1567440041481998336', '1567182683187056640', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757990', '1567440041481998336', '1567182766066503680', NULL);
INSERT INTO `sys_role_menu` VALUES ('1567451866709757991', '1567440041481998336', '1567182885012770816', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186816', '1563500948251348992', 'web_app', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186817', '1563500948251348992', '1539506077102641153', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186818', '1563500948251348992', '1563139490028064768', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186819', '1563500948251348992', '1563497996870619137', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186820', '1563500948251348992', '1563498751786618882', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186821', '1563500948251348992', '1563498751786618883', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186822', '1563500948251348992', '1563498751786618884', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186823', '1563500948251348992', '1563498751786618885', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186824', '1563500948251348992', '1563504365816385536', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186825', '1563500948251348992', '1563504365816385537', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186826', '1563500948251348992', '1563504365816385538', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186827', '1563500948251348992', '1563504365816385539', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186828', '1563500948251348992', '1563504365816385540', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186829', '1563500948251348992', '1563506132595642368', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186830', '1563500948251348992', '1563506517972488192', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186831', '1563500948251348992', '1563504365816385541', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186832', '1563500948251348992', '1563500219818184704', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186833', '1563500948251348992', '1563500219818184705', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186834', '1563500948251348992', '1563500219818184706', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186835', '1563500948251348992', '1563500219818184707', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186836', '1563500948251348992', '1563500219818184708', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186837', '1563500948251348992', '1563500219818184709', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186838', '1563500948251348992', '1563501492080611328', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186839', '1563500948251348992', '1556461808062173184', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186840', '1563500948251348992', '1563491976005947392', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186841', '1563500948251348992', '1563492307016224768', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186842', '1563500948251348992', '1563492549476356096', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186843', '1563500948251348992', '1563492724638879744', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186844', '1563500948251348992', '1563492994114523136', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186845', '1563500948251348992', '1563491791578206208', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186846', '1563500948251348992', '1563493310667034624', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186847', '1563500948251348992', '1563493532361166848', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186848', '1563500948251348992', '1563493702217895936', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186849', '1563500948251348992', '1563494130162733056', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186850', '1563500948251348992', '1563502008068083712', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186851', '1563500948251348992', '1563502008068083713', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186852', '1563500948251348992', '1563502008068083714', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186853', '1563500948251348992', '1563502008068083715', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186854', '1563500948251348992', '1563502008068083717', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186855', '1563500948251348992', '1563502008068083716', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186856', '1563500948251348992', '1563503046821023744', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186857', '1563500948251348992', '1563503346768285696', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186858', '1563500948251348992', '1563503592151846912', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186859', '1563500948251348992', '1563503771064078336', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186860', '1563500948251348992', '1563504032054644736', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186861', '1563500948251348992', '1556461808573878272', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186862', '1563500948251348992', '1563499282768728065', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186863', '1563500948251348992', '1563499282768728066', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186864', '1563500948251348992', '1563499282768728067', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186865', '1563500948251348992', '1563499282768728068', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186866', '1563500948251348992', '1563499282768728069', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186867', '1563500948251348992', '1567182432116019200', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186868', '1563500948251348992', '1567182596612427776', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186869', '1563500948251348992', '1567182683187056640', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186870', '1563500948251348992', '1567182766066503680', NULL);
INSERT INTO `sys_role_menu` VALUES ('1593436636497186871', '1563500948251348992', '1567182885012770816', NULL);
INSERT INTO `sys_role_menu` VALUES ('1650042031004848128', '1643274063357022208', '1540926019261829120', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848129', '1643274063357022208', '1539506077102641153', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848130', '1643274063357022208', '1563139490028064768', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848131', '1643274063357022208', '1563497996870619137', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848132', '1643274063357022208', '1563498751786618882', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848133', '1643274063357022208', '1563498751786618883', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848134', '1643274063357022208', '1563498751786618884', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848135', '1643274063357022208', '1563498751786618885', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848136', '1643274063357022208', '1563504365816385536', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848137', '1643274063357022208', '1563504365816385537', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848138', '1643274063357022208', '1563504365816385538', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848139', '1643274063357022208', '1563504365816385539', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848140', '1643274063357022208', '1563504365816385540', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848141', '1643274063357022208', '1563506132595642368', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848142', '1643274063357022208', '1563506517972488192', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848143', '1643274063357022208', '1563504365816385541', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848144', '1643274063357022208', '1563500219818184704', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848145', '1643274063357022208', '1563500219818184705', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848146', '1643274063357022208', '1563500219818184706', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848147', '1643274063357022208', '1563500219818184707', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848148', '1643274063357022208', '1563500219818184708', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848149', '1643274063357022208', '1563500219818184709', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848150', '1643274063357022208', '1563501492080611328', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848151', '1643274063357022208', '1556461808062173184', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848152', '1643274063357022208', '1563491976005947392', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848153', '1643274063357022208', '1563492307016224768', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848154', '1643274063357022208', '1563492549476356096', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848155', '1643274063357022208', '1563492724638879744', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848156', '1643274063357022208', '1563492994114523136', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848157', '1643274063357022208', '1563491791578206208', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848158', '1643274063357022208', '1563493310667034624', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848159', '1643274063357022208', '1563493532361166848', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848160', '1643274063357022208', '1563493702217895936', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848161', '1643274063357022208', '1563494130162733056', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848162', '1643274063357022208', '1563502008068083712', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848163', '1643274063357022208', '1563502008068083713', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848164', '1643274063357022208', '1563502008068083714', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848165', '1643274063357022208', '1563502008068083715', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848166', '1643274063357022208', '1563502008068083717', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848167', '1643274063357022208', '1563502008068083716', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848168', '1643274063357022208', '1563503046821023744', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848169', '1643274063357022208', '1563503346768285696', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848170', '1643274063357022208', '1563503592151846912', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848171', '1643274063357022208', '1563503771064078336', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848172', '1643274063357022208', '1563504032054644736', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848173', '1643274063357022208', '1556461808573878272', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848174', '1643274063357022208', '1563499282768728065', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848175', '1643274063357022208', '1563499282768728066', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848176', '1643274063357022208', '1563499282768728067', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848177', '1643274063357022208', '1563499282768728068', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848178', '1643274063357022208', '1563499282768728069', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848179', '1643274063357022208', '1567182432116019200', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848180', '1643274063357022208', '1567182683187056640', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848181', '1643274063357022208', '1567182766066503680', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1650042031004848182', '1643274063357022208', '1567182885012770816', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806976', '1593488950146764800', 'web_app', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806977', '1593488950146764800', '1539506077102641153', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806978', '1593488950146764800', '1563139490028064768', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806979', '1593488950146764800', '1563497996870619137', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806980', '1593488950146764800', '1563498751786618882', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806981', '1593488950146764800', '1563498751786618883', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806982', '1593488950146764800', '1563498751786618884', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806983', '1593488950146764800', '1563498751786618885', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806984', '1593488950146764800', '1563504365816385536', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806985', '1593488950146764800', '1563504365816385537', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806986', '1593488950146764800', '1563504365816385538', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806987', '1593488950146764800', '1563504365816385539', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806988', '1593488950146764800', '1563504365816385540', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806989', '1593488950146764800', '1563506132595642368', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806990', '1593488950146764800', '1563506517972488192', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806991', '1593488950146764800', '1563504365816385541', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806992', '1593488950146764800', '1563500219818184704', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806993', '1593488950146764800', '1563500219818184705', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806994', '1593488950146764800', '1563500219818184706', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806995', '1593488950146764800', '1563500219818184707', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806996', '1593488950146764800', '1563500219818184708', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806997', '1593488950146764800', '1563500219818184709', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806998', '1593488950146764800', '1563501492080611328', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055806999', '1593488950146764800', '1556461808062173184', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807000', '1593488950146764800', '1563491976005947392', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807001', '1593488950146764800', '1563492307016224768', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807002', '1593488950146764800', '1563492549476356096', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807003', '1593488950146764800', '1563492724638879744', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807004', '1593488950146764800', '1563492994114523136', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807005', '1593488950146764800', '1563491791578206208', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807006', '1593488950146764800', '1563493310667034624', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807007', '1593488950146764800', '1563493532361166848', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807008', '1593488950146764800', '1563493702217895936', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807009', '1593488950146764800', '1563494130162733056', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807010', '1593488950146764800', '1563502008068083712', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807011', '1593488950146764800', '1563502008068083713', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807012', '1593488950146764800', '1563502008068083714', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807013', '1593488950146764800', '1563502008068083715', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807014', '1593488950146764800', '1563502008068083717', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807015', '1593488950146764800', '1563502008068083716', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807016', '1593488950146764800', '1563503046821023744', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807017', '1593488950146764800', '1563503346768285696', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807018', '1593488950146764800', '1563503592151846912', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807019', '1593488950146764800', '1563503771064078336', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807020', '1593488950146764800', '1563504032054644736', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807021', '1593488950146764800', '1556461808573878272', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807022', '1593488950146764800', '1563499282768728065', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807023', '1593488950146764800', '1563499282768728066', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807024', '1593488950146764800', '1563499282768728067', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807025', '1593488950146764800', '1563499282768728068', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807026', '1593488950146764800', '1563499282768728069', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807027', '1593488950146764800', '1567149300868321280', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807028', '1593488950146764800', '1563523443859787776', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807029', '1593488950146764800', '1563523443859787777', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807030', '1593488950146764800', '1563523443859787780', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807031', '1593488950146764800', '1563523443859787781', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807032', '1593488950146764800', '1567182432116019200', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807033', '1593488950146764800', '1567182596612427776', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807034', '1593488950146764800', '1567182683187056640', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807035', '1593488950146764800', '1567182766066503680', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807036', '1593488950146764800', '1567182885012770816', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807037', '1593488950146764800', '1539506077102641152', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807038', '1593488950146764800', '1539506450076930048', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807039', '1593488950146764800', '1563495341288984576', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807040', '1593488950146764800', '1563495702405976064', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807041', '1593488950146764800', '1563496093470298112', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807042', '1593488950146764800', '1563496409666293760', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1655742234055807043', '1593488950146764800', '1563496638331359232', 'WEB_APP');
INSERT INTO `sys_role_menu` VALUES ('1658113778098769920', '1658091090085023744', '1655904181543899136', 'NEXT_APP');
INSERT INTO `sys_role_menu` VALUES ('1658113778098769921', '1658091090085023744', '1655931800020717568', 'NEXT_APP');
INSERT INTO `sys_role_menu` VALUES ('1658113778098769922', '1658091090085023744', '1658083203468103680', 'NEXT_APP');
INSERT INTO `sys_role_menu` VALUES ('1658113778098769923', '1658091090085023744', '1657266958112002048', 'NEXT_APP');
INSERT INTO `sys_role_menu` VALUES ('1658113778098769924', '1658091090085023744', '1657267205756293120', 'NEXT_APP');
INSERT INTO `sys_role_menu` VALUES ('1658113778098769925', '1658091090085023744', '1655904525380358144', 'NEXT_APP');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据唯一标识',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1643967457788039168', '1567426872327933952', '1643274063357022208', 'web_app');
INSERT INTO `sys_role_user` VALUES ('1655742291341611008', '1650042355497177088', '1593488950146764800', 'WEB_APP');

-- ----------------------------
-- Table structure for sys_user_connection
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_connection`;
CREATE TABLE `sys_user_connection`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `USER_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务系统的用户id',
  `provider_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务提供商提供的id',
  `provider_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务提供商提供的用户id(openId)',
  `RANK` int NULL DEFAULT NULL,
  `display_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `profile_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接口访问凭证',
  `secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `refresh_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '刷新令牌',
  `expire_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '第三方登录信息关联' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_connection
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录账户',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `birthday` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `telephone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `depart_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门ID',
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别: 数据字典-sys_sex',
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态: 数据字典: user_status 0-冻结;1-正常',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户id/机构id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端ID',
  `is_del` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否删除',
  `attr1` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性1',
  `attr2` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性2',
  `attr3` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性3',
  `attr4` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性4',
  `attr5` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性5',
  `attr6` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性6',
  `attr7` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性7',
  `attr8` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性8',
  `attr9` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性9',
  `attr10` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性10',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_usernane`(`username` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('1541230113952239617', 'admin', '$2a$10$XmbU6NITPtycf0qHQsIqtekZUSmC/ZmErQRke9zjsWyOJLKAspy9G', '王大宸', 'https://itdachen.com/upload/2022/3/20220323213205704122392246894592.png', NULL, '贵州省贵阳市观山湖区', '13212345678', 'itdachen@163.com', '660312611032023041', '1', '1', '1', NULL, NULL, '2021-09-16 22:34:26', NULL, NULL, '2021-11-26 21:51:18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_info` VALUES ('1567426872327933952', 'test001', '$2a$10$s1Kmwd8PNTCjHo7V.6sakudLjzrTatbo8ntAAJhsrm0yt8hb7XcQ.', 'test001', 'http://127.0.0.1:8080/upload/2023/5/f33505a0ec514526816996bbc10c8971.png', NULL, '', '13201234567', '', '660312611032023041', '1', '4', '1', '', NULL, '2022-09-07 16:17:42', '1541230113952239617', '王大宸', '2023-05-17 21:43:37', '1541230113952239617', '王大宸', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_info` VALUES ('1643290352167292928', '234', '231', '3123123123', '', NULL, '3123123', '12', '312312', 'ROOT', '1', NULL, '1', '', NULL, '2023-04-05 00:32:05', '1541230113952239617', '王大宸', '2023-04-05 00:32:05', '1541230113952239617', '王大宸', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_info` VALUES ('1643290415891353600', '23412312312312', '231', '3123123123', '', NULL, '3123123', '12', '312312', 'ROOT', '1', NULL, '1', '', NULL, '2023-04-05 00:32:21', '1541230113952239617', '王大宸', '2023-04-05 00:32:21', '1541230113952239617', '王大宸', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_info` VALUES ('1643290507226517504', '1321234556', '231', '3123123123', '', NULL, '3123123', '12', '312312', 'ROOT', '1', NULL, '1', '', NULL, '2023-04-05 00:32:42', '1541230113952239617', '王大宸', '2023-04-05 00:32:42', '1541230113952239617', '王大宸', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_info` VALUES ('1643290750080913408', '312312', '1323123', '12312', '', NULL, '', '3123123123', '', 'ROOT', '1', NULL, '1', '', NULL, '2023-04-05 00:33:40', '1541230113952239617', '王大宸', '2023-04-05 00:33:40', '1541230113952239617', '王大宸', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_info` VALUES ('1643494759597215744', '4324', '$2a$10$5KQskGjE0yE6lPJ1fwuqbeWt93YwJ4.44c.bw95Q7w7jcCagHSley', '234', '', NULL, '4234', '234', '234', '693505675909021696', '1', '4', '1', '', NULL, '2023-04-05 14:04:20', '1541230113952239617', '王大宸', '2023-04-05 14:04:20', '1541230113952239617', '王大宸', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user_info` VALUES ('1650042355497177088', 'test002', 'test002', 'test00211111111', 'https://itdachen.oss-cn-chengdu.aliyuncs.com/2023/06/12/06a3197181b34fd8b6c796a5a6773f60.png.png', NULL, '', '13212345678', '', '660312611032023041', '1', '4', '1', '', '1541230113952239610', '2023-04-23 15:42:09', '1541230113952239617', '王大宸', '2023-06-12 23:08:21', '1541230113952239617', '王大宸', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login`;
CREATE TABLE `sys_user_login`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统用户ID(第三方关联时,系统的用户ID)',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户ID',
  `app_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务提供商提供的id,例如: 微信,系统,支付宝,抖音等',
  `open_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务提供商提供的用户id, 例如: openid,unionid, username等',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `status` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户状态(1-正常;0-冻结)',
  `user_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称(用户姓名)',
  `profile_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置地址',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `del_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标志(1-已删除;0-未删除)',
  `can_del` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否可删除(0-不可删除;1-可删除)',
  `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间(密码过期时间, 有些系统需要定期更新账号的密码)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '第三方登录信息关联(用户登录表)' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_login
-- ----------------------------
INSERT INTO `sys_user_login` VALUES ('1541230113952239617', '1541230113952239617', '1541230113952239610', 'WEB_APP', 'admin', 'admin', '$2a$10$XmbU6NITPtycf0qHQsIqtekZUSmC/ZmErQRke9zjsWyOJLKAspy9G', '1', '1', '王大宸', NULL, 'https://itdachen.com/upload/2022/3/20220323213205704122392246894592.png', '0', '0', '2021-09-16 22:34:26', '2021-09-16 22:34:26', '2021-09-16 22:34:26');
INSERT INTO `sys_user_login` VALUES ('1541230113952239618', '1541230113952239617', '1541230113952239610', 'WEB_APP', '13212345678', '13212345678', '$2a$10$XmbU6NITPtycf0qHQsIqtekZUSmC/ZmErQRke9zjsWyOJLKAspy9G', '1', '1', '王大宸', NULL, 'https://itdachen.com/upload/2022/3/20220323213205704122392246894592.png', '0', '0', '2021-09-16 22:34:26', '2021-09-16 22:34:26', '2021-09-16 22:34:26');
INSERT INTO `sys_user_login` VALUES ('1650042355497177088', '1650042355497177088', '1541230113952239610', 'WEB_APP', NULL, 'test002', '$2a$10$saavogl0cte2anFG4o.g/OfpxK3XwcoJaUj70s0KiGQFLMOmu.jWK', '1', '4', 'test002', NULL, 'http://127.0.0.1:8080/upload/2023/4/4a45bbc9cffb4f9582db5fe9e8e8416c.jpg', '0', '1', '2022-10-25 15:42:09', '2023-04-23 15:42:09', '2023-04-23 15:42:09');

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键ID',
  `session_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户会话id',
  `client_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  `login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `create_time` datetime NULL DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime NULL DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int NULL DEFAULT 0 COMMENT '超时时间，单位为分钟',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '在线用户记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------

-- ----------------------------
-- Table structure for sys_worker_changes
-- ----------------------------
DROP TABLE IF EXISTS `sys_worker_changes`;
CREATE TABLE `sys_worker_changes`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户标识',
  `worker_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工ID',
  `data_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其他表关联ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `chenge_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变动类型: 入职,离职,调离等',
  `cause` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原因',
  `from_here` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '来自于',
  `from_here_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '来自于(明文)',
  `to_here` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '去哪里',
  `to_here_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '去哪里(明文)',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `take_effect_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生效时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '变更记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_worker_changes
-- ----------------------------

-- ----------------------------
-- Table structure for sys_worker_identity
-- ----------------------------
DROP TABLE IF EXISTS `sys_worker_identity`;
CREATE TABLE `sys_worker_identity`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识(身份ID)',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户标识',
  `worker_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职工ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份名称',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门ID',
  `dept_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `status` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否有效: 1-有效;0-无效',
  `is_primary` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否主身份标识(1-是,0-不是)',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '职工身份' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_worker_identity
-- ----------------------------
INSERT INTO `sys_worker_identity` VALUES ('1658473796513959936', NULL, '1658458462293725184', '213', '1643284935135596544', '231', '1', '1', '12312', '2023-05-16 22:05:41', '1541230113952239617', '王大宸', '2023-05-17 21:24:26', '1541230113952239617', '王大宸');
INSERT INTO `sys_worker_identity` VALUES ('1658476068316778496', NULL, '1658439361580109824', 'HRDB', '693505675909021696', '人事部', '1', '0', '2222222222222', '2023-05-16 22:14:42', '1541230113952239617', '王大宸', '2023-05-17 21:26:23', '1541230113952239617', '王大宸');
INSERT INTO `sys_worker_identity` VALUES ('1658826221112397824', NULL, '1658439361580109824', '研发经理', '693511254211706880', '研发部', '1', '1', '', '2023-05-17 21:26:05', '1541230113952239617', '王大宸', '2023-05-17 21:26:31', '1541230113952239617', '王大宸');

-- ----------------------------
-- Table structure for sys_worker_identity_position
-- ----------------------------
DROP TABLE IF EXISTS `sys_worker_identity_position`;
CREATE TABLE `sys_worker_identity_position`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `identity_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份ID',
  `position_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位ID',
  `client_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '身份岗位表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_worker_identity_position
-- ----------------------------
INSERT INTO `sys_worker_identity_position` VALUES ('1658819062970585088', '1658473796513959936', '693511254211706880', 'NEXT_APP');
INSERT INTO `sys_worker_identity_position` VALUES ('1658819062970585089', '1658473796513959936', '1658090160996356096', 'NEXT_APP');

-- ----------------------------
-- Table structure for sys_worker_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_worker_info`;
CREATE TABLE `sys_worker_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '租户标识',
  `worker_no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职工编号',
  `worker_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职工姓名',
  `sex` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生日',
  `telephone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态: 正常;离职;休假',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `entry_day` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '入职日期',
  `depart_day` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '离职日期',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_worker_info
-- ----------------------------
INSERT INTO `sys_worker_info` VALUES ('1658439361580109824', NULL, '1231', '李四', '1', 'http://127.0.0.1:8081/api/upload/2023/5/5ed42591edf448d490d9bad83e5b50d7.jpg', '231231', '23123', '123', '1', '12312', '123123123', '', '2023-05-16 19:48:51', '1541230113952239617', '王大宸', '2023-05-16 22:14:24', '1541230113952239617', '王大宸');
INSERT INTO `sys_worker_info` VALUES ('1658458462293725184', NULL, '001', '张三', '1', 'http://127.0.0.1:8081/api/upload/2023/5/6ed13181917447eb9229bf76a8e12492.png', '2023-05-23T16:00:00.000Z', '123', '312', '1', '3123123123', '2023-05-22T16:00:00.000Z', '', '2023-05-16 21:04:45', '1541230113952239617', '王大宸', '2023-05-16 22:14:17', '1541230113952239617', '王大宸');

SET FOREIGN_KEY_CHECKS = 1;
