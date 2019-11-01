CREATE TABLE `kb_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(1000) COLLATE utf8mb4_bin NOT NULL COMMENT '博客标题',
  `context` longtext COLLATE utf8mb4_bin NOT NULL COMMENT '博客内容',
  `publish_status` tinyint(4) DEFAULT '0' COMMENT '发布状态（1：已发布，0：待发布）',
  `customer_id` bigint(20) NOT NULL COMMENT '用户id',
  `first_image_url` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '首图地址',
  `blog_type` tinyint(4) DEFAULT NULL COMMENT '博客类型（0：原创，1：转载，2：翻译）',
  `appreciate_status` tinyint(4) DEFAULT '0' COMMENT '赞赏按钮开关（0：关闭，1：开启）',
  `category_id` bigint(20) NOT NULL COMMENT '分类ID',
  `delete_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记（1：已删除，0：未删除）',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;