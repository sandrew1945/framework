package com.sandrew.bootsec.bean.esign;

/**
 * 投资者列表数据
 */
public class InvestorListFundInv
{
    private String investor;    // 投资者姓名
    private String type;        // 类型 0：个人普通   1：个人专业
    private String fundCode;    // 项目编号
    private String process;     // 投资者待办事项
    private String investorAccount; // 投资者平台账号
    private String fundInvestorId;  // 基金投资者编号

    public String getInvestor()
    {
        return investor;
    }

    public void setInvestor(String investor)
    {
        this.investor = investor;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getFundCode()
    {
        return fundCode;
    }

    public void setFundCode(String fundCode)
    {
        this.fundCode = fundCode;
    }

    public String getProcess()
    {
        return process;
    }

    public void setProcess(String process)
    {
        this.process = process;
    }

    public String getInvestorAccount()
    {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount)
    {
        this.investorAccount = investorAccount;
    }

    public String getFundInvestorId()
    {
        return fundInvestorId;
    }

    public void setFundInvestorId(String fundInvestorId)
    {
        this.fundInvestorId = fundInvestorId;
    }
}
