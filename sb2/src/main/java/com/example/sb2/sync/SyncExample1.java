package com.example.sb2.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExample1 {
    // 修饰一个代码块
    public void test1() {
        synchronized (this) {
            for(int i = 0;i<10;++i) {
                log.info("test1 - {}", i);
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2() {
        for(int i = 0;i<10;++i) {
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SyncExample1 syncExample1 = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample1.test1();
        });
        executorService.execute(() -> {
            syncExample1.test1();
        });
    }
}
