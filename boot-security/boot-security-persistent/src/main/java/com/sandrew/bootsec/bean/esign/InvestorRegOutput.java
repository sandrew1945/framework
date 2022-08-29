package com.sandrew.bootsec.bean.esign;

/** 投资者注册输出 */
public class InvestorRegOutput {

  private String requestId;


  private InvestorRegResult results;

  public String getRequestId()
  {
    return requestId;
  }

  public void setRequestId(String requestId)
  {
    this.requestId = requestId;
  }

  public InvestorRegResult getResults()
  {
    return results;
  }

  public void setResults(InvestorRegResult results)
  {
    this.results = results;
  }
}
