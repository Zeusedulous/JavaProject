package com.zsl.cn.statics;

/**
 * @Author : Zeusedulous
 * @Date : 2021/6/29 9:32
 * @Desc : 测试类
 */
public class Test {

    public static void main(String[] args) {
        Store store = new Store();
        Mask maskInterface = new ProxyStore(store);
        maskInterface.sell();
    }
}
