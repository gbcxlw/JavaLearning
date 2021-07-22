package com.sso.vip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PublicKey;

@Controller
@RequestMapping("/view")
public class ViewController {
    @GetMapping("/vip")
    public String toVip() {
        return "vip";
    }
}
