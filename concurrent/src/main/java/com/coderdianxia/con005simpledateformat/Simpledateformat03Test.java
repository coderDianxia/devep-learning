package com.coderdianxia.con005simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;

/**
 * @ClassName: Simpledateformat01Test
 * @Description:解决并发线程不安全，使用局部变量
 * @Author:coderDianxia
 * @Date: 2022/11/9 9:52
 */
public class Simpledateformat03Test {
    //同时运行的线程数
    private static final Integer THREAD_COUNT=20;
    //并发量
    private static final Integer EXECUTE_COUNT=100000;

    public static void main(String[] args)  {

        Semaphore semaphore = new Semaphore(THREAD_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ExecutorService executorService = Executors.newCachedThreadPool();
        long start = System.nanoTime();
        for (int i = 0; i < EXECUTE_COUNT; i++) {

            executorService.execute(() ->{

                try {
                    semaphore.acquire();
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        format.parse("2022-01-01");
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
            System.out.println("任务并发结束:局部变量耗时"+ TimeUnit.NANOSECONDS.toMillis(end-start)+"毫秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
