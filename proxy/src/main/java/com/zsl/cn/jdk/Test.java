package com.zsl.cn.jdk;

import java.lang.reflect.Proxy;

/**
 * @Author : Zeusedulous
 * @Date : 2021/6/29 9:32
 * @Desc : 测试类
 */
public class Test {

    public static void main(String[] args){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Mask store = new Store();
        MyInvocationHandler ihHandler = new MyInvocationHandler(store);
        Mask realStore = (Mask) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{Mask.class},ihHandler);
        System.out.println(realStore.getClass().getName());
        realStore.sell();
    }
}
