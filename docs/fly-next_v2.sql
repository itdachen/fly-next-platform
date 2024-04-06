/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 127.0.0.1:3306
 Source Schema         : fly_next_admin

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 06/04/2024 20:25:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fly_dev_table_column
-- ----------------------------
DROP TABLE IF EXISTS `fly_dev_table_column`;
CREATE TABLE `fly_dev_table_column`  (
      `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '编号',
      `table_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '归属表编号',
      `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '列名称',
      `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '列描述',
      `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '列类型',
      `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'JAVA类型',
      `java_title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'JAVA类型名称',
      `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'JAVA字段名',
      `ts_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '前端TS类型',
      `is_pk` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否主键（1是）',
      `is_usable` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否使用（1是）',
      `is_dto` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否 DTO 类字段（1是）',
      `is_vo` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否 VO 类字段（1是）',
      `is_required` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否必填（1是）',
      `is_form` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否为表单字段（1是）',
      `is_list` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
      `is_query` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
      `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '查询方式（等于、不等于、大于、小于、范围）',
      `query_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '查询方式名称',
      `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
      `html_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '显示类型名',
      `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典类型',
      `dict_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典类型名称',
      `sort` int NULL DEFAULT NULL COMMENT '排序',
      `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
      `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
      `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
      `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
      `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
      `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '代码生成业务表字段' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for fly_dev_table_info
-- ----------------------------
DROP TABLE IF EXISTS `fly_dev_table_info`;
CREATE TABLE `fly_dev_table_info`  (
    `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
    `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '表名称',
    `client_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '所属客户端',
    `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上级菜单目录id',
    `iframe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '浏览器打开方式',
    `func_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '功能名',
    `func_author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '生成功能作者',
    `clazz_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '实体类名称',
    `context_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '服务上下文',
    `rear_package` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '后端包路径',
    `rear_split` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否前后端分离(0-不是;1-是;根据UI类型自动判断)',
    `rear_ddd` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否使用DTOVO模型',
    `rear_temp` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '后端模板(biz,default)',
    `rear_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '后端 Controller 地址',
    `build_entity` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '实体类是否创建者模式',
    `build_query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '查询类是否创建者模式',
    `build_dto` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'DTO是否创建者模式',
    `build_vo` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'VO是否创建者模式',
    `ask_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '访问地址(全地址, 后端自动拼接:上下文+controller路径)',
    `module_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '模块名(路径)',
    `front_package` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '前端包路径',
    `front_ui_style` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'UI类型',
    `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
    `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
    `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
    `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
    `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
    `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '代码生成业务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for ta_fly_app_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_app_info`;
CREATE TABLE `ta_fly_app_info`  (
   `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'appID',
   `app_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'app秘钥',
   `app_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用标识',
   `app_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用名称',
   `type_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用类型',
   `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用类型标题',
   `ask_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '访问地址',
   `icon_ico` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图标',
   `func_code` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '职能代码',
   `func_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '职能名称',
   `valid_del` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否可删除',
   `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-是;N-否',
   `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
   `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
   `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
   `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '应用信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_app_info
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_auth_clazz_dept
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_auth_clazz_dept`;
CREATE TABLE `ta_fly_auth_clazz_dept`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'ID',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户ID',
  `app_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用ID',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门ID',
  `clazz_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '岗位ID',
  `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-是;N-否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '机构岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_auth_clazz_dept
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_auth_clazz_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_auth_clazz_info`;
CREATE TABLE `ta_fly_auth_clazz_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户ID',
  `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用ID',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门ID',
  `dept_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门名称',
  `type_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '岗位类型ID',
  `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '岗位类型',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '岗位名称',
  `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-是;N-否',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '岗位信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_auth_clazz_info
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_auth_clazz_menu
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_auth_clazz_menu`;
CREATE TABLE `ta_fly_auth_clazz_menu`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'ID',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户ID',
  `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用ID',
  `job_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '岗位ID',
  `meni_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单ID/资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '岗位菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_auth_clazz_menu
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_auth_clazz_role
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_auth_clazz_role`;
CREATE TABLE `ta_fly_auth_clazz_role`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'ID',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户ID',
  `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用ID',
  `job_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '岗位ID',
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '身份岗位管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_auth_clazz_role
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_auth_grant_menu
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_auth_grant_menu`;
CREATE TABLE `ta_fly_auth_grant_menu`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'ID',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户ID',
  `app_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'appID',
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户id',
  `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '权限下发' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_auth_grant_menu
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_dept_info`;
CREATE TABLE `ta_fly_dept_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
  `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户标识/公司标识',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上级ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门名称',
  `title_as` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门简称',
  `type_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门类型ID',
  `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门类型',
  `dept_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门标志: Y-是;N-否',
  `dept_level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门级次',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '联系电话',
  `e_mail_box` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电子邮箱',
  `facsimile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '传真',
  `func_code` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '职能代码',
  `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-是;N-否',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '部门信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_dept_info
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_dept_type
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_dept_type`;
CREATE TABLE `ta_fly_dept_type`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标题',
  `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-有效;N-无效',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '部门类型管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_dept_type
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_dict_data`;
CREATE TABLE `ta_fly_dict_data`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '数据字典ID',
  `type_id` int NULL DEFAULT NULL COMMENT '数据字典类型ID',
  `type_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '数据字典类型',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典标签',
  `dict_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典类型',
  `is_default` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否默认（1是 0否）',
  `dict_sort` int NULL DEFAULT NULL COMMENT '字典排序',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否展示/有效标志: Y-有效;N-无效',
  `create_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '数据字典信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_dict_data
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_dict_type`;
CREATE TABLE `ta_fly_dict_type`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '数据字典类型ID',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典标签',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '字典类型',
  `is_default` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否默认（1是 0否）',
  `dict_sort` int NULL DEFAULT NULL COMMENT '字典排序',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否展示/有效标志: Y-有效;N-无效',
  `create_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建者',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '数据字典类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_login_connection
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_login_connection`;
CREATE TABLE `ta_fly_login_connection`  (
   `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
   `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '系统用户ID(第三方关联时,系统的用户ID)',
   `provider_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '服务提供商提供的id,例如: 微信小程序',
   `provider_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '服务提供商提供的用户id(openId)',
   `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '昵称',
   `profile_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '配置地址',
   `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像地址',
   `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '接口访问凭证',
   `secret_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '秘钥',
   `acccess_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效令牌',
   `refresh_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '刷新令牌',
   `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '第三方登录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_login_connection
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_login_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_login_info`;
CREATE TABLE `ta_fly_login_info`  (
   `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户ID(与 ta_fly_user_info 表保持一致)',
   `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录账号',
   `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录密码',
   `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-有效;N-无效(与 ta_fly_user_info 表保持一致)',
   `exp_time` datetime NULL DEFAULT NULL COMMENT '过期时间(密码过期时间, 有些系统需要定期更新账号的密码)',
   `last_time` datetime NULL DEFAULT NULL COMMENT '上次更新密码时间',
   `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '登录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_login_info
-- ----------------------------
INSERT INTO `ta_fly_login_info` VALUES ('1541230113952239617', 'admin', '$2a$10$XmbU6NITPtycf0qHQsIqtekZUSmC/ZmErQRke9zjsWyOJLKAspy9G', 'Y', '2035-12-31 19:08:04', '2024-04-06 19:08:20', '2024-04-06 19:08:23', '2024-04-06 19:08:26');

-- ----------------------------
-- Table structure for ta_fly_login_record
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_login_record`;
CREATE TABLE `ta_fly_login_record`  (
     `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'ID',
     `app_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'APPID',
     `session_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会话id',
     `nickname` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登陆者姓名',
     `sign_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录方式',
     `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录账号',
     `ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录IP地址',
     `access_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录地点',
     `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '浏览器类型',
     `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作系统',
     `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录状态（0成功 1失败）',
     `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '提示消息',
     `create_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '登录记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_login_record
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_login_record_error
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_login_record_error`;
CREATE TABLE `ta_fly_login_record_error`  (
     `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'ID',
     `app_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'appID',
     `error_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '错误类型',
     `session_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会话ID(sessionId)',
     `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录账号',
     `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '错误密码',
     `verification_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '验证码',
     `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '访问IP',
     `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '错误消息',
     `request_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求ID',
     `os` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作系统',
     `access_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '访问地址',
     `browser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '浏览器',
     `create_time` datetime NULL DEFAULT NULL COMMENT '访问时间',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '登录错误记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_login_record_error
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_oplog_api
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_oplog_api`;
CREATE TABLE `ta_fly_oplog_api`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '接口访问地址(对外接口)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_oplog_api
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_oplog_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_oplog_info`;
CREATE TABLE `ta_fly_oplog_info`  (
   `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
   `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端id: PC端, 微程序, APP等 ',
   `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户id',
   `service_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '服务ID',
   `request_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'http 请求id',
   `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '日志标题: 用户管理, 菜单管理等',
   `type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '日志类型: button, uri',
   `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '日志类型: 按钮, 链接',
   `remote_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作类型: SAVE,UPDATE,JUMP,REMOVE',
   `remote_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作类型: 新增, 修改, 删除, 查看',
   `remote_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作IP地址',
   `remote_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作地址',
   `remote_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作状态: 成功, 失败, 异常',
   `user_agent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户代理',
   `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求URI',
   `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作方式',
   `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '操作提交的数据',
   `json_result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '返回数据',
   `del_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '删除标记',
   `ex_info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '异常信息',
   `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
   `execute_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '服务端处理耗时',
   `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '返回消息',
   `yearly` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '年份',
   `monthly` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '月份',
   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
   `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
   `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
   `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_oplog_info
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_oplog_page
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_oplog_page`;
CREATE TABLE `ta_fly_oplog_page`  (
   `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
   `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端id: PC端, 微程序, APP等 ',
   `tenant_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户id',
   `service_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '服务ID',
   `request_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'http 请求id',
   `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '日志标题: 用户管理, 菜单管理等',
   `page_type` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '页面类型',
   `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '页面类型: 可视化, 后台系统',
   `remote_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作IP地址',
   `remote_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作地址',
   `user_agent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户代理',
   `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '请求URI',
   `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
   `execute_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '服务端处理耗时',
   `del_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '删除标记',
   `yearly` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '年份',
   `monthly` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '月份',
   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
   `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
   `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
   `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '页面访问日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_oplog_page
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_route_element_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_route_element_info`;
CREATE TABLE `ta_fly_route_element_info`  (
     `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源ID',
     `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用ID/appID',
     `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单ID',
     `menu_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单名称',
     `auth_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '认证编码',
     `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类型: button,uri',
     `page_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '页面访问地址',
     `api_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '接口请求地址',
     `http_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'API请求类型: POST/GET/PUT/DELETE',
     `order_num` int NULL DEFAULT NULL COMMENT '排序',
     `third_party` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '第三方平台标识',
     `third_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '第三方平台名称',
     `third_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '第三方基础访问地址, 例如: http://www.baidu.com',
     `ask_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最终访问地址, 根据第三方平台信息拼接',
     `valid_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否展示/有效标志: Y-有效;N-无效',
     `has_auth` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否需要授权: Y-需要;N-不需要',
     `has_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否需要IP授权: Y-需要;N-不需要',
     `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
     `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
     `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
     `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
     `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
     `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '认证资源信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_route_element_info
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_route_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_route_menu_info`;
CREATE TABLE `ta_fly_route_menu_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '菜单ID',
  `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用ID/appId',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上级ID',
  `parent_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上级菜单',
  `auth_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '认证编码',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类型:dirt-目录;menu-菜单;uri-外链;third-第三方平台',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单标题',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '访问地址',
  `lay_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图标',
  `order_num` int NULL DEFAULT NULL COMMENT '排序',
  `valid_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否展示/有效标志: Y-有效;N-无效',
  `open_with` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单打开方式',
  `has_auth` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否需要授权: Y-需要;N-不需要',
  `has_ip` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否需要白名单IP: Y-需要;N-不需要',
  `third_party` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '第三方平台标识',
  `third_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '第三方平台名称',
  `third_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '第三方基础访问地址, 例如: http://www.baidu.com',
  `ask_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最终访问地址, 根据第三方平台信息拼接',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '菜单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_route_menu_info
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_route_white_ip
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_route_white_ip`;
CREATE TABLE `ta_fly_route_white_ip`  (
 `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
 `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '应用ID/appID',
 `ip_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类型: menu-菜单;element-按钮',
 `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单ID',
 `menu_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单名称',
 `element_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '按钮ID',
 `element_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '按钮名称',
 `type_id` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '白名单类型',
 `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '类型名: 固定IP/范围IP',
 `host_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '固定IP',
 `host_ip_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '固定IP的值',
 `start_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '起始IP',
 `start_ip_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '起始IP的值',
 `end_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '结束IP',
 `end_ip_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '结束IP的值',
 `valid_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否展示/有效标志: Y-有效;N-无效',
 `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
 `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
 `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
 `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
 `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '菜单白名单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_route_white_ip
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_tenant_info`;
CREATE TABLE `ta_fly_tenant_info`  (
    `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
    `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上级ID',
    `type_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '行业代码',
    `type_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '行业名称',
    `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '名称',
    `title_as` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '简称',
    `home_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图标',
    `home_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '官网/访问地址',
    `owner_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '拥有者ID',
    `owner_nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '拥有者昵称',
    `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '联系电话',
    `e_mail_box` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电子邮箱',
    `facsimile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '传真',
    `func_code` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '职能代码',
    `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-是;N-否',
    `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
    `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
    `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
    `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
    `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
    `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '租户/公司信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_tenant_info
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_tenant_type
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_tenant_type`;
CREATE TABLE `ta_fly_tenant_type`  (
    `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键唯一标识',
    `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '上级ID',
    `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '名称',
    `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-是;N-否',
    `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
    `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
    `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
    `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
    `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
    `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '行业类型信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_tenant_type
-- ----------------------------

-- ----------------------------
-- Table structure for ta_fly_user_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_user_info`;
CREATE TABLE `ta_fly_user_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户id唯一标识',
  `nick_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '昵称',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份证号码',
  `sex` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '性别',
  `telephone` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电话号码',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像',
  `e_mail_box` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电子邮箱',
  `user_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户类型',
  `valid_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y-是;N-否; 与 ta_fly_login_info 表保持一致',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '基础用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_user_info
-- ----------------------------
INSERT INTO `ta_fly_user_info` VALUES ('1541230113952239617', '王大宸', 'xxxxxxxxxxxxxxxxxx', '1', '18500000000', NULL, 'itdachen@qq.om', 'A', 'Y', '好帅的一个哥', '2024-04-06 19:05:10', NULL, NULL, '2024-04-06 19:05:16', NULL, NULL);

-- ----------------------------
-- Table structure for ta_fly_user_role_info
-- ----------------------------
DROP TABLE IF EXISTS `ta_fly_user_role_info`;
CREATE TABLE `ta_fly_user_role_info`  (
 `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '身份ID',
 `tenant_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '租户ID',
 `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户ID',
 `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份名称',
 `role_flag` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主身份标志: Y/N',
 `valid_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '有效标志: Y/N',
 `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份部门ID',
 `dept_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份部门名称',
 `start_time` datetime NULL DEFAULT NULL COMMENT '身份有效期起',
 `end_time` datetime NULL DEFAULT NULL COMMENT '身份有效期止',
 `order_num` int NULL DEFAULT NULL COMMENT '排序',
 `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
 `create_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人id',
 `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
 `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
 `update_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人id',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '身份角色信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ta_fly_user_role_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
