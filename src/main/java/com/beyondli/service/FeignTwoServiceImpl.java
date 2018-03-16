package com.beyondli.service;

import com.beyondli.feign.FeignOne;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2018/3/16
 * Desc .
 */
@Service
public class FeignTwoServiceImpl implements FeignTwoService {

    @Resource
    FeignOne feignOne;
    /**
     * 获取服务1信息
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getOneInfo() {
        String info = feignOne.hello();
        return info;
    }
}
