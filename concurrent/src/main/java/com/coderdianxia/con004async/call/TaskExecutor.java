package com.coderdianxia.con004async.call;

/**
 * @ClassName: TaskExecutor
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 17:51
 */
public class TaskExecutor implements Runnable{

    TaskCallable call;

    public TaskExecutor(TaskCallable call) {
        this.call = call;
    }

    @Override
    public void run() {

        TaskResult taskResult = new TaskResult();
        taskResult.setMsg("回调信息");
        taskResult.setThreadName(Thread.currentThread().getName());
        taskResult.setStatus("success");
        try {
            call.call(taskResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
