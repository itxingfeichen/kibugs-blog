package com.kibugs.blog.web.web;


import com.kibugs.blog.web.service.KbBugsBlogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@RestController
@RequestMapping("/blog/kb-category")
public class KbCategoryController extends BaseController {


    private final KbBugsBlogService blogService;

    public KbCategoryController(KbBugsBlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 跳转到分类首页
     *
     * @param categoryId 分类ID
     * @return ModelAndView
     */
    @RequestMapping("index")
    public ModelAndView toIndex(@RequestParam(value = "categoryId", required = false) Long categoryId) {
        ModelAndView modelAndView = new ModelAndView("/category/index");
        blogService.indexPageForCategory(modelAndView, categoryId);

        return modelAndView;
    }

}

