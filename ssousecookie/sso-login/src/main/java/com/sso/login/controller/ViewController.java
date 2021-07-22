package com.sso.login.controller;

import com.sso.login.entity.User;
import com.sso.login.utils.LoginCacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * 页面跳转
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    /**
     * 跳转到登录界面
     * @return
     */
    @GetMapping("/login")
    public String toLogin(@RequestParam(required = false, defaultValue = "") String target,
                          HttpSession session, @CookieValue(required = false, value = "TOKEN")Cookie cookie) {
        if (StringUtils.isEmpty(target)) {
            target = "http://www.codeshop.com:9001/view/index";
        }
        //如果已登录用户在
        if (cookie != null) {
            String value = cookie.getValue();
            User user = LoginCacheUtil.loginUser.get(value);
            if (user != null) {
                return "redirect:" + target;
            }
        }
        //TODO:要做target地址是否合法校验
        session.setAttribute("target", target);
        return "login";
    }
}
