package com.sandrew.bootsec.bean;

import com.sandrew.bury.bean.PO;
import lombok.Data;

/** 投资者注册信息bean */
@Data
public class InvestorInfo extends PO {

  private String mobile; // 手机号

  private String name; // 姓名

  private Integer cardType; // 证件类型(0:身份证)

  private String cardNo; // 证件号码

  private String investorNo; // 投资者编号
}
