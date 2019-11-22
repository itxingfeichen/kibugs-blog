package com.kibugs.blog.web.web;

import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.web.service.KbCategoryService;
import com.kibugs.blog.web.service.KbTagService;
import com.kibugs.blog.web.service.KbBugsBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public CommonResponse loadMore(Integer current, String type, Long objectId) {
        log.info("params={},{}", current, type);
        String data = new StringBuilder().append("<div class=\"ui padded segment vertical ki-padded-tb-large ki-padded-lr-response ki-padded-tb-large ki-padded-lr-clear\">\n").append("<div class=\"ui mobile reversed stackable grid\">\n").append("<div class=\"eleven wide column\">\n").append("<h3 class=\"ui header\">\n").append("<a href=\"/blog/detail/1\" class=\"header\">标题</a></h3>\n").append("<p class=\"ki-text\">昨天，35岁的表姐把我拉黑了。 表姐是医院有名的好护士，脾气好，耐心足，对谁都笑眯眯。 最近小半年，他们医院在搞评职称，指标之一就是护士的论文发布情况。 得知消息后，表姐开始着手发布职称论文，与此同时，我的噩梦也来了。 获得授权，非商业转载请注明出处。......</p>\n").append("<div class=\"ui stackable  grid\">\n").append("<div class=\"eleven wide column\">\n").append("<div class=\"ui horizontal link list mini\">\n").append("<div class=\"item\">\n").append("<img src=\"https://picsum.photos/id/1011/367/267\" alt=\"头像地址\" class=\"ui avatar image\">\n").append("<div class=\"content inverted\">\n").append("<a href=\"#\" class=\"header\">爱折腾</a>\n").append("</div>\n").append("</div>\n").append("<div class=\"item\">\n").append("<i class=\"calendar icon\"></i><span>2019-11-02</span>\n").append("</div>\n").append("<div class=\"item\">\n").append("<i class=\"eye icon\"></i><span>123</span>\n").append("</div>\n").append("\n").append("</div>\n").append("</div>\n").append("<div class=\"right aligned ui five wide column\">\n").append("<a href=\"#\" class=\"ui teal basic label ki-padded-tiny ki-text-thin\">核心技术</a>\n").append("</div>\n").append("\n").append("</div>\n").append("\n").append("</div>\n").append("<div class=\"ui five wide column\">\n").append("<a href=\"@{/blog/detail/{id}(id=${blog.id})}\" target=\"_blank\">\n").append("<img src=\"https://picsum.photos/seed/picsum/800/450\" alt=\"\" class=\"ui rounded image ki-padded-tb-big ki-text-thin\" style=\"width:800px;height:200px\">\n").append("</a>\n").append("\n").append("</div>\n").append("</div>\n").append("</div>").toString();

        return CommonResponse.success(data);
    }


}
