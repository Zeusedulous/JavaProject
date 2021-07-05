package com.zsl.cn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : Zeusedulous
 * @Date : 2021/6/29 9:16
 * @Desc :
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object subject;

    public MyInvocationHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("顾客已经下单，开始向总厂家订货");
        Object obj = method.invoke(subject, args);
        System.out.println("订单完成");
        return obj;
    }
}
