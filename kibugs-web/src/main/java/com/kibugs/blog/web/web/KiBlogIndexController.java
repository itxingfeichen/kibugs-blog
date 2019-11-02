package com.kibugs.blog.web.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kibug.blog.common.entity.KbBlog;
import com.kibugs.blog.web.service.KiBugsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private KiBugsBlogService kiBugsBlogService;


    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");
        IPage<KbBlog> page = kiBugsBlogService.indexPage(1, 20);
        modelAndView.addObject("page",page);
        return modelAndView;
    }


}
