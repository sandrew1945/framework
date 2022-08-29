package com.sandrew.bootsec.bean.esign;

import com.sandrew.bootsec.bean.InvestorInfo;

/** 投资者注册输入参数 */
public class InvestorRegInput {
  private InvestorInfo investorInfo = new InvestorInfo();

  public InvestorInfo getInvestorInfo() {
    return investorInfo;
  }

  public void setInvestorInfo(InvestorInfo investorInfo) {
    this.investorInfo = investorInfo;
  }
}
