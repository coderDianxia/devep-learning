package com.coderdianxia.con004async.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: FutureTaskTest
 * @Description:
 * @Author:coderDianxia
 * @Date: 2022/11/4 17:43
 */
public class FutureTaskTest03 {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int i=0;
                while (i<10000000) {
                    Thread thread = Thread.currentThread();
                    if(thread.isInterrupted())
                    {
                        System.out.println("=线程已中断=");
                        break;
                    }
                    System.out.println("任务运行中===");
                    i++;
                }
                return "测试线程方式返回异步结果";
            }
        });
        new Thread(futureTask).start();


        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean cancel = futureTask.cancel(true);
            System.out.println("========================取消结果:"+cancel);
        }).start();

        for(;;)
        {
            System.out.println(futureTask.isCancelled()+"任务状态");
            if(futureTask.isDone())
            {
                System.out.println("线程已完成:isDone:"+futureTask.isDone()+"任务已取消isCancelled:"+futureTask.isCancelled());
                break;
            }
        }
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            System.out.println("任务被中断");

        } catch (ExecutionException e) {
            System.out.println("任务执行异常");
        }catch (CancellationException e) {
            System.out.println("任务取消异常");
        }
    }
}
