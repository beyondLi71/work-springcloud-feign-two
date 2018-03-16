package com.beyondli.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beyondLi
 * Date 2018/3/16
 * Desc .
 */
@FeignClient("feign-one")
public interface FeignOne {
    /**
     * 调用feignone服务接口
     * @return
     */
    @RequestMapping(value = "/one/hello")
    public String hello();
}
