package com.coderdianxia.con004async.call;

/**
 * @ClassName: TaskHandler
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 17:48
 */
public class TaskHandler implements TaskCallable<TaskResult> {


    @Override
    public TaskResult call(TaskResult e) throws Exception {

        System.out.println(e.toString());
        return e;
    }
}
