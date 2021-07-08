package com.zsl.cn;

/**
 * @Author : Zeusedulous
 * @Date : 2021/7/8 21:32
 * @Desc : 懒汉式<>只有调用的时候才去new对象，Singleton1.getInstance()</>
 */
public class Singleton1 {

    /**
     * 2.我们需要声明一个全局的Singleton，在任何地方都只能获取或者new这一个对象
     */
    private static Singleton1 singleton1;

    /**
     * 1.首先我们创建对象的方式都是通过new对象来获取，这样对象就可能被多次new，所以可能就会产生多个对象
     *   所以我们需要添加private类型的构造，防止外部进行new创建对象
     *
     */
    private Singleton1(){}

    /**
     * 3.我们需要提供一个方法来让外部调用来获取对象Singleton1 single = Singleton1.getInstance();
     *   所以，我们需要在方法前面添加static
     * 4.而由于静态方法里只能使用静态变量，所以外部声明的Singleton我们需要改成static类型的
     * @return
     */
    public static Singleton1 getInstance(){
        /**
         *  5.判断singleton是否为空
         */
        if(null == singleton1){
            /**
             * 6.考虑到多线程的情况，我们需要把当前类Singleton锁住
             */
            synchronized (Singleton1.class){
                /**
                 * 7.需要双重判断，如果线程1，线程2都进入synchronized上面那一步，这时候线程1进入synchronized
                 *   判断不为null就要new一下，然后结束，这时候线程2也进来，也会new一下，所以需要再次判断是否为null
                 */
                if(null == singleton1){
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
