package com.coderdianxia.con001create;

import java.util.concurrent.Callable;

/**
 * @ClassName: CallableTest
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 11:09
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws InterruptedException{


        return Thread.currentThread().getName();
    }
}
