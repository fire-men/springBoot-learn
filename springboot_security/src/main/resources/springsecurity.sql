/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : springsecurity

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 25/11/2021 16:33:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_operate
-- ----------------------------
DROP TABLE IF EXISTS `sys_operate`;
CREATE TABLE `sys_operate`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `operate_range` int(1) DEFAULT NULL COMMENT '0:add 1:delete 2:update 3:select',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_operate
-- ----------------------------
INSERT INTO `sys_operate` VALUES (1, 0);
INSERT INTO `sys_operate` VALUES (2, 1);
INSERT INTO `sys_operate` VALUES (3, 2);
INSERT INTO `sys_operate` VALUES (4, 3);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin');
INSERT INTO `sys_role` VALUES (2, 'visitor');

-- ----------------------------
-- Table structure for sys_role_operate
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_operate`;
CREATE TABLE `sys_role_operate`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `role_id` int(16) DEFAULT NULL,
  `operate_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_operate
-- ----------------------------
INSERT INTO `sys_role_operate` VALUES (1, 1, 1);
INSERT INTO `sys_role_operate` VALUES (2, 1, 2);
INSERT INTO `sys_role_operate` VALUES (3, 1, 3);
INSERT INTO `sys_role_operate` VALUES (4, 1, 4);
INSERT INTO `sys_role_operate` VALUES (5, 2, 4);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nick_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `state` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:失效 2:被锁定',
  `is_delete` int(1) NOT NULL DEFAULT 0 COMMENT '0:正常 1:被删除',
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '韩信', '$2a$10$/zumt9w3uwK0BTpD7i.YI.3zTxzH1zOsCkiN8uCmct9LUonNfxxFC', '韩跳跳', '河北正定县', 'hanxin@qq.com', '我位移贼多', 0, 0, 'zs', '2021-11-25 14:01:42', 'zs', '2021-11-25 14:01:42');
INSERT INTO `sys_user` VALUES (2, '马超', '$2a$10$/zumt9w3uwK0BTpD7i.YI.3zTxzH1zOsCkiN8uCmct9LUonNfxxFC', '马屁精', '山东济南', 'machao@qq.com', '我很秀', 0, 0, 'zs', '2021-11-25 14:04:57', 'zs', '2021-11-25 14:04:57');
INSERT INTO `sys_user` VALUES (3, '关羽', '$2a$10$/zumt9w3uwK0BTpD7i.YI.3zTxzH1zOsCkiN8uCmct9LUonNfxxFC', '马上到来', '山东济南', 'guanyu@qq.com', '我很秀123', 0, 0, 'zs', '2021-11-25 14:06:51', 'zs', '2021-11-25 14:06:51');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_id` int(16) DEFAULT NULL,
  `role_id` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 2);
INSERT INTO `sys_user_role` VALUES (3, 3, 2);
INSERT INTO `sys_user_role` VALUES (4, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
