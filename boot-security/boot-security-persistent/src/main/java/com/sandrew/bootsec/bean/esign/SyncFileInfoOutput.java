package com.sandrew.bootsec.bean.esign;

import java.util.List;

/**
 * 经办人注册输出
 */
public class SyncFileInfoOutput
{
    private String requestId;

    private List<SyncFileInfoResult> fileList;

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public List<SyncFileInfoResult> getFileList()
    {
        return fileList;
    }

    public void setFileList(List<SyncFileInfoResult> fileList)
    {
        this.fileList = fileList;
    }
}
