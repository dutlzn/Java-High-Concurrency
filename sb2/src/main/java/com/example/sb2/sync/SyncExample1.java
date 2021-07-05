package com.example.sb2.sync;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyncExample1 {
    // 修饰一个代码块
    public void test() {
        synchronized (this) {
            for(int i = 0;i<100;++i) {
                log.info("test1 - {}", i);
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2() {
        for(int i = 0;i<100;++i) {
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {

    }
}
