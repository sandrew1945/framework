package com.sandrew.bootsec.bean.esign;

/**
 *
 */
public class SingleFileSyncInput
{
    private String symKey;

    private String data;        // 加密的签约平台项目信息

    public String getSymKey()
    {
        return symKey;
    }

    public void setSymKey(String symKey)
    {
        this.symKey = symKey;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }
}
