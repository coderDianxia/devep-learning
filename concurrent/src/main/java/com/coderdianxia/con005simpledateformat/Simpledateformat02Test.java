package com.coderdianxia.con005simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: Simpledateformat01Test
 * @Description:模拟并发场景调用Simpledateformat线程异常
 * @Author:coderDianxia
 * @Date: 2022/11/9 9:52
 */
public class Simpledateformat02Test {
    //同时运行的线程数
    private static final Integer THREAD_COUNT=2;
    //并发量
    private static final Integer EXECUTE_COUNT=1000;

    public static void main(String[] args)  {

        Semaphore semaphore = new Semaphore(THREAD_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < EXECUTE_COUNT; i++) {

            executorService.execute(() ->{

                try {
                    semaphore.acquire();
                    try {
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
            System.out.println("==任务并发正常结束====");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
