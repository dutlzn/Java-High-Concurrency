package com.example.sb2.atomic;

import com.example.sb2.annoations.TreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子性
 */
@Slf4j
@TreadSafe
public class AtomicExample4 {
    public static AtomicReference<Integer> count = new AtomicReference<>(0);
    public static void main(String[] args) {
        count.compareAndSet(0, 2);
        count.compareAndSet(2, 4);
        log.info("count:{}", count);
    }
}
