package com.zsl.cn.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/7 19:53
 * @Desc :
 */
public class Test2 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Store.class);

        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("顾客已经下单，开始向总厂家订货");
            Object result = methodProxy.invokeSuper(o,objects);
            System.out.println("订单完成");
            return result;
        });
        Store store = (Store)enhancer.create();
        store.sell();
    }
}
