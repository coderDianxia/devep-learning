package com.coderdianxia.con002state;

/**
 * @ClassName: BlockThread
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 11:47
 */
public class WaittingThread implements Runnable{
    @Override
    public void run() {
        synchronized(WaittingThread.class){
            while (true){
                try {
                    System.out.println("等待状态线程");
                    WaittingThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
