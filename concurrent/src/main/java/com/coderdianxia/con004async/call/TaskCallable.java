package com.coderdianxia.con004async.call;

/**
 * @ClassName: TaskCallable
 * @Description:TODO
 * @Author:wengzx
 * @Date: 2022/10/31 17:47
 */
public interface TaskCallable<T> {
    T call(T e) throws Exception;
}
