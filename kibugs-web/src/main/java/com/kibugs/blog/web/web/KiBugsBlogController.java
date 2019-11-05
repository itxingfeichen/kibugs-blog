package com.kibugs.blog.web.web;

import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.entity.KbBlog;
import com.kibug.blog.common.entity.KbCustomer;
import com.kibugs.blog.web.service.KbBugsBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/10/31  22:31
 * @description: 博客业务处理控制器
 **/
@Controller
@RequestMapping("blog")
public class KiBugsBlogController extends BaseController {


    private final KbBugsBlogService kiBugsBlogService;

    public KiBugsBlogController(KbBugsBlogService kiBugsBlogService) {
        this.kiBugsBlogService = kiBugsBlogService;
    }

    @RequestMapping("getBlogById")
    @ResponseBody
    public KbBlogDTO getBlogById(Long id) {
        return kiBugsBlogService.getBlogById(id);
    }

    /**
     * 跳转到发布页面
     *
     * @param request
     * @return
     */
    @RequestMapping("gotoPublish")
    public ModelAndView gotoPublish(HttpServletRequest request) {
        final KbCustomer kbCustomer = getCurrentCustomer(request);
        final ModelAndView modelAndView = new ModelAndView("/publish/publish");
        modelAndView.addObject("customer", kbCustomer);
        return modelAndView;
    }

    /**
     * 发布
     *
     * @param kbBlog
     * @return
     */
    public ModelAndView publishBlog(HttpServletRequest request, KbBlog kbBlog) {

        ModelAndView modelAndView = new ModelAndView("/index");
        kiBugsBlogService.publishBlog(kbBlog);
        return modelAndView;
    }


}
