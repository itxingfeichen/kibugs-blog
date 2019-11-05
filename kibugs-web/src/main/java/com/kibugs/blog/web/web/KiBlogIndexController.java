package com.kibugs.blog.web.web;

import com.kibugs.blog.web.service.KbCategoryService;
import com.kibugs.blog.web.service.KbTagService;
import com.kibugs.blog.web.service.KbBugsBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : chenxingfei
 * @date: 2019-11-01  07:04
 * @description: 博客首页
 */
@RequestMapping
@Controller
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
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("customer",getCurrentCustomer(request));
        kiBugsBlogService.indexPage(modelAndView);
        return modelAndView;
    }


}
