package com.beyondli.service;

/**
 * Created by beyondLi
 * Date 2018/3/16
 * Desc .
 */
public interface FeignTwoService {
    /**
     * 获取服务一信息
     * @return
     */
    String getOneInfo();

    /**
     * 测试异常
     * @param state
     * @return
     */
    String testExcByState(Integer state);

    /**
     * 测试服务1调用2,2抛异常机制
     */
    void helloExc();
}
