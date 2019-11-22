package com.kibugs.blog.web.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kibug.blog.common.entity.KbBlog;
import com.kibug.blog.common.enums.PageType;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.web.service.KbBugsBlogService;
import com.kibugs.blog.web.service.KbCategoryService;
import com.kibugs.blog.web.service.KbTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-11-01  07:04
 * @description: 博客首页
 */
@Slf4j
@Controller
@RequestMapping
public class KiBlogIndexController extends BaseController {

    private final KbBugsBlogService kiBugsBlogService;

    private final KbCategoryService categoryService;

    private final KbTagService tagService;

    public KiBlogIndexController(KbBugsBlogService kiBugsBlogService, KbCategoryService categoryService, KbTagService tagService) {
        this.kiBugsBlogService = kiBugsBlogService;
        this.categoryService = categoryService;
        this.tagService = tagService;
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("customer", getCurrentCustomer(request));
        kiBugsBlogService.indexPage(modelAndView);
        return modelAndView;
    }

    @RequestMapping("loadMore")
    @ResponseBody
    public CommonResponse loadMore(Integer current, PageType type, Long objectId) {

        log.info("params={},{}", current, type);
        final CommonResponse<IPage<KbBlog>> commonResponse = kiBugsBlogService.loadMore(type, current, objectId);
        final IPage<KbBlog> page = commonResponse.getData();
        final List<KbBlog> records = page.getRecords();
        final StringBuilder result = new StringBuilder();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(CollectionUtils.isEmpty(records)){
            records.forEach(kbBlog -> result.append("<div class=\"ui padded segment vertical ki-padded-tb-large ki-padded-lr-response ki-padded-tb-large ki-padded-lr-clear\">\n")
                    .append("<div class=\"ui mobile reversed stackable grid\">\n").append("<div class=\"eleven wide column\">\n").append("<h3 class=\"ui header\">\n")
                    .append("<a href=\"/blog/detail/1\" class=\"header\">标题</a></h3>\n")
                    .append("<p class=\"ki-text\">"+kbBlog.getDescription()+"</p>\n")
                    .append("<div class=\"ui stackable  grid\">\n")
                    .append("<div class=\"eleven wide column\">\n")
                    .append("<div class=\"ui horizontal link list mini\">\n")
                    .append("<div class=\"item\">\n")
                    .append("<img src=\""+kbBlog.getCustomer().getAvatarUrl()+"\" alt=\"头像地址\" class=\"ui avatar image\">\n").append("<div class=\"content inverted\">\n")
                    .append("<a href=\"#\" class=\"header\">"+kbBlog.getCustomer().getNickname()+"</a>\n")
                    .append("</div>\n")
                    .append("</div>\n")
                    .append("<div class=\"item\">\n")
                    .append("<i class=\"calendar icon\"></i><span>"+dateFormat.format(kbBlog.getPublishTime())+"</span>\n")
                    .append("</div>\n")
                    .append("<div class=\"item\">\n")
                    .append("<i class=\"eye icon\"></i><span>"+kbBlog.getViews()+"</span>\n")
                    .append("</div>\n")
                    .append("</div>\n")
                    .append("</div>\n")
                    .append("<div class=\"right aligned ui five wide column\">\n")
                    .append("<a href=\"#\" class=\"ui teal basic label ki-padded-tiny ki-text-thin\">"+kbBlog.getCategory().getName()+"</a>\n")
                    .append("</div>\n").append("\n")
                    .append("</div>\n")
                    .append("</div>\n")
                    .append("<div class=\"ui five wide column\">\n")
                    .append("<a href=\"/blog/detail?id="+kbBlog.getId()+"\" target=\"_blank\">\n")
                    .append("<img src=\""+kbBlog.getFirstImageUrl()+"\" alt=\"\" class=\"ui rounded image ki-padded-tb-big ki-text-thin\" style=\"width:800px;height:200px\">\n")
                    .append("</a>\n").append("\n").append("</div>\n").append("</div>\n").append("</div>").toString());
        }
        return CommonResponse.success(result.toString());
    }


}
