package com.coderdianxia.con001create;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: DemoTest
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 11:10
 */
public class DemoTest {
    public static void main(String[] args) {

        ThreadTest thread = new ThreadTest();
        RunnableTest runnableTest = new RunnableTest();
        CallableTest callableTest = new CallableTest();

        thread.setName("threadTest-01");
        thread.start();

        Thread runnableThread = new Thread(runnableTest,"runnableTest");
        runnableThread.start();

        FutureTask<String> futureTask = new FutureTask<String>(callableTest);
        Thread callableThread = new Thread(futureTask, "callableTest");
        callableThread.start();

        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
