package com.zsl.cn.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @Author : Zeusedulous
 * @Date : 2021/6/29 9:32
 * @Desc : 测试类
 */
public class Test {

    public static void main(String[] args) throws IOException {
        //将生成的代理类class文件保存到本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Mask store = new Store();
        MyInvocationHandler ihHandler = new MyInvocationHandler(store);
        //因为代理类是实现的mask接口，所以需要mask来接收
        Mask realStore = (Mask) Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{Mask.class},ihHandler);
        System.out.println(realStore.getClass().getName());
        realStore.sell();

        // 将生成的字节码保存到本地，看源码，是调用里面的方法生成的代理类class
        createProxyClassFile();

    }

    public static void createProxyClassFile() throws IOException {
        String proxyClassName = "myProxy";
        byte[] data = ProxyGenerator.generateProxyClass(proxyClassName,Mask.class.getInterfaces());
        FileOutputStream out = new FileOutputStream(proxyClassName+".class");
        out.write(data);
    }
}
