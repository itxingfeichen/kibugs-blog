/*
Navicat MySQL Data Transfer

Source Server         : 本地虚拟机数据源(192.168.3.128)
Source Server Version : 50724
Source Host           : 192.168.3.128:3306
Source Database       : kibugs-blog

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-11-01 18:37:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kb_blog
-- ----------------------------
DROP TABLE IF EXISTS `kb_blog`;
CREATE TABLE `kb_blog` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '博客标题',
  `context` longtext COLLATE utf8mb4_bin NOT NULL COMMENT '博客内容',
  `publish_status` tinyint(4) DEFAULT '0' COMMENT '发布状态（1：已发布，0：待发布）',
  `customer_id` bigint(20) NOT NULL COMMENT '用户id',
  `first_image_url` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '首图地址',
  `blog_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '博客类型（0：原创，1：转载，2：翻译）',
  `appreciate_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '打赏按钮开关（0：关闭，1：开启）',
  `prise_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '点赞按钮开关（0：关闭，1：开启）',
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  `delete_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记（1：已删除，0：未删除）',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='博客表';

-- ----------------------------
-- Records of kb_blog
-- ----------------------------

-- ----------------------------
-- Table structure for kb_blog_category
-- ----------------------------
DROP TABLE IF EXISTS `kb_blog_category`;
CREATE TABLE `kb_blog_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_id` bigint(20) NOT NULL COMMENT '博客id',
  `category_id` bigint(20) NOT NULL COMMENT '分类id',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='博客分类映射表';

-- ----------------------------
-- Records of kb_blog_category
-- ----------------------------

-- ----------------------------
-- Table structure for kb_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `kb_blog_tag`;
CREATE TABLE `kb_blog_tag` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_id` bigint(20) NOT NULL COMMENT '博客id',
  `tag_id` bigint(20) NOT NULL COMMENT '标签id',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='博客分类映射表';

-- ----------------------------
-- Records of kb_blog_tag
-- ----------------------------

-- ----------------------------
-- Table structure for kb_category
-- ----------------------------
DROP TABLE IF EXISTS `kb_category`;
CREATE TABLE `kb_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '分类名称',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='分类表';

-- ----------------------------
-- Records of kb_category
-- ----------------------------

-- ----------------------------
-- Table structure for kb_comment
-- ----------------------------
DROP TABLE IF EXISTS `kb_comment`;
CREATE TABLE `kb_comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_id` bigint(20) NOT NULL COMMENT '博客id',
  `customer_id` bigint(20) NOT NULL COMMENT '评论用户id',
  `be_commented_customer_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '被评论用户id，-1代表主动评论',
  `parent_comment_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '被评论id，默认为-1代表顶层评论',
  `praise_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可以点赞（1：可以，0：不可以）',
  `content` text COLLATE utf8mb4_bin NOT NULL COMMENT '评论内容',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='评论表';

-- ----------------------------
-- Records of kb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for kb_customer
-- ----------------------------
DROP TABLE IF EXISTS `kb_customer`;
CREATE TABLE `kb_customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cell_phone` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号',
  `username` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '实际名称',
  `nickname` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '昵称',
  `email` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '邮箱',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '登录密码',
  `user_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '用户状态(0：正常，1：已禁用)',
  `avatar_url` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '头像地址',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of kb_customer
-- ----------------------------

-- ----------------------------
-- Table structure for kb_praise
-- ----------------------------
DROP TABLE IF EXISTS `kb_praise`;
CREATE TABLE `kb_praise` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` bigint(20) NOT NULL COMMENT '被评论项目id（根据type区分，type为COMMENT则为评论id，type为BLOG则为博客id）',
  `type` char(64) COLLATE utf8mb4_bin NOT NULL COMMENT '点赞类型',
  `customer_id` bigint(20) NOT NULL COMMENT '点赞用户id',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='点赞表';

-- ----------------------------
-- Records of kb_praise
-- ----------------------------

-- ----------------------------
-- Table structure for kb_tag
-- ----------------------------
DROP TABLE IF EXISTS `kb_tag`;
CREATE TABLE `kb_tag` (
  `id` bigint(20) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='标签表';

-- ----------------------------
-- Records of kb_tag
-- ----------------------------
