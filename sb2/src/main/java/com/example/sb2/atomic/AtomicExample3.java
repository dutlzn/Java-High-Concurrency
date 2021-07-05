package com.example.sb2.atomic;

import com.example.sb2.annoations.TreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子性
 */
@Slf4j
@TreadSafe
public class AtomicExample3 {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时执行并发数
    public static int threadTotal = 200;
    // 计数器
    public static LongAdder count = new LongAdder();

    private static void add() {
        count.increment();
//        count.incrementAndGet();
//        count.getAndIncrement()
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0;i<clientTotal;++i) {
            executorService.execute(() -> {
                // 单个线程执行
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
                semaphore.release();
            });
            countDownLatch.countDown();
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }
}
