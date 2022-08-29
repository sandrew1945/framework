package com.sandrew.bootsec.bean.esign;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 经办人注册输出
 */
@Data
public class TaskListOutput
{
    private String requestId;

    private List<TaskListHandleTask> handleList = new ArrayList<>();

    public void addTask(TaskListHandleTask task)
    {
        handleList.add(task);
    }
}

