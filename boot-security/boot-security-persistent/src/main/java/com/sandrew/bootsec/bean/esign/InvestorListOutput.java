package com.sandrew.bootsec.bean.esign;

import java.util.List;

/**
 * 经办人注册输出
 */
public class InvestorListOutput
{
    private String requestId;

    private List<InvestorListFundInv> rows;


    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public List<InvestorListFundInv> getRows()
    {
        return rows;
    }

    public void setRows(List<InvestorListFundInv> rows)
    {
        this.rows = rows;
    }
}
