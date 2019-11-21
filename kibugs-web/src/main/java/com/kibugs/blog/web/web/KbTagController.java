package com.kibugs.blog.web.web;


import com.kibugs.blog.web.service.KbBugsBlogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@RestController
@RequestMapping("/blog/kb-tag")
public class KbTagController {

    private final KbBugsBlogService blogService;

    public KbTagController(KbBugsBlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 跳转到分类首页
     *
     * @param tagId 标签ID
     * @return ModelAndView
     */
    @RequestMapping("index")
    public ModelAndView toIndex(@RequestParam(value = "tagId", required = false) Long tagId) {
        ModelAndView modelAndView = new ModelAndView("/tag/index");
        blogService.indexPageForTag(modelAndView, tagId);

        return modelAndView;
    }

}

