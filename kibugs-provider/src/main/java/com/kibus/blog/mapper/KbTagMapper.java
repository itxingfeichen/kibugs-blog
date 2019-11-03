package com.kibus.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kibug.blog.common.entity.KbTag;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
public interface KbTagMapper extends BaseMapper<KbTag> {

    /**
     * 获取top10标签
     * @return
     */
    @Select({"select tag.name,count(kbt.tag_id) num from kb_blog_tag kbt left join kb_blog kb on kbt.blog_id=kb.id left join kb_tag tag on kbt.tag_id = tag.id where kb.delete_status=0 and kb.publish_status=1  group by kbt.tag_id limit 10;"})
    List<Map<String,Integer>> getTagsForTop10();

}
