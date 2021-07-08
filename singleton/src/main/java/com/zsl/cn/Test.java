package com.zsl.cn;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/8 21:33
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton11 = Singleton1.getInstance();
        System.out.println(singleton1 == singleton11);

        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton21 = Singleton2.getInstance();
        System.out.println(singleton2 == singleton21);
    }
}
