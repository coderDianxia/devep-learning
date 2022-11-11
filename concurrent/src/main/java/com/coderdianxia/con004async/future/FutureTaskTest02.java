package com.coderdianxia.con004async.future;

import java.util.concurrent.*;

/**
 * @ClassName: FutureTaskTest02
 * @Description:线程池创建
 * @Author:coderDianxia
 * @Date: 2022/11/4 17:54
 */
public class FutureTaskTest02 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        FutureTask<String> futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "线程池返回";
            }
        });
        executorService.submit(futureTask);

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
