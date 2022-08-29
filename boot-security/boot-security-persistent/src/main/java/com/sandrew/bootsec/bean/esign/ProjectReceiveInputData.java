package com.sandrew.bootsec.bean.esign;

/**
 *
 */
public class ProjectReceiveInputData
{
    private String productCode;     // 代销机构产品编号

    private String fundCode;        // 签约平台项目编号

    private String fundName;        // 签约平台项目名称

    private String confirmTime;     // 代销关系当次确认时间


    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    public String getFundCode()
    {
        return fundCode;
    }

    public void setFundCode(String fundCode)
    {
        this.fundCode = fundCode;
    }

    public String getFundName()
    {
        return fundName;
    }

    public void setFundName(String fundName)
    {
        this.fundName = fundName;
    }

    public String getConfirmTime()
    {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime)
    {
        this.confirmTime = confirmTime;
    }
}
