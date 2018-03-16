package com.beyondli.rest;

import com.beyondli.service.FeignTwoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2018/3/16
 * Desc .
 */
@RestController
@RequestMapping(value = "/two")
public class FeignTwoRest {
    @Resource
    FeignTwoService feignTwoService;
    /**
     * 测试服务2号
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "welcome to two";
    }

    /**
     * 调用服务1号接口获取返回值
     */
    @RequestMapping(value = "/get/one", method = RequestMethod.GET)
    public String getOne() {
        String info = feignTwoService.getOneInfo();
        return info;
    }
}
