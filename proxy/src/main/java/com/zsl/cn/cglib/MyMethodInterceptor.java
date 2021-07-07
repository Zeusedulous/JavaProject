package com.zsl.cn.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/7 9:28
 * @Desc :
 */

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("顾客已经下单，开始向总厂家订货");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("订单完成");
        return result;
    }
}
