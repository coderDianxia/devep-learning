package com.coderdianxia.con002state;

/**
 * @ClassName: BlockThread
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 14:21
 */
public class BlockThread implements Runnable{
    @Override
    public void run() {
        synchronized(BlockThread.class){
            System.out.println("blockingThread====");
            while(true){

            }
        }
    }
}
