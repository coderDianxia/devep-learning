package com.coderdianxia.con002state;

/**
 * @ClassName: ThreadStateTest
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 14:16
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        WaittingThread waittingState = new WaittingThread();

        Thread waittingThread = new Thread(waittingState, "waitting");
        waittingThread.start();

        TimeWaittingThread timeWaittingState = new TimeWaittingThread();
        Thread timeWaittingThread = new Thread(timeWaittingState, "timeWaittingThread");
        timeWaittingThread.start();

        BlockThread blockState = new BlockThread();
        Thread blockThread = new Thread(blockState, "blockThread1");
        blockThread.start();

        BlockThread blockState2 = new BlockThread();
        Thread blockThread2 = new Thread(blockState2, "blockThread1");
        blockThread2.start();

    }
}
