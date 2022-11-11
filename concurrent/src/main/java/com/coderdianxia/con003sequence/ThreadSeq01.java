package com.coderdianxia.con003sequence;

/**
 * @ClassName: ThreadSeq01
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 14:49
 */
public class ThreadSeq01 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("thread3");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
