package com.kibugs.blog.web.web;

import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.entity.KbCustomer;
import com.kibug.blog.common.form.KbBlogPublishForm;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.web.service.KbBugsBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    /**
     * 博客详情
     * @param id
     * @return
     */
    @RequestMapping("detail/{id}")
    public ModelAndView getBlogById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/blog/detail");
        KbBlogDTO blogDTO = kiBugsBlogService.getBlogById(id);
        modelAndView.addObject("blog",blogDTO);
        return modelAndView;
    }

    /**
     * 跳转到发布页面
     *
     * @param request
     * @return
     */
    @RequestMapping("gotoPublish")
    public ModelAndView gotoPublish(HttpServletRequest request) {
//        final KbCustomer kbCustomer = getCurrentCustomer(request);
        final ModelAndView modelAndView = new ModelAndView("/blog/publish");
//        modelAndView.addObject("customer", kbCustomer);
        return modelAndView;
    }


    /**
     * 发布
     * @param request
     * @param blogPublishForm 表单数据封装对象 {@link KbBlogPublishForm}
     * @return
     */
    @PostMapping("publishBlog")
    public ModelAndView publishBlog(HttpServletRequest request, KbBlogPublishForm blogPublishForm) {
        ModelAndView modelAndView = new ModelAndView();
        CommonResponse commonResponse = kiBugsBlogService.publishBlog(blogPublishForm,getCurrentCustomer(request));
        if (commonResponse.getSuccess()) {
            modelAndView.setViewName("redirect:/index");
        }
        return modelAndView;
    }

    @ModelAttribute(value = "customer")
    public KbCustomer customer(HttpServletRequest request){

        return getCurrentCustomer(request);
    }


}
