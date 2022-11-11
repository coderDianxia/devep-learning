package com.coderdianxia.con001create;

/**
 * @ClassName: RunnableTest
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 11:08
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"===");
    }
}
