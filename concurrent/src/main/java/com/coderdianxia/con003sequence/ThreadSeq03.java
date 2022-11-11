package com.coderdianxia.con003sequence;

/**
 * @ClassName: ThreadSeq03
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 14:52
 */
public class ThreadSeq03 {
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

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
