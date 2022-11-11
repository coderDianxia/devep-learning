package com.coderdianxia.con004async.call;

import java.io.Serializable;

/**
 * @ClassName: TaskResult
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/10/31 17:48
 */
public class TaskResult implements Serializable {
    private String status;
    private String threadName;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "status='" + status + '\'' +
                ", threadName='" + threadName + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
