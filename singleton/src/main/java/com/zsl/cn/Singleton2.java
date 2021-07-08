package com.zsl.cn;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/8 21:32
 * @Desc : 饿汉式<>被加载的时候就先new一个对象，不管你用还是不用</>
 */
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return singleton2;
    }
}

