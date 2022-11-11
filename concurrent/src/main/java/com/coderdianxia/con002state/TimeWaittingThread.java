package com.coderdianxia.con002state;

/**
 * @ClassName: BlockThread
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 11:47
 */
public class TimeWaittingThread implements Runnable{
    @Override
    public void run() {
        synchronized(TimeWaittingThread.class){
            while (true){
                try {
                   Thread.sleep(2000);
                   System.out.println("超时等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
