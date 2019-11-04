package com.kibugs.blog.web.web;

import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibugs.blog.web.service.KbBugsBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/10/31  22:31
 * @description: 博客业务处理控制器
 **/
@Controller
@RequestMapping("blog")
public class KiBugsBlogController {


    private final KbBugsBlogService kiBugsBlogService;

    public KiBugsBlogController(KbBugsBlogService kiBugsBlogService) {
        this.kiBugsBlogService = kiBugsBlogService;
    }

    @RequestMapping("getBlogById")
    @ResponseBody
    public KbBlogDTO getBlogById(Long id){
        return kiBugsBlogService.getBlogById(id);
    }

    @RequestMapping("index")
    public ModelAndView index(){

        return new ModelAndView("/index");
    }
}
