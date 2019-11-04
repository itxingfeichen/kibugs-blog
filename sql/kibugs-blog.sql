create table kb_blog
(
    id                bigint unsigned auto_increment comment '主键'
        primary key,
    title             varchar(255)                         not null comment '博客标题',
    description       text                                 null comment '描述',
    publish_status    tinyint    default 0                 null comment '发布状态（1：已发布，0：待发布）',
    customer_id       bigint                               not null comment '用户id',
    first_image_url   varchar(255)                         not null comment '首图地址',
    blog_type         tinyint(1) default 0                 not null comment '博客类型（0：原创，1：转载，2：翻译）',
    appreciate_status tinyint(1) default 0                 not null comment '打赏按钮开关（0：关闭，1：开启）',
    prise_status      tinyint(1) default 0                 not null comment '点赞按钮开关（0：关闭，1：开启）',
    category_id       bigint                               not null comment '分类ID',
    delete_status     tinyint(1) default 0                 not null comment '删除标记（1：已删除，0：未删除）',
    views             int        default 0                 null comment '查看次数（被点击一次详情增加一次）',
    recommend         tinyint    default 0                 not null comment '是否推荐（0：不推荐，1：推荐）',
    publish_time      timestamp                            null comment '发布时间',
    create_time       timestamp  default CURRENT_TIMESTAMP null comment '创建时间',
    update_time       timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '博客表' collate = utf8mb4_bin;

create table kb_blog_category
(
    id          bigint unsigned auto_increment comment '主键'
        primary key,
    blog_id     bigint                             not null comment '博客id',
    category_id bigint                             not null comment '分类id',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间'
)
    comment '博客分类映射表' collate = utf8mb4_bin;

create table kb_blog_tag
(
    id          bigint unsigned auto_increment comment '主键'
        primary key,
    blog_id     bigint                             not null comment '博客id',
    tag_id      bigint                             not null comment '标签id',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间'
)
    comment '博客分类映射表' collate = utf8mb4_bin;

create table kb_category
(
    id          bigint unsigned auto_increment comment '主键'
        primary key,
    name        varchar(128)                           not null comment '分类名称',
    remark      varchar(255) default ''                not null comment '备注',
    update_time datetime     default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    create_time datetime     default CURRENT_TIMESTAMP null comment '创建时间'
)
    comment '分类表' collate = utf8mb4_bin;

create table kb_comment
(
    id                       bigint unsigned auto_increment comment '主键'
        primary key,
    blog_id                  bigint                               not null comment '博客id',
    customer_id              bigint                               not null comment '评论用户id',
    be_commented_customer_id bigint     default -1                not null comment '被评论用户id，-1代表主动评论',
    parent_comment_id        bigint     default -1                not null comment '被评论id，默认为-1代表顶层评论',
    praise_status            tinyint(1) default 0                 not null comment '是否可以点赞（1：可以，0：不可以）',
    content                  text                                 not null comment '评论内容',
    update_time              datetime   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    create_time              datetime   default CURRENT_TIMESTAMP null comment '创建时间'
)
    comment '评论表' collate = utf8mb4_bin;

create table kb_customer
(
    id          bigint unsigned auto_increment comment '主键'
        primary key,
    cell_phone  varchar(128)                         not null comment '手机号',
    username    varchar(128)                         not null comment '实际名称',
    nickname    varchar(128)                         null comment '昵称',
    email       varchar(128)                         not null comment '邮箱',
    password    varchar(255)                         not null comment '登录密码',
    user_status tinyint(1) default 0                 not null comment '用户状态(0：正常，1：已禁用)',
    avatar_url  varchar(255)                         not null comment '头像地址',
    update_time datetime   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    create_time datetime   default CURRENT_TIMESTAMP not null comment '创建时间'
)
    collate = utf8mb4_bin;

create table kb_praise
(
    id          bigint unsigned auto_increment
        primary key,
    project_id  bigint                             not null comment '被评论项目id（根据type区分，type为COMMENT则为评论id，type为BLOG则为博客id）',
    type        char(64)                           not null comment '点赞类型',
    customer_id bigint                             not null comment '点赞用户id',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    create_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间'
)
    comment '点赞表' collate = utf8mb4_bin;

create table kb_tag
(
    id          bigint auto_increment,
    name        varchar(128)                           not null,
    remark      varchar(255) default ''                null,
    update_time datetime     default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    create_time datetime     default CURRENT_TIMESTAMP null,
    constraint kb_tag_id_uindex
        unique (id)
)
    comment '标签表' collate = utf8mb4_bin;

alter table kb_tag
    add primary key (id);


