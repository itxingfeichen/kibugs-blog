package com.kibugs.blog.web.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * <p>
 * 用户信息前端控制器
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Slf4j
@RestController
@RequestMapping("/blog/customer")
public class KbCustomerController extends BaseController {


    /**
     * 登录，注册页面跳转
     * @param type 操作类型（1：注册，其他：登录）
     * @return ModelAndView
     */
    @RequestMapping(value = {"/signUp/{type}", "/signIn/{type}"})
    public ModelAndView signUpOrSignIn(@PathVariable String type) {

        if (Objects.equals(type, "1")) {
            return new ModelAndView("/customer/register");
        } else {
            return new ModelAndView("/customer/login");
        }

    }

    /**
     * 注册
     * @param password 密码
     * @param email 邮箱
     * @param phone 手机号
     * @return ModelAndView
     */
    @RequestMapping("signUp")
    public ModelAndView signUp(String password,String email,String phone){

        log.info("{}{}{}",password,email,phone);
        return null;
    }


    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return ModelAndView
     */
    @RequestMapping("signIn")
    public ModelAndView signIn(String email,String password){
        log.info("{}{}",password,email);
        return null;
    }
}

