package com.sandrew.bootsec.bean.esign;

/**
 *  投资者列表输入参数
 */
public class InvestorListInput
{
    private String itoAccount;

    private String fundCode;

    private String type;

    public String getItoAccount()
    {
        return itoAccount;
    }

    public void setItoAccount(String itoAccount)
    {
        this.itoAccount = itoAccount;
    }

    public String getFundCode()
    {
        return fundCode;
    }

    public void setFundCode(String fundCode)
    {
        this.fundCode = fundCode;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
