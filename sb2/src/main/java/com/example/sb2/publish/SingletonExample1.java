package com.example.sb2.publish;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

/**
 * 懒汉模式
 * 单例在第一次使用的时候创建
 */
@Slf4j
public class SingletonExample1 {
    // 私有构造方法
    private SingletonExample1() {

    }

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态工厂方法
    public static SingletonExample1 getInstance() {
        if(instance == null) {
            instance = new SingletonExample1();
        }

        return instance;
    }
}
