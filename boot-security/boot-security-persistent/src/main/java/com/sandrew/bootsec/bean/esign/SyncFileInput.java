package com.sandrew.bootsec.bean.esign;

/**
 *  查询文件同步流水号输入参数
 */

public class SyncFileInput
{
    private String requestId;   // 下载业务流水号

    private String sequence;    // 序号

    private String name;        // 文件名

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public String getSequence()
    {
        return sequence;
    }

    public void setSequence(String sequence)
    {
        this.sequence = sequence;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
