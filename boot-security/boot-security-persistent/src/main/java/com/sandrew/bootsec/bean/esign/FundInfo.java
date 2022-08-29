package com.sandrew.bootsec.bean.esign;

public class FundInfo
{
    private String fundCode;

    private String productCode;

    private String status;

    private String fundName;

    private String manager;

    private String trustee;

    private String createTime;

    public String getFundCode()
    {
        return fundCode;
    }

    public void setFundCode(String fundCode)
    {
        this.fundCode = fundCode;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getFundName()
    {
        return fundName;
    }

    public void setFundName(String fundName)
    {
        this.fundName = fundName;
    }

    public String getManager()
    {
        return manager;
    }

    public void setManager(String manager)
    {
        this.manager = manager;
    }

    public String getTrustee()
    {
        return trustee;
    }

    public void setTrustee(String trustee)
    {
        this.trustee = trustee;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
}
