package com.coderdianxia.con003sequence;

/**
 * @ClassName: ThreadSeq02
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 14:51
 */
public class ThreadSeq02 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1");
        });
        thread1.setPriority(10);

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2");
        });
        thread2.setPriority(7);

        Thread thread3 = new Thread(() -> {
            System.out.println("thread3");
        });
        thread3.setPriority(5);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
