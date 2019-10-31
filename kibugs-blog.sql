create table kb_blog
(
    id                bigint auto_increment comment '主键'
        primary key,
    title             varchar(1000)     not null comment '博客标题',
    context           longtext          not null comment '博客内容',
    publish_status    tinyint default 0 null comment '发布状态（1：已发布，0：待发布）',
    customer_id       bigint            not null comment '用户id',
    first_image_url   varchar(255)      not null comment '首图地址',
    blog_type         tinyint           null comment '博客类型（0：原创，1：转载，2：翻译）',
    appreciate_status tinyint default 0 null comment '赞赏按钮开关（0：关闭，1：开启）',
    category_id       bigint            not null comment '分类ID',
    publish_time      timestamp         null comment '发布时间',
    create_time       timestamp         null comment '创建时间',
    update_time       timestamp         null comment '更新时间'
);

