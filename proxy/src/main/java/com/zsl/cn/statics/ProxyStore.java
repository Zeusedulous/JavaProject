package com.zsl.cn.statics;

/**
 * @Author : Zeusedulous
 * @Date : 2021/6/29 9:16
 * @Desc : 代理商
 */
public class ProxyStore implements Mask {

    private Store store;

    public ProxyStore(Store store){
        this.store = store;
    }

    @Override
    public void sell() {
        System.out.println("顾客已经下单，开始向总厂家订货");
        store.sell();
        System.out.println("订单完成");
    }
}
