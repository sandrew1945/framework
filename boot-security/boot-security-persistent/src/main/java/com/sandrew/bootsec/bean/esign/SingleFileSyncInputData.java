package com.sandrew.bootsec.bean.esign;

/**
 *
 */
public class SingleFileSyncInputData
{
    private String templateId;     // 模版ID

    private String status;        // 模版状态 0: 新建 1: 修改

    public String getTemplateId()
    {
        return templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
