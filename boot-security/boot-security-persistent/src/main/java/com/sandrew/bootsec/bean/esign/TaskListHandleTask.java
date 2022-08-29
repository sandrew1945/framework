package com.sandrew.bootsec.bean.esign;

import lombok.Data;

/**
 *  待办任务信息
 */
@Data
public class TaskListHandleTask
{
    private String channelId;

    private String name;

    private String fundCode;

    private String fundName;
}
