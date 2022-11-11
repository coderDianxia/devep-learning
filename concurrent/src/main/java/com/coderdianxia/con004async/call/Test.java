package com.coderdianxia.con004async.call;

/**
 * @ClassName: Test
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 17:55
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        TaskCallable taskHandler = new TaskHandler();

        TaskExecutor taskExecutor = new TaskExecutor(taskHandler);

        new Thread(taskExecutor,"test01").start();
        Thread.sleep(2000);

    }
}
