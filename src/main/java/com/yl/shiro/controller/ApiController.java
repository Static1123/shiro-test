package com.yl.shiro.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Liang.Yang5
 * @date 2018/9/5 14:04
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @RequestMapping("/index")
    public Map<String, Object> index() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("CODE", "SUCCESS");
        return result;
    }
}