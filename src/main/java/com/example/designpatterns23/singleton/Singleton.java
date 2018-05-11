package com.example.designpatterns23.singleton;

/**
 * Created by LiWeilong on 2018/5/7.
 */
public class Singleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton instance = null;
    /* 私有构造方法，防止被实例化 */
    private Singleton(){}
    /* 静态工程方法，创建实例 线程安全加synchronized 但是会锁住这个对象 */
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    public static synchronized Singleton getInstance_1(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstance_2(){
        if(instance == null){
            // 只在第一次创建对象时加锁
            synchronized (instance){
                instance = new Singleton();
            }
        }
        return instance;
    }
    // 使用内部类来维护单例
    public static Singleton getInstance_static(){
        return SingletonFactory.instance;
    }
    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }
    // 只在创建类的时候同步
    public static Singleton getInstance_synInit(){
        if(instance ==null){
            synInit();
        }
        return instance;
    }

    private static synchronized void synInit() {
        if(instance ==null){
            instance = new Singleton();
        }
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve(){
        return instance;
    }



}
