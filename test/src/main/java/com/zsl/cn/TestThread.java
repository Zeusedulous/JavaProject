package com.zsl.cn;

/**
 * @Author : Zeusedulous
 * @Date : 2022/3/10 15:57
 * @Desc :
 */
public class TestThread {

    private boolean flag = true;
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        TestThread test = new TestThread();

        new Thread(() -> test.echo(), "线程A").start();

        Thread.sleep(1000);

        new Thread(() -> test.updateFlag(), "线程B").start();
    }


    public void echo() {
        System.out.println(Thread.currentThread().getName() + "开始执行");

        while (flag) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + "跳出循环，count=" + count);
    }

    public void updateFlag() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag:" + flag);
    }
}
