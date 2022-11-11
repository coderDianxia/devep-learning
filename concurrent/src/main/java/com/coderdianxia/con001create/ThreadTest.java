package com.coderdianxia.con001create;

/**
 * @ClassName: ThreadTest
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 11:07
 */
public class ThreadTest extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"====");
    }
}
