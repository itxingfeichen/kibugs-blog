/*
Navicat MySQL Data Transfer

Source Server         : 本地虚拟机数据源(192.168.3.128)
Source Server Version : 50724
Source Host           : 192.168.3.128:3306
Source Database       : kibugs-blog

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-11-05 17:47:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kb_blog
-- ----------------------------
DROP TABLE IF EXISTS `kb_blog`;
CREATE TABLE `kb_blog` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '博客标题',
  `description` text COLLATE utf8mb4_bin COMMENT '描述',
  `publish_status` tinyint(4) DEFAULT '0' COMMENT '发布状态（1：已发布，0：待发布）',
  `customer_id` bigint(20) NOT NULL COMMENT '用户id',
  `first_image_url` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '首图地址',
  `blog_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '博客类型（0：原创，1：转载，2：翻译）',
  `appreciate_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '打赏按钮开关（0：关闭，1：开启）',
  `prise_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '点赞按钮开关（0：关闭，1：开启）',
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  `delete_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记（1：已删除，0：未删除）',
  `views` int(11) DEFAULT '0' COMMENT '查看次数（被点击一次详情增加一次）',
  `recommend` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否推荐（0：不推荐，1：推荐）',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='博客表';

-- ----------------------------
-- Records of kb_blog
-- ----------------------------
INSERT INTO `kb_blog` VALUES ('1', '标题', 0xE698A8E5A4A9EFBC8C3335E5B281E79A84E8A1A8E5A790E68A8AE68891E68B89E9BB91E4BA86E3808220E8A1A8E5A790E698AFE58CBBE999A2E69C89E5908DE79A84E5A5BDE68AA4E5A3ABEFBC8CE884BEE6B094E5A5BDEFBC8CE88090E5BF83E8B6B3EFBC8CE5AFB9E8B081E983BDE7AC91E79CAFE79CAFE3808220E69C80E8BF91E5B08FE58D8AE5B9B4EFBC8CE4BB96E4BBACE58CBBE999A2E59CA8E6909EE8AF84E8818CE7A7B0EFBC8CE68C87E6A087E4B98BE4B880E5B0B1E698AFE68AA4E5A3ABE79A84E8AEBAE69687E58F91E5B883E68385E586B5E3808220E5BE97E79FA5E6B688E681AFE5908EEFBC8CE8A1A8E5A790E5BC80E5A78BE79D80E6898BE58F91E5B883E8818CE7A7B0E8AEBAE69687EFBC8CE4B88EE6ADA4E5908CE697B6EFBC8CE68891E79A84E599A9E6A2A6E4B99FE69DA5E4BA86E3808220E88EB7E5BE97E68E88E69D83EFBC8CE99D9EE59586E4B89AE8BDACE8BDBDE8AFB7E6B3A8E6988EE587BAE5A484E38082, '1', '1', 'https://picsum.photos/seed/picsum/800/450', '1', '1', '1', '1', '0', '123', '0', '2019-11-02 10:53:13', '2019-11-02 10:53:17', '2019-11-02 21:21:47');
INSERT INTO `kb_blog` VALUES ('2', '把我拉黑3', 0xE698A8E5A4A9EFBC8C3335E5B281E79A84E8A1A8E5A790E68A8AE68891E68B89E9BB91E4BA86E3808220E8A1A8E5A790E698AFE58CBBE999A2E69C89E5908DE79A84E5A5BDE68AA4E5A3ABEFBC8CE884BEE6B094E5A5BDEFBC8CE88090E5BF83E8B6B3EFBC8CE5AFB9E8B081E983BDE7AC91E79CAFE79CAFE3808220E69C80E8BF91E5B08FE58D8AE5B9B4EFBC8CE4BB96E4BBACE58CBBE999A2E59CA8E6909EE8AF84E8818CE7A7B0EFBC8CE68C87E6A087E4B98BE4B880E5B0B1E698AFE68AA4E5A3ABE79A84E8AEBAE69687E58F91E5B883E68385E586B5E3808220E5BE97E79FA5E6B688E681AFE5908EEFBC8CE8A1A8E5A790E5BC80E5A78BE79D80E6898BE58F91E5B883E8818CE7A7B0E8AEBAE69687EFBC8CE4B88EE6ADA4E5908CE697B6EFBC8CE68891E79A84E599A9E6A2A6E4B99FE69DA5E4BA86E3808220E88EB7E5BE97E68E88E69D83EFBC8CE99D9EE59586E4B89AE8BDACE8BDBDE8AFB7E6B3A8E6988EE587BAE5A484E38082, '1', '1', 'https://picsum.photos/seed/picsum/800/450', '1', '1', '1', '1', '0', '123', '0', '2019-11-02 10:53:13', '2019-11-02 10:53:17', '2019-11-02 21:24:32');
INSERT INTO `kb_blog` VALUES ('3', '把我拉黑4', 0xE698A8E5A4A9EFBC8C3335E5B281E79A84E8A1A8E5A790E68A8AE68891E68B89E9BB91E4BA86E3808220E8A1A8E5A790E698AFE58CBBE999A2E69C89E5908DE79A84E5A5BDE68AA4E5A3ABEFBC8CE884BEE6B094E5A5BDEFBC8CE88090E5BF83E8B6B3EFBC8CE5AFB9E8B081E983BDE7AC91E79CAFE79CAFE3808220E69C80E8BF91E5B08FE58D8AE5B9B4EFBC8CE4BB96E4BBACE58CBBE999A2E59CA8E6909EE8AF84E8818CE7A7B0EFBC8CE68C87E6A087E4B98BE4B880E5B0B1E698AFE68AA4E5A3ABE79A84E8AEBAE69687E58F91E5B883E68385E586B5E3808220E5BE97E79FA5E6B688E681AFE5908EEFBC8CE8A1A8E5A790E5BC80E5A78BE79D80E6898BE58F91E5B883E8818CE7A7B0E8AEBAE69687EFBC8CE4B88EE6ADA4E5908CE697B6EFBC8CE68891E79A84E599A9E6A2A6E4B99FE69DA5E4BA86E3808220E88EB7E5BE97E68E88E69D83EFBC8CE99D9EE59586E4B89AE8BDACE8BDBDE8AFB7E6B3A8E6988EE587BAE5A484E38082, '1', '1', 'https://images.unsplash.com/photo-1451337516015-6b6e9a44a8a3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1267&q=80', '1', '1', '1', '2', '0', '123', '0', '2019-11-02 10:53:13', '2019-11-02 10:53:17', '2019-11-02 22:44:04');
INSERT INTO `kb_blog` VALUES ('10', '把我拉黑2把我拉黑2把我拉黑2把我拉黑2', 0xE698A8E5A4A9EFBC8C3335E5B281E79A84E8A1A8E5A790E68A8AE68891E68B89E9BB91E4BA86E3808220E8A1A8E5A790E698AFE58CBBE999A2E69C89E5908DE79A84E5A5BDE68AA4E5A3ABEFBC8CE884BEE6B094E5A5BDEFBC8CE88090E5BF83E8B6B3EFBC8CE5AFB9E8B081E983BDE7AC91E79CAFE79CAFE3808220E69C80E8BF91E5B08FE58D8AE5B9B4EFBC8CE4BB96E4BBACE58CBBE999A2E59CA8E6909EE8AF84E8818CE7A7B0EFBC8CE68C87E6A087E4B98BE4B880E5B0B1E698AFE68AA4E5A3ABE79A84E8AEBAE69687E58F91E5B883E68385E586B5E3808220E5BE97E79FA5E6B688E681AFE5908EEFBC8CE8A1A8E5A790E5BC80E5A78BE79D80E6898BE58F91E5B883E8818CE7A7B0E8AEBAE69687EFBC8CE4B88EE6ADA4E5908CE697B6EFBC8CE68891E79A84E599A9E6A2A6E4B99FE69DA5E4BA86E3808220E88EB7E5BE97E68E88E69D83EFBC8CE99D9EE59586E4B89AE8BDACE8BDBDE8AFB7E6B3A8E6988EE587BAE5A484E38082, '1', '1', 'https://picsum.photos/seed/picsum/800/450', '1', '1', '1', '2', '0', '123', '1', '2019-11-02 10:53:13', '2019-11-02 10:53:17', '2019-11-03 14:58:42');
INSERT INTO `kb_blog` VALUES ('11', '把我拉黑3', 0xE698A8E5A4A9EFBC8C3335E5B281E79A84E8A1A8E5A790E68A8AE68891E68B89E9BB91E4BA86E3808220E8A1A8E5A790E698AFE58CBBE999A2E69C89E5908DE79A84E5A5BDE68AA4E5A3ABEFBC8CE884BEE6B094E5A5BDEFBC8CE88090E5BF83E8B6B3EFBC8CE5AFB9E8B081E983BDE7AC91E79CAFE79CAFE3808220E69C80E8BF91E5B08FE58D8AE5B9B4EFBC8CE4BB96E4BBACE58CBBE999A2E59CA8E6909EE8AF84E8818CE7A7B0EFBC8CE68C87E6A087E4B98BE4B880E5B0B1E698AFE68AA4E5A3ABE79A84E8AEBAE69687E58F91E5B883E68385E586B5E3808220E5BE97E79FA5E6B688E681AFE5908EEFBC8CE8A1A8E5A790E5BC80E5A78BE79D80E6898BE58F91E5B883E8818CE7A7B0E8AEBAE69687EFBC8CE4B88EE6ADA4E5908CE697B6EFBC8CE68891E79A84E599A9E6A2A6E4B99FE69DA5E4BA86E3808220E88EB7E5BE97E68E88E69D83EFBC8CE99D9EE59586E4B89AE8BDACE8BDBDE8AFB7E6B3A8E6988EE587BAE5A484E38082, '1', '1', 'https://picsum.photos/seed/picsum/800/450', '1', '1', '1', '1', '0', '123', '1', '2019-11-02 10:53:13', '2019-11-02 10:53:17', '2019-11-03 14:11:07');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='博客分类映射表';

-- ----------------------------
-- Records of kb_blog_tag
-- ----------------------------
INSERT INTO `kb_blog_tag` VALUES ('1', '1', '1', '2019-11-03 10:54:08', '2019-11-03 10:54:08');
INSERT INTO `kb_blog_tag` VALUES ('2', '3', '3', '2019-11-03 10:57:59', '2019-11-03 10:57:59');
INSERT INTO `kb_blog_tag` VALUES ('3', '2', '2', '2019-11-03 10:58:09', '2019-11-03 10:58:09');
INSERT INTO `kb_blog_tag` VALUES ('4', '10', '4', '2019-11-03 10:59:15', '2019-11-03 10:58:15');
INSERT INTO `kb_blog_tag` VALUES ('5', '11', '4', '2019-11-03 11:03:01', '2019-11-03 10:58:24');

-- ----------------------------
-- Table structure for kb_category
-- ----------------------------
DROP TABLE IF EXISTS `kb_category`;
CREATE TABLE `kb_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '分类名称',
  `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='分类表';

-- ----------------------------
-- Records of kb_category
-- ----------------------------
INSERT INTO `kb_category` VALUES ('1', '核心技术', '核心技术', '2019-11-02 21:20:10', '2019-11-02 21:20:10');
INSERT INTO `kb_category` VALUES ('2', '执行合一', '核心技术', '2019-11-02 22:44:31', '2019-11-02 22:44:31');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of kb_customer
-- ----------------------------
INSERT INTO `kb_customer` VALUES ('1', '18613892254', 'jannik', '爱折腾', '', '123', '0', 'https://picsum.photos/id/1011/367/267', '2019-11-02 21:35:26', '2019-11-02 20:20:07');

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `kb_tag_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='标签表';

-- ----------------------------
-- Records of kb_tag
-- ----------------------------
INSERT INTO `kb_tag` VALUES ('1', 'java', 'java', '2019-11-03 10:52:53', '2019-11-03 10:53:41');
INSERT INTO `kb_tag` VALUES ('2', 'python', 'python', '2019-11-03 10:56:54', '2019-11-03 10:56:54');
INSERT INTO `kb_tag` VALUES ('3', 'JavaScript', '', '2019-11-03 11:10:03', '2019-11-03 10:57:35');
INSERT INTO `kb_tag` VALUES ('4', 'go', '', '2019-11-03 10:57:43', '2019-11-03 10:57:43');

-- ----------------------------
-- 2019-11-04
-- ----------------------------
alter table kb_blog add commentStatus tinyint default 0 null comment '评论开关（0：关闭，1：开启）';

alter table kb_blog add reprintStatus tinyint default 0 null comment '转载声明（0：不需要，1：需要）';

create table `kibugs-blog`.kb_blog_detail
(
  id      bigint auto_increment comment '主键'
    primary key,
  blog_id tinyint  not null comment '博客ID',
  content longtext not null comment '博客内容'
);
-- ----------------------------
-- 2019-11-06
-- ----------------------------
alter table `kb_blog` convert to character set utf8;

alter table `kb_blog_detail` convert to character set utf8;


alter table `kb_blog_category` convert to character set utf8;

alter table `kb_blog_tag` convert to character set utf8;

alter table `kb_category` convert to character set utf8;

alter table `kb_comment` convert to character set utf8;

alter table `kb_customer` convert to character set utf8;

alter table `kb_tag` convert to character set utf8;

alter table `kb_praise` convert to character set utf8;

alter table `kb_comment` add  `delete_status` tinyint default 0  null comment '删除状态（1：已删除，0：未删除）
