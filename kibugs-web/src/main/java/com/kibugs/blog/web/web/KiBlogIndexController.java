package com.kibugs.blog.web.web;

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


    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }


}
