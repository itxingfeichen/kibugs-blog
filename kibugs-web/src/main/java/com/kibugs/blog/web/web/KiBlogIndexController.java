package com.kibugs.blog.web.web;

import com.kibugs.blog.web.service.KbCategoryService;
import com.kibugs.blog.web.service.KiBugsBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : chenxingfei
 * @date: 2019-11-01  07:04
 * @description: 博客首页
 */
@RequestMapping
@Controller
public class KiBlogIndexController {

    private final KiBugsBlogService kiBugsBlogService;

    private final KbCategoryService categoryService;

    public KiBlogIndexController(KiBugsBlogService kiBugsBlogService, KbCategoryService categoryService) {
        this.kiBugsBlogService = kiBugsBlogService;
        this.categoryService = categoryService;
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("page",kiBugsBlogService.indexPage(1, 20));
        modelAndView.addObject("categoryTop5",categoryService.getCategoryTop5());
        return modelAndView;
    }


}
