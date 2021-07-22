package com.sso.login.controller;

import com.sso.login.entity.User;
import com.sso.login.utils.LoginCacheUtil;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Set<User> dbUsers;
    static {
        dbUsers = new HashSet<>();
        dbUsers.add(new User(1, "zhangsan", "123456"));
        dbUsers.add(new User(2, "lisi", "123456"));
        dbUsers.add(new User(3, "wangwu", "123456"));
    }

    @PostMapping
    public String doLogin(User user, HttpSession session, HttpServletResponse response) {
        String target = (String) session.getAttribute("target");

        //模拟从数据库查找用户
        Optional<User> first = dbUsers.stream().filter(dbUser -> dbUser.getUserName().equals(user.getUserName()) &&
                dbUser.getPassWord().equals(user.getPassWord())).findFirst();
        if (first.isPresent()) {
            //保存用户或密码信息
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("TOKEN", token);
            cookie.setDomain("codeshop.com");
            response.addCookie(cookie);
            LoginCacheUtil.loginUser.put(token, first.get());
        } else {
            session.setAttribute("msg", "用户名或密码错误");
            return "login";
        }
        //重定向
        return "redirect:" + target;
    }

    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<User> getUserInfo(String token) {
        if (!StringUtils.isEmpty(token)) {
            User user = LoginCacheUtil.loginUser.get(token);
            return ResponseEntity.ok(user);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
