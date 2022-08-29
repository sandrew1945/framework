package com.sandrew.bootsec.bean.esign;

/**
 * 经办人注册输出
 */
public class OperatorRegOutput
{
    private String requestId;

    private OperatorRegResult results;


    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public OperatorRegResult getResults()
    {
        return results;
    }

    public void setResults(OperatorRegResult results)
    {
        this.results = results;
    }
}
