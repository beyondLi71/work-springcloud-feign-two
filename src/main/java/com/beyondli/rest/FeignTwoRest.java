package com.beyondli.rest;

import com.beyondli.service.FeignTwoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Value("${title}")
    private String title;
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

    /**
     *获取配置文件的信息
     */
    @RequestMapping(value = "/get/config", method = RequestMethod.GET)
    public String getConfig() {
        //return "ok";
        return title;
    }

    /**
     * 测试异常
     */
    @RequestMapping(value = "/test/exc/{state}", method = RequestMethod.GET)
    public String testExcByState(@PathVariable Integer state) {
        String info = feignTwoService.testExcByState(state);
        return info;
    }

    /**
     * 测试服务1调用2,2抛异常机制
     * @return
     */
    @RequestMapping(value = "/hello/exc", method = RequestMethod.GET)
    public void helloExc() {
        feignTwoService.helloExc();
    }
}
