package com.sandrew.bootsec.bean.esign;

/**
 *  查询文件同步流水号输入参数
 */

public class SyncFileSerialNoInput
{
    private String operatorAccount; // 经办人签约平台ito

    private String investorAccount; // 投资者签约平台ito

    private String fundCode;        // 项目编号

    public String getOperatorAccount()
    {
        return operatorAccount;
    }

    public void setOperatorAccount(String operatorAccount)
    {
        this.operatorAccount = operatorAccount;
    }

    public String getInvestorAccount()
    {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount)
    {
        this.investorAccount = investorAccount;
    }

    public String getFundCode()
    {
        return fundCode;
    }

    public void setFundCode(String fundCode)
    {
        this.fundCode = fundCode;
    }
}
