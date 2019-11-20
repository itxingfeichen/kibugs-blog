package com.kibugs.blog.web.web;


import com.kibugs.blog.web.service.KbCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 博客分类映射表 前端控制器
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@RestController
@RequestMapping("/category")
public class KbBlogCategoryController extends BaseController {

    private final KbCategoryService categoryService;

    public KbBlogCategoryController(KbCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 跳转到分类首页
     * @return
     */
    @RequestMapping("index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView("/category/index");
        categoryService.indexPage(modelAndView);
        return modelAndView;
    }

}

