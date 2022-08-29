package com.sandrew.bootsec.bean.esign;

/**
 * 经办人注册输出
 */
public class SyncFileOutput
{
    private String requestId;   // 下载业务流水号

    private String name;        // 文件名

    private String sequence;    // 序号

    private String file;        // 文件base64

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSequence()
    {
        return sequence;
    }

    public void setSequence(String sequence)
    {
        this.sequence = sequence;
    }

    public String getFile()
    {
        return file;
    }

    public void setFile(String file)
    {
        this.file = file;
    }
}
