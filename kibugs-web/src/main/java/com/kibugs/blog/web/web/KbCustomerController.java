package com.kibugs.blog.web.web;


import com.kibug.blog.common.constant.BaseConstants;
import com.kibug.blog.common.entity.KbCustomer;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.request.CustomerIntoDTO;
import com.kibugs.blog.web.service.KbCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    private final KbCustomerService customerService;

    public KbCustomerController(KbCustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 登录，注册页面跳转
     *
     * @param type 操作类型（1：注册，其他：登录）
     * @return ModelAndView
     */
    @RequestMapping(value = {"/signUp/{type}", "/signIn/{type}"})
    public ModelAndView signUpOrSignIn(@PathVariable String type) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errMsg", "");
        if (Objects.equals(type, "1")) {
            modelAndView.setViewName("/customer/register");
        } else {
            modelAndView.setViewName("/customer/login");
        }
        return modelAndView;

    }

    /**
     * 注册
     *
     * @param password 密码
     * @param email    邮箱
     * @param phone    手机号
     * @return ModelAndView
     */
    @RequestMapping("signUp")
    public ModelAndView signUp(String password, String email, String phone) {

        ModelAndView modelAndView = new ModelAndView();
        log.info("{}{}{}", password, email, phone);
        CustomerIntoDTO customerIntoDTO = CustomerIntoDTO.builder().email(email).password(password).phone(phone).build();
        CommonResponse commonResponse = customerService.signUp(customerIntoDTO);
        if (commonResponse.getSuccess()) {
            modelAndView.setViewName("/login");
        } else {
            modelAndView.setViewName("/customer/register");
            modelAndView.addObject("errMsg", commonResponse.getErrMsg());
        }
        return modelAndView;
    }

    /**
     * 登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return ModelAndView
     */
    @RequestMapping("signIn")
    public ModelAndView signIn(HttpServletRequest request, String email, String password) {
        log.info("{}{}", password, email);
        ModelAndView modelAndView = new ModelAndView();
        CustomerIntoDTO customerIntoDTO = CustomerIntoDTO.builder().email(email).password(password).build();
        CommonResponse<KbCustomer> commonResponse = customerService.signIn(customerIntoDTO);
        if (commonResponse.getSuccess()) {
            KbCustomer kbCustomer = commonResponse.getData();
            request.getSession().setAttribute("kibugs:customer", kbCustomer);
            modelAndView.addObject("customer",kbCustomer);
            modelAndView.setViewName("redirect:/index");
        } else {
            modelAndView.setViewName("/customer/login");
            modelAndView.addObject("errMsg", commonResponse.getErrMsg());
        }
        return modelAndView;
    }


    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().removeAttribute(BaseConstants.CUSTOMER_SESSION);
        modelAndView.setViewName("redirect:/index");
        return modelAndView;

    }
}

