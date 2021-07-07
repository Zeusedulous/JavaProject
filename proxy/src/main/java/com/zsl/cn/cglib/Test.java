package com.zsl.cn.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/7 15:03
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Store.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Store store = (Store)enhancer.create();
        store.sell();
    }
}
