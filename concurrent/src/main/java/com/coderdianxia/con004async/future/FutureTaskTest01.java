package com.coderdianxia.con004async.future;

import java.util.concurrent.*;

/**
 * @ClassName: FutureTaskTest
 * @Description:
 * @Author:coderDianxia
 * @Date: 2022/11/4 17:43
 */
public class FutureTaskTest01 {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int i=0;
                while (i<2000) {
                    System.out.println("===");
                    i++;
                }
                return "测试线程方式返回异步结果";
            }
        });
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
            System.out.println("任务结束===");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
