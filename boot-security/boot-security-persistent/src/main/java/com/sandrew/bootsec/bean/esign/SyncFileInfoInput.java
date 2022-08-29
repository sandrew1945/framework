package com.sandrew.bootsec.bean.esign;

/**
 *  查询文件同步流水号输入参数
 */

public class SyncFileInfoInput
{
    private String requestId; // 下载业务流水号

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }
}
