package com.beyondli.service;

import com.beyondli.common.tools.exception.ExceptionManager;
import com.beyondli.feign.FeignOne;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by beyondLi
 * Date 2018/3/16
 * Desc .
 */
@Service
public class FeignTwoServiceImpl implements FeignTwoService {

    @Resource
    FeignOne feignOne;
    @Resource
    ExceptionManager exceptionManager;
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

    /**
     * 测试异常
     * @param state
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String testExcByState(Integer state) {
        if (Objects.equals(state, 0)) {
            throw exceptionManager.createByCode("TEST_0001");
        }
        return "success";
    }

    /**
     * 测试服务1调用2,2抛异常机制
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void helloExc() {
        throw exceptionManager.createByCode("TEST_0002");
    }
}
