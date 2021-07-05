package com.zsl.cn.jdk;

/**
 * @Author : Zeusedulous
 * @Date : 2021/6/29 9:16
 * @Desc : 厂家
 */
public class Store implements Mask {

    @Override
    public void sell() {
        System.out.println("我是最大的厂家： 我已经发货给顾客");
    }
}
