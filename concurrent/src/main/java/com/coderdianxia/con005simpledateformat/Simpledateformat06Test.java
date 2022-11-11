package com.coderdianxia.con005simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Simpledateformat01Test
 * @Description:解决并发线程不安全，使用Lock
 * @Author:coderDianxia
 * @Date: 2022/11/9 9:52
 */
public class Simpledateformat06Test {
    //同时运行的线程数
    private static final Integer THREAD_COUNT=20;
    //并发量
    private static final Integer EXECUTE_COUNT=100000;

    public static void main(String[] args)  {

        Semaphore semaphore = new Semaphore(THREAD_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd");
            }
        };
        long start = System.nanoTime();
        for (int i = 0; i < EXECUTE_COUNT; i++) {

            executorService.execute(() ->{

                try {
                    semaphore.acquire();
                    try {
                        threadLocal.get().parse("2022-01-01");
                    } catch (ParseException e) {
                        System.out.println("线程：" + Thread.currentThread().getName() + " 格式化日期失 败");
                        System.exit(1);
                    } catch (NumberFormatException e){
                        System.out.println("线程：" + Thread.currentThread().getName() + " 格式化日期失 败");
                        e.printStackTrace();
                        System.exit(1);
                    }
                    semaphore.release();
                } catch (InterruptedException e) {
                    System.out.println("信号量发生错误"); e.printStackTrace();
                    System.exit(1);
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
            long end = System.nanoTime();
            System.out.println("任务并发结束,使用ThreadLocal耗时"+ TimeUnit.NANOSECONDS.toMillis(end-start)+"毫秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
