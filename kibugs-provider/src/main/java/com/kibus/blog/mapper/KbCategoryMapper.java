package com.kibus.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kibug.blog.common.entity.KbCategory;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
public interface KbCategoryMapper extends BaseMapper<KbCategory> {


    /**
     * 获取top5分类（默认返回博客数量最多的5种分类）
     * @return
     */
    @Select({"select category.name,count(blog.category_id) num from kb_blog blog left join kb_category category on blog.category_id = category.id group by blog.category_id;"})
    List<Map<String,Integer>>  getCategoryTop5();

}
